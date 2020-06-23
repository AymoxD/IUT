package test;

import static org.junit.Assert.*;
import org.junit.Before;
import jeu.*;
import org.junit.Test;
public class PionTest {
	
	Plateau plat;
	protected Pion p;
	protected Pion pTest;
	Plateau platObstru;
	
	@Before
	   public void setUp() {
		 plat = new Plateau(false);
		 platObstru = new Plateau(false);
		 p = new Pion(2,6 ,plat ,"noir");
		 pTest = new Pion(5,5,platObstru,"blanc");
	   }
	   
	   
	@Test
	public void testGetCoordXPion() {
		assertEquals(p.getCoordXPion(), 2);
		assertEquals(p.getCoordYPion(), 6);
	}
	
	@Test
	public void testestObstrue() {
		int[][] plat = {{0,0,0,0,0,0,0,0,0,0,0},										
				 		{0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,2,2,2,0,0,0,0},
				 		{0,0,0,0,2,1,2,0,0,0,0},
				 		{0,0,0,0,2,2,2,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0},
				 		{0,0,0,0,0,0,0,0,0,0,0}};
		platObstru.matricePlateau = plat;
		assertTrue(pTest.estObstrue(1,5,5,5,7,plat));
		assertTrue(pTest.estObstrue(1,5,5,5,3,plat));
		assertTrue(pTest.estObstrue(1,5,5,7,7,plat));
		assertTrue(pTest.estObstrue(1,5,5,3,7,plat));
		assertTrue(pTest.estObstrue(1,5,5,3,3,plat));
		assertTrue(pTest.estObstrue(1,5,5,7,3,plat));
		assertTrue(pTest.estObstrue(1,5,5,7,5,plat));
		assertTrue(pTest.estObstrue(1,5,5,3,5,plat));
		
		int[][] plat2 = {{0,0,0,0,0,0,0,0,0,0,0},										
		 		{0,0,0,0,0,0,0,0,0,0,0},
		 		{0,0,0,0,0,0,0,0,0,0,0},
		 		{0,0,0,0,0,0,0,0,0,0,0},
		 		{0,0,0,0,1,1,1,0,0,0,0},
		 		{0,0,0,0,1,1,1,0,0,0,0},
		 		{0,0,0,0,1,1,1,0,0,0,0},
		 		{0,0,0,0,0,0,0,0,0,0,0},
		 		{0,0,0,0,0,0,0,0,0,0,0},
		 		{0,0,0,0,0,0,0,0,0,0,0},
		 		{0,0,0,0,0,0,0,0,0,0,0}};
		platObstru.matricePlateau = plat2;
		assertFalse(pTest.estObstrue(1,5,5,5,7,plat2));
		assertFalse(pTest.estObstrue(1,5,5,5,3,plat2));
		assertFalse(pTest.estObstrue(1,5,5,7,7,plat2));
		assertFalse(pTest.estObstrue(1,5,5,3,7,plat2));
		assertFalse(pTest.estObstrue(1,5,5,3,3,plat2));
		assertFalse(pTest.estObstrue(1,5,5,7,3,plat2));
		assertFalse(pTest.estObstrue(1,5,5,7,5,plat2));
		assertFalse(pTest.estObstrue(1,5,5,3,5,plat2));		
	}

	@Test
	public void testDeplacement() {
		Pion pDeplacement = new Pion(5,5,plat,"noir");
		assertEquals(pDeplacement.deplacementLigne(), 3);
		assertEquals(pDeplacement.deplacementColonne(), 3);
		assertEquals(pDeplacement.deplacementDiagAsc(), 3);
		assertEquals(pDeplacement.deplacementDiagDesc(), 3);
		
		Pion pDeplacement2 = new Pion(0,0,plat,"noir");
		assertEquals(pDeplacement2.deplacementLigne(), 3);
		assertEquals(pDeplacement2.deplacementColonne(), 3);
		assertEquals(pDeplacement2.deplacementDiagAsc(), 1);
		assertEquals(pDeplacement2.deplacementDiagDesc(), 3);
	}
}
