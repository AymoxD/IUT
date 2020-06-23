/**
 * classe écouteur du plateau graphique
 */
package listener;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import graphique.Jeu;
import jeu.Partie;
import jeu.Pion;
import utilitaire.LectureEcritureConfig;

public class PlateauGraphiqueListener implements MouseListener{
	
	Jeu frame;
	int click;
	Pion selec;
	/**
	 * constructeur de l'écouteur sur le plateau graphique
	 * @param frame la fenetre de jeu
	 */
	public PlateauGraphiqueListener(Jeu frame){
		if(frame != null){
			this.frame = frame;
			this.frame.panelPlateau.plateau.addMouseListener(this);
		}
	}
	/**
	 * réaction à l'action faite sur la souris
	 * @param e un évenement d'action sur un click de la souris
	 */
	@Override
	public void mouseClicked(MouseEvent e) {
		click ++;
		//comment le plateau réagit si le jeu est en mode solo
		if(frame.solo){
			if(Partie.j1.aGagne() && Partie.j2.aGagne()){
				frame.add(frame.panelVictoire);
    			frame.panelVictoire.statuVictoire.setText("Egalité, félicitation à vous deux !");
    		}else if(Partie.j1.aGagne() && !Partie.j2.aGagne()){
    			frame.add(frame.panelVictoire);
    			frame.panelVictoire.statuVictoire.setText(Partie.j1.nom + " a gagné la partie, félicitation !");
    		}else if(!Partie.j1.aGagne() && Partie.j2.aGagne()){
    			frame.add(frame.panelVictoire);
    			frame.panelVictoire.statuVictoire.setText(Partie.j2.nom + " a gagné la partie, félicitation !");
    		}
			Partie.courrant = Partie.j1;
			frame.panelPlateau.statuPartie.setText("C'est au tour de : " + Partie.courrant.nom);
			if(Partie.j1.aGagne() || Partie.j2.aGagne()){
				frame.panelPlateau.setVisible(false);
        		frame.add(frame.panelVictoire);
        		frame.panelVictoire.setVisible(true);
        		frame.pack();
			}else if(click == 1 && Partie.courrant == Partie.j1){
				frame.panelPlateau.statuPartie.setText("C'est au tour de : " + Partie.j1.nom);
				selec = Partie.j1.selectionPionGraphique(frame.panelPlateau.plateau.getSelectedColumn(),frame.panelPlateau.plateau.getSelectedRow());
				LectureEcritureConfig.writeFile(Partie.j1.nom, Partie.j2.nom, Partie.courrant.sonPlateau.matricePlateau);
				if(selec != null){
					frame.panelPlateau.pModele.matrice = selec.casePossible();
				}
				frame.repaint();
			}else if (click == 2 && Partie.courrant == Partie.j1){
				int x = frame.panelPlateau.plateau.getSelectedColumn();
				int y = frame.panelPlateau.plateau.getSelectedRow();
				//joueur deplace son pion
				
				boolean dep = Partie.j1.deplacementPionGraphique(selec,x,y);
				if(dep){
					frame.panelPlateau.pModele.matrice = Partie.j1.sonPlateau.matricePlateau;
					frame.repaint();
					Partie.courrant = Partie.j2;
					frame.panelPlateau.statuPartie.setText("C'est au tour de : " + Partie.j2.nom);
					Partie.j2.joueTour();
					frame.panelPlateau.statuPartie.setText("C'est au tour de : " + Partie.j1.nom);
					LectureEcritureConfig.writeFile(Partie.j1.nom, Partie.j2.nom, Partie.courrant.sonPlateau.matricePlateau);
					frame.panelPlateau.pModele.matrice = Partie.j2.sonPlateau.matricePlateau;
					frame.repaint();
					click = 0;
				}
				click = 0;
			}else{
				click = 0;
			}
		//comment le plateau réagit si le jeu n'est pas solo
		}else if (!frame.solo){
			if(Partie.j1.aGagne() || Partie.j2.aGagne()){
				frame.panelPlateau.setVisible(false);
        		frame.add(frame.panelVictoire);
        		frame.panelVictoire.setVisible(true);
        		frame.pack();
        		if(Partie.j1.aGagne() && Partie.j2.aGagne()){
        			frame.panelVictoire.statuVictoire.setText("Egalité, félicitation à vous deux !");
        		}else if(Partie.j1.aGagne() && !Partie.j2.aGagne()){
        			frame.panelVictoire.statuVictoire.setText(Partie.j1.nom + " a gagné la partie, félicitation !");
        		}else if(!Partie.j1.aGagne() && Partie.j2.aGagne()){
        			frame.panelVictoire.statuVictoire.setText(Partie.j2.nom + " a gagné la partie, félicitation !");
        		}
			}else if(click == 1 && Partie.courrant == Partie.j1){
				selec = Partie.j1.selectionPionGraphique(frame.panelPlateau.plateau.getSelectedColumn(),frame.panelPlateau.plateau.getSelectedRow());
				LectureEcritureConfig.writeFile(Partie.j1.nom, Partie.j2.nom, Partie.courrant.sonPlateau.matricePlateau);
				if(selec != null){
					frame.panelPlateau.pModele.matrice = selec.casePossible();
				}
				frame.repaint();
			}else if (click == 2 && Partie.courrant == Partie.j1){
				int x = frame.panelPlateau.plateau.getSelectedColumn();
				int y = frame.panelPlateau.plateau.getSelectedRow();
				//joueur deplace son pion
				
				boolean dep = Partie.j1.deplacementPionGraphique(selec,x,y);
				if(dep){
					frame.panelPlateau.pModele.matrice = Partie.j1.sonPlateau.matricePlateau;
					LectureEcritureConfig.writeFile(Partie.j1.nom, Partie.j2.nom, Partie.courrant.sonPlateau.matricePlateau);
					frame.repaint();
					Partie.courrant = Partie.j2;
					frame.panelPlateau.statuPartie.setText("C'est au tour de : " + Partie.courrant.nom);
					click = 0;
				}
				click = 0;
			}else if(click == 1 && Partie.courrant == Partie.j2){
				selec = Partie.j2.selectionPionGraphique(frame.panelPlateau.plateau.getSelectedColumn(),frame.panelPlateau.plateau.getSelectedRow());
				if(selec != null){
					frame.panelPlateau.pModele.matrice = selec.casePossible();
				}
				LectureEcritureConfig.writeFile(Partie.j1.nom, Partie.j2.nom, Partie.courrant.sonPlateau.matricePlateau);
				frame.repaint();
			}else if (click == 2 && Partie.courrant == Partie.j2){
				int x = frame.panelPlateau.plateau.getSelectedColumn();
				int y = frame.panelPlateau.plateau.getSelectedRow();
				//joueur deplace son pion
				boolean dep = Partie.j2.deplacementPionGraphique(selec,x,y);
				if(dep){
					frame.panelPlateau.pModele.matrice = Partie.j2.sonPlateau.matricePlateau;
					LectureEcritureConfig.writeFile(Partie.j1.nom, Partie.j2.nom, Partie.courrant.sonPlateau.matricePlateau);
					frame.repaint();
					Partie.courrant = Partie.j1;
					frame.panelPlateau.statuPartie.setText("C'est au tour de : " + Partie.courrant.nom);
					click = 0;
				}
				click = 0;
			}else{
				click = 0;
				selec = null;
			}
		}
	}
	/**
	 * réaction sur l'entré d'un click
	 * @param e l'action
	 */
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * réaction sur la sortie d'un click
	 * @param e l'action
	 */
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * réaction sur un click maintenue
	 * @param e l'action
	 */
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	/**
	 * réaction sur l'entré d'un click laché
	 * @param e l'action
	 */
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}
