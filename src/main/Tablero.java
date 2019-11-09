package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class Tablero {

	public int side = 8;
	private static Tablero tablero;

	Node[][] nodes = new Node[side][side];
	Node startNode;
	Node goalNode;

	// #REGION SINGLETON START
	private Tablero(int squares) {
		this.side = squares;
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
			tablero = new Tablero(8);
		}
		return tablero;
	}

	public void setUnaccessibles(boolean[][] obstacleMatrix) {

		int squares = this.side;

		System.out.println(squares);
		for (int y = 0; y < squares; y++) {
			for (int x = 0; x < squares; x++) {
				if (obstacleMatrix[y][x]) {
					tablero.nodes[x][y].setAccesible(false);
					System.out.println(tablero.nodes[x][y].num + " set unaccessible.");
					// System.out.println("Node " + x + " " + y + " is " +
					// tablero.nodes[x][y].isAccesible());
				}
			}
		}
	}

	public int getSide() {
		return side;
	}

	public void setSide(int side) {
		this.side = side;
	}

	public void setGoal(ArrayList<Vector<Integer>> startGoal) {
		// TODO Auto-generated method stub
		int startPosX = startGoal.get(0).get(0);
		int startPosY = startGoal.get(0).get(1);

		int goalPosX = startGoal.get(1).get(0);
		int goalPosY = startGoal.get(1).get(1);

		System.out.println(tablero.nodes[startPosX][startPosY].toString());
		startNode = tablero.nodes[startPosX][startPosY];
		goalNode = tablero.nodes[goalPosX][goalPosY];

		System.out.println(startNode.toString());
		System.out.println(goalNode.toString());
	}

	public String getGoalCheck() {
		return "Start " + startNode.toString() + "\n" + "Goal " + goalNode.toString();
	}

}