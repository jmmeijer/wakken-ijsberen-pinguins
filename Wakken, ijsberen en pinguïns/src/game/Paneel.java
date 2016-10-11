package game;

import javax.swing.*;
import javax.swing.event.*;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * De klasse <code>Paneel</code> representeert een paneel.
 * 
 * @author Jesse
 * @version 0.1
 * @see Opstart
 * @see Paneel
 */
class Paneel extends JPanel {
	// Declareren van de variabelen.
	private int frameWidth;
	private JLabel labelWakken, labelIjsberen, labelPinguins;
	private JTextField invoervakWakken, invoervakIjsberen, invoervakPinguins;
	private JButton dobbelKnop, checkKnop;
	private Game game;
	
	public Paneel()	{
		// Lay-outmanager uitschakelen.
		setLayout( null );
		
		// Framebreedte kan nog niet worden uitgelezen bij instantiering van Paneelklasse
		frameWidth = (int) this.getWidth();
		
		game = new Game(1, 4);
		
		JSlider aantalDobbelstenen = new JSlider(JSlider.HORIZONTAL, 3, 8, 3);
		
		aantalDobbelstenen.addChangeListener(null);
		aantalDobbelstenen.setBounds(200, 250, 400, 50);
		aantalDobbelstenen.setMajorTickSpacing(1);
		aantalDobbelstenen.setMinorTickSpacing(1);
		aantalDobbelstenen.setPaintTicks(true);
		aantalDobbelstenen.setPaintLabels(true);
		add(aantalDobbelstenen);
		
		//dobbelsteen.draw(g);
		
		//int test = (int) frameWidth / aantalDobbelstenen;
		
		Font font = new Font( "Arial", Font.PLAIN, 20 );
		
		dobbelKnop = new JButton( "Dobbel" );
		dobbelKnop.addActionListener( new dobbelKnopHandler() );
		dobbelKnop.setFont(font);
		dobbelKnop.setSize(100, 50);
		//dobbelKnop.setBounds(200, 200, 100, 50);
		
		checkKnop = new JButton( "Check!" );
		checkKnop.addActionListener( new checkKnopHandler() );
		checkKnop.setFont(font);
		checkKnop.setSize(100, 50);
		//checkKnop.setBounds(200, 200, 100, 50);
		
		checkKnop.setVisible( false );
		
		// Labels en invoervakken aanmaken en positioneren
		
		labelWakken = new JLabel( "Wakken" );
		labelWakken.setFont( font );
		labelWakken.setBounds( 50, 300, 150, 50 );
		
		invoervakWakken = new JTextField( 10 );
		invoervakWakken.setBounds( 150, 300, 50, 50 );
		
		labelIjsberen = new JLabel( "IJsberen" );
		labelIjsberen.setFont( font );
		labelIjsberen.setBounds( 50, 350, 150, 50 );
		
		invoervakIjsberen = new JTextField( 10 );
		invoervakIjsberen.setBounds( 150, 350, 50, 50 );
		
		labelPinguins = new JLabel( "Pinguïns" );
		labelPinguins.setFont( font );
		labelPinguins.setBounds( 50, 400, 150, 50 );
		
		invoervakPinguins = new JTextField( 10 );
		invoervakPinguins.setBounds( 150, 400, 50, 50 );
		
		add(labelWakken);
		add(invoervakWakken);
		add(labelIjsberen);
		add(invoervakIjsberen);
		add(labelPinguins);
		add(invoervakPinguins);
		add(dobbelKnop);
		add(checkKnop);
	}
	
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		
		frameWidth = (int) this.getWidth();
		
		g.drawString("" + frameWidth , 400, 400);
		
		
		String text;
		int width;
		
		g.setFont(new Font("Arial", Font.PLAIN, 32));
		text = "Wakken, ijsberen en pinguïns";
		width = (int) g.getFontMetrics().stringWidth(text);
		//g.drawString( text, (frameWidth - width) / 2, 50 );
		g.drawString( text, 50, 50 );
		
		width = dobbelKnop.getWidth();
		dobbelKnop.setBounds( (frameWidth - width) / 2, 300, 200, 50 );
		checkKnop.setBounds( (frameWidth - width) / 2, 300, 200, 50 );
		
		// Scoreboard
		
		int beurt = game.getBeurt();
		
		game.teken( g );
		
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
		
		//g.drawString( "test", 50, 50 );
	}
	
	class dobbelKnopHandler implements ActionListener {
		public void actionPerformed( ActionEvent e )
		{
			game.dobbel();
			dobbelKnop.setVisible( false );
			checkKnop.setVisible( true );
			
			// TODO: Misschien is uitschakelen beter dan verwisselen
			//dobbelKnop.setEnabled(false);
			
			repaint();
		}
	}
	
	class checkKnopHandler implements ActionListener {
		public void actionPerformed( ActionEvent e ) {

			// TODO: write check function
			game.check();
			
			String invoerstringWakken = invoervakWakken.getText();
			int wakken = Integer.parseInt( invoerstringWakken );
			
			String invoerstringIjsberen = invoervakIjsberen.getText();
			int ijsberen = Integer.parseInt( invoerstringIjsberen );
			
			String invoerstringPinguins = invoervakPinguins.getText();
			int pinguins = Integer.parseInt( invoerstringPinguins );
			
			dobbelKnop.setVisible( true );
			checkKnop.setVisible( false );
			
			repaint();
		}
	}
	
	public void stateChanged( ChangeEvent e ) {
		
		//int aantalDobbelstenen = game.getAantalDobbelstenen();
		
	    JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        
	    	int aantalDobbelstenen = (int) source.getValue();
	    	
	        game.setAantalDobbelstenen( aantalDobbelstenen );
	        
	    }
		
		repaint();
		
	}
	
}