package graphique;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.TextField;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import element.Exercice;
import element.Type;

public class ExoAffichage extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//déclaration des attributs
	public Exercice exercice;
	public TextField explication;
	public JPanel panelGauche;
	public JPanel panelHaut;
	public JPanel panelCentre;
	public JButton logo;
	public JLabel JTitre;
	public JButton retour;
	public JButton vid;
	public JButton photo;
	public JButton option;
	public JLabel expli;
	public JScrollBar scroll;

	
	/**
	 * permet de construire la fenêtre de détail d'un exercice seléctionné
	 * @param exo l'exercice à détailler
	 */
	public ExoAffichage(Exercice exo){
		//création du panelHaut
		this.exercice = exo;
		this.panelHaut = new JPanel();
		this.JTitre = new JLabel(exo.nom);
		this.JTitre.setHorizontalAlignment(JLabel.CENTER);
		this.JTitre.setVerticalAlignment(JLabel.CENTER);
		this.JTitre.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,40));
		this.retour = new JButton();
		this.panelHaut.setLayout(new BorderLayout());
		this.panelHaut.setBackground(new Color(62,172,172));
		if(exo.type == Type.PHYSIQUE){
			this.logo = new JButton();
			try {
		        Image img = ImageIO.read(getClass().getResource("kong.png"));
		        logo.setIcon(new ImageIcon(img));
		        logo.setBackground(new Color(62, 172, 172));
		        logo.setEnabled(false);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		}else{
			this.logo = new JButton();
			try {
		        Image img = ImageIO.read(getClass().getResource("paddle.png"));
		        logo.setIcon(new ImageIcon(img));
		        logo.setBackground(new Color(62, 172, 172));
		        logo.setEnabled(false);
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		}
		try {
	        Image img = ImageIO.read(getClass().getResource("ret.png"));
	        retour.setIcon(new ImageIcon(img));
	        retour.setBackground(new Color(62, 172, 172));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		this.panelHaut.add(retour,BorderLayout.EAST);
		this.panelHaut.add(logo,BorderLayout.WEST);
		this.panelHaut.add(JTitre);
		
		
		//création du panel de gauche
		this.vid = new JButton();
		this.photo = new JButton();
		this.option = new JButton();
		this.panelGauche = new JPanel();
		this.panelGauche.setLayout(new GridLayout(3,1));
		try {
	        Image img = ImageIO.read(getClass().getResource("yt.jpg"));
	        vid.setIcon(new ImageIcon(img));
	        vid.setBackground(new Color(62, 172, 172));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		try {
	        Image img = ImageIO.read(getClass().getResource("photo.png"));
	        photo.setIcon(new ImageIcon(img));
	        photo.setBackground(new Color(62, 172, 172));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		try {
	        Image img = ImageIO.read(getClass().getResource("settings.png"));
	        option.setIcon(new ImageIcon(img));
	        option.setBackground(new Color(62, 172, 172));
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
		this.panelGauche.add(vid);
		this.panelGauche.add(photo);
		this.panelGauche.add(option);
		
		//création du panel centre
		this.expli = new JLabel("Explication de l'exercice : ");
		this.explication = new TextField(exo.explication);
		this.explication.setEditable(false);
		this.explication.setBackground(new Color(62,153,153));
		this.explication.setFocusable(false);
		this.explication.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,17));
		this.scroll = new JScrollBar(JScrollBar.VERTICAL);
		this.expli.setFont(new java.awt.Font(Font.SERIF,Font.BOLD,30));
		this.panelCentre = new JPanel();
		this.panelCentre.setBackground(new Color(62,172,172));
		this.panelCentre.setLayout(new BorderLayout());
		this.panelCentre.add(expli,BorderLayout.NORTH);
		this.panelCentre.add(explication,BorderLayout.CENTER);
		this.panelCentre.add(scroll,BorderLayout.EAST);
		
		// création du panel global
		this.setLayout(new BorderLayout());
		this.setBackground(new Color (62, 172, 172));
		this.add(panelHaut,BorderLayout.NORTH);
		this.add(panelGauche,BorderLayout.WEST);
		this.add(panelCentre,BorderLayout.CENTER);
		
		
	}
}
