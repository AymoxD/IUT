import java.util.Scanner;

import javax.swing.JOptionPane;

import graphique.Jeu;
import jeu.Partie;

public class Lanceur {
	
	
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int choix = Integer.parseInt(JOptionPane.showInputDialog("BIENVENUE DANS LE JEU ZEN l'INITIE BY AYMERICK LEBORGNE \n" + "Veuillez choisir le style de jeu : \n \t 1 : mode graphique \n \t 2 : mode console" ));
		if(choix == 1 ){
			Jeu.fenetre();
		}else if (choix == 2){
			Partie p = new Partie();
			p.lancement();
		}
		sc.close();
	}
}
