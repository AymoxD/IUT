/**
 * classe écouteur de l'accueil
 */
package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import graphique.Jeu;

public class AccueilListener implements ActionListener{
	
	Jeu frame;
	/**
	 * constructeur de lécouteur
	 * @param frame la fenetre de jeu
	 */
		public AccueilListener(Jeu frame){
			if(frame != null){
				this.frame = frame;
				iniComponent();
			}
			
			
		}
		/**
		 * initialise les composents
		 */
		private void iniComponent() {
			frame.panelAccueil.unJoueur.addActionListener(this);
			frame.panelAccueil.multiJoueur.addActionListener(this);
			frame.panelAccueil.parametre.addActionListener(this);
			frame.panelVictoire.accueil.addActionListener(this);
			frame.panelVictoire.quitter.addActionListener(this);
		}
		/**
		 * réaction à l'action faite sur le panel Accueil
		 * @param e un évenement d'action
		 */
		@Override
		public void actionPerformed(ActionEvent e) {
			Object o = e.getSource();
	        if(o instanceof JButton) {
	        	JButton objet = (JButton)o;
	        	if(objet != null && objet == frame.panelAccueil.unJoueur){
	        		frame.panelAccueil.setVisible(false);
	        		frame.add(frame.panelUnJoueur);
	        		frame.panelUnJoueur.setVisible(true);
	        		frame.pack();
	        	}else if(objet != null && objet == frame.panelAccueil.multiJoueur){
	        		frame.panelAccueil.setVisible(false);
	        		frame.add(frame.panelMultijoueur);
	        		frame.panelMultijoueur.setVisible(true);
	        		frame.pack();
	        	}else if(objet != null && objet == frame.panelAccueil.parametre){
	        		frame.panelAccueil.setVisible(false);
	        		frame.add(frame.panelParametre);
	        		frame.panelParametre.setVisible(true);
	        		frame.pack();
	        	}else if(objet != null && objet == frame.panelVictoire.accueil){
	        		frame.panelVictoire.setVisible(false);
	        		frame.remove(frame.panelVictoire);
	        		frame.add(frame.panelAccueil);
	        		frame.panelAccueil.setVisible(true);
	        		frame.pack();
	        		frame.solo = false;
	        	}else if(objet != null && objet == frame.panelVictoire.quitter){
	        		frame.dispose();
	        		System.exit(0);
	        	}
	        	
	        	
	        }
			
		}
}
