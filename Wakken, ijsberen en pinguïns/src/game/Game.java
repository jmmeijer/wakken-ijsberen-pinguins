package game;

import java.awt.Graphics;
import java.util.*;

/**
 * De klasse <code>Game</code> representeert het model Game.
 * 
 * @author Jesse
 * @version 0.2
 * @see ScorePaneel
 * @see Dobbelsteen
 * @see BedieningsPaneel
 */
public class Game {
	
	private int variant, aantalDobbelstenen, beurt, score, totaalWakken, totaalIjsberen, totaalPinguins;
	private ArrayList<Dobbelsteen> dobbelstenen;
	private ArrayList<String> hints;

	// Constructor
	public Game( int variant, int aantalDobbelstenen ) {
		
		// Check of aantal dobbelstenen tussen 3 en 8 ligt, zo ja: instellen.
		// Misschien onnodig bij het gebruik van een slider
		if( aantalDobbelstenen >= 3 && aantalDobbelstenen <= 8){
			this.aantalDobbelstenen = aantalDobbelstenen;
		}else{
			// anders standaard 3
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

		this.start();
		
	}
	
	public void start() {
		
		dobbelstenen = new ArrayList<Dobbelsteen>(aantalDobbelstenen);

		int size = (int) 800 / 8 - 20;
		
		for( int i=0; i<aantalDobbelstenen; i++ ){
			 
			 int test = i*(size+15)+15;
			 Dobbelsteen dobbelsteen = new Dobbelsteen( size, test, 20 );
			 
			 this.voegtoe( dobbelsteen );
		 }
		
		// TODO: onderscheid tussen varianten in tips
		hints = new ArrayList<String>();
		hints.add("Wakken zijn in het midden van de Noordpool");
		hints.add("Ijsberen zijn vaak rondom wakken te vinden");
		hints.add("Pinguins bevinden zich op de Zuidpool");
		
	}
	
	public void voegtoe( Dobbelsteen dobbelsteen ) {
		dobbelstenen.add( dobbelsteen );
	}
	
	public ArrayList<Dobbelsteen> getDobbelstenen(){
		return dobbelstenen;
	}
	
	public void dobbel(){
		// Tel 1 beurt op bij totaal aantal beurten.
		beurt++;
		
		this.start();
		
		// reset waardes naar 0.
		// Misschien in ArrayList?
		totaalWakken = 0;
		totaalIjsberen = 0;
		totaalPinguins = 0;
		
		 for( Dobbelsteen dobbelsteen : dobbelstenen ){
			 dobbelsteen.dobbel();
		 }
	}
	
	public void check(int wakken, int ijsberen, int pinguins){
		
		// reset waardes naar 0.
		//totaalWakken = 0;
		//totaalIjsberen = 0;
		//totaalPinguins = 0;
		
		// Ga voor elke dobbelsteen het aantal w, ij en p na en tel deze op bij totaal
		for( Dobbelsteen dobbelsteen : dobbelstenen ){
			
			int worp = dobbelsteen.getWorp();

			if(worp == 1 || worp == 3 || worp == 5){
				totaalWakken += 1;
				totaalIjsberen += worp - 1;
				totaalPinguins += 7 - worp;
			}
		}
		
		//controleer of de invoer gelijk is, anders is het fout
		if(wakken == totaalWakken){
			// aantal wakken goed
		}else{
			// aantal wakken fout
		}
		if(ijsberen == totaalIjsberen){
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
	
	// Methode om aantal dobbelstenen in te stellen
	public void setAantalDobbelstenen(int aantalDobbelstenen) {
		
		// Controleer of de input tussen 3 en 8 is.
		if(aantalDobbelstenen >= 3 && aantalDobbelstenen <= 8) {
			this.aantalDobbelstenen = aantalDobbelstenen;
		} else {
			this.aantalDobbelstenen = 3;
		}
		
	}
	
	public String getHint(){
		// Geef een willekeurige tip
		Random random = new Random();
		String randomHint = hints.get( random.nextInt(hints.size()) );
		return randomHint;
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
	
	// Methode om de score op te vragen
	public Integer getTotaalWakken() {
		return totaalWakken;
	}

	// Methode om de score op te vragen
	public Integer getTotaalIjsberen() {
		return totaalIjsberen;
	}
	
	// Methode om de score op te vragen
	public Integer getTotaalPinguins() {
		return totaalPinguins;
	}		
	
}
