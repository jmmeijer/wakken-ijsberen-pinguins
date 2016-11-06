package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.*;

/**
 * De klasse <code>BediendingsPaneel</code> representeert het bediendingspaneel.
 * 
 * @author Jesse
 * @version 0.4
 * @see GameModel
 * @see GameView
 */
public class BedieningsPaneel extends JPanel
							  implements ChangeListener {
	private JFrame frame;
	private GameModel model;
	private JPanel view, scorePaneel;
	private JLabel beurtLabel, scoreLabel, foutLabel, wakkenLabel, ijsberenLabel, pinguinsLabel, wakkenTotaalLabel, ijsberenTotaalLabel, pinguinsTotaalLabel;
	private JTextField wakkenVak, ijsberenVak, pinguinsVak;
	private JButton dobbelKnop, checkKnop;
	
	/**
	 * Constructor
	 * @param frame
	 * @param model
	 * @param view
	 * @param scorePaneel
	 */
	public BedieningsPaneel( JFrame frame, GameModel model, JPanel view, JPanel scorePaneel ){
		
		this.frame = frame;
		this.model = model;
		this.view = view;
		this.scorePaneel = scorePaneel;
		
		// TODO: Welke layout is het meest geschikt?
		setLayout( new GridLayout( 1,2 ) );
		//setLayout( new BoxLayout( this, BoxLayout.LINE_AXIS ) );
		setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		int frameWidth = (int) this.getWidth();
		
		Font font = new Font( "Arial", Font.PLAIN, 20 );
		
		// stel achtergrondkleur in
		setBackground( new Color(0, 0, 0, 80) );
		
		JPanel linksPaneel = new JPanel();
		linksPaneel.setLayout( new BoxLayout( linksPaneel, BoxLayout.PAGE_AXIS ));
		//linksPaneel.setLayout( new GridLayout( 4,2,10,10 ) );
		//linksPaneel.setAlignmentX( Component.LEFT_ALIGNMENT );
		linksPaneel.setBackground(Color.RED);
		
		JPanel rechtsPaneel = new JPanel();
		rechtsPaneel.setLayout( new BoxLayout( rechtsPaneel, BoxLayout.PAGE_AXIS ) );
		//rechtsPaneel.setLayout( new GridLayout( 4,2,10,10 ) );
		
		rechtsPaneel.setBackground(Color.BLUE);
		
		JPanel linksBovenPaneel = new JPanel();
		JPanel linksMiddenPaneel = new JPanel();
		JPanel linksOnderPaneel = new JPanel();
		JPanel rechtsBovenPaneel = new JPanel();
		JPanel rechtsMiddenPaneel = new JPanel();
		JPanel rechtsOnderPaneel = new JPanel();
		
		JPanel linksKnopPaneel = new JPanel();
		JPanel rechtsKnopPaneel = new JPanel();
		
		linksBovenPaneel.setLayout(new BoxLayout(linksBovenPaneel, BoxLayout.PAGE_AXIS));
		linksMiddenPaneel.setLayout(new BoxLayout(linksMiddenPaneel, BoxLayout.LINE_AXIS));
		linksOnderPaneel.setLayout(new BoxLayout(linksOnderPaneel, BoxLayout.LINE_AXIS));
		//linksKnopPaneel.setLayout(new BoxLayout(linksKnopPaneel, BoxLayout.LINE_AXIS));
		/*
		 * TODO: werkt alleen goed bij expliciete groottes van componenten
		rechtsBovenPaneel.setLayout(new BoxLayout(rechtsBovenPaneel, BoxLayout.LINE_AXIS));
		rechtsMiddenPaneel.setLayout(new BoxLayout(rechtsMiddenPaneel, BoxLayout.LINE_AXIS));
		rechtsOnderPaneel.setLayout(new BoxLayout(rechtsOnderPaneel, BoxLayout.LINE_AXIS));
		//rechtsKnopPaneel.setLayout(new BoxLayout(rechtsKnopPaneel, BoxLayout.LINE_AXIS));
		*/
		
		linksBovenPaneel.setAlignmentX( LEFT_ALIGNMENT );
		linksMiddenPaneel.setAlignmentX( LEFT_ALIGNMENT );
		linksOnderPaneel.setAlignmentX( LEFT_ALIGNMENT );
		linksKnopPaneel.setAlignmentX( LEFT_ALIGNMENT );
		
		rechtsBovenPaneel.setAlignmentX( RIGHT_ALIGNMENT );
		rechtsMiddenPaneel.setAlignmentX( RIGHT_ALIGNMENT );
		rechtsOnderPaneel.setAlignmentX( RIGHT_ALIGNMENT );
		rechtsKnopPaneel.setAlignmentX( CENTER_ALIGNMENT );
		
		/*
		linksBovenPaneel.setBackground(Color.BLUE);
		linksMiddenPaneel.setBackground(Color.YELLOW);
		linksOnderPaneel.setBackground(Color.RED);
		linksKnopPaneel.setBackground(Color.GREEN);
		*/
		
		linksPaneel.add( linksBovenPaneel );
		linksPaneel.add( linksMiddenPaneel );
		linksPaneel.add( linksOnderPaneel );
		rechtsPaneel.add( rechtsBovenPaneel );
		rechtsPaneel.add( rechtsMiddenPaneel );
		rechtsPaneel.add( rechtsOnderPaneel );
		
		linksPaneel.add( linksKnopPaneel );
		rechtsPaneel.add( rechtsKnopPaneel );
		
		linksPaneel.setOpaque(false);
		linksBovenPaneel.setOpaque(false);
		linksMiddenPaneel.setOpaque(false);
		linksOnderPaneel.setOpaque(false);
		linksKnopPaneel.setOpaque(false);
		rechtsPaneel.setOpaque(false);
		rechtsBovenPaneel.setOpaque(false);
		rechtsMiddenPaneel.setOpaque(false);
		rechtsOnderPaneel.setOpaque(false);
		rechtsKnopPaneel.setOpaque(false);
		
		// Labels en invoervakken aanmaken en positioneren
		Dimension labelsize = new Dimension( 100, 32 );
		
		beurtLabel = new JLabel("Beurt: 0");
		//beurtLabel.setSize( labelsize );
		beurtLabel.setPreferredSize( labelsize );
		beurtLabel.setMinimumSize( labelsize );
		beurtLabel.setMaximumSize( labelsize );
		beurtLabel.setFont( font );
		beurtLabel.setForeground(Color.WHITE);
		beurtLabel.setHorizontalAlignment( JLabel.LEFT );
		beurtLabel.setAlignmentX( LEFT_ALIGNMENT );
		
		scoreLabel = new JLabel("Score: 0");
		//scoreLabel.setSize( labelsize );
		scoreLabel.setPreferredSize( labelsize );
		scoreLabel.setMinimumSize( labelsize );
		scoreLabel.setMaximumSize( labelsize );
		scoreLabel.setFont( font );
		scoreLabel.setForeground(Color.WHITE);
		scoreLabel.setAlignmentX( CENTER_ALIGNMENT );
		
		foutLabel = new JLabel("Fout: 0");
		//foutLabel.setSize( labelsize );
		foutLabel.setPreferredSize( labelsize );
		foutLabel.setMinimumSize( labelsize );
		foutLabel.setMaximumSize( labelsize );
		foutLabel.setFont( font );
		foutLabel.setForeground(Color.WHITE);
		foutLabel.setHorizontalAlignment( JLabel.LEFT );
		foutLabel.setAlignmentX( LEFT_ALIGNMENT );
		
		wakkenLabel = new JLabel( "Wakken" );
		//wakkenLabel.setBounds( 50, 300, 150, 50 );
		//wakkenLabel.setSize( labelsize );
		wakkenLabel.setPreferredSize( labelsize );
		wakkenLabel.setFont( font );
		wakkenLabel.setForeground(Color.WHITE);
		
		wakkenVak = new JTextField( 5 );
		wakkenVak.setToolTipText("Voer hier het aantal wakken in");
		wakkenVak.setAlignmentX(LEFT_ALIGNMENT);
		wakkenVak.setHorizontalAlignment( JTextField.RIGHT );
		//wakkenVak.setBounds( 150, 300, 50, 50 );
		//wakkenVak.setSize( new Dimension(10,20) );
		//wakkenVak.setPreferredSize(new Dimension(200, 100));
		//wakkenVak.setBackground(Color.BLUE);
		
		wakkenTotaalLabel = new JLabel( "0" );
		wakkenTotaalLabel.setPreferredSize( new Dimension(32,32) );
		wakkenTotaalLabel.setFont( font );
		wakkenTotaalLabel.setForeground(Color.WHITE);
		wakkenTotaalLabel.setHorizontalAlignment( JLabel.RIGHT );
		
		ijsberenLabel = new JLabel( "IJsberen" );
		//ijsberenLabel.setBounds( 50, 350, 150, 50 );
		//ijsberenLabel.setSize( labelsize );
		ijsberenLabel.setPreferredSize( labelsize );
		ijsberenLabel.setFont( font );
		ijsberenLabel.setForeground(Color.WHITE);
		
		ijsberenVak = new JTextField( 5 );
		ijsberenVak.setHorizontalAlignment( JTextField.RIGHT );
		//ijsberenVak.setBounds( 150, 350, 50, 50 );
		
		ijsberenTotaalLabel = new JLabel( "0" );
		ijsberenTotaalLabel.setPreferredSize( new Dimension(32,32) );
		ijsberenTotaalLabel.setFont( font );
		ijsberenTotaalLabel.setForeground(Color.WHITE);
		ijsberenTotaalLabel.setHorizontalAlignment( JLabel.RIGHT );
		
		pinguinsLabel = new JLabel( "Pinguïns" );
		//pinguinsLabel.setBounds( 50, 400, 150, 50 );
		//pinguinsLabel.setSize( labelsize );
		pinguinsLabel.setPreferredSize( labelsize );
		pinguinsLabel.setFont( font );
		pinguinsLabel.setForeground(Color.WHITE);

		pinguinsVak = new JTextField( 5 );
		pinguinsVak.setHorizontalAlignment( JTextField.RIGHT );
		//pinguinsVak.setBounds( 150, 400, 50, 50 );
		
		pinguinsTotaalLabel = new JLabel( "0" );
		pinguinsTotaalLabel.setPreferredSize( new Dimension(32,32) );
		pinguinsTotaalLabel.setFont( font );
		pinguinsTotaalLabel.setForeground(Color.WHITE);
		pinguinsTotaalLabel.setHorizontalAlignment( JLabel.RIGHT );
		
		dobbelKnop = new JButton( "Dobbel" );
		dobbelKnop.addActionListener( new Handler() );
		dobbelKnop.setSize(new Dimension(120, 40));
		dobbelKnop.setPreferredSize(new Dimension(120, 40));
		//dobbelKnop.setPreferredSize( 120,80 );
		dobbelKnop.setFont(font);
		dobbelKnop.setBackground(Color.GREEN);
		dobbelKnop.setForeground(Color.WHITE);
		dobbelKnop.setBorder(new LineBorder(Color.WHITE, 2));
		
		//dobbelKnop.setBounds(200, 200, 100, 50);
		
		checkKnop = new JButton( "Controleer" );
		checkKnop.addActionListener( new Handler() );
		checkKnop.setFont(font);
		checkKnop.setSize(100, 50);
		//checkKnop.setBounds(200, 200, 100, 50);
		
		//checkKnop.setVisible( false );
		checkKnop.setEnabled( false );
		
		int width;
		width = dobbelKnop.getWidth();
		
		// TODO: kan weg?
		dobbelKnop.setBounds( (frameWidth - width) / 2 - width, 300, 200, 50 );
		checkKnop.setBounds( (frameWidth - width) / 2 + width, 300, 200, 50 );
		
		linksBovenPaneel.add(beurtLabel);
		linksMiddenPaneel.add(scoreLabel);
		linksOnderPaneel.add(foutLabel);
		
		rechtsBovenPaneel.add(wakkenLabel);
		rechtsBovenPaneel.add(wakkenVak);
		rechtsBovenPaneel.add(wakkenTotaalLabel);
		rechtsMiddenPaneel.add(ijsberenLabel);
		rechtsMiddenPaneel.add(ijsberenVak);
		rechtsMiddenPaneel.add(ijsberenTotaalLabel);
		rechtsOnderPaneel.add(pinguinsLabel);
		rechtsOnderPaneel.add(pinguinsVak);
		rechtsOnderPaneel.add(pinguinsTotaalLabel);
		
		//wakkenLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
		//wakkenVak.setAlignmentX(Component.RIGHT_ALIGNMENT);

		linksKnopPaneel.add(dobbelKnop);
        rechtsKnopPaneel.add(checkKnop);
        
		add(linksPaneel);
		add(rechtsPaneel);
		
		//Test met anonieme actionlistener
		/*
		ActionListener testal = new ActionListener() {
			public void actionPerformed( ActionEvent e ){
				JOptionPane.showMessageDialog(frame,
	                    "Test");
			}
		};
		
		dobbelKnop.addActionListener(testal);
		*/
	}
	
	/**
	 * 
	 */
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);

		/*
		// Scoreboard
		*/
		
		g.drawString( "" + model.getTotaalWakken(), 220, 120 );
		g.drawString( "" + model.getTotaalIJsberen(), 220, 160 );
		g.drawString( "" + model.getTotaalPinguins(), 220, 200 );
		
	}
	
	/**
	 * 
	 * @author Jesse
	 *
	 */
	private class Handler implements ActionListener {
		public void actionPerformed( ActionEvent e ){
			
			String newline = "\n";
			
			if( e.getSource() == dobbelKnop ){
				model.dobbel();
				
				int beurt = model.getBeurt();
				beurtLabel.setText("Beurt: " + beurt);
				
				wakkenVak.setText("");
				ijsberenVak.setText("");
				pinguinsVak.setText("");
				
				//TODO: uncomment voor inleveren
				//wakkenTotaalLabel.setText("");
				//ijsberenTotaalLabel.setText("");
				//pinguinsTotaalLabel.setText("");
				
				//wakkenTotaalLabel.setVisible(false);
				//ijsberenTotaalLabel.setVisible(false);
				//pinguinsTotaalLabel.setVisible(false);
				
				dobbelKnop.setEnabled( false );
				checkKnop.setEnabled( true );
				
				
			}else
			if( e.getSource() == checkKnop ){
				
				String invoerstringWakken = wakkenVak.getText();
				String invoerstringIJsberen = ijsberenVak.getText();
				String invoerstringPinguins = pinguinsVak.getText();
				
				try{
					int wakken = Integer.parseInt( invoerstringWakken );
					int ijsberen = Integer.parseInt( invoerstringIJsberen );
					int pinguins = Integer.parseInt( invoerstringPinguins );
					
					model.check(wakken, ijsberen, pinguins);
					
					int beurt = model.getBeurt();
					int score = model.getScore();
					scoreLabel.setText("Score: " + score);
					foutLabel.setText("Fout: " + (beurt - score));
					
					wakkenTotaalLabel.setText(""+model.getTotaalWakken());
					ijsberenTotaalLabel.setText(""+model.getTotaalIJsberen());
					pinguinsTotaalLabel.setText(""+model.getTotaalPinguins());
					
					// TODO: kan beter leeg ipv niet zichtbaar
					//wakkenTotaalLabel.setVisible(true);
					//ijsberenTotaalLabel.setVisible(true);
					//pinguinsTotaalLabel.setVisible(true);
					
					checkKnop.setEnabled( false );
					dobbelKnop.setEnabled( true );
					
					//TODO: invoervakken ook nog leegmaken?

				}catch( NumberFormatException nfe ){
					
					String invoer = "";
					
					if( invoerstringWakken.equals( "" ) ){
						invoer += "Je hebt nog niets bij wakken ingevuld!" + newline;
					}
					if( invoerstringIJsberen.equals( "" ) ){
						invoer += "Je hebt nog niets bij ijsberen ingevuld!" + newline;
					}
					if(invoerstringPinguins.equals( "" ) ){
						invoer += "Je hebt nog niets bij pinguïns ingevuld!" + newline;
					}
						/*
					else{
						invoer = "" + wakkenVak.getText() + ijsberenVak.getText() + pinguinsVak.getText();
					}
					*/
					JOptionPane.showMessageDialog( frame, 
						"Fout getal: " + invoer,
						"Fout in invoer",
						JOptionPane.ERROR_MESSAGE
					);
					
				} finally {
					// Wat hier?
				}
				


			}

			//hele frame verversen?
			frame.repaint();
			
			//scorePaneel.repaint();
			//view.repaint();
			
			
			
		}
	}

	/**
	 * TODO: Verwijderen?
	 */
	public void stateChanged( ChangeEvent e ) {
		/*
		//int aantalDobbelstenen = model.getAantalDobbelstenen();
		
	    JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        
	    	int test2 = (int) source.getValue();
	    	
	    	//JOptionPane.showMessageDialog(null, "Test"+ test2);
	    	
	    	model.setAantalDobbelstenen( test2 );
	        
	    }
	    
	    // start aanroepen om nieuwe aantal dobbelstenen te laten zien?
	    //model.start();
	    
		frame.repaint();
		*/
	}
	
}
