package jeu;
import java.util.ArrayList;

import utilitaire.tableau2DUtil;

public class Pion {
	public int coordXPion;
	public int coordYPion;
	private Plateau sonPlateau;
	public String couleur;
	/**
	 * Construit un pion 
	 * @param coordX la coordonnée en abscisse du pion à construire
	 * @param coordY la coordonnée en ordonnée du pion à construire
	 * @param plat le plateau sur lequel le pion est positionné
	 * @param couleur la couleur du Pion
	 */
	public Pion(int coordX, int coordY, Plateau plat, String couleur){
		if(coordX >= 0 && coordX <= plat.matricePlateau.length ){
			this.coordXPion = coordX;
		}else{System.out.println("Pion : la coordonn�e en X est incorrect");}
		
		if(coordY >= 0 && coordY <= plat.matricePlateau.length){
			this.coordYPion = coordY;
		}else{System.out.println("Pion : la coordonn�e en y est incorrect");}
		
		if(plat != null){
			this.sonPlateau = plat;
		}else{System.out.println("Pion : le plateau entr� en param�tre est null");}
		
		if(couleur.equals("rouge") || couleur.equals("noir") || couleur.equals("blanc")){
			this.couleur = couleur;
		}else{System.out.println("Pion : un probleme de couleur dans les param�tre constructeur");}
		
	}
	
	/**
	 * renvoie un tableau qui donne les cases ou peut se déplacer le pion
	 * @return le tableau où peut se déplacer le pion
	 */
	public int[][] casePossible(){
		//copie du tableau � deux dimension du plateau pour ne pas le modifier
		int[][] matricePlateau = this.sonPlateau.matricePlateau;
		int [][] deplacementPossible = tableau2DUtil.copierTableauCarre2D(matricePlateau);
		int numero;
		if(this.couleur.equals("noir")){
			numero = 2;
		}else if (this.couleur.equals("blanc")){ numero = 1;}
		else{
			numero = 3;
		}
		int ligne = deplacementLigne();
		int colonne = deplacementColonne();
		int diagAsc = deplacementDiagAsc();
		int diagDesc = deplacementDiagDesc();
		//si le pion est pas zen
		if(numero != 3){
			//placement du bon chiffre dans la matrice sur la ligne vers la droite
			if(this.coordXPion + ligne < 11){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion + ligne, this.coordYPion, deplacementPossible)){
					if(deplacementPossible[this.coordYPion][this.coordXPion + ligne] != numero && deplacementPossible[this.coordYPion][this.coordXPion + ligne] != 0){
						deplacementPossible[this.coordYPion][this.coordXPion + ligne] = 5;
					}else if(deplacementPossible[this.coordYPion][this.coordXPion + ligne] == 0){
						deplacementPossible[this.coordYPion][this.coordXPion + ligne] = 4;
					}
				}
				
			}
			//placement du bon chiffre dans la matrice sur la ligne vers la gauche
			if(this.coordXPion - ligne >= 0){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion - ligne, this.coordYPion, deplacementPossible)){
					if(deplacementPossible[this.coordYPion][this.coordXPion - ligne] != numero && deplacementPossible[this.coordYPion][this.coordXPion - ligne] != 0 ){
						deplacementPossible[this.coordYPion][this.coordXPion - ligne] = 5;
					}else if(deplacementPossible[this.coordYPion][this.coordXPion - ligne] == 0){
						deplacementPossible[this.coordYPion][this.coordXPion - ligne] = 4;
					}
				}
			}
			//placement du bon chiffre dans la matrice sur la colonne vers le bas
			if(this.coordYPion + colonne < 11){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion, this.coordYPion + colonne, deplacementPossible)){
					if(deplacementPossible[this.coordYPion+colonne][this.coordXPion] != numero && deplacementPossible[this.coordYPion+colonne][this.coordXPion] != 0 ){
						deplacementPossible[this.coordYPion+colonne][this.coordXPion] = 5;
					}else if(deplacementPossible[this.coordYPion+colonne][this.coordXPion] == 0){
						deplacementPossible[this.coordYPion + colonne][this.coordXPion] = 4;
					}
				}
			}
			//placement du bon chiffre dans la matrice sur la colonne vers le haut
			if(this.coordYPion - colonne >= 0){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion, this.coordYPion - colonne, deplacementPossible)){
					if(deplacementPossible[this.coordYPion-colonne][this.coordXPion] != numero && deplacementPossible[this.coordYPion-colonne][this.coordXPion] != 0){
						deplacementPossible[this.coordYPion-colonne][this.coordXPion] = 5;
					}else if (deplacementPossible[this.coordYPion-colonne][this.coordXPion] == 0){
						deplacementPossible[this.coordYPion - colonne][this.coordXPion] = 4;
					}
				}
			}
			//placement 
			if(this.coordYPion - diagAsc >= 0 && this.coordXPion + diagAsc < 11 ){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion + diagAsc, this.coordYPion - diagAsc, deplacementPossible)){
					if(deplacementPossible[this.coordYPion-diagAsc][this.coordXPion + diagAsc] != numero && deplacementPossible[this.coordYPion-diagAsc][this.coordXPion+diagAsc] != 0){
						deplacementPossible[this.coordYPion-diagAsc][this.coordXPion+diagAsc] = 5;
					}else if (deplacementPossible[this.coordYPion-diagAsc][this.coordXPion + diagAsc] == 0){
						deplacementPossible[this.coordYPion - diagAsc][this.coordXPion + diagAsc] = 4;
					}
				}
				
			}
			if(this.coordYPion + diagAsc < 11 && this.coordXPion - diagAsc >= 0 ){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion - diagAsc, this.coordYPion + diagAsc, deplacementPossible)){
					if(deplacementPossible[this.coordYPion+diagAsc][this.coordXPion - diagAsc] != numero && deplacementPossible[this.coordYPion+diagAsc][this.coordXPion-diagAsc] != 0){
						deplacementPossible[this.coordYPion+diagAsc][this.coordXPion-diagAsc] = 5;
					}else if (deplacementPossible[this.coordYPion+diagAsc][this.coordXPion - diagAsc] == 0){
						deplacementPossible[this.coordYPion + diagAsc][this.coordXPion - diagAsc] = 4;
					}
				}
			}
			
			if(this.coordYPion + diagDesc < 11 && this.coordXPion + diagDesc < 11){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion + diagDesc, this.coordYPion + diagDesc, deplacementPossible)){
					if(deplacementPossible[this.coordYPion+diagDesc][this.coordXPion + diagDesc] != numero && deplacementPossible[this.coordYPion+diagDesc][this.coordXPion+diagDesc] != 0){
						deplacementPossible[this.coordYPion+diagDesc][this.coordXPion+diagDesc] = 5;
					}else if (deplacementPossible[this.coordYPion+diagDesc][this.coordXPion + diagDesc] == 0){
						deplacementPossible[this.coordYPion + diagDesc][this.coordXPion + diagDesc] = 4;
					}
				}
			}
			if(this.coordYPion - diagDesc >= 0 && this.coordXPion - diagDesc >= 0){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion - diagDesc, this.coordYPion - diagDesc, deplacementPossible)){
					if(deplacementPossible[this.coordYPion-diagDesc][this.coordXPion - diagDesc] != numero && deplacementPossible[this.coordYPion-diagDesc][this.coordXPion-diagDesc] != 0){
						deplacementPossible[this.coordYPion-diagDesc][this.coordXPion-diagDesc] = 5;
					}else if (deplacementPossible[this.coordYPion-diagDesc][this.coordXPion - diagDesc] == 0){
						deplacementPossible[this.coordYPion - diagDesc][this.coordXPion - diagDesc] = 4;
					}
				}
			}
		//si le pion est zen on vérifie qu'il y ait un pion à coté (le zen est pas bloqué)
		}else if(numero == 3){
		

			if(this.coordXPion + ligne < 11){
				
				if(deplacementPossible[this.coordYPion][this.coordXPion + ligne] != numero && deplacementPossible[this.coordYPion][this.coordXPion + ligne] != 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion][this.coordXPion + ligne] = 5;
				}else if(deplacementPossible[this.coordYPion][this.coordXPion + ligne] == 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion][this.coordXPion + ligne] = 4;
				}
			}
				
			//placement du bon chiffre dans la matrice sur la ligne vers la gauche
			if(this.coordXPion - ligne >= 0){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion - ligne, this.coordYPion, deplacementPossible)){
					if(deplacementPossible[this.coordYPion][this.coordXPion - ligne] != numero && deplacementPossible[this.coordYPion][this.coordXPion - ligne] != 0 && this.pionEstACote() ){
						deplacementPossible[this.coordYPion][this.coordXPion - ligne] = 5;
					}else if(deplacementPossible[this.coordYPion][this.coordXPion - ligne] == 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion][this.coordXPion - ligne] = 4;
					}
				}
			}
			//placement du bon chiffre dans la matrice sur la colonne vers le bas
			if(this.coordYPion + colonne < 11){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion, this.coordYPion + colonne, deplacementPossible)){
					if(deplacementPossible[this.coordYPion+colonne][this.coordXPion] != numero && deplacementPossible[this.coordYPion+colonne][this.coordXPion] != 0 && this.pionEstACote() ){
						deplacementPossible[this.coordYPion+colonne][this.coordXPion] = 5;
					}else if(deplacementPossible[this.coordYPion+colonne][this.coordXPion] == 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion + colonne][this.coordXPion] = 4;
					}
				}
			}
			//placement du bon chiffre dans la matrice sur la colonne vers le haut
			if(this.coordYPion - colonne >= 0){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion, this.coordYPion - colonne, deplacementPossible)){
					if(deplacementPossible[this.coordYPion-colonne][this.coordXPion] != numero && deplacementPossible[this.coordYPion-colonne][this.coordXPion] != 0 && this.pionEstACote() ){
						deplacementPossible[this.coordYPion-colonne][this.coordXPion] = 5;
					}else if (deplacementPossible[this.coordYPion-colonne][this.coordXPion] == 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion - colonne][this.coordXPion] = 4;
					}
				}
			}
			//placement du bon chiffre dans la diagonale ascendente
			if(this.coordYPion - diagAsc >= 0 && this.coordXPion + diagAsc < 11 ){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion + diagAsc, this.coordYPion - diagAsc, deplacementPossible)){
					if(deplacementPossible[this.coordYPion-diagAsc][this.coordXPion + diagAsc] != numero && deplacementPossible[this.coordYPion-diagAsc][this.coordXPion+diagAsc] != 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion-diagAsc][this.coordXPion+diagAsc] = 5;
					}else if (deplacementPossible[this.coordYPion-diagAsc][this.coordXPion + diagAsc] == 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion - diagAsc][this.coordXPion + diagAsc] = 4;
					}
				}
				
			}
			//placement du bon chiffre dans la diagonale ascendente
			if(this.coordYPion + diagAsc < 11 && this.coordXPion - diagAsc >= 0 ){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion - diagAsc, this.coordYPion + diagAsc, deplacementPossible)){
					if(deplacementPossible[this.coordYPion+diagAsc][this.coordXPion - diagAsc] != numero && deplacementPossible[this.coordYPion+diagAsc][this.coordXPion-diagAsc] != 0 &&  this.pionEstACote()){
						deplacementPossible[this.coordYPion+diagAsc][this.coordXPion-diagAsc] = 5;
					}else if (deplacementPossible[this.coordYPion+diagAsc][this.coordXPion - diagAsc] == 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion + diagAsc][this.coordXPion - diagAsc] = 4;
					}
				}
			}
			//placement du bon chiffre dans la diagonale descendente
			if(this.coordYPion + diagDesc < 11 && this.coordXPion + diagDesc < 11){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion + diagDesc, this.coordYPion + diagDesc, deplacementPossible)){
					if(deplacementPossible[this.coordYPion+diagDesc][this.coordXPion + diagDesc] != numero && deplacementPossible[this.coordYPion+diagDesc][this.coordXPion+diagDesc] != 0 &&  this.pionEstACote()){
						deplacementPossible[this.coordYPion+diagDesc][this.coordXPion+diagDesc] = 5;
					}else if (deplacementPossible[this.coordYPion+diagDesc][this.coordXPion + diagDesc] == 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion + diagDesc][this.coordXPion + diagDesc] = 4;
					}
				}
			}
			//placement du bon chiffre dans la diagonale descendente
			if(this.coordYPion - diagDesc >= 0 && this.coordXPion - diagDesc >= 0){
				if(!estObstrue(numero, this.coordXPion, this.coordYPion,this.coordXPion - diagDesc, this.coordYPion - diagDesc, deplacementPossible)){
					if(deplacementPossible[this.coordYPion-diagDesc][this.coordXPion - diagDesc] != numero && deplacementPossible[this.coordYPion-diagDesc][this.coordXPion-diagDesc] != 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion-diagDesc][this.coordXPion-diagDesc] = 5;
					}else if (deplacementPossible[this.coordYPion-diagDesc][this.coordXPion - diagDesc] == 0 && this.pionEstACote()){
						deplacementPossible[this.coordYPion - diagDesc][this.coordXPion - diagDesc] = 4;
					}
				}
			}
			
		}
		return deplacementPossible;
	}
		

	/**
	 * Compte jusqu'ou se déplace le Pion sur une ligne
	 * @return le nombre de case de déplacement possible
	 */
	public int deplacementLigne(){
		return sonPlateau.compteLigne(this.coordYPion);
	}
	/**
	 * Compte jusqu'ou se déplace le Pion sur une colonne
	 * @return le nombre de case de déplacement possible
	 */
	public int deplacementColonne(){
		return sonPlateau.compteColonne(this.coordXPion);
	}
	/**
	 * Compte jusqu'ou se déplace le Pion sur une diagonale ascendente
	 * @return le nombre de case de déplacement possible
	 */
	public int deplacementDiagAsc(){
		return sonPlateau.compteDiagAsc(this.coordXPion, this.coordYPion);
	}
	/**
	 * Compte jusqu'ou se déplace le Pion sur une diagonale descendente
	 * @return le nombre de case de déplacement possible
	 */
	public int deplacementDiagDesc(){
		return sonPlateau.compteDiagDesc(this.coordXPion, this.coordYPion);
	}
	
	/**
	 * Permet de savoir si le déplacement du pion est obstrué
	 * @param numero l'id du type du pion 
	 * @param xDep l'abscisse de départ du pion
	 * @param yDep l'ordonné de départ du pion
	 * @param xDest l'abscisse de départ du pion
	 * @param yDest l'ordonné de départ du pion
	 * @param matriceJeu le tableau qui donne l'état du jeu actuel
	 * @return true si le chemin du pion est obstrué
	 */
	public boolean estObstrue(int numero,int xDep, int yDep,int xDest,int yDest,int[][] matriceJeu){
		boolean obstrue = false;
		//verification en colonne vers le bas
		if(xDep == xDest && yDep < yDest){
			for(int i = yDep; i < yDest; i++){
				if(matriceJeu[i][xDest] != 0 && (matriceJeu[i][xDest] != numero && matriceJeu[i][xDest] != 3)){
					obstrue = true;
				}
			}
		}
		//verification en colonne vers le haut
		if(xDep == xDest && yDep > yDest){
			for(int i = yDep; i > yDest; i--){
				if(matriceJeu[i][xDest] != 0 && (matriceJeu[i][xDest] != numero && matriceJeu[i][xDest] != 3)){
					obstrue = true;
				}
			}
		}
		//verification en ligne vers la droite
		if(yDep == yDest && xDep < xDest){
			for(int i = xDep; i < xDest; i++){
				if(matriceJeu[yDest][i] != 0 && (matriceJeu[yDest][i] != numero && matriceJeu[yDest][i] != 3)){
					obstrue = true;
				}
			}
		}
		//verification en ligne vers la gauche
		if(yDep == yDest && xDep > xDest){
			for(int i = xDep; i > xDest; i--){
				if(matriceJeu[yDest][i] != 0 && (matriceJeu[yDest][i] != numero && matriceJeu[yDest][i] != 3)){
					obstrue = true;
				}
			}
		}
		//verification diagonale ascendente vers le haut
		if(yDep > yDest && xDep < xDest){
			int x,y;
			x = xDep;
			y = yDep;
			while(x < xDest && y > yDest){
				if(matriceJeu[y][x] != 0 && (matriceJeu[y][x] != numero && matriceJeu[y][x] != 3)){
					obstrue = true;
				}
				x ++;
				y --;
			}
		}
		//verification diagonale ascendante vers le bas 
		if(yDep < yDest && xDep > xDest){
			int x,y;
			x = xDep;
			y = yDep;
			while(x > xDest && y < yDest){
				if(matriceJeu[y][x] != 0 && (matriceJeu[y][x] != numero && matriceJeu[y][x] != 3)){
					obstrue = true;
				}
				x --;
				y ++;
			}
		}
		//verification diagonale descendante vers le haut
		if(yDep > yDest && xDep > xDest){
			int x,y;
			x = xDep;
			y = yDep;
			while(x > xDest && y > yDest){
				if(matriceJeu[y][x] != 0 && (matriceJeu[y][x] != numero && matriceJeu[y][x] != 3)){
					obstrue = true;
				}
				x --;
				y --;
			}
		}
		//verification diagonale descendante vers le haut
		if(yDep < yDest && xDep < xDest){
			int x,y;
			x = xDep;
			y = yDep;
			while(x < xDest && y < yDest){
				if(matriceJeu[y][x] != 0 && (matriceJeu[y][x] != numero && matriceJeu[y][x] != 3)){
					obstrue = true;
				}
				x ++;
				y ++;
			}
		}
		return obstrue;
	}
	/**
	 * cette methode retourne un tableau des positions à cotée du pion instance de cette classe
	 * @return le tableau de position de pions à coté
	 */
	private int[][] positionCote(){
		int[][] position = null;
		if(this.couleur.equals("rouge")){
			int[][] positionCoteTab = {{this.getCoordXPion(),this.getCoordXPion(),this.getCoordXPion() + 1,this.getCoordXPion()-1, this.getCoordXPion() + 1, this.getCoordXPion() + 1,this.getCoordXPion() - 1,this.getCoordXPion() - 1},
								{this.getCoordYPion() + 1, this.getCoordYPion()-1,this.getCoordYPion() , this.getCoordYPion(),this.getCoordYPion()-1, this.getCoordYPion() +1,this.getCoordYPion() +1,this.getCoordYPion() -1}};
			position = positionCoteTab;
		}
		return position;
	}
	/**
	 * méthode qui renvoie vrai si un pion est à coté
	 * @return vrai si un pion est à coté
	 */
	private boolean pionEstACote(){
		boolean colle = false;
		int[][] position = this.positionCote();
		if (position != null){
			ArrayList<Pion> noir = this.sonPlateau.iniPionNoir();
			ArrayList<Pion> blanc = this.sonPlateau.iniPionBlanc();
			int i = 0;
			while(i < position[0].length){
				for(Pion p : noir){
					if(position[0][i] == p.getCoordXPion() && position[1][i] == p.getCoordYPion()){
						colle = true;
					}
				}
				for(Pion p : blanc){
					if(position[0][i] == p.getCoordXPion() && position[1][i] == p.getCoordYPion()){
						colle = true;
					}	
				}
				i++;
			}
		}
		return colle;
	}
	
	/**
	 * méthode toString de la classe Pion
	 * @return la chaine de caractère à print
	 */
	public String toString(){
		return "" + this.coordXPion +" : " + this.coordYPion;
	}
	/**
	 * getter de la coordonné x de pion
	 * @return la coordonné x
	 */
	public int getCoordXPion(){return this.coordXPion;}
	/**
	 * getter de la coordonné y de pion
	 * @return la coordonné y
	 */
	public int getCoordYPion(){return this.coordYPion;}
	/**
	 * setter de la coordonné x de pion
	 * @param x la coordonné en x
	 */
	public void setCoordXPion(int x){ this.coordXPion = x;}
	/**
	 * setter de la coordonné y de pion
	 * @param y la coordonnée en y
	 */
	public void setCoordYPion(int y){ this.coordYPion = y;}
	

}
	

