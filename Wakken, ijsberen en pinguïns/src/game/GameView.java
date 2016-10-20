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
	}
	
	public void paintComponent( Graphics g ) {
		super.paintComponent( g );
		
		
		//eventueel vervangen met een teken functie binnen Game model???
		ArrayList<Dobbelsteen> dobbelstenen = model.getDobbelstenen();
		
		for( Dobbelsteen dobbelsteen : dobbelstenen ){
			dobbelsteen.teken( g );
		}
 
		g.drawString( "" + model.getTotaalWakken(), 220, 120 );
		g.drawString( "" + model.getTotaalIjsberen(), 220, 160 );
		g.drawString( "" + model.getTotaalPinguins(), 220, 200 );
		
	}
	
}
