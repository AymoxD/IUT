/**
 * classe écouteur des paramètres
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import graphique.Jeu;

public class ParametreListener implements ActionListener{
	public Jeu frame;
	/**
	 * constructeur de l'écouteur des paramètres
	 * @param frame la fenetre de jeu
	 */
	public ParametreListener(Jeu frame){
		if(frame != null){
			this.frame = frame;
			iniComponent();
		}
	}
	/**
	 * initialise les composants de l'écouteur
	 */
	private void iniComponent() {
		this.frame.panelParametre.vConsole.addActionListener(this);
		this.frame.panelParametre.vGraphique.addActionListener(this);
		this.frame.panelParametre.retour.addActionListener(this);
	}
	/**
	 * réaction à l'action faite sur le panel des paramètres
	 * @param e un évenement d'action
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
        if(o instanceof JButton) {
        	JButton objet = (JButton)o;
        	if(objet != null && objet == frame.panelParametre.vConsole){
        		System.out.println("Veuillez relancer l'application et sélectionner le mode console");
        		frame.dispose();
        	}else if(objet != null && objet == frame.panelParametre.vGraphique){
        		frame.add(frame.panelAccueil);
        		frame.panelAccueil.setVisible(true);
        		frame.remove(frame.panelParametre);
        	}else if(objet != null && objet == frame.panelParametre.retour){
        		frame.panelUnJoueur.setVisible(false);
        		frame.remove(frame.panelParametre);
        		frame.add(frame.panelAccueil);
        		frame.panelAccueil.setVisible(true);
        		frame.pack();
        		frame.solo = false;
        	}
        }
	}
}
