/**
 * @author Leborgne Aymerick
 * @version 1.0
 * cette méthode permet de créer le panel d'une création de partie multijoueur
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
public class MultijoueurGraphique extends JPanel{
	JPanel panelCentre;
	JPanel panelBas;
	JPanel panelHaut;
	JLabel titrePage;
	JLabel nomJoueur1;
	public JTextField selectionNomJoueur1;
	JLabel nomJoueur2;
	public JTextField selectionNomJoueur2;
	public JButton nouveauBouton;
	public JButton goBouton;
	public JButton chargerBouton;
	public JButton retour;
	
	/**
	 * constructeur du panel de création d'une partie multijoueur
	 */
	public MultijoueurGraphique(){
		this.panelCentre = new JPanel();
		this.panelBas = new JPanel();
		this.panelHaut = new JPanel();
		this.nomJoueur1 = new JLabel("Nom du Joueur 1 : ");
		this.selectionNomJoueur1 = new JTextField();
		this.nomJoueur2 = new JLabel("Nom du Joueur 2 : ");
		this.selectionNomJoueur2 = new JTextField();
		
		//panel du haut
		titrePage = new JLabel("MODE MULTIJOUEUR",SwingConstants.CENTER);
		titrePage.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
		retour = new JButton("Accueil");
		this.panelHaut.setLayout(new BorderLayout());
		this.panelHaut.add(titrePage,BorderLayout.CENTER);
		this.panelHaut.add(retour,BorderLayout.EAST);
		
		
		//panel du centre
		this.panelCentre.setLayout(new GridLayout(4,2,10,10));
		panelCentre.add(new JLabel());
		panelCentre.add(new JLabel());
		panelCentre.add(nomJoueur1);
		panelCentre.add(selectionNomJoueur1);
		panelCentre.add(nomJoueur2);
		panelCentre.add(selectionNomJoueur2);
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
