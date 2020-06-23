/**
 * @author Leborgne Aymerick
 * @version 1.0
 * cette classe permet de construire le plateau de jeu
 */
package graphique;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;

@SuppressWarnings("serial")
public class PlateauGraphique extends JPanel{
	public JTable plateau;
	public ModelePlateau pModele;
	public JLabel statuPartie;
	public int[][] plat;
	
	/**
	 * constructeur du panel qui représente le plateau de jeu
	 * @param plat la matrice d'entier représentant le plateau de jeu
	 */
	public PlateauGraphique(int[][] plat){
		//initialisation des éléments
		this.plat = plat;
		this.pModele = new ModelePlateau(plat);
		this.plateau = new JTable(pModele);
		plateau.setShowGrid(true);
		plateau.setGridColor(Color.GRAY);
		plateau.setBackground(Color.LIGHT_GRAY);
		plateau.setRowHeight(70);
		plateau.setRowSelectionAllowed(false);
		this.statuPartie = new JLabel();
		//ajout sur le panel
		this.setLayout(new BorderLayout());
		this.add(statuPartie,BorderLayout.NORTH);
		this.add(plateau,BorderLayout.CENTER);
	}
	
}
