package main;

import java.util.List;
import java.util.Vector;

public class Tablero {

	public int squaresNumber;
	private static Tablero tablero;

	Node[][] nodes = new Node[squaresNumber][squaresNumber];

	// #REGION SINGLETON START
	private Tablero(int squares) {
		this.squaresNumber = squares;
		int k = 1;
		for (int y = 0; y < squares; y++) {
			for (int x = 0; x < squares; x++) {
				nodes[x][y] = new Node(k, x, y);
				k++;
			}
		}

	}

	public static Tablero getSingletonInstance(int squares) {
		if (tablero == null) {
			tablero = new Tablero(squares);
		}
		return tablero;
	}

	public static Tablero getSingletonInstance() {
		if (tablero == null) {
			tablero = new Tablero(0);
		}
		return tablero;
	}

	// SINGLETON END

	public static void setUnaccessibles(Vector<Integer> v) {

		int posX = v.get(0);
		int posY = v.get(1);

		for (int y = 0; y < tablero.squaresNumber; y++) {
			for (int x = 0; x < tablero.squaresNumber; x++) {
				if (x == posX && y == posY)
					tablero.nodes[x][y].setAccesible(false);
				// TODO: Let user erase
			}
		}
	}

}