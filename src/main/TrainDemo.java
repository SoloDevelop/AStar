package main;

import javax.swing.*;
import java.awt.*;
import java.util.Stack;

public class TrainDemo {

	public static Stack<Node> stack;

	public void display() {
		JFrame frame = new JFrame("Demo");
		frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frame.setSize(900, 900);
		frame.setLocationRelativeTo(null);
		frame.add(new TrainCanvas());
		frame.setVisible(true);
	}

}

class TrainCanvas extends JComponent {
	Tablero tablero;
	private int lastX = 0;
	private int lastY = 0;
	int targetXPos = 100;
	int targetYPos = 100;

	public TrainCanvas() {
		Thread animationThread = new Thread(new Runnable() {
			public void run() {
				tablero = Tablero.getSingletonInstance();
				
				while (true) {
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

		for (int x = 50; x <= 750; x += 100)
			for (int y = 00; y <= 700; y += 100)
				g.drawRect(x, y, 100, 100);

		Graphics2D gg = (Graphics2D) g;

		int w = getWidth();
		int h = getHeight();

		int trainW = 30;
		int trainH = 30;
		int trainSpeed = 3;

		int x = 0;
		int y = 0;

		if (lastX == targetXPos && lastY == targetYPos) {
			targetXPos = 400;
			targetYPos = 300;

			// NEXT STACK
		}

		if (x < targetXPos) {
			x = lastX + trainSpeed;
		}

		if (y < targetYPos) {
			y = lastY + trainSpeed;
		}

		if (x > targetXPos) {
			x = lastX - trainSpeed;
		}

		if (y > targetYPos) {
			y = lastY - trainSpeed;
		}

		if (x > targetXPos - 10 && x < targetXPos + 10) {
			x = targetXPos;
		}

		if (y > targetYPos - 10 && y < targetYPos + 10) {
			y = targetYPos;
		}

		gg.setColor(Color.BLACK);
		gg.fillRect(x, y, trainW, trainH);

		lastX = x;
		lastY = y;

	}

}