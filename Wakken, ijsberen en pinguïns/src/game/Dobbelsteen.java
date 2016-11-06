package game;

import java.awt.Color;
import java.awt.Graphics;

/**
 * De klasse <code>Dobbelsteen</code> representeert een dobbelsteen.
 * 
 * @author Jesse
 * @version 0.3
 * @see Game
 * @see GameView
 */
public class Dobbelsteen {
	
	private int radius, diameter, left, center, right, top, middle, bottom, worp, x, y, size, borderRadius, borderWidth, wakken, ijsberen, pinguins;
	
	/**
	 *  Constructor voor de klasse Dobbelsteen.
	 * @param size
	 * @param x
	 * @param y
	 */
	public Dobbelsteen( int size, int x, int y ) {
		
		this.size = size;
		this.x = x;
		this.y = y;
		
		radius = size/10;
		diameter = radius*2;
		
		borderRadius = size/5;
		borderWidth = size/50;
		
		top = left = size / 5;
		middle = center = size / 2;
		bottom = right = size / 5 * 4;

	}
	
	/**
	 * Haal de worp op
	 * @return het getal dat geworpen is
	 */
	public int getWorp() {
		return worp;
	}
	
	/**
	 * Een onnodige functie om een geworpen getal te forceren.
	 * @param worp
	 */
	public void setWorp( int worp )	{
		if(worp >= 1 && worp <= 6)
		{
			this.worp = worp;
		}
		else
		{
			this.worp = 1;
		}
	}
	
	public void dobbel() {
		worp = (int) ( 6 * Math.random() +1 );
		
		if(worp == 1 || worp == 3 || worp == 5){
			wakken = 1;
			ijsberen = worp - 1;
			pinguins = 7 - worp;
		}else{
			wakken = ijsberen = pinguins = 0;
		}
	}
	
	public void teken(Graphics g) {
		// Teken lijn
		g.setColor(Color.BLACK);
		g.fillRoundRect(x-borderWidth, y-borderWidth, size+(borderWidth*2), size+(borderWidth*2), borderRadius+(borderWidth*2), borderRadius+(borderWidth*2)   );
		g.setColor(Color.WHITE);
		g.fillRoundRect( x, y, size, size, borderRadius, borderRadius );
		
		// Teken ogen
		g.setColor(Color.BLACK);
		
		if(worp == 1 || worp == 3 || worp == 5) {
			// centerMiddle
			g.fillOval(x + center - radius, y + middle - radius, diameter, diameter);
		}
		if(worp == 2 || worp == 3 || worp == 4 || worp == 5 || worp == 6) {
			// topRight
			g.fillOval(x + right - radius, y + top - radius, diameter, diameter);
		}
		if(worp == 2 || worp == 3 || worp == 4 || worp == 5 || worp == 6) {
			// bottomLeft
			g.fillOval(x + left - radius, y + bottom - radius, diameter, diameter);
		}
		if(worp == 4 || worp == 5 || worp == 6) {
			// topLeft
			g.fillOval(x + left - radius, y + top - radius, diameter, diameter);	
			// bottomRight
			g.fillOval(x + right - radius, y + bottom - radius, diameter, diameter);
		}
		if(worp == 6) {
			// leftMiddle
			g.fillOval(x + left - radius, y + middle - radius, diameter, diameter);
			// rightMiddle
			g.fillOval(x + right - radius, y + middle - radius, diameter, diameter);
		}
		
		//g.drawString(""+ worp, x + middle, y + size + 50);
	}
	
}
