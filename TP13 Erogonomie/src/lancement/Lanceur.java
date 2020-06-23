package lancement;
import graphique.*;

import listeners.*;
/**
 * classe qui lance l'application
 * @author aymerick leborgne
 */
public class Lanceur extends javax.swing.JFrame{
	//decalration des attributs
	public Accueil accueil;
	public Physique phys;
	public Technique tech;
	public ExoAffichage exo;
	public PropoSeance seance;
	public AccueilListener listen1;
	public GoBackListener listen2;
	public ExerciceListener listen3;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//lancement de l'application
	public static void main(String[] args) {
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new Lanceur();
				
			}
		});
	}
	
	public Lanceur(){
		this.accueil = new Accueil();
		this.add(accueil);
		this.listen1 = new AccueilListener(this);
		this.setVisible(true);
		this.pack();
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}
	
	public void setPhys(Physique phys){this.phys = phys;}
	public void setTech(Technique tech){this.tech = tech;}
	public void setExo(ExoAffichage exo){this.exo = exo;}

	public Physique getPhys() {
		return phys;
	}

	public Technique getTech() {
		return tech;
	}

	public ExoAffichage getExo() {
		return exo;
	}
	
}
