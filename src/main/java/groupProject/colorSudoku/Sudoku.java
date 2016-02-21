package groupProject.colorSudoku;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sudoku extends JFrame {
	private SudokuPanel sudokuPanel;
	private Board board;
	private JPanel buttonPanel;
	private ColorsPanel colorsPanel;
	private JButton newGame;
	private JButton check;
	private JLabel timerLabel;
	private Timer timer;
	private int timerCount = 0;

	public Sudoku() {
		setTitle("COLORKU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 625);
		setLocationRelativeTo(null);
		setResizable(false);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		board = new Board();
		colorsPanel = new ColorsPanel();
		sudokuPanel = new SudokuPanel(board, colorsPanel);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 3));
		buttonPanel.setSize(600, 50);
		newGame = new JButton("New Game");
		newGame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				board.newGame();
				sudokuPanel.setNewBoard(board);
				timerCount = 0;
			}
		});

		check = new JButton("Check");
		check.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				timer.stop();
				if (board.checkGame()) {
					JOptionPane.showMessageDialog(null, "YOU WON!!");
				} else {
					JOptionPane.showMessageDialog(null, "Keep Trying!!");
				}
				timer.start();
			}
		});

		timerLabel = new JLabel();
		timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				timerCount++;

				long hours = TimeUnit.MINUTES.toHours(timerCount);
				long remainMinute = timerCount - TimeUnit.HOURS.toMinutes(hours);
				timerLabel.setText("Time: " + String.format("%02d", hours) + ":" + String.format("%02d", remainMinute));
			}

		});
		timer.start();

		buttonPanel.add(newGame);
		buttonPanel.add(timerLabel);
		buttonPanel.add(check);

		container.add(sudokuPanel, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.NORTH);
		container.add(colorsPanel, BorderLayout.SOUTH);
	}

	public static void main(String[] args) {
		new Sudoku().setVisible(true);
	}
}
