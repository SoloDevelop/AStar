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

public class Frame extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField tf_squareSide;
	public static Frame frame;

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

				GridButtonPanel.N = squareSides;

				new main.GridButtonPanel().display();

				// System.out.println(squareSides);
//				for (int row = 0; row < squareSides; row++) {
//					for (int col = 0; col < squareSides; col++) {
//						JCheckBox b = new JCheckBox("");
//						centerPanel.add(b, "cell " + col + " " + row);
//					}
//				}

//				for (int row = 0; row < squareSides; row++) {
//					for (int col = 0; col < squareSides; col++) {
//						JButton b = new JButton();
//						frame.getContentPane().add(b, -1);
//						if (b != null)
//							System.out.println("button " + b.getName() + " added.");
//					}
//				}

//				for (int row = 0; row < squareSides; row++) {
//					for (int col = 0; col < squareSides; col++) {
//						JCheckBox b = new JCheckBox();
//						GridBagConstraints gbc_b = new GridBagConstraints();
//						gbc_b.insets = new Insets(0, 0, 5, 0);
//						gbc_b.gridx = row;
//						gbc_b.gridy = col;
//						centerPanel.add(b, gbc_b);
//						if (b != null)
//							System.out.println("button " + b.getName() + " added.");
//					}
//				}
			}
		});
		northPanel.add(btn_Start);

	}

}
