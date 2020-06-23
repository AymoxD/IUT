package jeu;
import java.util.ArrayList;

import utilitaire.LectureEcritureConfig;

/**
 * Cette classe simule un joueur d'une partie de zen l'initi�
 * @author Leborgne Aymerick
 * @version 1.0
 */
public class Plateau {
	public int[][] matricePlateau;
	/**
	 * Le constructeur de Plateau cr�e un plateau de jeu avec le bon nombre de pion
	 * @param charge permet de savoir si on reprend une partie en cours
	 */
	public Plateau(boolean charge){
		this.matricePlateau = new int[11][11];
		if(!charge){
			//placement du zen :
			this.matricePlateau[5][5] = 3;
			//placement des pion noir
			this.matricePlateau[0][5] = 2;
			this.matricePlateau[0][10] = 2;
			this.matricePlateau[2][3] = 2;
			this.matricePlateau[2][7] = 2;
			this.matricePlateau[4][1] = 2;
			this.matricePlateau[4][9] = 2;
			this.matricePlateau[6][1] = 2;
			this.matricePlateau[6][9] = 2;
			this.matricePlateau[8][3] = 2;
			this.matricePlateau[8][7] = 2;
			this.matricePlateau[10][0] = 2;
			this.matricePlateau[10][5] = 2;
			//placement des pions blanc
			this.matricePlateau[0][0] = 1;
			this.matricePlateau[1][4] = 1;
			this.matricePlateau[1][6] = 1;
			this.matricePlateau[3][2] = 1;
			this.matricePlateau[3][8] = 1;
			this.matricePlateau[5][0] = 1;
			this.matricePlateau[5][10] = 1;
			this.matricePlateau[7][8] = 1;
			this.matricePlateau[7][2] = 1;
			this.matricePlateau[9][4] = 1;
			this.matricePlateau[9][6] = 1;
			this.matricePlateau[10][10] = 1;
		}else{
			ArrayList<String> fichier = LectureEcritureConfig.readFile("data/save.txt");
			int[][] matriceReprise = new int[11][11];
			String[][] tableau = new String[11][11];
			for(int i = 2; i < fichier.size();i++){
				tableau[i-2] = fichier.get(i).split("\t");
			}
			for(int i =0; i < tableau.length;i++){
				for(int j = 0; j < tableau[i].length;j++){
					matriceReprise[i][j] = Integer.parseInt(tableau[i][j]);
				}
			}
			this.matricePlateau = matriceReprise;
		}
	}
	
	/**
	 * Cette m�thode affiche l'�tat du plateau de jeu dans la console
	 */
	public void affichePlateau(){
		for(int i = 0; i < matricePlateau.length; i++){
			System.out.println("\n");
			for(int j = 0; j < matricePlateau[i].length; j++){
				System.out.print(matricePlateau[i][j] + "\t");
			}
		}
		System.out.println("\n");
		
	}
	/**
	 * Cette m�thode permet de connaitre le nombre de pion sur une ligne du plateau
	 * @param y un entier qui repr�sente l'indice de la coordonn�e de l'ordonn� du tableau
	 * @return ret un int qui est le nombre de pion dans une ligne de y
	 */
	public int compteLigne(int y){
		int ret = 0;
		for(int i = 0; i < this.matricePlateau[y].length; i++){
			if(this.matricePlateau[y][i] > 0){
				ret ++;
			}
		}
		return ret;
	}
	/**
	 * Cette m�thode retourne le nombre de pion sur une colonne
	 * @param x l'index de la colonne sur laquelle on veut compter le nombre de s
	 * @return ret le nombre de pion sur la colonne x
	 */
	public int compteColonne(int x){
		int ret = 0;
		for(int i = 0; i < this.matricePlateau.length;i ++){
			if(this.matricePlateau[i][x] > 0){
				ret ++;
			}
		}
		return ret;
	}
	/**
	 * retourne le nombre de pion sur la diagonale descendante de la matrice
	 * @param x index de position du pion en x
	 * @param y index de position du pion en y
	 * @return ret le nombre de pion sur la diagonale descendent de la matrice
	 */
	public int compteDiagDesc(int x, int y){
		int ret = 1;
		int xSup = x-1;
		int ySup = y-1;
		int xInf = x+1;
		int yInf = y+1;
		while(xSup >= 0 && ySup >= 0){
			if(this.matricePlateau[ySup][xSup] > 0){
				ret ++;
			}
			xSup --;
			ySup --;
		}
		while(xInf < matricePlateau.length && yInf < matricePlateau.length){
			if(this.matricePlateau[yInf][xInf] > 0){
				ret ++;
			}
			xInf ++;
			yInf ++;
		}
		return ret;
	}
	/**
	 * retourne le nombre de pion sur la diagonale ascendente de la matrice
	 * @param x index de position du pion en x
	 * @param y index de position du pion en y
	 * @return ret le nombre de pion sur la diagonale ascendente de la matrice
	 */
	public int compteDiagAsc(int x, int y){
		int ret = 1;
		int xSup = x+1;
		int ySup = y-1;
		int xInf = x-1;
		int yInf = y+1;
		while(xSup < matricePlateau.length && ySup >= 0){
			if(this.matricePlateau[ySup][xSup] > 0){
				ret ++;
			}
			xSup ++;
			ySup --;
		}
		while(xInf >= 0 && yInf < matricePlateau.length){
			if(this.matricePlateau[yInf][xInf] > 0){
				ret ++;
			}
			xInf --;
			yInf ++;
		}
		return ret;
	}
	/**
	 * permet d'initialiser les pions blanc en cas de nouvelle partie
	 * @return l'arrayList de pion blanc
	 */
	public ArrayList<Pion> iniPionBlanc(){
		ArrayList<Pion> pionBlanc = new ArrayList<Pion>();
		
		for(int i = 0; i < this.matricePlateau.length;i++){
			for(int j = 0; j < this.matricePlateau.length; j++){
				if(matricePlateau[i][j] == 1){
					pionBlanc.add(new Pion(j,i,this,"blanc"));
				}
			}
		}
		return pionBlanc;
	}
	/**
	 * permet d'initialiser les pions noir en cas de nouvelle partie
	 * @return l'arrayList de pion noir
	 */
	public ArrayList<Pion> iniPionNoir(){
		ArrayList<Pion> pionNoir = new ArrayList<Pion>();
		
		for(int i = 0; i < this.matricePlateau.length;i++){
			for(int j = 0; j < this.matricePlateau.length; j++){
				if(matricePlateau[i][j] == 2){
					pionNoir.add(new Pion(j,i,this,"noir"));
				}
			}
		}
		
		return pionNoir;
	}
	/**
	 * permet d'initialiser le pion zen en cas de nouvelle partie
	 * @return l'arrayList de pion rouge
	 */
	Pion iniPionRouge(){
		Pion pionRouge = null;
		for(int i = 0; i < this.matricePlateau.length;i++){
			for(int j = 0; j < this.matricePlateau.length; j++){
				if(matricePlateau[i][j] == 3){
					pionRouge = new Pion(j,i,this,"rouge");
				}
			}
		}
		return pionRouge;
	}
	
	
}
