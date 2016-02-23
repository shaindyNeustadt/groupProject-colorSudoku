package groupProject.colorSudoku;

import java.awt.Color;
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

	private JPanel[][] panels;
	private Box[][] boxes;
	private SudokuGenerator sudoku;

	public SudokuPanel(final SudokuGenerator sudokuGenerator,
			final ColorsPanel colorsPanel) {
		setLayout(new GridLayout(3, 3));
		setBackground(Color.WHITE);

		this.sudoku = sudokuGenerator;
		this.panels = new JPanel[3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				panels[x][y] = new JPanel();
				panels[x][y].setLayout(new GridLayout(3, 3));
				panels[x][y].setBorder(BorderFactory.createLineBorder(
						Color.BLACK, 3));
				add(panels[x][y]);
			}
		}
		boxes = new Box[9][9];

		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				boxes[x][y] = new Box(colorsPanel);
				boxes[x][y].setBorder(BorderFactory.createCompoundBorder(
						BorderFactory.createBevelBorder(BevelBorder.RAISED,
								Color.WHITE, Color.BLACK), BorderFactory
								.createEtchedBorder(EtchedBorder.LOWERED)));

				final int i = x;
				final int j = y;
				boxes[x][y].addActionListener(new ActionListener() {

					public void actionPerformed(ActionEvent arg0) {
						boxes[i][j].setNumber(colorsPanel.getLastColor());
						if (colorsPanel.getLastColor() != 10) {
							sudoku.setNumber(i, j, colorsPanel.getLastColor());
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
			}
		}
		setNewBoard(0);
	}

	public void setNewBoard(int difficulty) {
		sudoku.nextBoard(difficulty);
		for (int x = 0; x < 9; x++) {
			for (int y = 0; y < 9; y++) {
				boxes[x][y].setEnabled(true);
				boxes[x][y].setNumber(10);
				boxes[x][y].setNumber(sudoku.getBoard(x, y));
				if (sudoku.getBoard(x, y) > 0) {
					boxes[x][y].setEnabled(false);
				}
			}
		}
	}
}