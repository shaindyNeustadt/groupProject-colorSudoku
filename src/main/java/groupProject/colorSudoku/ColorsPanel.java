package groupProject.colorSudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class ColorsPanel extends JPanel {

	private JButton[] buttons;
	private int lastColor = 9;
	private Color[] colorArray;

	public ColorsPanel() {

		colorArray = new Color[10];
		colorArray[0] = new Color(255, 0, 217);
		colorArray[1] = Color.ORANGE;
		colorArray[2] = Color.YELLOW;
		colorArray[3] = Color.GREEN;
		colorArray[4] = Color.BLUE;
		colorArray[5] = Color.CYAN;
		colorArray[6] = Color.PINK;
		colorArray[7] = Color.WHITE;
		colorArray[8] = Color.BLACK;
		colorArray[9] = Color.getHSBColor(0, 0, .9F);

		this.setLayout(new FlowLayout());
		this.buttons = new JButton[9];

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setBackground(colorArray[i]);
			buttons[i].setBorder(BorderFactory.createCompoundBorder(
				BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE, Color.BLACK),
					BorderFactory.createEtchedBorder(EtchedBorder.LOWERED)));
			final int j = i;
			buttons[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if (lastColor != 9) {
						buttons[lastColor].setBorder(BorderFactory.createLineBorder(colorArray[lastColor]));
					}
					lastColor = j;
					buttons[j].setBorder(BorderFactory.createLineBorder(Color.RED));
					
				}
			});
			buttons[i].setPreferredSize(new Dimension(50, 50));
			add(buttons[i]);
		}
	}

	/**
	 * buttons[1] = new JButton(); buttons[1].setBackground(Color.ORANGE);
	 * buttons[1].addActionListener(new ActionListener() {
	 * 
	 * public void actionPerformed(ActionEvent arg0) { colorChosen =
	 * Color.ORANGE; } }); buttons[2] = new JButton();
	 * buttons[2].setBackground(Color.YELLOW); buttons[2].addActionListener(new
	 * ActionListener() {
	 * 
	 * public void actionPerformed(ActionEvent arg0) { colorChosen =
	 * Color.YELLOW; } }); buttons[3] = new JButton();
	 * buttons[3].setBackground(Color.GREEN); buttons[3].addActionListener(new
	 * ActionListener() {
	 * 
	 * public void actionPerformed(ActionEvent arg0) { colorChosen =
	 * Color.GREEN; } }); buttons[4] = new JButton();
	 * buttons[4].setBackground(Color.BLUE); buttons[4].addActionListener(new
	 * ActionListener() {
	 * 
	 * public void actionPerformed(ActionEvent arg0) { colorChosen = Color.BLUE;
	 * } }); buttons[5] = new JButton(); buttons[5].setBackground(Color.CYAN);
	 * buttons[5].addActionListener(new ActionListener() {
	 * 
	 * public void actionPerformed(ActionEvent arg0) { colorChosen = Color.CYAN;
	 * } }); buttons[6] = new JButton(); buttons[6].setBackground(Color.PINK);
	 * buttons[6].addActionListener(new ActionListener() {
	 * 
	 * public void actionPerformed(ActionEvent arg0) { colorChosen = Color.PINK;
	 * } }); buttons[7] = new JButton(); buttons[7].setBackground(Color.WHITE);
	 * buttons[7].addActionListener(new ActionListener() {
	 * 
	 * public void actionPerformed(ActionEvent arg0) { colorChosen =
	 * Color.WHITE; } }); buttons[8] = new JButton();
	 * buttons[8].setBackground(Color.BLACK); buttons[8].addActionListener(new
	 * ActionListener() {
	 * 
	 * public void actionPerformed(ActionEvent arg0) { colorChosen =
	 * Color.BLACK; } });
	 * 
	 * for (int i = 0; i < buttons.length; i++) {
	 * buttons[i].setPreferredSize(new Dimension(50, 50)); add(buttons[i]); } }
	 */

	public int getLastColor() {
		return lastColor + 1;
	}
}