package game;

import java.awt.Graphics;
import java.util.*;

public class Game {
	
	private int aantalDobbelstenen, beurt, score, variant;
	private ArrayList<Dobbelsteen> dobbelstenen;

	public Game() {
		// Standaard aantal dobbelstenen instellen op 3.
		
		aantalDobbelstenen = 4;
		beurt = 1;
		dobbelstenen = new ArrayList<Dobbelsteen>();
		
		int size = (int) 800 / 8 - 20;
		
		 for( int i=0; i<aantalDobbelstenen; i++ ){
			 
			 int test = i*(size+15)+15;
			 Dobbelsteen dobbelsteen = new Dobbelsteen( size, test, 150 );
			 
			// TODO: fix voegtoe functie
			 dobbelstenen.add( dobbelsteen );
		 }
		
		
	}
	
	public void voegtoe( Dobbelsteen dobbelsteen ) {
		dobbelstenen.add( dobbelsteen );
	}
	
	public void dobbel(){
		// Tel 1 beurt op bij totaal aantal beurten.
		beurt++;
		
		 for( Dobbelsteen dobbelsteen : dobbelstenen ){
			 dobbelsteen.dobbel();
		 }
	}
	
	// Methode om aantal dobbelstenen in te stellen
	public void setAantalDobbelstenen(int aantalDobbelstenen) {
		
		// Controleer of de input tussen 3 en 8 is.
		if(aantalDobbelstenen >= 3 && aantalDobbelstenen <= 8) {
			this.aantalDobbelstenen = aantalDobbelstenen;
		} else {
			this.aantalDobbelstenen = 3;
		}
		
	}
	
	// Methode om aantal dobbelstenen op te vragen
	public Integer getAantalDobbelstenen() {
		return aantalDobbelstenen;
	}
	
	// Methode om aantal beurten op te vragen
	public Integer getBeurt() {
		return beurt;
	}
	
	// Methode om de score op te vragen
	public Integer getScore() {
		return score;
	}
	
	public void teken( Graphics g ) {

		 for( Dobbelsteen dobbelsteen : dobbelstenen ){
			 dobbelsteen.draw( g );
		 }

	}
		
		
	
}
