package groupProject.colorSudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ColorChooser extends JPanel {
	private JLabel[][] colors;

	public ColorChooser() {
		setLayout(new GridLayout(3, 3));
		// setPreferredSize(new Dimension(200, 200));
		Color[][] colorArray = new Color[3][3];
		colorArray[0][0] = Color.RED;
		colorArray[0][1] = Color.ORANGE;
		colorArray[0][2] = Color.YELLOW;
		colorArray[1][0] = Color.GREEN;
		colorArray[1][1] = Color.BLUE;
		colorArray[1][2] = Color.CYAN;
		colorArray[2][0] = Color.PINK;
		colorArray[2][1] = Color.WHITE;
		colorArray[2][2] = Color.BLACK;

		colors = new JLabel[3][3];
		for (int x = 0; x < 3; x++) {
			for (int y = 0; y < 3; y++) {
				colors[x][y] = new JLabel();
				colors[x][y].setOpaque(true);
				colors[x][y].setBackground(colorArray[x][y]);
				// colors[x][y].setPreferredSize(new Dimension(15, 15));
				/*colors[x][y].addMouseListener(new MouseAdapter() {
					public void mouseClicked(MouseEvent evt) {
							//System.out.println(colors[evt.getX()/200][evt.getY()/200]);
							System.out.println(evt.getX()/75 + " " + evt.getY()/75);
							
					}
					});*/
				add(colors[x][y]);
			}
		}

	}

}
