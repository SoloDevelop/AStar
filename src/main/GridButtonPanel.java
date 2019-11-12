package main;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSplitPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class GridButtonPanel {

	public static int N = 8;
	private final List<JCheckBox> buttonList = new ArrayList<JCheckBox>();
	public boolean[][] obstacleList = new boolean[N][N];
	Tablero tablero;

	@SuppressWarnings("unused")
	private JCheckBox getGridButton(int r, int c) {
		int index = r * N + c;
		return buttonList.get(index);
	}

	private JCheckBox createGridButton(final int row, final int col) {
		final JCheckBox b = new JCheckBox();
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// JCheckBox gb = GridButtonPanel.this.getGridButton(row, col);
				obstacleList[row][col] = true;
			}
		});
		return b;
	}

	private JPanel createGridPanel() {
		JPanel p = new JPanel(new GridLayout(N, N));
		for (int i = 0; i < N * N; i++) {
			int row = i / N;
			int col = i % N;
			JCheckBox gb = createGridButton(row, col);
			buttonList.add(gb);
			p.add(gb);
		}
		return p;
	}

	public void display() {

		JFrame f = new JFrame("GridButton");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				tablero = Tablero.getSingletonInstance();
				tablero.setUnaccessibles(obstacleList);
			}
		});

		splitPane.setRightComponent(btnSend);
		splitPane.setLeftComponent(createGridPanel());
		f.add(splitPane);

		f.pack();
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}
}
