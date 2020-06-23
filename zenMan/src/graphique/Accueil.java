/**
 * @author Leborgne Aymerick
 * cette classe permet de créer l'aspect graphique du panel d'accueil
 */
package graphique;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Accueil extends JPanel {

	JLabel messageTitre;
	public JButton unJoueur;
	public JButton multiJoueur;
	public JButton parametre;
	/**
	 * Le constructeur du panel d'accueil
	 */
	public Accueil(){
		this.messageTitre = new JLabel("Bienvenue dans Zen l'initié");
		this.unJoueur = new JButton("Mode un joueur");
		this.multiJoueur = new JButton("Mode multijoueur");
		this.parametre = new JButton("Paramètres");
		this.setLayout(new GridLayout(4,1,10,10));
		this.add(messageTitre);
		this.add(unJoueur);
		this.add(multiJoueur);
		this.add(parametre);
	}
}
