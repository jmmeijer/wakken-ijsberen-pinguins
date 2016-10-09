package game;

import java.awt.Color;
import java.awt.Graphics;

public class Dobbelsteen {
	private int radius, diameter, left, center, right, top, middle, bottom, worp, x, y, size, borderRadius, borderWidth;
	
	public Dobbelsteen( int x, int y ){
	
		radius = 25;
		diameter = radius*2;

		size = 250;
		borderRadius = 50;
		borderWidth = 2;
		
		top = left = size / 5;
		middle = center = size / 2;
		bottom = right = size / 5 * 4;
		
		this.x = x;
		this.y = y;
		
		
	
	}
	
	public void dobbel(){
		worp = (int) ( 6 * Math.random() +1 );
	}
	
	public void draw(Graphics g)
	{
		// Teken lijn
		g.setColor(Color.BLACK);
		g.fillRoundRect(x-borderWidth, y-borderWidth, size+(borderWidth*2), size+(borderWidth*2), borderRadius+(borderWidth*2), borderRadius+(borderWidth*2)   );
		g.setColor(Color.WHITE);
		g.fillRoundRect( x, y, size, size, borderRadius, borderRadius );
		
		// Teken ogen
		g.setColor(Color.BLACK);
		
		
		if(worp == 1 || worp == 3 || worp == 5)
		{
			// centerMiddle
			g.fillOval(x + center - radius, y + middle - radius, diameter, diameter);
		}
		if(worp == 2 || worp == 3 || worp == 4 || worp == 5 || worp == 6)
		{
			// topRight
			g.fillOval(x + right - radius, y + top - radius, diameter, diameter);
		}
		if(worp == 2 || worp == 3 || worp == 4 || worp == 5 || worp == 6)
		{
			// bottomLeft
			g.fillOval(x + left - radius, y + bottom - radius, diameter, diameter);
		}
		if(worp == 4 || worp == 5 || worp == 6)
		{
			// topLeft
			g.fillOval(x + left - radius, y + top - radius, diameter, diameter);	
			// bottomRight
			g.fillOval(x + right - radius, y + bottom - radius, diameter, diameter);
		}
		if(worp == 6)
		{
			// leftMiddle
			g.fillOval(x + left - radius, y + middle - radius, diameter, diameter);
			// rightMiddle
			g.fillOval(x + right - radius, y + middle - radius, diameter, diameter);
		}
		
		g.drawString(""+ worp, x + middle, y + size + 50);
	}
	
	
	
}
