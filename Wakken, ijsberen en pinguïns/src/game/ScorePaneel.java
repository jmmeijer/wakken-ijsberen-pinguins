package game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * De klasse <code>ScorePaneel</code> representeert het scorepaneel.
 * 
 * @author Jesse
 * @version 0.2
 * @see Game
 * @see GameView
 */
public class ScorePaneel extends JPanel {
	private Game model;
	private JLabel beurtLabel, scoreLabel;
	
	// Constructor
	public ScorePaneel( Game model ){
		
		//setLayout(new GridLayout());
		this.model = model;

		// stel achtergrondkleur in
		//setBackground(Color.black);
		setBackground( new Color(0, 0, 0, 80) );
		
		int beurt = model.getBeurt();
		
		scoreLabel = new JLabel("Score: 0");
		scoreLabel.setText("Score: " + beurt);
		
		add(scoreLabel);
		
	}
	
	public void teken( Graphics g ){
		int frameWidth = (int) this.getWidth();
		
		g.drawString("" + frameWidth , 400, 400);
		
		String text;
		int width;
		
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Arial", Font.PLAIN, 32));
		text = "Wakken, ijsberen en pinguïns";
		width = (int) g.getFontMetrics().stringWidth(text);
		//g.drawString( text, (frameWidth - width) / 2, 50 );
		g.drawString( text, 50, 50 );
		
		// Scoreboard
		
		int beurt = model.getBeurt();
		
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		
		text = "Worp: "+ beurt;
		//width = g.getFontMetrics().stringWidth(text);
		g.drawString( text, frameWidth - 150, 50 );
		
		text = "Goed: "+ beurt;
		//width = g.getFontMetrics().stringWidth(text);
		g.drawString( text, frameWidth - 150, 80 );
		
		text = "Fout: "+ beurt;
		//width = g.getFontMetrics().stringWidth(text);
		g.drawString( text, frameWidth - 150, 110 );
	}
	
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		
		int frameWidth = (int) this.getWidth();
		
		g.drawString("" + frameWidth , 400, 400);
		
		String text;
		int width;
		
		g.setColor(Color.WHITE);
		
		g.setFont(new Font("Arial", Font.PLAIN, 32));
		text = "Wakken, ijsberen en pinguïns";
		width = (int) g.getFontMetrics().stringWidth(text);
		//g.drawString( text, (frameWidth - width) / 2, 50 );
		g.drawString( text, 50, 50 );
		
		// Scoreboard
		
		int beurt = model.getBeurt();
		
		g.setFont(new Font("Arial", Font.PLAIN, 24));
		
		text = "Worp: "+ beurt;
		//width = g.getFontMetrics().stringWidth(text);
		g.drawString( text, frameWidth - 150, 50 );
		
		text = "Goed: "+ beurt;
		//width = g.getFontMetrics().stringWidth(text);
		g.drawString( text, frameWidth - 150, 80 );
		
		text = "Fout: "+ beurt;
		//width = g.getFontMetrics().stringWidth(text);
		g.drawString( text, frameWidth - 150, 110 );
		
	}
}
