package main;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSplitPane;

public class GridGoalPanel {

	public static int N = 8;
	private final List<JRadioButton> buttonList = new ArrayList<JRadioButton>();
	public ArrayList<Vector<Integer>> startGoal = new ArrayList<Vector<Integer>>();

	Tablero tablero;

	private JRadioButton getGridButton(int r, int c) {
		int index = r * N + c;
		return buttonList.get(index);
	}

	private JRadioButton createGridButton(final int row, final int col) {
		final JRadioButton b = new JRadioButton();
		b.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO: Solo se guarda el primero que se marca
				// JCheckBox gb = GridButtonPanel.this.getGridButton(row, col);
				if (startGoal.size() < 2) {
					Vector<Integer> v = new Vector<Integer>();
					v.add(col);
					v.add(row);
					startGoal.add(v);
				}
			}
		});
		return b;
	}

	private JPanel createGridPanel() {
		JPanel p = new JPanel(new GridLayout(N, N));
		for (int i = 0; i < N * N; i++) {
			int row = i / N;
			int col = i % N;
			JRadioButton gb = createGridButton(row, col);
			buttonList.add(gb);
			p.add(gb);
		}
		return p;
	}

	public void display() {

		tablero = Tablero.getSingletonInstance();

		JFrame f = new JFrame("GridButton");
		f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

		JSplitPane splitPane = new JSplitPane();
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);

		JButton btnSend = new JButton("Send");
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: delete this
				tablero.setGoal(startGoal);
				System.out.println(tablero.getGoalCheck());
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