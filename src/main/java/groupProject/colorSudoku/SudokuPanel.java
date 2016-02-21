package groupProject.colorSudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class SudokuPanel extends JPanel {

	private Board board;
	private ColorsPanel colorsPanel;
	private JPanel[][] panels;
	private Box[][] boxes;

	public SudokuPanel(final Board board, final ColorsPanel colorsPanel) {
		setLayout(new GridLayout(3, 3));
		setPreferredSize(new Dimension(100, 100));
		this.board = board;
		this.colorsPanel = colorsPanel;
		this.panels = new JPanel[3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				panels[x][y] = new JPanel();
				panels[x][y].setLayout(new GridLayout(3, 3));
				panels[x][y].setBorder(BorderFactory.createLineBorder(Color.RED));
				add(panels[x][y]);
			}
		}
		boxes = new Box[9][9];
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				boxes[x][y] = new Box(x, y, colorsPanel);
				boxes[x][y].setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK),
						BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
				final int i = x;
				final int j = y;
				boxes[x][y].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						boxes[i][j].setNumber(colorsPanel.getLastColor());
						if (colorsPanel.getLastColor() != 10) {
							board.setNumber(i, j, colorsPanel.getLastColor() + 1);
						}
					}

				});

				boxes[x][y].addMouseListener(new MouseListener() {

					public void mouseClicked(MouseEvent arg0) {
					}

					public void mouseEntered(MouseEvent arg0) {
					}

					public void mouseExited(MouseEvent arg0) {

					}

					public void mousePressed(MouseEvent arg0) {

					}

					public void mouseReleased(MouseEvent arg0) {
						if (SwingUtilities.isRightMouseButton(arg0)) {
							if (boxes[i][j].isEnabled()) {
								boxes[i][j].setNumber(10);
							}
						}
					}

				});
				panels[x / 3][y / 3].add(boxes[x][y]);
				boxes[x][y].setNumber(board.getGameBoard()[x][y]);
				if (board.getGameBoard()[x][y] > 0) {
					boxes[x][y].setEnabled(false);
				}
			}
		}
	}

	public void setNewBoard(Board board) {
		this.board = board;
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				boxes[x][y].setNumber(board.getGameBoard()[x][y]);
			}
		}
	}

}