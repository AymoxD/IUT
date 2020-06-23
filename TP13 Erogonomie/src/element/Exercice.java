package element;
/**
 * cette classe permet de créer un exercice
 * @author aymerick Leborgne
 *
 */
public class Exercice {
	//declaration des attributs
	public String nom;
	public String explication;
	public Type type;
	public int temps;
	/**
	 * constructeur de l'exercice
	 * @param nom le nom de l'exercice
	 * @param explication l'explication de l'exercice
	 * @param type le type de l'exercice
	 * @param temps la durée de l'exercice
	 */
	public Exercice(String nom, String explication, Type type,int temps){
		this.nom = nom;
		this.explication = explication;
		this.type = type;
		this.temps = temps;
	}
	/**
	 * @return la chaine de caractère pour afficher un exercice
	 */
	public String toString(){
		return this.nom + "                       duree: "+ this.temps + "min";
	}
}
