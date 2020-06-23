/**
 * @author Leborgne Aymerick
 * @version 1.0
 * cette classe permet de construire le panel qui informe de la victoire d'un joueur
 * 
 */
package graphique;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class VictoireGraphique extends JPanel {
	
	public JLabel statuVictoire;
	public JButton accueil;
	public JButton quitter;
	public JPanel panelCentre;
	
	/**
	 * constructeur du panel qui informe de la victoire d'un joueur
	 */
	public VictoireGraphique(){
		//initialisation des attributs
		this.panelCentre = new JPanel();
		this.statuVictoire = new JLabel();
		this.statuVictoire.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
		this.accueil = new JButton("Accueil");
		this.quitter = new JButton("Quitter");
		//partie supérieur
		this.setLayout(new BorderLayout());
		this.add(statuVictoire,BorderLayout.NORTH);
		//partie centre
		this.panelCentre.setLayout(new GridLayout(3,2,10,10));
		this.panelCentre.add(new JLabel());
		this.panelCentre.add(new JLabel());
		this.panelCentre.add(accueil);
		this.panelCentre.add(quitter);
		this.panelCentre.add(new JLabel());
		this.panelCentre.add(new JLabel());
		
		this.add(panelCentre,BorderLayout.CENTER);
		
		
		
	}
	
}
