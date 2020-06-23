package listeners;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import element.Exercice;
import element.Type;
import graphique.ExoAffichage;
import graphique.Physique;
import graphique.PropoSeance;
import graphique.Technique;
import lancement.Lanceur;

/**
 * classe qui permet de réagir aux action sur les pages d'exercice
 * @author aymerick leborgne
 *
 */
public class ExerciceListener implements MouseListener{
	//déclaration des attributs
	Lanceur frame;
	Technique tech;
	Physique phys;
		/**
		 * permet d'initialiser les attributs de la classe
		 * @param fenetre la fenetre
		 * @param phys la page physique
		 * @param tech la page technique
		 */
		public ExerciceListener(Lanceur fenetre){
			this.frame = fenetre;
			if(frame.phys != null){
				this.phys = frame.phys;
				this.phys.listExo.addMouseListener(this);
				this.phys.exoAlea.addMouseListener(this);
				this.phys.proposSeance.addMouseListener(this);
			}
			if(frame.tech != null){
				this.tech = frame.tech;
				this.tech.listExo.addMouseListener(this);
				this.tech.exoAlea.addMouseListener(this);
				this.tech.proposSeance.addMouseListener(this);
			}
			
		}
		
		/**
		 * permet de réagir à l'action mené sur une fenetre exercice
		 * ici click sur la jList d'exo ou su les bouton du panel exercice
		 */
		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getClickCount() == 1){
				if(tech != null && e.getSource() == tech.listExo){
					Exercice selecItem = (Exercice) tech.listExo.getSelectedValue();
					this.tech.setVisible(false);
					this.frame.exo = new ExoAffichage(selecItem);
					this.frame.add(this.frame.exo);
					this.frame.listen2 = new GoBackListener(frame); 
				}else if(phys != null && e.getSource() == phys.listExo){
					Exercice selecItem = (Exercice) phys.listExo.getSelectedValue();
					this.phys.setVisible(false);
					this.frame.exo = new ExoAffichage(selecItem);
					this.frame.add(this.frame.exo);
					this.frame.listen2 = new GoBackListener(frame); 
				}else if(tech != null && e.getSource() == tech.exoAlea){
					Random rn = new Random();
					int n = rn.nextInt(tech.listeExo.length);
					this.tech.setVisible(false);
					this.frame.exo = new ExoAffichage(tech.listeExo[n]);
					this.frame.add(this.frame.exo);
					this.frame.listen2 = new GoBackListener(frame); 
				}else if(phys != null && e.getSource() == phys.exoAlea){
					Random rn = new Random();
					int n = rn.nextInt(phys.listeExo.length);
					this.phys.setVisible(false);
					this.frame.exo = new ExoAffichage(phys.listeExo[n]);
					this.frame.add(this.frame.exo);
					this.frame.listen2 = new GoBackListener(frame);
				}else if(phys != null && e.getSource() == phys.proposSeance){
					Exercice[] seanceExo = new Exercice[4];
					Random rn = new Random();
					int temps = 10;
					seanceExo[0] = new Exercice("Echauffement","Echauffe toi",Type.PHYSIQUE,10);
					for(int i=1; i<seanceExo.length;i++){
						int n = rn.nextInt(phys.listeExo.length);
						seanceExo[i] = phys.listeExo[n];
						temps += seanceExo[i].temps;
					}
					this.frame.seance = new PropoSeance(seanceExo,temps);
					this.phys.setVisible(false);
					this.frame.add(frame.seance);
					this.frame.listen2 = new GoBackListener(frame); 
				}else if(tech != null && e.getSource() == tech.proposSeance){
					Exercice[] seanceExo = new Exercice[4];
					int temps = 10;
					Random rn = new Random();
					seanceExo[0] = new Exercice("Echauffement","Echauffe toi",Type.TECHNIQUE,10);
					for(int i=1; i<seanceExo.length;i++){
						int n = rn.nextInt(tech.listeExo.length);
						seanceExo[i] = tech.listeExo[n];
						temps += seanceExo[i].temps;
					}
					this.frame.seance = new PropoSeance(seanceExo,temps);
					this.tech.setVisible(false);
					this.frame.add(frame.seance);
					this.frame.listen2 = new GoBackListener(frame); 
				}
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {}

		@Override
		public void mouseExited(MouseEvent arg0) {}

		@Override
		public void mousePressed(MouseEvent arg0) {}

		@Override
		public void mouseReleased(MouseEvent arg0) {}
}
