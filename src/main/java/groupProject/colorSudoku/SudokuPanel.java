package groupProject.colorSudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class SudokuPanel extends JPanel {

	private Board board;
	private JPanel[][] panels;
	private Square[][] boxes;

	public SudokuPanel(Board board) {
		setLayout(new GridLayout(3, 3));
		setPreferredSize(new Dimension(600, 600));
		this.board = board;
		this.panels = new JPanel[3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				panels[x][y] = new JPanel();
				panels[x][y].setLayout(new GridLayout(3, 3));
				panels[x][y].setBorder(BorderFactory
						.createLineBorder(Color.RED));
				add(panels[x][y]);
			}
		}
		boxes = new Square[9][9];
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				boxes[x][y] = new Square(board.getGameBoard()[x][y]);
				panels[x / 3][y / 3].add(boxes[x][y]);
				//boxes[x][y].setColor(board.getGameBoard()[x][y], false);
			}
		}
	}

	public void setNewBoard(Board board) {
		this.board = board;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				boxes[x][y] = new Square(board.getGameBoard()[x][y]);
						//.setColor(board.getGameBoard()[x][y], false);
			}
		}
	}
}