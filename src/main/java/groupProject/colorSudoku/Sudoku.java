package groupProject.colorSudoku;

import java.awt.BorderLayout;
import java.awt.Container;

import javax.swing.JFrame;

public class Sudoku extends JFrame {

	private SudokuPanel sudokuPanel;
	private SudokuGenerator sudokuGenerator;
	private OptionsPanel optionsPanel;
	private ColorsPanel colorsPanel;
	private DifficultiesPanel difficultiesPanel;

	public Sudoku() {
		setTitle("COLORKU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(650, 650);
		setLocationRelativeTo(null);
		setResizable(false);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		sudokuGenerator = new SudokuGenerator();
		colorsPanel = new ColorsPanel();
		sudokuPanel = new SudokuPanel(sudokuGenerator, colorsPanel);
		optionsPanel = new OptionsPanel(sudokuGenerator);
		difficultiesPanel = new DifficultiesPanel(sudokuPanel, sudokuGenerator);

		container.add(sudokuPanel, BorderLayout.CENTER);
		container.add(colorsPanel, BorderLayout.SOUTH);
		container.add(difficultiesPanel, BorderLayout.WEST);
		container.add(optionsPanel, BorderLayout.NORTH);
	}

	public static void main(String[] args) {
		new Sudoku().setVisible(true);
	}
}