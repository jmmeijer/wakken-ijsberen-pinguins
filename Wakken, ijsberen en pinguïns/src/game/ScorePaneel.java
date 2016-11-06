package game;

import java.awt.*;
import javax.swing.*;

/**
 * De klasse <code>ScorePaneel</code> representeert het scorepaneel.
 * 
 * @author Jesse
 * @version 0.4
 * @see GameModel
 * @see GameView
 */
public class ScorePaneel extends JPanel {
	private GameModel model;
	
	
	/**
	 *  Constructor
	 * @param model
	 */
	public ScorePaneel( GameModel model ){
		
		//setLayout(new GridLayout());
		this.model = model;

		// stel achtergrondkleur in
		//setBackground(Color.black);
		setBackground( new Color(0, 0, 0, 80) );
		
	}
	
	/**
	 * Override paintCompoonent
	 * @param g
	 */
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		
		/*
		int frameWidth = (int) this.getWidth();
		g.drawString("" + frameWidth , 400, 400);
		int width;
		width = (int) g.getFontMetrics().stringWidth(text);
		*/
		String text;
		
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		text = "Wakken, ijsberen en pinguïns";
		
		//g.drawString( text, (frameWidth - width) / 2, 50 );
		g.drawString( text, 20, 35 );
		
		

		
	}
}
