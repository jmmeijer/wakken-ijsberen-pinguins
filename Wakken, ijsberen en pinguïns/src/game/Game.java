package game;

import java.awt.Graphics;
import java.util.*;

public class Game {
	
	private int variant, aantalDobbelstenen, beurt, score, totaalWakken, totaalIjsberen, totaalPinguins;
	private ArrayList<Dobbelsteen> dobbelstenen;

	public Game( int variant, int aantalDobbelstenen ) {
		
		// Check of aantal dobbelstenen tussen 3 en 8 ligt, zo ja: instellen.
		if( aantalDobbelstenen >= 3 && aantalDobbelstenen <= 8){
			this.aantalDobbelstenen = aantalDobbelstenen;
		}else{
			// anders default 3
			this.aantalDobbelstenen = 3;
		}
		// Check of variant tussen 1 en 3 ligt, zo ja: instellen.
		if( variant >= 3 && variant <= 8){
			this.variant = variant;
		}else{
			// anders default 1
			this.variant = 1;
		}
		
		
		
		beurt = 1;
		dobbelstenen = new ArrayList<Dobbelsteen>();
		
		int size = (int) 800 / 8 - 20;
		
		for( int i=0; i<aantalDobbelstenen; i++ ){
			 
			 int test = i*(size+15)+15;
			 Dobbelsteen dobbelsteen = new Dobbelsteen( size, test, 150 );
			 
			// TODO: fix voegtoe functie, werkt niet in constructor
			 dobbelstenen.add( dobbelsteen );
		 }
		
		
	}
	
	public void voegtoe( Dobbelsteen dobbelsteen ) {
		dobbelstenen.add( dobbelsteen );
	}
	
	public void dobbel(){
		// Tel 1 beurt op bij totaal aantal beurten.
		beurt++;
		
		// reset waardes naar 0.
		totaalWakken = 0;
		totaalIjsberen = 0;
		totaalPinguins = 0;
		
		 for( Dobbelsteen dobbelsteen : dobbelstenen ){
			 dobbelsteen.dobbel();
		 }
	}
	
	public void check(){

		
		for( Dobbelsteen dobbelsteen : dobbelstenen ){
			
			int worp = dobbelsteen.getWorp();
			int wakken = 0;
			int ijsberen = 0;
			int pinguins = 0;
			
			if(worp == 1 || worp == 3 || worp == 5){
				wakken = 1;
				ijsberen = worp - 1;
				pinguins = 7 - worp;
			}
			
			totaalWakken += wakken;
			totaalIjsberen += ijsberen;
			totaalPinguins += pinguins;
			
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
		 
		 g.drawString( "" + totaalWakken, 220, 340 );
		 g.drawString( "" + totaalIjsberen, 220, 390 );
		 g.drawString( "" + totaalPinguins, 220, 440 );

	}
		
		
	
}
