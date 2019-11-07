package main;

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

}