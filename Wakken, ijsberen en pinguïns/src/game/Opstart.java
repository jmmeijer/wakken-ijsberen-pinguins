package game;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * De klasse <code>Opstart</code> representeert een frame.
 * 
 * @author Jesse
 * @version 0.1
 * @see Opstart
 * @see Paneel
 */
public class Opstart extends JFrame
{
	private static int width, height;
	
	public static void main( String args[] )
	{
		width = 800;
		height = 600;
		JFrame frame = new Opstart();
		frame.setMinimumSize(new Dimension(width, height));
		frame.setSize( new Dimension(width, height) );
		frame.setLocation(400,300);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Wakken, ijsberen en Pinguïns" );
		
		JMenuBar test = maakMenuBalk();
		
		frame.setJMenuBar(test);
		
		JPanel paneel = new Paneel();
		frame.setContentPane( paneel );
		frame.setVisible( true );
		
	}
	
	// DOCS: https://docs.oracle.com/javase/tutorial/uiswing/components/menu.html
	
	// Static gemaakt om werkend te krijgen
	public static JMenuBar maakMenuBalk(){
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
		//menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		
		menuItem = new JMenuItem("Instellingen", KeyEvent.VK_I);
		menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
		//menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		
		// Seperator
		fileMenu.addSeparator();
		
		// Sluit optie
		menuItem = new JMenuItem("Afsluiten", KeyEvent.VK_T);
		menuItem.setAccelerator(KeyStroke.getKeyStroke( KeyEvent.VK_Q, ActionEvent.CTRL_MASK));
		menuItem.getAccessibleContext().setAccessibleDescription( "This doesn't really do anything");
		//menuItem.addActionListener(this);
		fileMenu.add(menuItem);
		
		// Help menu
		helpMenu = new JMenu("Help");
		helpMenu.setMnemonic(KeyEvent.VK_H);

		menuItem = new JMenuItem("Welkom");
		//menuItem.addActionListener(this);
		helpMenu.add(menuItem);
		
		helpMenu.addSeparator();
		menuItem = new JMenuItem("Over...");
		//menuItem.addActionListener(this);
		helpMenu.add(menuItem);
		
		menuBar.add(fileMenu);
		menuBar.add(helpMenu);
		
		return menuBar;
	}

}