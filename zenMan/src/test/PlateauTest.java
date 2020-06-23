package test;

import static org.junit.Assert.*;
import org.junit.Test;
import jeu.Plateau;

public class PlateauTest {
	
	Plateau plat1 = new Plateau(false);
	
	@Test
	public void testCompteLigne() {
		assertEquals(plat1.compteLigne(0), 3);
		assertEquals(plat1.compteLigne(5), 3);
		assertEquals(plat1.compteLigne(3), 2);
	}
	
	@Test
	public void testCompteColonne() {
		assertEquals(plat1.compteColonne(0), 3);
		assertEquals(plat1.compteColonne(5), 3);
		assertEquals(plat1.compteColonne(3), 2);
	}
	
	@Test
	public void testCompteDiagAsc() {
		assertEquals(plat1.compteDiagAsc(0,5), 6);
		assertEquals(plat1.compteDiagAsc(0,0), 1);
		assertEquals(plat1.compteDiagAsc(5,5), 3);
	}
	
	@Test
	public void testCompteDesc() {
		assertEquals(plat1.compteDiagDesc(0,5), 6);
		assertEquals(plat1.compteDiagDesc(0,0), 3);
		assertEquals(plat1.compteDiagDesc(5,5), 3);
	}
}
