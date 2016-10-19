package game;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import javax.swing.event.*;

public class BedieningsPaneel extends JPanel
							  implements ChangeListener {

	private Game model;
	private JPanel view;
	private JLabel labelWakken, labelIjsberen, labelPinguins;
	private JTextField invoervakWakken, invoervakIjsberen, invoervakPinguins;
	private JButton dobbelKnop, checkKnop;
	
	//Constructor
	public BedieningsPaneel( Game model, JPanel view ){
		this.model = model;
		this.view = view;
		
		int frameWidth = (int) this.getWidth();
		
		Font font = new Font( "Arial", Font.PLAIN, 20 );
		
		// stel achtergrondkleur in
		setBackground( new Color(0, 0, 0, 70) );
		
		JPanel linksPaneel = new JPanel();
		linksPaneel.setLayout( new BoxLayout( linksPaneel, BoxLayout.Y_AXIS ));
		//linksPaneel.setBackground(Color.RED);
		
		JPanel rechtsPaneel = new JPanel();
		rechtsPaneel.setLayout( new BoxLayout( rechtsPaneel, BoxLayout.Y_AXIS ) );
		//rechtsPaneel.setBackground(Color.BLUE);
		
		JPanel linksBovenPaneel = new JPanel();
		linksBovenPaneel.setLayout( new GridLayout(0, 1) );
		//linksBovenPaneel.setLayout( null );
		
		JPanel linksMiddenPaneel = new JPanel();
		JPanel linksOnderPaneel = new JPanel();
		JPanel rechtsBovenPaneel = new JPanel();
		JPanel rechtsMiddenPaneel = new JPanel();
		JPanel rechtsOnderPaneel = new JPanel();
		
		//linksBovenPaneel.setBackground(Color.BLUE);
		//linksMiddenPaneel.setBackground(Color.YELLOW);
		//linksOnderPaneel.setBackground(Color.RED);
		
		linksPaneel.add( linksBovenPaneel );
		linksPaneel.add( linksMiddenPaneel );
		linksPaneel.add( linksOnderPaneel );
		rechtsPaneel.add( rechtsBovenPaneel );
		rechtsPaneel.add( rechtsMiddenPaneel );
		rechtsPaneel.add( rechtsOnderPaneel );
		
	    //Radio knoppen
	    JRadioButton variant1Knop = new JRadioButton( "Variant 1" );
	    variant1Knop.setMnemonic(KeyEvent.VK_B);
	    variant1Knop.setActionCommand("variant1");
	    variant1Knop.setSelected(true);

	    JRadioButton variant2Knop = new JRadioButton( "Variant 2" );
	    variant2Knop.setMnemonic(KeyEvent.VK_C);
	    variant2Knop.setActionCommand("variant2");

	    JRadioButton variant3Knop = new JRadioButton( "Variant 3" );
	    variant3Knop.setMnemonic(KeyEvent.VK_D);
	    variant3Knop.setActionCommand("variant3");

	    //Group the radio buttons.
	    ButtonGroup group = new ButtonGroup();
	    group.add(variant1Knop);
	    group.add(variant2Knop);
	    group.add(variant3Knop);
	    
	    //topLeftPanel.add(group);
		
		// Labels en invoervakken aanmaken en positioneren
		
		labelWakken = new JLabel( "Wakken" );
		labelWakken.setFont( font );
		//labelWakken.setBounds( 50, 300, 150, 50 );
		//labelWakken.setPreferredSize(new Dimension(200, 100));
		//labelWakken.setSize( new Dimension(10,50) );
		
		invoervakWakken = new JTextField( 10 );
		//invoervakWakken.setBounds( 150, 300, 50, 50 );
		//invoervakWakken.setSize( new Dimension(10,20) );
		
		//invoervakWakken.setPreferredSize(new Dimension(200, 100));
		//invoervakWakken.setBackground(Color.BLUE);
		
		labelIjsberen = new JLabel( "IJsberen" );
		labelIjsberen.setFont( font );
		//labelIjsberen.setBounds( 50, 350, 150, 50 );
		//labelIjsberen.setSize( new Dimension(10,50) );
		
		invoervakIjsberen = new JTextField( 10 );
		//invoervakIjsberen.setBounds( 150, 350, 50, 50 );
		
		labelPinguins = new JLabel( "Pinguïns" );
		labelPinguins.setFont( font );
		//labelPinguins.setBounds( 50, 400, 150, 50 );
		//labelPinguins.setSize( new Dimension(10,50) );
		
		invoervakPinguins = new JTextField( 10 );
		//invoervakPinguins.setBounds( 150, 400, 50, 50 );
		
	    //b2 = new JButton("Middle button", middleButtonIcon);
	    //b2.setVerticalTextPosition(AbstractButton.BOTTOM);
	    //b2.setHorizontalTextPosition(AbstractButton.CENTER);
		
		dobbelKnop = new JButton( "Dobbel" );
		dobbelKnop.addActionListener( new Handler() );
		dobbelKnop.setFont(font);
		dobbelKnop.setSize(100, 50);
		//dobbelKnop.setBounds(200, 200, 100, 50);
		
		checkKnop = new JButton( "Check!" );
		checkKnop.addActionListener( new Handler() );
		checkKnop.setFont(font);
		checkKnop.setSize(100, 50);
		//checkKnop.setBounds(200, 200, 100, 50);
		
		//checkKnop.setVisible( false );
		
		int width;
		width = dobbelKnop.getWidth();
		
		dobbelKnop.setBounds( (frameWidth - width) / 2 - width, 300, 200, 50 );
		checkKnop.setBounds( (frameWidth - width) / 2 + width, 300, 200, 50 );
		
		JSlider aantalDobbelstenen = new JSlider(JSlider.HORIZONTAL, 3, 8, model.getAantalDobbelstenen());
		
		
		// DOCS: https://docs.oracle.com/javase/tutorial/uiswing/components/slider.html
		aantalDobbelstenen.addChangeListener(this);
		//aantalDobbelstenen.setBounds(200, 250, 400, 50);
		aantalDobbelstenen.setMajorTickSpacing(1);
		aantalDobbelstenen.setMinorTickSpacing(1);
		aantalDobbelstenen.setPaintTicks(true);
		aantalDobbelstenen.setPaintLabels(true);
		
		// verplaatsen naar settings window
		//linksMiddenPaneel.add(aantalDobbelstenen);
		
		rechtsBovenPaneel.add(invoervakWakken);
		rechtsBovenPaneel.add(labelWakken);
		rechtsMiddenPaneel.add(invoervakIjsberen);
		rechtsMiddenPaneel.add(labelIjsberen);
		rechtsOnderPaneel.add(invoervakPinguins);
		rechtsOnderPaneel.add(labelPinguins);
		
        JPanel radioPanel = new JPanel(new GridLayout(0, 1));
        radioPanel.add(variant1Knop);
        radioPanel.add(variant2Knop);
        radioPanel.add(variant3Knop);
 
        //add(radioPanel, BorderLayout.LINE_START);
        
        // verplaatsen naar settings window
        //linksBovenPaneel.add(radioPanel);
        
        linksOnderPaneel.add(dobbelKnop);
        linksOnderPaneel.add(checkKnop);
        
		add(linksPaneel);
		add(rechtsPaneel);
	}
	
	class Handler implements ActionListener {
		public void actionPerformed( ActionEvent e ){
			
			
			if( e.getSource() == dobbelKnop ){
				model.dobbel();
				//dobbelKnop.setVisible( false );
				//checkKnop.setVisible( true );
			}else
			if( e.getSource() == checkKnop ){
				
				String invoerstringWakken = invoervakWakken.getText();
				int wakken = Integer.parseInt( invoerstringWakken );
				
				String invoerstringIjsberen = invoervakIjsberen.getText();
				int ijsberen = Integer.parseInt( invoerstringIjsberen );
				
				String invoerstringPinguins = invoervakPinguins.getText();
				int pinguins = Integer.parseInt( invoerstringPinguins );
				
				// TODO: check functie die argumenten kan ontvangen??
				model.check(wakken, ijsberen, pinguins);
				
				//dobbelKnop.setVisible( true );
				//checkKnop.setVisible( false );
			}

			view.repaint();
			
		}
	}

	public void stateChanged( ChangeEvent e ) {
		
		//int aantalDobbelstenen = model.getAantalDobbelstenen();
		
	    JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        
	    	int test2 = (int) source.getValue();
	    	
	    	//JOptionPane.showMessageDialog(null, "Test"+ test2);
	    	
	    	model.setAantalDobbelstenen( test2 );
	        
	    }
	    
	    // start aanroepen om nieuwe aantal dobbelstenen te laten zien?
	    model.start();
	    
		view.repaint();
		
	}
	
}
