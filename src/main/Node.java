package main;

import java.util.List;

public class Node {

	public int num;
	public Node parent;
	public boolean accesible;

	public List<Node> neighbors; // Nodes next to this one

	public int fScore; // hScore + gScore
	public int gScore; // Movement cost record
	public int hScore; // Manhattan eq result (# of grids away from target)

	public int positionX;
	public int positionY;

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

	public List<Node> getNeighbors() {
		return neighbors;
	}

	public void setNeighbors(List<Node> neighbors) {
		this.neighbors = neighbors;
	}

	public int getgScore() {
		return gScore;
	}

	public void setgScore(int gScore) {
		this.gScore = gScore;
	}

	public int gethScore() {
		return hScore;
	}

	public void sethScore(int hScore) {
		this.hScore = hScore;
	}

}
