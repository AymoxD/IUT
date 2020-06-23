package jeu;
import java.util.ArrayList;
import java.util.Scanner;

import graphique.Jeu;
import utilitaire.tableau2DUtil;
/**
 * Cette classe simule un joueur d'une partie de zen l'initi�
 * @author Leborgne Aymerick
 * @version 1.0
 */
public class Joueur {
	public String nom;
	public ArrayList<Pion> sesPions;
	public Plateau sonPlateau;
	int[] memoirePlacement = new int[2];
	static int[] memoireZen = {5,5};
	public Joueur sonAdversaire;
	public Jeu frame;
	/**
	 * Permet de construire un joueur sans adversaire
	 * @param nom Le nom du joueur
	 * @param pions les pions du joueur
	 * @param plat le plateau sur lequel va jouer le joueur
	 * @param couleur la couleur de Pion du joueur
	 * @param frame la fenetre de jeu du jeu
	 */
	public Joueur(String nom,ArrayList<Pion> pions,Plateau plat, String couleur,Jeu frame){
		this.frame = frame;
		this.nom = nom;
		if(!pions.isEmpty()){
			this.sesPions = pions;
		}else{
			this.sesPions = null;
			System.out.println("Joueur : n'a pas de pions");
			}
		if(plat != null){
			this.sonPlateau = plat;
		}else{System.out.println("Joueur : le plateau entr� en param�tre est null");}
		this.sonAdversaire = null;
	}
	/**
	 * Permet de construire un joueur avec un adversaire
	 * @param nom Le nom du joueur
	 * @param pions les pions du joueur
	 * @param plat le plateau sur lequel va jouer le joueur
	 * @param couleur la couleur de Pion du joueur
	 * @param adverse l'adversaire du joueur
	 */
	public Joueur(String nom,ArrayList<Pion> pions,Plateau plat, String couleur, Joueur adverse){
		this.nom = nom;
		if(!pions.isEmpty()){
			this.sesPions = pions;
		}else{System.out.println("Joueur : n'a pas de pions");}
		if(plat != null){
			this.sonPlateau = plat;
		}else{System.out.println("Joueur : le plateau entr� en param�tre est null");}
		if(adverse != null){
			this.sonAdversaire = adverse;
		}
	}
	/**
	 * Permet au joueur de jouer son tour
	 */
	public void joueTour(){
		System.out.println("C'est le tour de : " + this.nom);
		this.sonPlateau.affichePlateau();
		this.deplacePion(this.selectionnePion());
	}
	/**
	 * Permet de sélectionner un pion parmi les siens
	 * @return le pion sélectionné par le joueur
	 */
	public Pion selectionnePion(){
		@SuppressWarnings("resource")
		Scanner sc1 = new Scanner(System.in);
		int x,y;
		Pion pionDePla = null;
		boolean selectionne = false;
		while(!selectionne){
			System.out.println("Entrez les coordonn�e en index du pion � d�placer : ");
			System.out.print("x : " );
			x = sc1.nextInt();
			sc1.nextLine();
			System.out.print("y : " );
			y = sc1.nextInt();
			sc1.nextLine();
			for(Pion p: this.sesPions){
				if(x == p.getCoordXPion() && y == p.getCoordYPion()){
					this.memoirePlacement[0] = x;
					this.memoirePlacement[1] = y;
					pionDePla = p;
					
					selectionne = true;
				}
			}
			if(pionDePla == null){
				System.out.println("coordonn�e de pion non trouv�e ou le pion ne vous appartient pas");
			}
		}
		
		return pionDePla;
	}
	/**
	 * Permet au joueur de rentrer les coordonnées ou déplacer son pion
	 * @param pionDePla le pion à déplacer
	 */
	public void deplacePion(Pion pionDePla){
		@SuppressWarnings("resource")
		Scanner sc = new Scanner(System.in);
		int x,y;
		int [][] matriceDeDeplacement;
		boolean deplacementPossible = false;
		while(!deplacementPossible){
			
			matriceDeDeplacement = pionDePla.casePossible();
			tableau2DUtil.afficherTableau2D(matriceDeDeplacement);
			System.out.println("Entrez les coordonn�e o� vous voulez d�placer votre pion ");
			System.out.print("x : " );
			x = sc.nextInt();
			sc.nextLine();
			System.out.print("y : " );
			y = sc.nextInt();
			sc.nextLine();
			if(matriceDeDeplacement[y][x] == 4){
				int numero;
				if(pionDePla.couleur.equals("blanc")){
					numero = 1;
				}else if (pionDePla.couleur.equals("noir")){
					numero = 2;
				}else{
					numero = 3;
				}
				if(numero == 3 && (Joueur.memoireZen[0] != y || Joueur.memoireZen[1] != x)){
					Joueur.memoireZen[1] = this.memoirePlacement[0];
					Joueur.memoireZen[0] = this.memoirePlacement[1];
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					this.sonPlateau.matricePlateau[y][x] = numero;
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					deplacementPossible = true;
				}else if(numero != 3){
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					this.sonPlateau.matricePlateau[y][x] = numero;
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					deplacementPossible = true;
				}else{
					System.out.println("Mouvement imposssible veuillez res�lectionner un pion");
					pionDePla = selectionnePion();
				}
				
			}else if(matriceDeDeplacement[y][x] == 5){
				Pion pionAdverse = null;
				for(Pion p: this.sonAdversaire.sesPions){
					if(x == p.getCoordXPion() && y == p.getCoordYPion()){
						pionAdverse = p;
					}
				}
				if(this.sonPlateau.matricePlateau[y][x] == 1){
					pionAdverse.couleur = "noir";
					this.sonAdversaire.sesPions.remove(pionAdverse);
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					this.sonPlateau.matricePlateau[y][x] = 2;
				}else if(this.sonPlateau.matricePlateau[y][x] == 2){
					pionAdverse.couleur = "blanc";
					this.sonAdversaire.sesPions.remove(pionAdverse);
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					this.sonPlateau.matricePlateau[y][x] = 1;
				}else if(this.sonPlateau.matricePlateau[y][x] == 3 && this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] == 1){
					this.sonAdversaire.sesPions.remove(pionAdverse);
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					pionAdverse.couleur = "blanc";
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					this.sonPlateau.matricePlateau[y][x] = 1;
				}else{
					this.sonAdversaire.sesPions.remove(pionAdverse);
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					pionAdverse.couleur = "noir";
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					this.sonPlateau.matricePlateau[y][x] = 2;
				}
				
				deplacementPossible = true;
			}else{
				System.out.println("les coordonn�e rentr�e ne sont pas correcte ou le zen � d�ja �t� plac� ici au tour pr�c�dent");
				pionDePla = selectionnePion();
			}
		}
		
	}
	/**
	 * Revoie un booléen pour savoir si le joueur a gagné
	 * @return true si le joueur gagne false sinon
	 */
	public boolean aGagne(){
		boolean gagne = false;
		ArrayList<Pion> pionColle = new ArrayList<Pion>();
		if(this.sesPions != null && !this.sesPions.isEmpty()){
			Pion premier = this.sesPions.get(0);
			pionColle.add(premier);
			pionACote(premier,pionColle);
			if(pionColle.size() == this.sesPions.size()){
				gagne = true;
			}
		}
		
		return gagne;
	}
	/**
	 * Méthode qui renvoie les position possible pour qu'un pion soit à côtée
	 * @param p Le pion à vérifier
	 * @return les cases à cotées du pion
	 */
	public int[][] positionCote(Pion p){
		int [][] positionCoteTab = {{p.getCoordXPion(),p.getCoordXPion(),p.getCoordXPion() + 1,p.getCoordXPion()-1, p.getCoordXPion() + 1, p.getCoordXPion() + 1,p.getCoordXPion() - 1,p.getCoordXPion() - 1,p.getCoordXPion()},
									{p.getCoordYPion() + 1, p.getCoordYPion()-1,p.getCoordYPion() , p.getCoordYPion(),p.getCoordYPion()-1, p.getCoordYPion() +1,p.getCoordYPion() +1,p.getCoordYPion() -1,p.getCoordYPion()}};
		return positionCoteTab;
	}
	/**
	 * Methode récursive qui permet de savoir si des pions sonts à côtés
	 * @param premier le premier pion de la liste
	 * @param pionColle l'arrayList qui contient les pion collés
	 */
	public void pionACote(Pion premier, ArrayList<Pion> pionColle){
		int[][] positionCote = positionCote(premier);
		int i = 0;
		for(Pion pi : this.sesPions){
			i = 0;
			while(i < positionCote[0].length){
				if(positionCote[0][i] == pi.getCoordXPion() && positionCote[1][i] == pi.getCoordYPion()){
					if(!pionColle.contains(pi)){
						pionColle.add(pi);
						positionCote = positionCote(pi);
						pionACote(pi,pionColle);
					}
				}
				i ++;
			}
		}
		
	}
	/**
	 * cette méthode permet de sélectionne le pion Graphiquement
	 * @param x la coordonnée en abscisse du pion
	 * @param y la coordonnée en ordonné du pion
	 * @return le pion sélectionné 
	 */
	public Pion selectionPionGraphique(int x, int y){
		Pion pionDePla = null;
		for(Pion p: this.sesPions){
			if(x == p.getCoordXPion() && y == p.getCoordYPion()){
				this.memoirePlacement[0] = x;
				this.memoirePlacement[1] = y;
				pionDePla = p;
			}
		}
		return pionDePla;
	}
	/**
	 * pemet de déplacer le pion passé en paramètre methode pour plus de facilité en version graphique
	 * @param pionDePla le pion à déplacer
	 * @param x la coordonnée en abscisse du pion
	 * @param y la coordonnée en ordonné du pion
	 * @return booléen vrai si le déplacement est effectué
	 */
	public boolean deplacementPionGraphique(Pion pionDePla,int x,int y){
		boolean deplace = false;
		if(pionDePla != null){
			int [][] matriceDeDeplacement;
			matriceDeDeplacement = pionDePla.casePossible();
			if(matriceDeDeplacement[y][x] == 4){
				int numero;
				if(pionDePla.couleur.equals("blanc")){
					numero = 1;
				}else if (pionDePla.couleur.equals("noir")){
					numero = 2;
				}else{
					numero = 3;
				}
				if(numero == 3 && (Joueur.memoireZen[0] != y || Joueur.memoireZen[1] != x)){
					Joueur.memoireZen[1] = this.memoirePlacement[0];
					Joueur.memoireZen[0] = this.memoirePlacement[1];
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					this.sonPlateau.matricePlateau[y][x] = numero;
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					deplace = true;
				}else if(numero != 3){
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					this.sonPlateau.matricePlateau[y][x] = numero;
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					deplace = true;
				}else{
					System.out.println("Mouvement imposssible veuillez res�lectionner un pion");
					pionDePla = selectionPionGraphique(x,y);
				}
				
			}else if(matriceDeDeplacement[y][x] == 5){
				Pion pionAdverse = null;
				Pion pionAllie = null;
				for(Pion p: this.sonAdversaire.sesPions){
					if(x == p.getCoordXPion() && y == p.getCoordYPion()){
						pionAdverse = p;
					}
				}
				for(Pion p: this.sesPions){
					if(x == p.getCoordXPion() && y == p.getCoordYPion()){
						pionAllie = p;
					}
				}
				if(this.sonPlateau.matricePlateau[y][x] == 1){
					this.sonAdversaire.sesPions.remove(pionAdverse);
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					this.sonPlateau.matricePlateau[y][x] = 2;
					deplace = true;
				}else if(this.sonPlateau.matricePlateau[y][x] == 2){
					this.sonAdversaire.sesPions.remove(pionAdverse);
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					this.sonPlateau.matricePlateau[y][x] = 1;
					deplace = true;
				}else if(this.sonPlateau.matricePlateau[y][x] == 3 && this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] == 1){
					this.sonAdversaire.sesPions.remove(pionAdverse);
					this.sesPions.remove(pionAllie);
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					this.sonPlateau.matricePlateau[y][x] = 1;
					deplace = true;
				}else{
					this.sonAdversaire.sesPions.remove(pionAdverse);
					this.sesPions.remove(pionAllie);
					pionDePla.setCoordXPion(x);
					pionDePla.setCoordYPion(y);
					pionAdverse.couleur = "noir";
					this.sonPlateau.matricePlateau[this.memoirePlacement[1]][this.memoirePlacement[0]] = 0;
					this.sonPlateau.matricePlateau[y][x] = 2;
				}
			}
		}
		return deplace;
	}
	
	/**
	 * Méthode setter de l'adversaire
	 * @param adverse l'adversaire du joueur
	 */
	public void setAdversaire(Joueur adverse){this.sonAdversaire = adverse;}
}


