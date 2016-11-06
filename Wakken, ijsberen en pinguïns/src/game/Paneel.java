package game;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * De klasse <code>Paneel</code> representeert een paneel.
 * 
 * @author Jesse
 * @version 0.4
 * @see Opstart
 * @see Paneel
 */
class Paneel extends JPanel {
	// Declareren van de variabelen.
	private JFrame frame;
	private GameModel model;
	private JPanel scorePaneel, view, bedieningsPaneel;
	private int frameWidth;

	public Paneel(JFrame frame, GameModel model)	{
		// Lay-outmanager uitschakelen.
		//setLayout( null );
		setLayout(new BorderLayout());
		
		this.frame = frame;
		this.model = model;
		
		//setBackground( Color.GREEN );
		//setBackground( new Color(40, 220, 40 ) );
		
		
		// maak een nieuwe instantie van de game aan met als argument 1 voor variant en 3 voor aantalDobbelstenen.
		//model = new Game(1, 3);
		
		scorePaneel = new ScorePaneel( model );
		scorePaneel.setPreferredSize(new Dimension(800, 50));
		//scorePaneel.setMaximumSize(new Dimension(100, 400));
		
		view = new GameView( model, scorePaneel );
		view.setPreferredSize(new Dimension(100, 150));
		
		//view.setBackground( new Color(0, 0, 0, 0) );
		view.setOpaque(false);
		
		bedieningsPaneel = new BedieningsPaneel( frame, model, view, scorePaneel );
		//bedieningsPaneel.setLayout( new BoxLayout( bedieningsPaneel, BoxLayout.X_AXIS ));
		//bedieningsPaneel.setLayout( new GridLayout( 1,2 ) );
		bedieningsPaneel.setPreferredSize(new Dimension(100, 200));
		//bedieningsPaneel.setMaximumSize(new Dimension(100, 400));
		
		//bedieningsPaneel.setBackground( new Color(0, 0, 0, 0) );
		//bedieningsPaneel.setOpaque(false);

		//add(scorePaneel, BorderLayout.PAGE_START);
		add(view, BorderLayout.CENTER);
		add(bedieningsPaneel, BorderLayout.PAGE_END);

		// Framebreedte kan nog niet worden uitgelezen bij instantiering van Paneelklasse
		frameWidth = (int) this.getWidth();
		
		//dobbelsteen.draw(g);
		
		//int test = (int) frameWidth / aantalDobbelstenen;
	}
	
	public void paintComponent( Graphics g ) {
		super.paintComponent(g);
		
		//frameWidth = (int) this.getWidth();
		//g.drawString("" + frameWidth , 400, 400);
		
		//http://stackoverflow.com/questions/523767/how-to-set-background-image-in-java
		BufferedImage img;
		try {
			img = ImageIO.read(new File("src/green_felt.jpg"));
			
			g.drawImage(img, 0, 0, null);
			
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}