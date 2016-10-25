package game;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;

public class GameView extends JPanel {

	private Game model;
	
	// Constructor
	public GameView( Game model, JPanel scorePaneel ){
		this.model = model;
		
		setLayout( null );
		
		//setBackground( Color.GREEN );
		//setBackground( new Color(0, 0, 0, 0) );
	}
	
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);

		model.teken(g);
		
		g.drawString( "" + model.getTotaalWakken(), 220, 120 );
		g.drawString( "" + model.getTotaalIjsberen(), 220, 160 );
		g.drawString( "" + model.getTotaalPinguins(), 220, 200 );
		
	}
	
}
