package groupProject.colorSudoku;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class ColorsPanel extends JPanel {

	private JButton[] buttons;
	private int lastColor = 9;
	private Color[] colorArray;

	public ColorsPanel() {
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
		setPreferredSize(new Dimension(200, 55));

		setLayout(new FlowLayout());
		setBackground(Color.WHITE);

		this.buttons = new JButton[9];
		JLabel label = new JLabel("");
		label.setPreferredSize(new Dimension(90, 55));
		add(label);

		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new JButton();
			buttons[i].setBackground(colorArray[i]);
			buttons[i].setBorder(BorderFactory.createCompoundBorder(

			BorderFactory.createBevelBorder(BevelBorder.RAISED, Color.WHITE,
					Color.BLACK), BorderFactory
					.createEtchedBorder(EtchedBorder.LOWERED)));

			final int j = i;
			buttons[i].addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent arg0) {
					if (lastColor != 9) {
						buttons[lastColor].setBorder(BorderFactory.createCompoundBorder(
								BorderFactory.createBevelBorder(
										BevelBorder.RAISED, Color.WHITE,
										Color.BLACK),
								BorderFactory
										.createEtchedBorder(EtchedBorder.LOWERED)));
					}
					lastColor = j;
					buttons[j].setBorder(BorderFactory.createLineBorder(
							Color.BLACK, 5));

				}
			});
			buttons[i].setPreferredSize(new Dimension(50, 50));
			add(buttons[i]);
		}
	}

	public int getLastColor() {
		return lastColor + 1;
	}
}