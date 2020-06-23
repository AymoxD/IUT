package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import graphique.Jeu;
import jeu.Joueur;
import jeu.Pion;
import jeu.Plateau;

public class JoueurTest {
	//creation du plateau test
	Plateau plat = new Plateau(false);
	//creation des pion tous cote � cote
	Jeu frame =null;
	@Test
	public void testAGagne(){
		//test de gagnant
		ArrayList<Pion> pionTestGagne = new ArrayList<Pion>();
		pionTestGagne.add(new Pion(0,0,plat,"noir"));
		pionTestGagne.add(new Pion(1,1,plat,"noir"));
		pionTestGagne.add(new Pion(2,0,plat,"noir"));
		pionTestGagne.add(new Pion(3,0,plat,"noir"));
		pionTestGagne.add(new Pion(4,0,plat,"noir"));
		pionTestGagne.add(new Pion(5,0,plat,"noir"));
		pionTestGagne.add(new Pion(6,1,plat,"noir"));
		pionTestGagne.add(new Pion(6,2,plat,"noir"));
		Joueur joueur1 = new Joueur("gagnantTest",pionTestGagne,plat, "noir",frame);
		assertTrue(joueur1.aGagne());
		//test de perdant
		ArrayList<Pion> pionTestPerte = new ArrayList<Pion>();
		pionTestPerte.add(new Pion(0,0,plat,"noir"));
		pionTestPerte.add(new Pion(1,1,plat,"noir"));
		pionTestPerte.add(new Pion(4,0,plat,"noir"));
		pionTestPerte.add(new Pion(6,2,plat,"noir"));
		Joueur joueur2 = new Joueur("perdantTest",pionTestPerte,plat, "noir",frame);
		assertFalse(joueur2.aGagne());
	}
	
	@Test
	public void testPositionCote(){
		//test de pion en cordonnée correcte
		ArrayList<Pion> pions = new ArrayList<Pion>();
		Pion pionTest = new Pion(1,1,plat,"noir");
		
		Joueur jTest = new Joueur("Test",pions,plat, "noir",frame);
		int[][] tab = {{1,1,2,0,2,2,0,0,1},{2,0,1,1,0,2,2,0,1}};
		for(int i = 0; i < tab.length; i++ ){
			for(int j = 0; j < tab.length; j ++){
				assertEquals(jTest.positionCote(pionTest)[i][j],tab[i][j]);
			}
		}
		//test de pion en coordonné limite
		Pion pionTestLim = new Pion(0,0,plat,"noir");
		int[][] tabLim = {{0,0,1,-1,1,1,-1,-1},{1,-1,0,0,-1,1,1,-1}};
		for(int i = 0; i < tab.length; i++ ){
			for(int j = 0; j < tab.length; j ++){
				assertEquals(jTest.positionCote(pionTestLim)[i][j],tabLim[i][j]);
			}
		}
	}
}
