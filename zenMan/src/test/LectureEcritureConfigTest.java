package test;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Test;

import utilitaire.LectureEcritureConfig;

public class LectureEcritureConfigTest {
	int[][] matrice = new int[11][11];
	
	@Test
	public void readWriteFileTest(){
		LectureEcritureConfig.writeFile("j1", "j2", matrice);
		ArrayList<String> recup = LectureEcritureConfig.readFile("data/save.txt");
		assertEquals(recup.get(0),"j1");
		assertEquals(recup.get(1),"j2");
		int i = 2;
		String test = "";
		while(i < matrice.length){
			
			test = "";
			for(int num: matrice[i] ){
				test += num + "\t";
			}
			assertEquals(test,recup.get(i));
			i++;
		}
		
	}

}
