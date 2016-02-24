package groupProject.colorSudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class DifficultiesPanel extends JPanel {

	private JLabel easy, medium, hard;
	private SudokuPanel sudokuPanel;

	public DifficultiesPanel(final SudokuPanel sudokuPanel, final SudokuGenerator sudokuGenerator) {

		this.setSize(new Dimension(100, 400));
		this.setLayout(new GridLayout(3, 0));
		this.setBackground(Color.WHITE);
		this.sudokuPanel = sudokuPanel;

		setUpDifficulties();

		add(easy);
		add(medium);
		add(hard);
	}

	public void setUpDifficulties() {
		easy = new JLabel();
		easy.setBackground(Color.WHITE);
		easy.setIcon(new ImageIcon(new ImageIcon("./easy.jpg").getImage().getScaledInstance(100, 100,
				Image.SCALE_SMOOTH)));
		easy.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				sudokuPanel.setNewBoard(25);
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});

		medium = new JLabel();
		medium.setBackground(Color.WHITE);
		medium.setIcon(new ImageIcon(new ImageIcon("./medium.jpg").getImage().getScaledInstance(100, 100,
				Image.SCALE_SMOOTH)));
		medium.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				sudokuPanel.setNewBoard(35);
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});

		hard = new JLabel();
		hard.setBackground(Color.WHITE);
		hard.setIcon(new ImageIcon(new ImageIcon("./hard.jpg").getImage().getScaledInstance(100, 100,
				Image.SCALE_SMOOTH)));
		hard.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				sudokuPanel.setNewBoard(45);
			}

			public void mouseEntered(MouseEvent arg0) {
			}

			public void mouseExited(MouseEvent arg0) {
			}

			public void mousePressed(MouseEvent arg0) {
			}

			public void mouseReleased(MouseEvent arg0) {
			}
		});
	}
}