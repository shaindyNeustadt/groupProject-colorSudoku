package groupProject.colorSudoku;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class Box extends JPanel {

	private int x;
	private int y;
	private ColorChooser colorChooser;
	private boolean setByUser;
	private boolean setByBoard;
	// private Color color;
	static Color[] colorArray;

	public Box(int x, int y) {
		// super("", CENTER);
		setLayout(new BorderLayout());
		setPreferredSize(new Dimension(200, 200));
		this.x = x;
		this.y = y;
		this.colorChooser = new ColorChooser();
		add(colorChooser, BorderLayout.CENTER);
		colorChooser.setVisible(false);

		colorArray = new Color[9];
		colorArray[0] = Color.RED;
		colorArray[1] = Color.ORANGE;
		colorArray[2] = Color.YELLOW;
		colorArray[3] = Color.GREEN;
		colorArray[4] = Color.BLUE;
		colorArray[5] = Color.CYAN;
		colorArray[6] = Color.PINK;
		colorArray[7] = Color.WHITE;
		colorArray[8] = Color.BLACK;

		this.setOpaque(true);
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));

		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				colorChooser.setVisible(true);
			}
		});

		this.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent evt) {
				colorChooser.setVisible(false);
			}
		});
	}

	public void setNumber(int number, boolean setByUser) {
		if (number > 0) {
			// this.setText(String.valueOf(number));
			setBackground(colorArray[number - 1]);
		} else {

			// colorChooser.setVisible(true);
			// this.setText("");
			setBackground(Color.getHSBColor(0, 0, .9F));

		}
	}

}