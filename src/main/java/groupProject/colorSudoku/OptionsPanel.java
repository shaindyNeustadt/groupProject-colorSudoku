package groupProject.colorSudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.concurrent.TimeUnit;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.border.Border;

public class OptionsPanel extends JPanel {

	private JLabel picture, easy, medium, hard, check, help;
	private int timerCount;
	private JLabel timerLabel;
	private Timer timer;
	private SudokuPanel sudokuPanel;
	private SudokuGenerator sudokuGenerator;

	public OptionsPanel(final SudokuPanel sudokuPanel,
			final SudokuGenerator sudokuGenerator) {

		// this.setSize(new Dimension(100, 100));
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.setBackground(Color.WHITE);
		this.sudokuPanel = sudokuPanel;
		this.sudokuGenerator = sudokuGenerator;

		JPanel panel1 = new JPanel();
		panel1.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel1.setBackground(Color.WHITE);

		JPanel panel2 = new JPanel();
		panel2.setLayout(new FlowLayout(FlowLayout.CENTER));
		panel2.setBackground(Color.WHITE);

		setUpPicture();
		setUpDifficulties();
		setUpChecker();
		setUpHelp();
		setTimer();

		panel1.add(easy);
		panel1.add(medium);
		panel1.add(hard);
		panel2.add(check);
		panel2.add(help);
		panel2.add(timerLabel);
		add(picture);
		add(panel1);
		add(panel2);

	}

	public void setUpPicture() {
		this.picture = new JLabel();
		this.picture.setIcon(new ImageIcon(new ImageIcon("./image.jpg")
				.getImage().getScaledInstance(300, 250, Image.SCALE_SMOOTH)));
	}

	public void setUpDifficulties() {
		easy = new JLabel();
		easy.setBackground(Color.WHITE);
		easy.setIcon(new ImageIcon(new ImageIcon("./easy.jpg").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		easy.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				sudokuPanel.setNewBoard(25);
				timerCount = 0;
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
		medium.setIcon(new ImageIcon(new ImageIcon("./medium.jpg").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		medium.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				sudokuPanel.setNewBoard(35);
				timerCount = 0;
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
		hard.setIcon(new ImageIcon(new ImageIcon("./hard.jpg").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		hard.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {
				sudokuPanel.setNewBoard(45);
				timerCount = 0;
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

	public void setUpChecker() {
		check = new JLabel();
		check.setBackground(Color.WHITE);
		check.setIcon(new ImageIcon(new ImageIcon("./check3.jpg").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
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
		help.setIcon(new ImageIcon(new ImageIcon("./help.jpg").getImage()
				.getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		help.addMouseListener(new MouseListener() {

			public void mouseClicked(MouseEvent arg0) {

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
		timerLabel.setIcon(new ImageIcon(new ImageIcon("./timer2.png")
				.getImage().getScaledInstance(100, 100, Image.SCALE_SMOOTH)));
		timerLabel.setIconTextGap(-80);
		timer = new Timer(1000, new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				timerCount++;

				long hours = TimeUnit.MINUTES.toHours(timerCount);
				long remainMinute = timerCount
						- TimeUnit.HOURS.toMinutes(hours);
				timerLabel.setText(String.format("%02d", hours) + ":"
						+ String.format("%02d", remainMinute));
				timerLabel.setFont(new Font("Calibri", Font.BOLD, 25));
			}

		});
		timer.start();
	}
}
