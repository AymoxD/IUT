/**
 * classe écouteur du panel de un joueur
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import graphique.Jeu;
import jeu.Partie;


public class UnJoueurListener implements ActionListener {
	Jeu frame;
	/**
	 * constructeur de l'écouteur sur le panel un joueur
	 * @param frame la fenetre de jeu
	 */
	public UnJoueurListener(Jeu frame){
		if(frame != null){
			this.frame = frame;
			iniComponent();
		}
	}
	/**
	 * initialise les composants de l'écouteur
	 */
	private void iniComponent() {
		frame.panelUnJoueur.nouveauBouton.addActionListener(this);
		frame.panelUnJoueur.chargerBouton.addActionListener(this);
		frame.panelUnJoueur.goBouton.addActionListener(this);
		frame.panelUnJoueur.retour.addActionListener(this);
	}
	
	/**
	 * réaction sur les éléments du panel d'un joueur
	 * @param e l'action sur les éléments du panel un joueur
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
        if(o instanceof JButton) {
        	JButton objet = (JButton)o;
        	if(objet != null && objet == frame.panelUnJoueur.nouveauBouton){
        		frame.nouveau = true;
        		frame.charge = false;
        		frame.panelUnJoueur.nouveauBouton.setEnabled(false);
        		frame.panelUnJoueur.chargerBouton.setEnabled(true);
        	}else if(objet != null && objet == frame.panelUnJoueur.chargerBouton){
        		frame.nouveau = false;
        		frame.charge = true;
        		frame.panelUnJoueur.chargerBouton.setEnabled(false);
        		frame.panelUnJoueur.nouveauBouton.setEnabled(true);
        	}else if(objet != null && objet == frame.panelUnJoueur.goBouton){
        		//on doit lancer une partie
        		
        		frame.panelUnJoueur.setVisible(false);
        		frame.add(frame.panelPlateau);
        		frame.panelPlateau.setVisible(true);
        		frame.pack();
        		frame.solo = true;
        		Partie.partieSoloG(this.frame);
        		
        	}else if(objet != null && objet == frame.panelUnJoueur.retour){
        		frame.panelUnJoueur.setVisible(false);
        		frame.remove(frame.panelUnJoueur);
        		frame.add(frame.panelAccueil);
        		frame.panelAccueil.setVisible(true);
        		frame.pack();
        		frame.solo = false;
        	}
        }
	}
}
