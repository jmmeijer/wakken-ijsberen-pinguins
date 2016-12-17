package game;

import java.awt.Graphics;
import java.util.*;

/**
 * De klasse <code>Game</code> representeert het model Game.
 * 
 * @author Jesse
 * @version 0.4
 * @see ScorePaneel
 * @see Dobbelsteen
 * @see BedieningsPaneel
 */
public class GameModel {
	
	private int variant, aantalDobbelstenen, beurt, score, totaalWakken, totaalIJsberen, totaalPinguins;
	private ArrayList<Dobbelsteen> dobbelstenen;
	private ArrayList<String> hints;

	/**
	 *  Constructor
	 * @param variant
	 * @param aantalDobbelstenen
	 */
	public GameModel( int variant, int aantalDobbelstenen ) {

		setAantalDobbelstenen(aantalDobbelstenen);
		
		// Check of variant tussen 1 en 3 ligt, zo ja: instellen.
		// Dit zou automatisch zo moeten zijn door gebruik te maken van radiobuttons
		if( variant >= 1 && variant <= 3){
			this.variant = variant;
		}else{
			// anders default 1
			this.variant = 1;
		}
		
		beurt = 0;
		score = 0;
		
		
		// TODO: onderscheid tussen varianten in tips
		hints = new ArrayList<String>();
		hints.add("Wakken zijn in het midden van de Noordpool");
		hints.add("IJsberen zijn vaak rondom wakken te vinden");
		hints.add("Pinguins bevinden zich op de Zuidpool");
		

		this.start();
		
	}
	
	/**
	 * Start functie, overbodig geworden
	 * TODO: referenties verwijderen
	 */
	private void start() {
		
	}
	
	/**
	 * Reset functie om spel opnieuw in te stellen
	 */
	public void reset() {
		
		beurt = 0;
		score = 0;
		totaalWakken = 0;
		totaalIJsberen = 0;
		totaalPinguins = 0;

	}
	
	public void voegtoe( Dobbelsteen dobbelsteen ) {
		dobbelstenen.add( dobbelsteen );
	}
	
	public ArrayList<Dobbelsteen> getDobbelstenen(){
		return dobbelstenen;
	}
	
	/**
	 *  Roep voor elke instantie van de dobbelsteen de functie dobbel aan.
	 */
	public void dobbel(){
		// Tel 1 beurt op bij totaal aantal beurten.
		beurt++;
		
		this.start();
		
		// reset waardes naar 0.
		// Misschien in ArrayList?
		totaalWakken = 0;
		totaalIJsberen = 0;
		totaalPinguins = 0;
		
		 for( Dobbelsteen dobbelsteen : dobbelstenen ){
			 dobbelsteen.dobbel();
		 }
	}
	
	/**
	 *  Controleer de ingevoerde aantallen met het antwoord
	 * @param wakken
	 * @param ijsberen
	 * @param pinguins
	 */
	public void check(int wakken, int ijsberen, int pinguins){
		
		// reset waardes naar 0.
		//totaalWakken = 0;
		//totaalIJsberen = 0;
		//totaalPinguins = 0;
		
		// Ga voor elke dobbelsteen het aantal w, ij en p na en tel deze op bij totaal
		for( Dobbelsteen dobbelsteen : dobbelstenen ){
			
			totaalWakken += dobbelsteen.getWakken();
			totaalIJsberen += dobbelsteen.getIJsberen();
			totaalPinguins += dobbelsteen.getPinguins();
			
		}
		
		if( wakken == totaalWakken && ijsberen == totaalIJsberen && pinguins == totaalPinguins ){
			score++;
		}else{
			
		}
		
		//controleer of de invoer gelijk is, anders is het fout
		if(wakken == totaalWakken){
			// aantal wakken goed
		}else{
			// aantal wakken fout
		}
		if(ijsberen == totaalIJsberen){
			// aantal ijsberen goed
		}else{
			// aantal ijsberen fout
		}
		if(pinguins == totaalPinguins){
			// aantal pinguins goed
		}else{
			// aantal pinguins fout
		}
		
	}
	
	/**
	 * Methode om aantal dobbelstenen in te stellen
	 * @param aantalDobbelstenen
	 */
	public void setAantalDobbelstenen(int aantalDobbelstenen) {
		
		// Controleer of de input tussen 3 en 8 is.
		if(aantalDobbelstenen >= 3 && aantalDobbelstenen <= 8) {
			this.aantalDobbelstenen = aantalDobbelstenen;
		} else if (aantalDobbelstenen < 3){
			this.aantalDobbelstenen = 3;
		} else if (aantalDobbelstenen > 8){
			this.aantalDobbelstenen = 8;
		}
		
		// roep start aan om ArrayList te updaten???
		//start();
		// kan dit beter in de constructor???
		// kan aantal in arraylist al beter op max 8 ingesteld worden?
		dobbelstenen = new ArrayList<Dobbelsteen>(aantalDobbelstenen);
		
		

		int aantalKolommen = 4;
		int size = (int) 800 / aantalKolommen - 40;
		int ypos = (int) 20;
		int xpos = 20;
		
		int k = 0;
		int r = 0;
		
		// Kan dit beter aan setAantalDobbelstenen worden toegevoegd?
		for( int i=0; i<aantalDobbelstenen; i++ ){
			
			//nieuwe loop voor kolommen
			/*
			for( k=0; k<aantalKolommen; k++ ){
				xpos = i*(size+15)+15;
			}
			*/
			
			 // nieuwe rij??
			 if( i%aantalKolommen == 0	){
				 ypos += r*(size+40);
				 k = 0;
				 r++;
				 /*
				if(k==aantalKolommen){
					k = 0;
				}
				*/
			 }
			 
			 xpos = k*(size+40)+20;
			 
			 Dobbelsteen dobbelsteen = new Dobbelsteen( size, xpos, ypos );
			 
			 this.voegtoe( dobbelsteen );
			 
			k++;
			 
		 }
	}
	
	/**
	 * Geef een willekeurige hint aan.
	 * @return randomHint
	 */
	public String getRandomHint(){
		// Geef een willekeurige tip
		Random random = new Random();
		String randomHint = hints.get( random.nextInt(hints.size()) );
		return randomHint;
	}
	
	/**
	 *  Methode om aantal dobbelstenen op te vragen
	 * @return het aantal dobbelstenen
	 */
	public Integer getAantalDobbelstenen() {
		return aantalDobbelstenen;
	}
	
	/**
	 *  Methode om aantal beurten op te vragen
	 * @return
	 */
	public Integer getBeurt() {
		return beurt;
	}
	
	/**
	 *  Methode om de score op te vragen
	 * @return
	 */
	public Integer getScore() {
		return score;
	}
	
	/**
	 *  Methode om het totaal aantal Wakken op te vragen
	 * @return
	 */
	public Integer getTotaalWakken() {
		return totaalWakken;
	}

	/**
	 * Methode om het totaal aantal IJsberen op te vragen.
	 * @return totaalIJsberen
	 */
	public Integer getTotaalIJsberen() {
		return totaalIJsberen;
	}
	
	/**
	 *  Methode om het totaal aantal pinguins op te vragen
	 * @return totaalPinguins;
	 */
	public Integer getTotaalPinguins() {
		return totaalPinguins;
	}
	
	/** 
	 * Roep voor elke instantie van de dobbelsteenklasse de teken-functie aan. maak gebruik van polymorfie
	 * @param g
	 */
	public void teken( Graphics g ){
		
		for( Dobbelsteen dobbelsteen : dobbelstenen ){
			dobbelsteen.teken( g );
		}
	}
	
}
