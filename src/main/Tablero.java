package main;

import java.util.ArrayList;
import java.util.Stack;
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

	public Stack<Node> getPath() {
		if (startNode == null) {
			System.out.println("Null startNode");
			return null;
		}

		else if (goalNode == null) {
			System.out.println("Null goalNode");
			return null;

		} else
			return AStar.Move(startNode, goalNode);
	}

	public ArrayList<Node> getNeighbors(Node node0) {

		ArrayList<Node> neighbors = new ArrayList<Node>();

		int posX0 = node0.positionX;
		int posX1 = node0.positionX + 1;
		int posX2 = node0.positionX - 1;

		int posY0 = node0.positionY;
		int posY1 = node0.positionY + 1;
		int posY2 = node0.positionY - 1;

		if (isValid(posX0) && isValid(posY1)) {
			Node node1 = tablero.nodes[posX0][posY1];
			if (node1.isAccesible())
				neighbors.add(node1);
		}
		if (isValid(posX0) && isValid(posY2)) {
			Node node2 = tablero.nodes[posX0][posY2];
			if (node2.isAccesible())
				neighbors.add(node2);
		}
		if (isValid(posX1) && isValid(posY1)) {
			Node node3 = tablero.nodes[posX1][posY1];
			if (node3.isAccesible())
				neighbors.add(node3);
		}

		if (isValid(posX1) && isValid(posY0)) {
			Node node4 = tablero.nodes[posX1][posY0];
			if (node4.isAccesible())
				neighbors.add(node4);
		}

		if (isValid(posX1) && isValid(posY2)) {
			Node node5 = tablero.nodes[posX1][posY2];
			if (node5.isAccesible())
				neighbors.add(node5);
		}

		if (isValid(posX2) && isValid(posY1)) {
			Node node6 = tablero.nodes[posX2][posY1];
			if (node6.isAccesible())
				neighbors.add(node6);
		}

		if (isValid(posX2) && isValid(posY0)) {
			Node node7 = tablero.nodes[posX2][posY0];
			if (node7.isAccesible())
				neighbors.add(node7);
		}

		if (isValid(posX2) && isValid(posY2)) {
			Node node8 = tablero.nodes[posX2][posY2];
			if (node8.isAccesible())
				neighbors.add(node8);
		}

		return neighbors;
	}

	private boolean isValid(int pos) {
		if (pos >= 0 && pos < 8)
			return true;
		else
			return false;
	}

}