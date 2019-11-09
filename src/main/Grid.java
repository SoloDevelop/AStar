package main;

import java.awt.*;
import javax.swing.*;

public class Grid extends JPanel {

	// TODO: SIze

	public Grid() {
		setSize(900, 900);
		setVisible(true);
	}

	public void paint(Graphics g) {
		// xPos
		for (int x = 30; x <= 730; x += 100)
			for (int y = 30; y <= 730; y += 100)
				g.drawRect(x, y, 100, 100);
	}

//	public static void main(String args[]) {
//		Grid application = new Grid();
//		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	}
}