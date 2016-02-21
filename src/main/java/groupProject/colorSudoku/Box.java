package groupProject.colorSudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Box extends JButton {

	private int x;
	private int y;
	private boolean setByUser;
	static Color[] colorArray;

	public Box(int x, int y, final ColorsPanel colorsPanel) {
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 200));
		this.x = x;
		this.y = y;

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

		this.setOpaque(true);
	}

	public void setNumber(int number) {
		if (number > 0) {
			setBackground(colorArray[number - 1]);
			
		} else {
			setBackground(Color.getHSBColor(0, 0, .9F));
		}
	}

}