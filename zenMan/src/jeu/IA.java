/**
 * classe qui crée un IA
 * @author Leborgne Aymerick
 * @version 1.0
 */
package jeu;

import java.util.ArrayList;
import java.util.Random;

public class IA extends Joueur{
	/**
	 * constructeur de l'IA
	 * @param nom son nom
	 * @param pions son arrayList de pions
	 * @param plat le plateau sur lequel elle joue
	 * @param couleur la couleur de ses pions
	 * @param adverse son adversaire
	 */
	public IA(String nom,ArrayList<Pion> pions,Plateau plat,String couleur,Joueur adverse){
		super(nom,pions,plat,couleur,adverse);
		this.nom = "IA";
	}
	
	/**
	 * sélectionne un pion décplacable au hasard parmi les siens
	 * @return un pion de la liste
	 */
	public Pion selectionnePion(){
		Pion ret;
		Random rd = new Random();
		int index = rd.nextInt(this.sesPions.size());
		ret = this.sesPions.get(index);
		return ret;}
	/**
	 * deplace de manière aléatoire le pion passé en paramètre
	 * @param pionDePla le pion à déplacer
	 */
	public void deplacePion(Pion pionDePla){
		int [][] matriceDeDeplacement;
		boolean deplace = false;
		while(!deplace){
			matriceDeDeplacement = pionDePla.casePossible();
			for(int i = 0; i  < matriceDeDeplacement.length; i++){
				for(int j = 0; j < matriceDeDeplacement[i].length; j++){
					int p = matriceDeDeplacement[i][j];
					if(p == 4){
						deplace = true;
						int x = pionDePla.getCoordXPion();
						int y = pionDePla.getCoordYPion();
						this.sonPlateau.matricePlateau[y][x] = 0;
						this.sonPlateau.matricePlateau[i][j] = 2;
						pionDePla.setCoordXPion(j);
						pionDePla.setCoordYPion(i);
						for(int indexP = 0; indexP < this.sonAdversaire.sesPions.size(); indexP++){
							if(j == sonAdversaire.sesPions.get(indexP).getCoordXPion() && i == sonAdversaire.sesPions.get(indexP).getCoordYPion()){
								this.sonAdversaire.sesPions.remove(sonAdversaire.sesPions.get(indexP));
							}
						}
					}else if(p == 5){
						deplace = true;
						int x = pionDePla.getCoordXPion();
						int y = pionDePla.getCoordYPion();
						this.sonPlateau.matricePlateau[y][x] = 0;
						this.sonPlateau.matricePlateau[i][j] = 2;
						pionDePla.setCoordXPion(j);
						pionDePla.setCoordYPion(i);
						for(int indexP = 0; indexP < this.sonAdversaire.sesPions.size(); indexP++){
							if(j == sonAdversaire.sesPions.get(indexP).getCoordXPion() && i == sonAdversaire.sesPions.get(indexP).getCoordYPion()){
								this.sonAdversaire.sesPions.remove(sonAdversaire.sesPions.get(indexP));
							}
						}
					}
				}
			}
			pionDePla = selectionnePion();
		}
		
		
	}
	/**
	 * méthode qui permet à l'IA de jouer son tour
	 */
	public void joueTour(){
		if(sonAdversaire.frame != null){
			//System.out.println("C'est le tour de : " + this.nom);
		}
		Pion pionDePla = selectionnePion();
		deplacePion(pionDePla);
	}
	
}
