package utilitaire;

public class tableau2DUtil {
	/**
	 * permet d'afficher un tableau à 2 dimension dans la console
	 * @param tableau2D le tableau à afficher
	 */
	public static void afficherTableau2D(int[][] tableau2D){
		for(int i = 0; i < 11; i++){
			System.out.println("\n");
			for(int j = 0; j < 11; j++){
				System.out.print(tableau2D[i][j] + "\t");
			}
		}
		System.out.println("\n");
		}
	/**
	 * permet de copier un tableau à 2 dimansion
	 * @param source le tableau à copier
	 * @return le tableau copier
	 */
	public static int[][] copierTableauCarre2D(int[][] source){
		int[][] retTab = new int[source.length][source.length];
		for (int i = 0; i < 11; i++){
		  retTab[i] = source[i].clone();
		}
		return retTab;
	}
}
