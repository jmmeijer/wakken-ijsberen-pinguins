package game;

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
		frame.setSize( width, height );
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Wakken, ijsberen en Pinguïns" );
		JPanel paneel = new Paneel();
		frame.setContentPane( paneel );
		frame.setVisible( true );
	}

}