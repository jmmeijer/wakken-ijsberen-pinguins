package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * De klasse <code>Opstart</code> representeert een frame.
 * 
 * @author Jesse
 * @version 0.3
 * @see Opstart
 * @see Paneel
 */
public class Opstart implements ActionListener, ChangeListener {
	
	// TODO statische var verwijderen
	private static Game model;
	
	/**
	 * 
	 * @param args
	 */
	public static void main( String args[] ) {
		int width = 800;
		int height = 600;
		
		Opstart opstart = new Opstart();
		JFrame frame = new JFrame("Opstart");
		
		// stel layout in op frame ipv paneel???
//		/frame.setLayout(null);
		//frame.setLayout(new BorderLayout());
		
		
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Wakken, ijsberen en Pinguïns" );
		
		//JMenuBar test = maakMenuBalk();
		//frame.setJMenuBar(test);
		
		frame.setJMenuBar(opstart.maakMenuBalk(frame));
		model = new Game(1, 3);
		
		//verstuur instantie van Opstartframe mee met Paneel voor manipulatie vanuit Paneel
		JPanel paneel = new Paneel( frame, model );
		paneel.setPreferredSize(new Dimension( width, height ));
		paneel.setMinimumSize(new Dimension( width, height ));
		frame.setContentPane( paneel );
		
		//frame.setMinimumSize(new Dimension(width, height));
		//frame.setSize( new Dimension(width, height) );
		// Venstergrootte automatisch instellen op basis van inhoud
		frame.pack();
		
		//frame.setLocation(400,300);
		// Het venster automatisch in het midden van her scherm plaatsen
		frame.setLocationRelativeTo(null);
		
		frame.setVisible( true );
		
	}
	
	// DOCS: https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
	
	// Static gemaakt om werkend te krijgen
	/*
	 * Maak de menubalk met menuitems.
	 */
	public JMenuBar maakMenuBalk( JFrame frame ){
		//Where the GUI is created:
		JMenuBar menuBar;
		JMenu fileMenu, helpMenu;
		JMenuItem menuItem;
		
		menuBar = new JMenuBar();

		//Build the first menu.
		fileMenu = new JMenu("Bestand");
		fileMenu.setMnemonic(KeyEvent.VK_B);
		fileMenu.getAccessibleContext().setAccessibleDescription( "The only menu in this program that has menu items");
		menuBar.add(fileMenu);
		
		//a group of JMenuItems
		menuItem = new JMenuItem("Hint", KeyEvent.VK_H);
		menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
		menuItem.setActionCommand("Hint");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Instellingen", KeyEvent.VK_I);
		menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
		menuItem.setActionCommand("Instellingen");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		
		// Seperator
		fileMenu.addSeparator();
		
		// Sluit optie
		menuItem = new JMenuItem("Afsluiten", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
		menuItem.setActionCommand("Afsluiten");
		menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		
		// Help menu
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);

		menuItem = new JMenuItem("Welkom");
		menuItem.setActionCommand("Welkom");
		menuItem.addActionListener(this);
		helpMenu.add(menuItem);
		
		helpMenu.addSeparator();
		menuItem = new JMenuItem("Over...");
		menuItem.setActionCommand("Over");
		menuItem.addActionListener(this);
		helpMenu.add(menuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		return menuBar;
	}
	
	//https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
	//http://stackoverflow.com/questions/11980151/java-jmenuitem-actionlistener
	/**
	 * Abstracte methode voor classes die ActionListener implementeren
	*/
	public void actionPerformed(ActionEvent e) {
        JMenuItem source = (JMenuItem)(e.getSource());
        
        String command = e.getActionCommand();
        
        /*
		JOptionPane.showMessageDialog(null,
                "Eggs aren't supposed to be green. "+ source.getText());
        */
        
        String newline = "\n";
        
        if(command.equals("Hint")){
        	
        	String hint = model.getRandomHint();
        	
        	JOptionPane.showMessageDialog(null,
        			hint,
        			"Hint",
                    JOptionPane.INFORMATION_MESSAGE);
    	}
        else if(command.equals("Instellingen")){
			
			Border titelrand = BorderFactory.createTitledBorder( "Spelopties" );
        	
			JLabel labelAantalDobbelstenen = new JLabel( "Aantal Dobbelstenen" );
			JLabel labelSpelvariant = new JLabel( "Spelvariant" );
			
        	// DOCS: https://docs.oracle.com/javase/tutorial/uiswing/components/slider.html
			JSlider aantalDobbelstenen = new JSlider(JSlider.HORIZONTAL, 3, 8, model.getAantalDobbelstenen());
			
			aantalDobbelstenen.addChangeListener(this);
			aantalDobbelstenen.setMajorTickSpacing(1);
			aantalDobbelstenen.setMinorTickSpacing(1);
			aantalDobbelstenen.setPaintTicks(true);
			aantalDobbelstenen.setPaintLabels(true);
			
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
			
		    ButtonGroup group = new ButtonGroup();
		    group.add(variant1Knop);
		    group.add(variant2Knop);
		    group.add(variant3Knop);
			
			JPanel test = new JPanel();
			test.setLayout( new GridLayout(0, 2) );
			test.setBorder( titelrand );
			
			test.add(labelSpelvariant);
			
			JPanel radioPanel = new JPanel(new GridLayout(1, 1));
	        radioPanel.add(variant1Knop);
	        radioPanel.add(variant2Knop);
	        radioPanel.add(variant3Knop);
			
			test.add(radioPanel);
			
			test.add(labelAantalDobbelstenen);
			test.add(aantalDobbelstenen);
			
			
			//test.add(group);
			
			/*
			JTextArea output = new JTextArea(5, 30);
	        output.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(output);
	        
			String s = "Welkom";
	        output.append(s + newline);
	        // Zet de scrollbalk bovenaan
	        output.setCaretPosition(0);
	        
	        */
			
			Object[] options = {"Opslaan",
            "Annuleren"};
			
			int n = JOptionPane.showOptionDialog(null,
					test,
                    "Instellingen",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    options,
                    options[0]);
			
			if (n == JOptionPane.OK_OPTION) {
				JOptionPane.showMessageDialog(null,
					    "Test");
				//TODO Alleen opslaan wanneer er op OK is gedrukt
			}
			
			
	}
        else if (command.equals("Afsluiten")){
    		System.exit(0);
    	}
        else if(command.equals("Welkom")){
    			
    			JTextArea output = new JTextArea(5, 30);
    	        output.setEditable(false);
    	        JScrollPane scrollPane = new JScrollPane(output);
    	        
    			String s = "Welkom";
    	        output.append(s + newline);
    	        // Zet de scrollbalk bovenaan
    	        output.setCaretPosition(0);
    			
    			JOptionPane.showMessageDialog(null,
    					scrollPane,
                        "Uitleg",
                        JOptionPane.PLAIN_MESSAGE);
		}
    	else if(command.equals("Over")){
		/*if(source.getText() == "Over..."){*/
			
			JTextArea output = new JTextArea(5, 30);
	        output.setEditable(false);
	        JScrollPane scrollPane = new JScrollPane(output);
	        
			String s = "Wakken, ijsberen en pinguins"
					+ newline
					+ "Versie 0.2.0"
					+ newline
					+ "in opdracht van Windesheim, Zwolle"
					+ newline
					+ newline
					+ "Copyright © 2016 J.M. Meijer";
	        output.append(s + newline);
	        // Zet de scrollbalk bovenaan
	        output.setCaretPosition(0);
			
			JOptionPane.showMessageDialog(null,
					scrollPane,
                    "Over Wakken, ijsberen en pinguïns",
                    JOptionPane.PLAIN_MESSAGE);
		}
        
    	
		
        /*
        String s = "Action event detected."
                   + newline
                   + "    Event source: " + source.getText()
                   + " (an instance of " + getClassName(source) + ")";
        output.append(s + newline);
        output.setCaretPosition(output.getDocument().getLength());
        */
    }
	
	// TODO: verplaatsen naar ok button.
	public void stateChanged( ChangeEvent e ) {
		
		//int aantalDobbelstenen = model.getAantalDobbelstenen();
		
	    JSlider source = (JSlider)e.getSource();
	    if (!source.getValueIsAdjusting()) {
	        
	    	int test2 = (int) source.getValue();
	    	
	    	//JOptionPane.showMessageDialog(null, "Test"+ test2);
	    	
	    	model.setAantalDobbelstenen( test2 );
	        
	    }
	    
	    // start aanroepen om nieuwe aantal dobbelstenen te laten zien?
	    //model.start();
	    
		//repaint();
		
	}

}