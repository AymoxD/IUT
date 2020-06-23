/**
 * @author Leborgne Aymerick
 * @version 1.0 
 * cette classe permet de créer une fenetre de jeu
 */
package graphique;

import javax.swing.JFrame;

import jeu.Partie;
import listener.AccueilListener;
import listener.MultijoueurListener;
import listener.ParametreListener;
import listener.PlateauGraphiqueListener;
import listener.UnJoueurListener;


public class Jeu extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public Accueil panelAccueil;
	public UnJoueurGraphique panelUnJoueur;
	public MultijoueurGraphique panelMultijoueur;
	public PlateauGraphique panelPlateau;
	public ParametreGraphique panelParametre;
	public VictoireGraphique panelVictoire;
	public boolean nouveau = true;
	public boolean charge = false;
	public boolean solo;
	public Partie partie;
	
	/**
	 */
	public static void fenetre() {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Jeu();
				
			}
		});
	}
	/**
	 * créer une fenetre de jeu
	 */
	@SuppressWarnings("unused")
	public Jeu(){
		
		this.setLocation(800, 200);
		this.panelAccueil = new Accueil();
		this.panelMultijoueur = new MultijoueurGraphique();
		this.panelUnJoueur = new  UnJoueurGraphique();
		this.panelParametre = new ParametreGraphique();
		this.panelPlateau = new PlateauGraphique(new int[11][11]);
		this.panelVictoire = new VictoireGraphique();

		this.add(panelVictoire);
		this.add(panelMultijoueur);
		this.add(panelUnJoueur);
		this.add(panelParametre);
		this.add(panelAccueil);
		
		AccueilListener listen1 = new AccueilListener(this);
		UnJoueurListener listen2 = new UnJoueurListener(this);
		MultijoueurListener listen3 = new MultijoueurListener(this);
		ParametreListener listen4 = new ParametreListener(this);
		PlateauGraphiqueListener listen5 = new PlateauGraphiqueListener(this);
		this.setVisible(true);
		this.pack();
		
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
}
