package groupProject.colorSudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class OptionsPanel extends JPanel {
	private JLabel timerLabel;
	private Timer timer;
	private Integer timerCount;
	private JLabel check, help;
	private JLabel picture1, picture2;
	private SudokuGenerator sudokuGenerator;

	public OptionsPanel(SudokuGenerator sudokuGenerator) {
		this.sudokuGenerator = sudokuGenerator;
		this.timerCount = -1;
		this.setLayout(new BorderLayout());
		this.setBackground(Color.WHITE);
		this.setSize(100, 50);

		setUpChecker();
		setUpHelp();
		setTimer();
		setUpPicture();

		JPanel panel1 = new JPanel();
		panel1.setLayout(new GridLayout(0, 2));
		panel1.setBackground(Color.WHITE);

		panel1.add(picture1);
		panel1.add(picture2);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new GridLayout(0, 2));
		panel2.setBackground(Color.WHITE);

		panel2.add(check);
		panel2.add(help);

		this.add(panel1, BorderLayout.WEST);
		this.add(timerLabel, BorderLayout.CENTER);
		this.add(panel2, BorderLayout.EAST);
	}

	public void setUpPicture() {
		this.picture1 = new JLabel();
		this.picture1.setPreferredSize(new Dimension(150, 50));
		this.picture1.setIcon(new ImageIcon(new ImageIcon("./image1.jpg").getImage().getScaledInstance(150, 50,
				Image.SCALE_SMOOTH)));
		this.picture2 = new JLabel();
		this.picture2.setPreferredSize(new Dimension(150, 50));
		this.picture2.setIcon(new ImageIcon(new ImageIcon("./image2.jpg").getImage().getScaledInstance(150, 50,
				Image.SCALE_SMOOTH)));
	}

	public void setUpChecker() {
		check = new JLabel();
		check.setBackground(Color.WHITE);
		check.setIcon(new ImageIcon(new ImageIcon("./check.jpg").getImage().getScaledInstance(50, 50,
				Image.SCALE_SMOOTH)));
		check.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				timer.stop();
				if (sudokuGenerator.checkBoard()) {
					JOptionPane.showMessageDialog(null, "YOU WON!!");
				} else {
					JOptionPane.showMessageDialog(null, "Keep Trying!!");
				}
				timer.start();
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

	public void setUpHelp() {
		help = new JLabel();
		help.setBackground(Color.WHITE);
		help.setIcon(new ImageIcon(new ImageIcon("./help1.png").getImage()
				.getScaledInstance(50, 50, Image.SCALE_SMOOTH)));
		help.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				timer.stop();
				JOptionPane
						.showMessageDialog(
								null,
								"INSTRUCTIONS:\n"
										+ "Fill in the grid with colors so that each column, each row,    \nand each of the nine 3×3 sub-grids that compose the grid\ncontains all of the nine colors."
										+ " Click on a color on the\nbottom to fill in a square. Right click to undo a selection."
										+ "\nChoose the level of your choice and race the clock! Enjoy!");
				timer.start();
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

	public void setTimer() {
		timerLabel = new JLabel();
		timerLabel.setBackground(Color.WHITE);
		timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if (sudokuGenerator.restart()) {
					timerCount = -1;
					sudokuGenerator.setRestart();
				}
				timerCount++;
				long hours = TimeUnit.MINUTES.toHours(timerCount);
				long remainMinute = timerCount - TimeUnit.HOURS.toMinutes(hours);
				timerLabel.setText(String.format("      " + "%02d", hours) + ":" + String.format("%02d", remainMinute));
				timerLabel.setFont(new Font("Calibri", Font.BOLD, 25));
			}
		});
		timer.start();
	}
}
