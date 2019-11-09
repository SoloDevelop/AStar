package main;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Game extends JPanel {

	public static boolean on = true;
	int x = 0;
	int y = 0;
	Tablero tablero = Tablero.getSingletonInstance();
	public static Stack<Node> stack;

	private void updatePosition() {
		x += 1;
		y += 1;
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		g2d.fillOval(x, y, 30, 30);
//
//		for (int x = 30; x <= 730; x += 100)
//			for (int y = 30; y <= 730; y += 100)
//				g.drawRect(x, y, 100, 100);
	}

	public static void begin(int side) throws InterruptedException {
		JFrame frame = new JFrame("Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Game game = new Game();
		Grid grid = new Grid();

		frame.add(game);
		frame.add(grid);

		frame.setSize(side * 100, side * 100);
		frame.setVisible(true);

		frame.pack();
		// stack = AStar.Move(startNode, targetNode)

		while (true) {
			if (!on) {
				frame.dispose();
			}
			game.updatePosition();
			game.repaint();
			Thread.sleep(10);
		}
	}

	public static void off() {
		on = false;
	}

}