/**
 * classe écouteur du panel multijoueur
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import graphique.Jeu;
import jeu.Partie;

public class MultijoueurListener implements ActionListener {
Jeu frame;
	/**
	 * constructeur de l'écouteur du panel multijoueur
	 * @param frame la fenetre de jeu
	 */
	public MultijoueurListener(Jeu frame){
		if(frame != null){
			this.frame = frame;
			iniComponent();
		}
	}
	/**
	 * initialise les composant de l'écouteur
	 */
	private void iniComponent() {
		frame.panelMultijoueur.nouveauBouton.addActionListener(this);
		frame.panelMultijoueur.chargerBouton.addActionListener(this);
		frame.panelMultijoueur.goBouton.addActionListener(this);
		frame.panelMultijoueur.retour.addActionListener(this);
	}
	/**
	 * réaction à l'action faite sur le panel multijoueur
	 * @param e un évenement d'action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
        if(o instanceof JButton) {
        	JButton objet = (JButton)o;
        	if(objet != null && objet == frame.panelMultijoueur.nouveauBouton){
        		frame.nouveau = true;
        		frame.charge = false;
        		frame.panelMultijoueur.nouveauBouton.setEnabled(false);
        		frame.panelMultijoueur.chargerBouton.setEnabled(true);
        	}else if(objet != null && objet == frame.panelMultijoueur.chargerBouton){
        		frame.nouveau = false;
        		frame.charge = true;
        		frame.panelMultijoueur.chargerBouton.setEnabled(false);
        		frame.panelMultijoueur.nouveauBouton.setEnabled(true);
        	}else if(objet != null && objet == frame.panelMultijoueur.goBouton){
        		//on doit lancer une partie
        		frame.panelMultijoueur.setVisible(false);
        		frame.add(frame.panelPlateau);
        		frame.panelPlateau.setVisible(true);
        		frame.pack();
        		frame.solo = false;
        		Partie.partieMultiG(this.frame);
        	}else if(objet != null && objet == frame.panelMultijoueur.retour){
        		frame.panelUnJoueur.setVisible(false);
        		frame.remove(frame.panelMultijoueur);
        		frame.add(frame.panelAccueil);
        		frame.panelAccueil.setVisible(true);
        		frame.pack();
        		frame.solo = false;
        	}
        	
        }
		
	}
}
