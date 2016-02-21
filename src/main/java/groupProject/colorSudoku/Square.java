package groupProject.colorSudoku;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JComponent;

public class Square extends JComponent {
	private Color color;
	private static Color[] colorArray;
	private boolean mouseOver;
	private boolean userSet;
	private boolean gameSet;
	

	public Square(int colorNumber) {
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
		
		if(colorNumber > 0){
		this.color = colorArray[colorNumber - 1];
		this.gameSet = true;
		}		
		else{
			this.color = Color.getHSBColor(0, 0, .9F);
			//this.gameSet = false;
			//this.userSet= false;
		}
		this.userSet = false;
		this.setBorder(BorderFactory.createLineBorder(Color.GRAY));
		this.mouseOver = false;
		
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent evt) {
				//colorChooser.setVisible(true);
				mouseOver = true;
				repaint();
			}
		});

		this.addMouseListener(new MouseAdapter() {
			public void mouseExited(MouseEvent evt) {
				//colorChooser.setVisible(false);
				mouseOver = false;
				repaint();
			}
		});
		
		this.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent evt) {
				//colorChooser.setVisible(true);
				if(userSet){
					mouseOver = true;
					userSet = true;
					repaint();	
				}
				else if(!gameSet){
					color = Color.DARK_GRAY;
					repaint();
				}
				}
		});
	}

/*	public void setColor(int colorNum, boolean userSet) {
		if(colorNum > 0){
		this.color = colorArray[colorNum - 1];
		
		gameSet = true;
		}
		else{
			this.color = Color.getHSBColor(0, 0, .9F);
			//userSet = true;
		}
		repaint();
	}*/
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		int row = -1;
		if(mouseOver && !gameSet && !userSet){
			for(int i =0; i < 9; i++){
				if(i % 3 == 0){
					row++;
				}
				g.setColor(colorArray[i]);
				g.fillRect(21*(i%3), 20 *row, 20, 20);
			}
		}
		else{
		g.setColor(color);
		g.fillRect(0, 0, getWidth(), getHeight());
		
		}
	}
}
	//getContentPane().remove(choicePanel);
	//getContentPane().revalidate();