package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import javax.swing.JTable;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Insets;
import java.awt.GridLayout;
import javax.swing.BoxLayout;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import net.miginfocom.swing.MigLayout;
import javax.swing.JSplitPane;

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tf_squareSide;
	public static Frame frame;
	Tablero tablero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {

				new main.TrainDemo().display();

				try {
					Frame f = new Frame();
					f.setVisible(true);
					frame = f;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Frame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));

		tf_squareSide = new JTextField("8");
		tf_squareSide.setToolTipText("Number of rows/columns");
		northPanel.add(tf_squareSide);
		tf_squareSide.setColumns(10);

		JButton btn_SetMap = new JButton("Set Map");
		btn_SetMap.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nSide = Integer.parseInt(tf_squareSide.getText());
				tablero = Tablero.getSingletonInstance(nSide);
				tablero.setSide(nSide);
				GridButtonPanel.N = nSide;
				new main.GridButtonPanel().display();
			}
		});
		northPanel.add(btn_SetMap);

		JButton btn_SetGoal = new JButton("Set Start/Finish");
		btn_SetGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int nSide = Integer.parseInt(tf_squareSide.getText());
				tablero = Tablero.getSingletonInstance(nSide);
				tablero.setSide(nSide);
				GridGoalPanel.N = nSide;
				new main.GridGoalPanel().display();
			}
		});
		northPanel.add(btn_SetGoal);

		JButton btn_Start = new JButton("Start");
		btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int squareSides = Integer.parseInt(tf_squareSide.getText());
				tablero = Tablero.getSingletonInstance(squareSides);
				try {
					Start(squareSides);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		northPanel.add(btn_Start);

		JPanel centrePanel = new JPanel();
		contentPane.add(centrePanel, BorderLayout.CENTER);
		centrePanel.setLayout(null);

		JButton btnTerminate = new JButton("Terminate");
		btnTerminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Game.off();
			}
		});
		btnTerminate.setBounds(152, 93, 114, 25);
		centrePanel.add(btnTerminate);

	}

	public void Start(int sq) throws InterruptedException {
		// TODO Auto-generated method stub
		tablero = Tablero.getSingletonInstance(8);
		Game.begin(sq);
	}
}
