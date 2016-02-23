package groupProject.colorSudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;

public class Box extends JButton {

	static Color[] colorArray;

	public Box(final ColorsPanel colorsPanel) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(50, 50));

		colorArray = colorsPanel.getColorArray();
	}

	public void setNumber(int number) {
		if (number > 0) {
			setBackground(colorArray[number - 1]);
		} else {
			setBackground(Color.WHITE);
		}
	}
}