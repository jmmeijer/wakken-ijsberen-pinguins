package game;

import javax.swing.*;

public class Opstart extends JFrame
{
	
	public static void main( String args[] )
	{
		JFrame frame = new Opstart();
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		frame.setTitle( "Wakken, ijsberen en Pinguïns" );
		JPanel paneel = new Paneel();
		frame.setContentPane( paneel );
		frame.setVisible( true );
	}

}