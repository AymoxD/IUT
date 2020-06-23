package graphique;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JScrollPane;
import element.Exercice;
/**
 * cette classe permet de créer le panel de séance proposé aléatoirement
 * @author aymerick leborgne
 *
 */
public class PropoSeance extends Entrainement{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//declaratio ndes attributs
	public JButton logos;
	public JLabel labelDureSeance;
	public JList<Exercice> listExo;
	public JScrollPane scrollPane;
	public Exercice[] listeExo;
	/**
	 * construit la page de la séance proposé
	 * @param listeExo la liste des exercices pour la séance
	 * @param duree la duree totale de la séance proposée
	 */
	public PropoSeance(Exercice[] listeExo,int duree){
		super("Proposition de séance");
		this.listeExo = listeExo;
		this.exoAlea.setVisible(false);
		this.proposSeance.setVisible(false);
		this.labelDureSeance = new JLabel("Durée de la séance :" + duree + "Min");
		this.listExo = new JList<Exercice>(listeExo);
		this.scrollPane = new JScrollPane(listExo);
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
		//panel de centre
		this.panelCentre.setVisible(true);
		this.panelCentre.setLayout(new BorderLayout());
		this.panelCentre.add(labelDureSeance,BorderLayout.NORTH);
		this.panelCentre.add(scrollPane);
		//
		this.panelGauche.setBackground(new Color(62, 172, 172));
	}
}
