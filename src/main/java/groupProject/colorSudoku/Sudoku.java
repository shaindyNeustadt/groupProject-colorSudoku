package groupProject.colorSudoku;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Sudoku extends JFrame {
	private SudokuPanel sudokuPanel;
	private Board board;
	private JPanel buttonPanel;
	private JButton newGame;
	private JButton check;
	private JLabel timer;

	public Sudoku() {
		setTitle("COLORKU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(600, 625);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		board = new Board();

		sudokuPanel = new SudokuPanel(board);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 3));
		buttonPanel.setSize(600, 50);
		newGame = new JButton("New Game");
		newGame.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				board.newGame();
				sudokuPanel.setNewBoard(board);
			}
		});
		check = new JButton("Check");
		check.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				if (board.checkGame()) {
					JOptionPane.showMessageDialog(null, "YOU WON!!");
				} else {
					JOptionPane.showMessageDialog(null, "Keep Trying!!");
				}
			}
		});

		timer = new JLabel("MM:SS");

		buttonPanel.add(newGame);
		buttonPanel.add(timer);
		buttonPanel.add(check);

		container.add(sudokuPanel, BorderLayout.CENTER);
		container.add(buttonPanel, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new Sudoku().setVisible(true);
	}
}
