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

		colorArray = new Color[10];
		colorArray[0] = new Color(255, 51, 51);
		colorArray[1] = new Color(255, 153, 51);
		colorArray[2] = new Color(255, 255, 51);
		colorArray[3] = new Color(153, 255, 51);
		colorArray[4] = new Color(51, 255, 255);
		colorArray[5] = new Color(51, 153, 255);
		colorArray[6] = new Color(153, 51, 255);
		colorArray[7] = new Color(255, 51, 153);
		colorArray[8] = new Color(160, 160, 160);
		colorArray[9] = Color.WHITE;

		this.setOpaque(true);
	}

	public void setNumber(int number) {
		if (number > 0) {
			setBackground(colorArray[number - 1]);

		} else {
			setBackground(Color.WHITE);
		}
	}

}