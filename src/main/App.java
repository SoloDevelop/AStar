package main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.BoxLayout;
import java.awt.event.ActionListener;
import java.util.Stack;
import java.awt.event.ActionEvent;

public class App extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7975717315846968561L;
	private JPanel contentPane;
	private JTextField tf_squareSide;
	public static App frame;
	Tablero tablero;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					App f = new App();
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
	public App() {
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

		JPanel centrePanel = new JPanel();
		contentPane.add(centrePanel, BorderLayout.CENTER);
		centrePanel.setLayout(null);

		JButton btnTerminate = new JButton("Terminate");
		btnTerminate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// TODO: terminate
				int squareSides = Integer.parseInt(tf_squareSide.getText());
				tablero = Tablero.getSingletonInstance(squareSides);
				Stack<Node> stack = tablero.getPath();
				System.out.println(stack);
			}
		});
		btnTerminate.setBounds(152, 93, 114, 25);
		centrePanel.add(btnTerminate);

		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
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
		btnStart.setBounds(10, 94, 114, 25);
		centrePanel.add(btnStart);

	}

	public void Start(int sq) throws InterruptedException {
		// Game.begin(sq);
		new main.Demo().display();
	}
}
