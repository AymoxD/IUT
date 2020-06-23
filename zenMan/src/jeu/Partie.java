package jeu;
import java.util.ArrayList;
import java.util.Scanner;

import graphique.Jeu;
import utilitaire.LectureEcritureConfig;

/**
 * Cette classe lance une partie
 * @author Aymerick Leborgne
 * @version 1.0
 */


public class Partie {
	
	public static Joueur j1;
	public static Joueur j2;
	public static Joueur courrant;
	
	/**
	 * création du menu en mode console
	 */
	public void lancement(){
		Scanner sc = new Scanner(System.in);
		System.out.println("Veuillez choisir le mode de jeu : \n \t 1 : mode solo \n \t 2 : mode multijoueurs \n \t 3 : quitter");
		int choix = sc.nextInt();
		sc.nextLine();
		if(choix == 1 ){
			partieSoloC(null);
		}else if (choix == 2){
			partieMultijoueursC(null);
		}else if(choix == 3){
			System.exit(0);
		}
		sc.close();
	}
	
	/**
	 * crée une partie de jeu de Zen l'initié
	 */
	public Partie(){
		
	}
	
	/**
	 * Lance une partie multijoueur de Zen l'initié
	 * @param frame la fenetre de jeu
	 */
	public void partieMultijoueursC(Jeu frame) {
		Scanner sc = new Scanner(System.in);
		//en cas de reprise de partie
		String nom1;
		String nom2;
		System.out.println("Voulez vous reprendre la dernière partie o/n");
		String rep = sc.nextLine();
		boolean charge = false;
		if(rep.equalsIgnoreCase("o") || rep.equalsIgnoreCase("oui")){
			charge = true;
			ArrayList<String> fichier = LectureEcritureConfig.readFile("data/save.txt");
			nom1 = fichier.get(0);
			nom2 = fichier.get(1);
		}else{
			System.out.println("Entrez les nom des joueurs");
			System.out.print("Joueur 1 : ");
			nom1 = sc.nextLine();
			System.out.print("Joueur 2 : ");
			nom2 = sc.nextLine();
		}
		
		//creation ou redéfinission de la partie
		System.out.println("Cr�ation du plateau . . .");
		Plateau plat = new Plateau(charge);
		System.out.println("Initialisation des pions . . .");
		ArrayList<Pion> pionNoir = plat.iniPionNoir();
		ArrayList<Pion> pionBlanc = plat.iniPionBlanc();
		Pion pionZen = plat.iniPionRouge();
		System.out.println("Initialisation des joueurs . . .");
		Joueur joueur1 = new Joueur(nom1,pionBlanc,plat,"blanc",frame);
		Joueur joueur2 = new Joueur(nom2,pionNoir,plat,"noir",joueur1);
		joueur1.setAdversaire(joueur2);
		if(pionZen != null){
			joueur1.sesPions.add(pionZen);
			joueur2.sesPions.add(pionZen);
		}
		System.out.println(nom1 + " poss�de les pions blanc (1)");
		System.out.println(nom2 + " poss�de les pions noir (2)");

		while(!joueur1.aGagne() || joueur2.aGagne()){
			System.out.println("C'est le tour de : " + joueur1.nom);
			joueur1.joueTour();
			LectureEcritureConfig.writeFile(joueur1.nom, joueur2.nom, plat.matricePlateau);
			System.out.println("C'est le tour de : " + joueur2.nom);
			joueur2.joueTour();
			LectureEcritureConfig.writeFile(joueur1.nom, joueur2.nom, plat.matricePlateau);
		}
		if(joueur1.aGagne() && joueur2.aGagne()){
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("EGALITE LES DEUX JOUEURS ONT GAGNES");
			System.out.println("--------------------------------------------------");
		}else if(joueur1.aGagne() && !joueur2.aGagne()){
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("FELECITATION A " + joueur1.nom + " QUI A GAGNE");
			System.out.println("--------------------------------------------------");
		}else if(joueur2.aGagne() && !joueur1.aGagne()){
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("FELECITATION A " + joueur2.nom + " QUI A GAGNE");
			System.out.println("--------------------------------------------------");
		}
		System.out.println("--------------------------------------------------");
		System.out.println("               NOUVELLE PARTIE ?");
		System.out.println("--------------------------------------------------");
		sc.close();
		this.lancement();
		
	}
	/**
	 * lance une partie solo de zen l'initié
	 * @param frame la fenetre de jeu
	 */
	public void partieSoloC(Jeu frame) {
		Scanner sc = new Scanner(System.in);
		String nom1;
		String nom2;
		//en cas de reprise de partie
		System.out.println("Voulez vous reprendre la dernière partie o/n");
		String rep = sc.nextLine();
		boolean charge = false;
		if(rep.equalsIgnoreCase("o") || rep.equalsIgnoreCase("oui")){
			charge = true;
			ArrayList<String> fichier = LectureEcritureConfig.readFile("data/save.txt");
			nom1 = fichier.get(0);
			nom2 = fichier.get(1);
		}else{
			System.out.println("Entrez les nom des joueurs");
			System.out.print("Joueur 1 : ");
			nom1 = sc.nextLine();
			nom2 = "IA";
		}
		Plateau plat = new Plateau(charge);
		System.out.println("Initialisation des pions . . .");
		ArrayList<Pion> pionNoir = plat.iniPionNoir();
		ArrayList<Pion> pionBlanc = plat.iniPionBlanc();
		Pion pionZen = plat.iniPionRouge();
		System.out.println("Initialisation des joueurs . . .");
		Joueur joueur1 = new Joueur(nom1,pionBlanc,plat,"noir",frame);
		Joueur joueur2 = new IA(nom2,pionNoir,plat,"blanc",joueur1);
		joueur1.setAdversaire(joueur2);
		if(pionZen != null){
			joueur1.sesPions.add(pionZen);
			joueur2.sesPions.add(pionZen);
		}
		System.out.println(nom1 + " poss�de les pions blanc (1)");
		System.out.println(nom2 + " poss�de les pions noir (2)");

		while(!joueur1.aGagne() || joueur2.aGagne()){
			LectureEcritureConfig.writeFile(joueur1.nom, joueur2.nom, plat.matricePlateau);
			joueur1.joueTour();
			LectureEcritureConfig.writeFile(joueur1.nom, joueur2.nom, plat.matricePlateau);
			joueur2.joueTour();
		}
		if(joueur1.aGagne() && joueur2.aGagne()){
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("EGALITE LES DEUX JOUEURS ONT GAGNES");
			System.out.println("--------------------------------------------------");
		}else if(joueur1.aGagne() && !joueur2.aGagne()){
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("FELECITATION A " + joueur1.nom + " QUI A GAGNE");
			System.out.println("--------------------------------------------------");
		}else if(joueur2.aGagne() && !joueur1.aGagne()){
			System.out.println();
			System.out.println("--------------------------------------------------");
			System.out.println("FELECITATION A " + joueur2.nom + " QUI A GAGNE");
			System.out.println("--------------------------------------------------");
		}
		System.out.println("--------------------------------------------------");
		System.out.println("               NOUVELLE PARTIE ?");
		System.out.println("--------------------------------------------------");
		sc.close();
		this.lancement();
	}
	/**
	 * lance une partie solo graphique
	 * @param frame la fenetre du jeu
	 */
	public static void partieSoloG(Jeu frame){
		Plateau plat = new Plateau(frame.charge);
		ArrayList<Pion> pionNoir = plat.iniPionNoir();
		ArrayList<Pion> pionBlanc = plat.iniPionBlanc();
		Pion pionRouge = plat.iniPionRouge();
		pionNoir.add(pionRouge);
		pionBlanc.add(pionRouge);
		frame.panelPlateau.plat = plat.matricePlateau;
		frame.panelPlateau.pModele.matrice = plat.matricePlateau;
		Joueur joueur1 = new Joueur(frame.panelUnJoueur.selectionNomJoueur.getText(),pionBlanc,plat,"blanc",frame);
		IA joueurAuto = new IA("IA",pionNoir,plat,"noir",joueur1);
		joueurAuto.frame = joueur1.frame;
		joueur1.setAdversaire(joueurAuto);
		Partie.j1 = joueur1;
		Partie.j2 = joueurAuto;
		Partie.courrant = joueur1;
	}
	/**
	 * lance une partie multijoueurs graphique
	 * @param frame la fenetre de jeu
	 */
	public static void partieMultiG(Jeu frame){
		Plateau plat = new Plateau(frame.charge);
		ArrayList<Pion> pionNoir = plat.iniPionNoir();
		ArrayList<Pion> pionBlanc = plat.iniPionBlanc();
		Pion pionRouge = plat.iniPionRouge();
		pionNoir.add(pionRouge);
		pionBlanc.add(pionRouge);
		frame.panelPlateau.plat = plat.matricePlateau;
		frame.panelPlateau.pModele.matrice = plat.matricePlateau;
		Joueur joueur1 = new Joueur(frame.panelMultijoueur.selectionNomJoueur1.getText(),pionBlanc,plat,"blanc",frame);
		Joueur joueur2 = new Joueur(frame.panelMultijoueur.selectionNomJoueur2.getText(),pionNoir,plat,"noir",joueur1);
		joueur2.frame = joueur1.frame;
		joueur1.setAdversaire(joueur2);
		Partie.j1 = joueur1;
		Partie.j2 = joueur2;
		Partie.courrant = joueur1;
	}
	
	
	
}
