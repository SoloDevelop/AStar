package main;

import java.util.ArrayList;
import java.util.Stack;

public class AStar {

	public static Stack<Node> Move(Node startNode, Node targetNode) {

		Tablero tablero = Tablero.getSingletonInstance();
		Node currentNode = null;
		ArrayList<Node> openList = new ArrayList<Node>(); // Nodes to process
		ArrayList<Node> closedList = new ArrayList<Node>(); // Nodes processed
		int movementCost;

		startNode.setgScore(0);
		startNode.fScore = startNode.getgScore() + hScore(startNode, targetNode);
		openList.add(startNode);

		while (!openList.isEmpty()) {

			currentNode = GetLowestFScore(openList); // Steps into the lowest fScore grid

			if (currentNode == targetNode) { // Finished?
				return ConstructPath(targetNode);
			}

			openList.remove(currentNode); // Processed
			closedList.add(currentNode);

			for (Node neighborNode : tablero.getNeighbors(currentNode)) {

				if (!FindNodeInList(neighborNode, closedList)) {

					if (neighborNode.isDiagonal(currentNode))
						movementCost = 14;
					else
						movementCost = 10;

					int testGScore = currentNode.gScore + movementCost;

					if (!FindNodeInList(currentNode, openList)) {

						neighborNode.gScore = testGScore;
						neighborNode.fScore = neighborNode.gScore + hScore(neighborNode, targetNode);
						neighborNode.parent = currentNode;
						openList.add(neighborNode);

					} else {

						if (testGScore < neighborNode.gScore) {
							neighborNode.gScore = testGScore;
							neighborNode.fScore = neighborNode.gScore + hScore(neighborNode, targetNode);
							neighborNode.parent = currentNode;
						}
					}
				}
			}
		}
		return null;
	}

	// TODO: NO sabe subir?
	private static boolean FindNodeInList(Node node, ArrayList<Node> list) {
		// TODO Auto-generated method stub
		if (list.contains(node))
			return true;
		else
			return false;
//		for (Node n : list) {
//			if (n.equals(node))
//				return true;
//		}
//		return false;
	}

	private static Stack<Node> ConstructPath(Node node) {
		// TODO Auto-generated method stub
		Stack<Node> path = new Stack<Node>();

		do {
			path.push(node);
			node = node.parent;
		} while (node.parent != null);

		return path;
	}

	private static Node GetLowestFScore(ArrayList<Node> openList) {

		int lowestScore = openList.get(0).fScore;

		Node node = null;

		for (Node n : openList) {

			if (n.fScore <= lowestScore) {
				lowestScore = n.fScore;
				node = n;
			}
		}
		return node;
	}

	private static int hScore(Node startNode, Node targetNode) {

		int xDelta = Math.abs(targetNode.positionX - startNode.positionX);
		int yDelta = Math.abs(targetNode.positionY - startNode.positionY);

		return 10 * (xDelta + yDelta);
	}

}
