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
		setBounds(100, 100, 600, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel northPanel = new JPanel();
		contentPane.add(northPanel, BorderLayout.NORTH);
		northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.X_AXIS));

		tf_squareSide = new JTextField();
		tf_squareSide.setToolTipText("Number of rows/columns");
		northPanel.add(tf_squareSide);
		tf_squareSide.setColumns(10);

		JPanel centerPanel = new JPanel();
		contentPane.add(centerPanel, BorderLayout.CENTER);
		centerPanel.setLayout(new MigLayout("", "[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]",
				"[10%][10%][10%][10%][10%][10%][10%][10%][10%][10%]"));

		JButton btn_Start = new JButton("Start");
		btn_Start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int squareSides = Integer.parseInt(tf_squareSide.getText());
				Start(squareSides);

				GridButtonPanel.N = squareSides;
				new main.GridButtonPanel().display();

			}
		});
		northPanel.add(btn_Start);

	}

	public void Start(int sq) {
		// TODO Auto-generated method stub
		tablero = Tablero.getSingletonInstance(sq);
	}

}
