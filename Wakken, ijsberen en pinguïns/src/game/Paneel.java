package game;

import java.awt.event.*;
import java.awt.Graphics;
import javax.swing.JButton;
import javax.swing.JPanel;

class Paneel extends JPanel
{
	private int aantalDobbelstenen;
	private JButton dobbelKnop;
	
	//private Dobbelsteen dobbelsteen1 = new Dobbelsteen(50, 100);
	
	public Paneel()
	{
		dobbelKnop = new JButton("Dobbel");
		dobbelKnop.addActionListener( new dobbelKnopHandler() );
		
		
		
		add(dobbelKnop);
	}
	
	public void paintComponent( Graphics g )
	{
		super.paintComponent(g);
		
		//dobbelsteen1.draw(g);
	}
	
	class dobbelKnopHandler implements ActionListener
	{
		public void actionPerformed( ActionEvent e )
		{
			
			
			repaint();
		}
	}
	
}