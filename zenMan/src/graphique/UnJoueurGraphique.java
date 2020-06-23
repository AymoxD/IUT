/**
 * @author Leborgne Aymerick
 * @version 1.0
 * cette classe permet de créer le panel de création d'une partie un joueur
 */
package graphique;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class UnJoueurGraphique extends JPanel {
	JPanel panelCentre;
	JPanel panelBas;
	JPanel panelHaut;
	JLabel titrePage;
	JLabel nomJoueur;
	public JTextField selectionNomJoueur;
	public JButton nouveauBouton;
	public JButton goBouton;
	public JButton chargerBouton;
	public JButton retour;
	
	/**
	 * constructeur du panel graphique permettant la création d'une partie à un joueur
	 */
	public UnJoueurGraphique(){
		this.panelCentre = new JPanel();
		this.panelBas = new JPanel();
		this.panelHaut = new JPanel();
		
		//panel du haut
		titrePage = new JLabel("MODE UN JOUEUR",SwingConstants.CENTER);
		titrePage.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
		retour = new JButton("Accueil");
		this.panelHaut.setLayout(new BorderLayout());
		this.panelHaut.add(titrePage,BorderLayout.CENTER);
		this.panelHaut.add(retour,BorderLayout.EAST);
	
		nomJoueur = new JLabel("Nom du Joueur : ");
		selectionNomJoueur = new JTextField();
		
		//panel du centre
		this.panelCentre.setLayout(new GridLayout(3,2,10,10));
		panelCentre.add(new JLabel());
		panelCentre.add(new JLabel());
		panelCentre.add(nomJoueur);
		panelCentre.add(selectionNomJoueur);
		panelCentre.add(new JLabel());
		panelCentre.add(new JLabel());
		
		//panel du Bas
		this.nouveauBouton = new JButton("Nouveau");
		this.goBouton = new JButton("GO");
		this.chargerBouton = new JButton("Charger");
		panelBas.setLayout(new GridLayout(2,3,10,10));
		panelBas.add(nouveauBouton);
		panelBas.add(new JLabel());
		panelBas.add(chargerBouton);
		panelBas.add(new JLabel());
		panelBas.add(goBouton);
		panelBas.add(new JLabel());
		
		//organisation du panel principal
		this.setLayout(new BorderLayout());
		this.add(panelCentre, BorderLayout.CENTER);
		this.add(panelHaut, BorderLayout.NORTH);
		this.add(panelBas,BorderLayout.SOUTH);
		
	}
}
