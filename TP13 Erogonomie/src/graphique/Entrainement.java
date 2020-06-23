package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
/**
 * cette classe permet de factoriser du code pour afficher la liste de type d'exo possible
 * @author aymerick leborgne
 *
 */
public class Entrainement extends JPanel {

	private static final long serialVersionUID = 1L;
	//declaration des attributs
	public JPanel panelExo;
	public JPanel panelGauche;
	public JPanel panelHaut;
	public JPanel panelCentre;
	public JLabel Jtitre;
	public JButton retour;
	public JButton exoAlea;
	public JButton proposSeance;
	public JButton option;
	
	/**
	 * constructeur du style de la fenetre des listes d'exo proposé par types
	 * @param titre le titre 
	 */
	public Entrainement(String titre){
		//initialisation des éléments
		this.panelExo = new JPanel();
		this.panelGauche = new JPanel();
		this.Jtitre = new JLabel(titre);
		this.panelHaut = new JPanel();
		this.retour = new JButton();
		this.panelCentre = new JPanel();
		this.option = new JButton();
		this.proposSeance = new JButton("Proposition de seance aléatoire");
		this.exoAlea = new JButton("Proposition d'exercice aléatoire");
		//initialisation de la forme de la page
		this.setLayout(new BorderLayout());
		this.add(panelGauche,BorderLayout.WEST);
		this.add(panelExo,BorderLayout.CENTER);
		this.add(panelHaut, BorderLayout.NORTH);
		//initialisation du panel de haut
		panelHaut.setLayout(new BorderLayout());
		panelHaut.add(Jtitre,BorderLayout.CENTER);
		panelHaut.setBackground(new Color(62, 172, 172));
		panelHaut.add(retour, BorderLayout.EAST);
		try {
	        Image img = ImageIO.read(getClass().getResource("ret.png"));
	        retour.setIcon(new ImageIcon(img));
	        retour.setBackground(new Color(62, 172, 172));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		// initialisation du panel de gauche
		this.panelGauche.setLayout(new GridLayout(3,1));
		panelGauche.add(exoAlea);
		exoAlea.setBackground(new Color(62,172,172));
		panelGauche.add(proposSeance);
		proposSeance.setBackground(new Color(62,172,172));
		panelGauche.add(option);
		try {
	        Image img = ImageIO.read(getClass().getResource("settings.png"));
	        option.setIcon(new ImageIcon(img));
	        option.setBackground(new Color(62, 172, 172));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		//on met le panel centre
		this.add(panelCentre);
		
	}
}
