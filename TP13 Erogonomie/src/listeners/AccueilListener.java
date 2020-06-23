package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import graphique.Accueil;
import graphique.ExoAffichage;
import graphique.Physique;
import graphique.Technique;
import lancement.Lanceur;
/**
 * cette classe permet de gérer les actions sur la page d'accueil
 * @author aymerick leborgne
 */
public class AccueilListener implements ActionListener{
	//declaration des attributs
	Lanceur frame;
	Accueil accueil;
	Physique phys;
	Technique tech;
	ExoAffichage exo;
	/**
	 * initialise les attribut de la classe
	 * @param frame la fenetre
	 * @param acc la page d'accueil
	 * @param phys la page physique
	 * @param tech la page technique
	 */
	public AccueilListener(Lanceur frame){
		this.frame = frame;
		this.accueil = frame.accueil;
		this.phys = frame.phys;
		this.tech = frame.tech;
		this.exo = frame.exo;
		iniEvent();
		
	}
	/**
	 * initialise les composant qui vont réagir à une action
	 */
	private void iniEvent() {
		this.accueil.physique.addActionListener(this);
		this.accueil.technique.addActionListener(this);
	}
	
	/**
	 * méthode de la réaction à l'action réalisé
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
        if(o instanceof JButton) {
        	JButton objet = (JButton)o;
        	if(objet == accueil.physique){
        		accueil.setVisible(false);
        		this.phys = new Physique("Entrainement Physique");
        		frame.setPhys(phys);
        		frame.getContentPane().add(phys);
        		frame.listen2 = new GoBackListener(frame);
        		frame.listen3 = new ExerciceListener(frame);
        	}else if(objet == accueil.technique){
        		accueil.setVisible(false);
        		this.tech = new Technique("Entrainement Technique");
        		frame.setTech(tech);
        		frame.getContentPane().add(tech);	
        		frame.listen2 = new GoBackListener(frame);
        		frame.listen3 = new ExerciceListener(frame);
        	}
		
        }

	}
}
