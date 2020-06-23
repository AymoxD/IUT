package utilitaire;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class LectureEcritureConfig {
	/**
	 * cette méthode lit un fichier ligne par ligne
	 * @param fileName le nom du fichier
	 * @return une ArrayList chaque élément est une ligne du fichier
	 */
	public static ArrayList<String> readFile(String fileName){
		ArrayList<String> liste = new ArrayList<String>();
		try{
			Scanner in = new Scanner(new FileReader(fileName));
			while(in.hasNextLine()){
				liste.add(in.nextLine());
			}
			in.close();
		}catch (FileNotFoundException e) {
			System.out.println("readfile : fichier non trouvé " + fileName); 
		}
		return liste;

	}
	
	/**
	 * cette méthode écrit dans un fichier la config du jeu
	 * @param nom1 le nom du joueur 1
	 * @param nom2 le nom du joueur 2
	 * @param matrice la matrice du plateau de jeu 
	 */
	public static void writeFile (String nom1,String nom2,int[][] matrice){
		try{
			PrintWriter out = new PrintWriter("data/save.txt");
			out.println(nom1);
			out.print(nom2);
			for(int i = 0; i < matrice.length;i++){
				out.print("\n");
				for(int j=0; j < matrice.length; j++){
					out.print(matrice[i][j] + "\t");
				}
			}
			out.close();
		}catch(FileNotFoundException e) {
			System.out.println(e.getMessage());
		}
		
		
	}
}
