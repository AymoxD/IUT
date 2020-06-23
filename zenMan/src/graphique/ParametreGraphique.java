/**
 * @author Leborgne Aymerick
 * @version 1.0
 * cette classe permet de créer le panel des paramètres
 */
package graphique;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class ParametreGraphique extends JPanel{
	JPanel panelHaut;
	JPanel panelCentre;
	JLabel JTitre;
	public JButton vGraphique;
	public JButton vConsole;
	public JButton retour;
	/**
	 * constructeur du panel des paramètres
	 */
	public ParametreGraphique(){
		//initialisation des panels
		this.panelHaut = new JPanel();
		this.panelCentre = new JPanel();
		//panel haut
		this.JTitre = new JLabel("PARAMETRES",SwingConstants.CENTER);
		retour = new JButton("Accueil");
		this.panelHaut.setLayout(new BorderLayout());
		this.panelHaut.add(JTitre,BorderLayout.CENTER);
		this.panelHaut.add(retour,BorderLayout.EAST);
		//panel du centre 
		this.vGraphique = new JButton("Version Graphique");
		this.vConsole = new JButton("Version Console");
		this.panelCentre.setLayout(new GridLayout(3,2,10,10));
		this.panelCentre.add(new JLabel());
		this.panelCentre.add(new JLabel());
		this.panelCentre.add(vGraphique);
		this.panelCentre.add(vConsole);
		this.panelCentre.add(new JLabel());
		this.panelCentre.add(new JLabel());
		
		//création du panel global
		this.setLayout(new BorderLayout());
		this.add(panelHaut,BorderLayout.NORTH);
		this.add(panelCentre,BorderLayout.CENTER);
		this.setVisible(true);
		
		
	}
	
	
}
