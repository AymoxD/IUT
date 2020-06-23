/**
 * @author Leborgne aymerick
 * @version 1.0
 * cette classe permet de créer le modèle du plateau de jeu
 */
package graphique;

import javax.swing.ImageIcon;
import javax.swing.table.AbstractTableModel;

@SuppressWarnings("serial")
public class ModelePlateau extends AbstractTableModel {
	
	 public int[][] matrice;
	 private static final String PATH = "/"; 
	 
	 /**
	  * Le constructeur de modèle du plateau
	  * @param plateauJeu la matrice du plateau de jeu
	  */
	 public ModelePlateau(int[][]plateauJeu){
		 this.matrice = plateauJeu;
	 }
	 
	 /**
	  * cette méthode permet d'avoir le nombre de colonne du plateau de jeu
	  * @return le nombre de colonne
	  */
	@Override
	public int getColumnCount() {
		return this.matrice[0].length;
	}
	/**
	 * cette méthode permet d'avoir le nombre de ligne du plateau de jeu
	 * @return le nombre de ligne
	 */
	@Override
	public int getRowCount() {
		return this.matrice.length;
	}
	/**
	 * Cette méthode permet d'avoir l'objet à la colonne et la ligne indiquée
	 * @param l l'indice de la ligne
	 * @param c l'indice de la colonne
	 * @return l'objet ciblé par la ligne et la colonne
	 */
	@Override
	public Object getValueAt(int l, int c) {
		 Object result = new Object();
		    int ma = matrice[l][c];
		    if (ma == 3) result= new ImageIcon(getClass().getResource(PATH + "pionZen.jpg"));
		    else if (ma == 1) result= new ImageIcon(getClass().getResource(PATH + "pionBlanc.jpg"));
		    else if (ma == 2) result= new ImageIcon(getClass().getResource(PATH + "pionNoir.jpg"));
		    else if (ma == 4) result = new ImageIcon(getClass().getResource(PATH + "deplacable.jpg"));
		    else if (ma == 5) result = new ImageIcon(getClass().getResource(PATH + "capturable.jpg"));
		    else if (ma == 0) result = new ImageIcon(getClass().getResource(PATH + "fond.png"));
		    return result;
	}
	/**
	 * cette méthode permet de définir si la cellule est éditable ou non
	 * @param x l'indice de la ligne
	 * @param y l'indice de la colonne
	 * @return booléen qui indique i la cellule est éditable
	 */
	public boolean isCellEditable(int x, int y) {
		return false;
	}
	/**
	 * pemer d'obtenir la classe d'une colonne
	 * @param c l'indice de la colonne
	 * @return la classe de la colonne
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getColumnClass(int c) {
	   return this.getValueAt(0, c).getClass();
	}

	
}
