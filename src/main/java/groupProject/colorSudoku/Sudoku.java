package groupProject.colorSudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class Sudoku extends JFrame {
	private SudokuPanel sudokuPanel;
	private SudokuGenerator sudokuGenerator;
	private JPanel buttonPanel;
	private ColorsPanel colorsPanel;
	private JButton newGame;
	private JButton check;
	private JLabel timerLabel;
	private Timer timer;
	private Integer timerCount = 0;

	public Sudoku() {
		setTitle("COLORKU");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(950, 650);
		setLocationRelativeTo(null);
		setResizable(false);

		Container container = getContentPane();
		setLayout(new BorderLayout());

		sudokuGenerator = new SudokuGenerator();
		colorsPanel = new ColorsPanel();
		sudokuPanel = new SudokuPanel(sudokuGenerator, colorsPanel);

		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(0, 3));
		buttonPanel.setSize(600, 50);

		check = new JButton("Check");
		check.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				timer.stop();
				if (sudokuGenerator.checkBoard()) {
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
				long remainMinute = timerCount
						- TimeUnit.HOURS.toMinutes(hours);
				timerLabel.setText("Time: " + String.format("%02d", hours)
						+ ":" + String.format("%02d", remainMinute));
			}

		});
		timer.start();

		OptionsPanel optionsPanel = new OptionsPanel(sudokuPanel,
				sudokuGenerator);

		buttonPanel.add(timerLabel);
		buttonPanel.add(check);

		container.add(sudokuPanel, BorderLayout.CENTER);
		// container.add(buttonPanel, BorderLayout.NORTH);
		container.add(colorsPanel, BorderLayout.SOUTH);
		container.add(optionsPanel, BorderLayout.WEST);
	}

	public static void main(String[] args) {
		new Sudoku().setVisible(true);
	}
}
