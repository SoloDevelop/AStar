package main;

import javax.swing.*;
import java.awt.*;
import java.util.EmptyStackException;
import java.util.Stack;

public class Demo {

	public static Stack<Node> stack;

	public void display() {
		JFrame frame = new JFrame("Demo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		frame.add(new DemoCanvas());
		frame.setVisible(true);
	}

}

class DemoCanvas extends JComponent {
	Tablero tablero;
	private int lastX;
	private int lastY;
	int targetXPos;
	int targetYPos;
	boolean on = true;

	Stack<Node> path;
	Rect[][] board = new Rect[8][8]; // TODO: stop cheating

	public DemoCanvas() {
		Thread animationThread = new Thread(new Runnable() {
			public void run() {
				tablero = Tablero.getSingletonInstance();
				if (tablero.nodes != null) {
					path = tablero.getPath();
					lastX = tablero.startNode.positionX * 100 + 50;
					lastY = tablero.startNode.positionY * 100 + 50;
					targetXPos = tablero.goalNode.positionX * 100 + 50;
					targetYPos = tablero.goalNode.positionY * 100 + 50;
				} else
					System.out.println("Null nodes");

				while (on) {
					repaint();
					try {
						Thread.sleep(10);
					} catch (Exception ex) {
					}
				}
			}
		});

		animationThread.start();
	}

	public void paintComponent(Graphics g) {
		int i = 0, j = 0;

		for (int y = 0; y <= 700; y += 100) {
			j = 0;
			for (int x = 0; x <= 700; x += 100) {
				g.drawRect(x, y, 100, 100);
				board[i][j] = new Rect(x, y);
				j++;
			}
			i++;
		}

		Graphics2D gg = (Graphics2D) g;

		int trainW = 30;
		int trainH = 30;
		int speed = 3;

		int x = 0;
		int y = 0;

		if (lastX == targetXPos && lastY == targetYPos) {
			try {
				Node n = path.pop();
				if (n != null) {
					targetXPos = n.positionX * 100;
					targetYPos = n.positionY * 100;

					System.out.println(n);
				}
			} catch (EmptyStackException e) {
				on = false;
			}

		}

		if (lastX < targetXPos) {
			x = lastX + speed;
		}

		if (lastY < targetYPos) {
			y = lastY + speed;
		}

		if (lastX > targetXPos) {
			x = lastX - speed;
		}

		if (lastY > targetYPos) {
			y = lastY - speed;
		}

		if (lastX > targetXPos - 10 && x < targetXPos + 10) {
			x = targetXPos;
		}

		if (lastY > targetYPos - 10 && y < targetYPos + 10) {
			y = targetYPos;
		}

		gg.setColor(Color.BLACK);
		gg.fillRect(x + 50, y + 50, trainW, trainH);

		lastX = x;
		lastY = y;

	}

}