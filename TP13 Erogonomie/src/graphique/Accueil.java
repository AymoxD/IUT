package graphique;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
/**
 * classe qui crée l'écran d'accueil
 * @author aymerick leborgne
 *
 */
public class Accueil extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//declaration des attribut
	public JButton technique;
	public JButton physique;
	public JButton option;
	public JLabel labelAccueil;
	public JLabel labelExpli;
	public JPanel accueil;
	/**
	 * constructeur qui initialise les composants
	 */
	public Accueil(){
		
	this.iniComponent();	
	}
	/**
	 * méthode qui initialise les composants graphiques de l'accueil
	 */
	private void iniComponent() {
		this.accueil = new JPanel();
		this.accueil.setBackground(new Color(62, 172, 172));
		//intialistaion des bouttons
		Border noBorder = new LineBorder(new Color(62, 172, 172), 0);
		this.technique = new JButton();
		try {
	        Image img = ImageIO.read(getClass().getResource("paddle.png"));
	        technique.setIcon(new ImageIcon(img));
	        technique.setBackground(new Color(62, 172, 172));
	        technique.setBorder(noBorder);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		this.physique = new JButton();
		try {
	        Image img = ImageIO.read(getClass().getResource("kong.png"));
	        physique.setIcon(new ImageIcon(img));
	        physique.setBackground(new Color(62, 172, 172));
	        physique.setBorder(noBorder);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		this.option = new JButton();
		try {
	        Image img = ImageIO.read(getClass().getResource("settings.png"));
	        option.setIcon(new ImageIcon(img));
	        option.setBackground(new Color(62, 172, 172));
	        option.setBorder(noBorder);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		
		this.labelAccueil = new JLabel("Entrainement au kayak polo");
		labelAccueil.setForeground(Color.white);
		labelAccueil.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,20));
		this.labelExpli = new JLabel("Veuillez choisir un type d'entrainement :");
		
		this.accueil.setLayout(new java.awt.GridLayout(4,5,10,10));
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(labelAccueil);
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel("Veuillez choisir un type d'entrainement :"));
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(this.technique);
		this.accueil.add(new JLabel());
		this.accueil.add(this.physique);
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(new JLabel());
		this.accueil.add(this.option);
		this.add(accueil);
		
	}
	
	
}
