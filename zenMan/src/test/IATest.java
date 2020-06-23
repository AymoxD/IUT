package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;
import jeu.IA;
import jeu.Pion;
import jeu.Plateau;
public class IATest {
	
	Plateau plat = new Plateau(false);
	
	@Test
	public void testSelectionnePion() {
		// on test avec 1 seul pion pour être sur que l epion sélectionné au hasard est celui-ci
		ArrayList<Pion> pionHasard = new ArrayList<Pion>();
		Pion onlyPion = new Pion(1,1,plat,"noir");
		pionHasard.add(onlyPion);
		IA iaTest = new IA("IA",pionHasard,plat,"noir",null);
		assertSame(onlyPion,iaTest.selectionnePion());
	}
}
