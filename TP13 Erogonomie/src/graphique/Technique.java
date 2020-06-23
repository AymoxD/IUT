package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import element.Exercice;
import element.Type;
/**
 * cette classe permet de créer le panel de la liste d'exercice de type technique
 * @author aymerick Leborgne
 */
public class Technique extends Entrainement {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//declaration des attributs
	public JButton logos;
	public JTextField barreDeRecherche;
	public JScrollPane scrollPane;
	public JList<Exercice> listExo;
	public Exercice[] listeExo;
	
	/**
	 * construit le panel de la liste d'exo de type technqiue
	 * @param titre le titre de la page
	 */
	public Technique(String titre) {
		super(titre);
		iniListExo();
		//initialisation des attributs
		this.barreDeRecherche = new JTextField("search ...");
		this.listExo = new JList<Exercice>(listeExo);
		this.scrollPane = new JScrollPane(listExo);
		//modif panneau de haut
		this.logos = new JButton();
		try {
	        Image img = ImageIO.read(getClass().getResource("paddle.png"));
	        logos.setIcon(new ImageIcon(img));
	        logos.setBackground(new Color(62, 172, 172));
	        logos.setEnabled(false);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		this.panelHaut.add(logos,BorderLayout.WEST);
		this.Jtitre.setHorizontalAlignment(JLabel.CENTER);
		this.Jtitre.setVerticalAlignment(JLabel.CENTER);
		this.Jtitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,40));
		//création du panel du milieu
		this.panelCentre.setVisible(true);
		this.panelCentre.setLayout(new BorderLayout());
		this.panelCentre.add(barreDeRecherche,BorderLayout.NORTH);
		this.panelCentre.add(scrollPane);
	}
	/**
	 * permet d'initialiser la liste d'exercice
	 */
	private void iniListExo() {
		this.listeExo = new Exercice[3];
		this.listeExo[0] = new Exercice("décalé","des décalés pour un entrainement en équipe",Type.TECHNIQUE,30);
		this.listeExo[1] = new Exercice("indiv","l'indiv pour se renforcer techniquement et individuellement",Type.TECHNIQUE,20);
		this.listeExo[2] = new Exercice("chicken wings","des chicken wings qui sont interdites dans le reglement maintenant",Type.TECHNIQUE,5);
		
	}
}
