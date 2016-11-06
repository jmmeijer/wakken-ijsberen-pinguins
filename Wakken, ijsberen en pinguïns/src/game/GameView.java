package game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;

/**
 * De klasse <code>Gameview</code> representeert het paneel gameview.
 * 
 * @author Jesse
 * @version 0.3
 * @see GameModel
 * @see GameView
 */
public class GameView extends JPanel {

	private GameModel model;
	
	/**
	 *  Constructor
	 * @param model
	 * @param scorePaneel
	 */
	public GameView( GameModel model, JPanel scorePaneel ){
		this.model = model;
		
		setLayout( null );
		
		//setBackground( Color.GREEN );
		//setBackground( new Color(0, 0, 0, 0) );
	}
	
	/**
	 * Teken het spel
	 */
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);

		model.teken(g);
		

		
	}
	
}
