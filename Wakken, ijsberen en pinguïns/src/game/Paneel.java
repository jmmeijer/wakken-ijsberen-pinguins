package game;

import java.awt.*;
import java.awt.event.*;

import java.util.*;

import javax.swing.*;
import javax.swing.event.*;

/**
 * De klasse <code>Paneel</code> representeert een paneel.
 * 
 * @author Jesse
 * @version 0.2
 * @see Opstart
 * @see Paneel
 */
class Paneel extends JPanel {
	// Declareren van de variabelen.
	
	private Game model;
	private JPanel scorePaneel, view, bedieningsPaneel;
	private int frameWidth;
	
	JPopupMenu popup;

	public Paneel()	{
		// Lay-outmanager uitschakelen.
		//setLayout( null );
		setLayout(new BorderLayout());
		
		// maak een nieuwe instantie van de game aan met als argument 1 voor variant en 3 voor aantalDobbelstenen.
		model = new Game(1, 3);
		
		scorePaneel = new ScorePaneel( model );
		scorePaneel.setPreferredSize(new Dimension(100, 150));
		//scorePaneel.setMaximumSize(new Dimension(100, 400));
		
		view = new GameView( model );
		view.setPreferredSize(new Dimension(100, 150));
		
		bedieningsPaneel = new BedieningsPaneel( model, view, scorePaneel );
		//bedieningsPaneel.setLayout( new BoxLayout( bedieningsPaneel, BoxLayout.X_AXIS ));
		bedieningsPaneel.setLayout( new GridLayout( 1,2 ) );
		bedieningsPaneel.setPreferredSize(new Dimension(100, 150));
		//bedieningsPaneel.setMaximumSize(new Dimension(100, 400));

		add(scorePaneel, BorderLayout.PAGE_START);
		add(view, BorderLayout.CENTER);
		add(bedieningsPaneel, BorderLayout.PAGE_END);


		// Framebreedte kan nog niet worden uitgelezen bij instantiering van Paneelklasse
		frameWidth = (int) this.getWidth();
		
		


		//dobbelsteen.draw(g);
		
		//int test = (int) frameWidth / aantalDobbelstenen;
		

		popup = new JPopupMenu();

	}
	
	
	/*
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		
		frameWidth = (int) this.getWidth();
		
		g.drawString("" + frameWidth , 400, 400);
		
		
//		model.teken( g );
		
	}
	*/

	/*
	public void stateChanged( ChangeEvent e ) {
		
		//int aantalDobbelstenen = model.getAantalDobbelstenen();
		
	    JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        
	    	int test2 = (int) source.getValue();
	    	model.setAantalDobbelstenen( test2 );
	        
	    }
	    
	    // start aanroepen om dobbelstenen te laten zien?
	    model.start();
	    
	    
		view.repaint();
		
	}
	*/
	
	
	
    class PopupListener extends MouseAdapter {
        JPopupMenu popup;
 
        PopupListener(JPopupMenu popupMenu) {
            popup = popupMenu;
        }
 
        public void mousePressed(MouseEvent e) {
            maybeShowPopup(e);
        }
 
        public void mouseReleased(MouseEvent e) {
            maybeShowPopup(e);
        }
 
        private void maybeShowPopup(MouseEvent e) {
            if (e.isPopupTrigger()) {
                popup.show(e.getComponent(),
                           e.getX(), e.getY());
            }
        }
    }
	
}