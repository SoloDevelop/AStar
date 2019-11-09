package main;

import java.util.ArrayList;

public class Node {

	public int num;
	public Node parent;
	public boolean accesible = true;

	private ArrayList<Node> neighbors = new ArrayList<Node>(); // Nodes next to this one

	public int fScore; // hScore (# of squares away from target - Manhattan eq) + gScore
	public int gScore; // Movement cost record

	public int positionX;
	public int positionY;

	public Node(int num, int positionX, int positionY) {
		this.num = num;
		this.positionX = positionX;
		this.positionY = positionY;
	}

	public boolean isDiagonal(Node node) {
		// TODO Auto-generated method stub
		int targPosX = node.positionX;
		int targPosY = node.positionY;

		// Self explanatory
		if ((targPosX == positionX - 1) || (targPosX == positionX + 1)) {
			if (targPosY == positionY + 1)
				return true;
			if (targPosY == positionY - 1)
				return true;
		}
		return false;
	}

	private boolean isOnSide(Node node) {
		// Self explanatory
		if (node.positionX == this.positionX) {
			if ((node.positionY == this.positionY + 1) || (node.positionY == this.positionY - 1))
				return true;
		}

		if (node.positionY == this.positionY) {
			if ((node.positionX == this.positionX + 1) || (node.positionX == this.positionX - 1))
				return true;
		}

		return false;
	}

//	public ArrayList<Node> getNeighborsRadar() { //TODO: mayb tablero has to deal with ths
//		Tablero tablero = Tablero.getSingletonInstance();
//
//		for (int i = 0; i < tablero.side; i++) {
//			for (int j = 0; j < tablero.side; j++) {
//				Node n = tablero.nodes[i][j];
//				if (this.isDiagonal(n)) {
//					neighbors.add(n);
//				} else if (this.isOnSide(n)) {
//					neighbors.add(n);
//				}
//			}
//		}
//
//		return neighbors;
//	}

//	public ArrayList<Node> getNeighbors() {
//		Tablero tablero = Tablero.getSingletonInstance();
//
//		Node node1 = tablero.nodes[positionX][positionY + 1];
//		if (node1.isAccesible())
//			neighbors.add(node1);
//
//		Node node2 = tablero.nodes[positionX][positionY - 1];
//		if (node2.isAccesible())
//			neighbors.add(node2);
//
//		Node node3 = tablero.nodes[positionX + 1][positionY + 1];
//		if (node3.isAccesible())
//			neighbors.add(node3);
//
//		Node node4 = tablero.nodes[positionX + 1][positionY];
//		if (node4.isAccesible())
//			neighbors.add(node4);
//
//		Node node5 = tablero.nodes[positionX + 1][positionY - 1];
//		if (node5.isAccesible())
//			neighbors.add(node5);
//
//		Node node6 = tablero.nodes[positionX - 1][positionY + 1];
//		if (node6.isAccesible())
//			neighbors.add(node6);
//
//		Node node7 = tablero.nodes[positionX - 1][positionY];
//		if (node7.isAccesible())
//			neighbors.add(node7);
//
//		Node node8 = tablero.nodes[positionX - 1][positionY - 1];
//		if (node8.isAccesible())
//			neighbors.add(node8);
//
//		return neighbors;
//	}

	public void setNeighbors(ArrayList<Node> neighbors) {
		this.neighbors = neighbors;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public Node getParent() {
		return parent;
	}

	public void setParent(Node parent) {
		this.parent = parent;
	}

	public boolean isAccesible() {
		return accesible;
	}

	public void setAccesible(boolean accesible) {
		this.accesible = accesible;
	}

	public int getgScore() {
		return gScore;
	}

	public void setgScore(int gScore) {
		this.gScore = gScore;
	}

	@Override
	public String toString() {
		return "Node " + num + " at " + positionX + "x " + positionY + "y.";
	}

}
