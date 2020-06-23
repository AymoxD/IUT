package graphique;

import java.awt.BorderLayout;
import element.Exercice;
import element.Type;

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

public class Physique extends Entrainement {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//declaration des attributs
	public JButton logos;
	public JTextField barreDeRecherche;
	public JList<Exercice> listExo;
	public JScrollPane scrollPane;
	public Exercice[] listeExo;
	
	/**
	 * permet de réaliser l'affichage de la liste d'exercice de type physique
	 * @param titre le titre de la page
	 */
	public Physique(String titre) {
		super(titre);
		iniListExo();
		//initialisation des attributs
		this.barreDeRecherche = new JTextField("search ...");
		this.listExo = new JList<Exercice>(listeExo);
		this.scrollPane = new JScrollPane(listExo);
		//modif panneau de haut
		this.logos = new JButton();
		try {
	        Image img = ImageIO.read(getClass().getResource("kong.png"));
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
	 * initialise la liste des exercices physique possible
	 */
	private void iniListExo() {
		this.listeExo = new Exercice[3];
		this.listeExo[0] = new Exercice("abdominaux","des abdos pour se muscler les abdominaux",Type.PHYSIQUE,10);
		this.listeExo[1] = new Exercice("pompes","des pompes pour muscler les pectauraux",Type.PHYSIQUE,10);
		this.listeExo[2] = new Exercice("traction","des tractions pour muscler les bras",Type.PHYSIQUE,10);
	}

}
