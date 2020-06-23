package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import element.Type;
import graphique.ExoAffichage;
import graphique.Physique;
import graphique.Technique;
import lancement.Lanceur;
/**
 * cette classe permet de gérer les boutons retour sur chaque panel
 * @author aymerick leborgne
 *
 */
public class GoBackListener implements ActionListener {
	//declaration des attributs
	Physique panelPhysique;
	Technique panelTechnique;
	ExoAffichage exo;
	Lanceur frame;
	/**
	 * initialise les attributs du listener
	 * @param fenetre la fenetre pricipale
	 * @param phy le paneau physique
	 * @param tech le paneau technique
	 * @param exo le paneau exercice
	 */
	public GoBackListener(Lanceur fenetre){
		this.frame = fenetre;
		if(frame.phys != null){
			this.panelPhysique = frame.phys;
			this.panelPhysique.retour.addActionListener(this);
		}
		if(frame.tech != null){
			this.panelTechnique = frame.tech;
			this.panelTechnique.retour.addActionListener(this);
		}
		if(frame.exo != null){
			this.exo = frame.exo;
			this.exo.retour.addActionListener(this);
		}if(frame.seance != null){
			this.frame.seance.retour.addActionListener(this);
		}
	}
	
	/**
	 * méthode qui permet la réaction sur les différents boutons de retour des panels de l'application
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		Object o = e.getSource();
	    if(o instanceof JButton) {
	    	JButton objet = (JButton)o;
	        if(panelPhysique != null && objet == panelPhysique.retour){
	        	panelPhysique.setVisible(false);
	        	frame.accueil.setVisible(true);
	        }else if(panelTechnique != null && objet == panelTechnique.retour){
	        	panelTechnique.setVisible(false);
	        	frame.accueil.setVisible(true);
	        }else if(exo != null && objet == exo.retour){
	        	exo.setVisible(false);
	        	if(exo.exercice.type == Type.PHYSIQUE){
	        		exo.setVisible(false);
	        		frame.phys.setVisible(true);
	        	}else{
	        		exo.setVisible(false);
	        		frame.tech.setVisible(true);
	        	}
	        }else if(frame.phys != null && objet == frame.seance.retour){
	        	if(frame.seance.listeExo[0].type == Type.PHYSIQUE){
	        		frame.seance.setVisible(false);
		        	frame.phys.setVisible(true);
	        	}
	        }else if(frame.tech != null && objet == frame.seance.retour){
	        	if(frame.seance.listeExo[0].type == Type.TECHNIQUE){
	        		frame.seance.setVisible(false);
		        	frame.tech.setVisible(true);
	        	}
	        }
	   }
	}
}
