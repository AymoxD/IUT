/**
 * class with create a new human player
 * @author Leborgne Aymerick
 * @version 1.0
 */
package battle;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
public class HumanPlayer extends Player{
	
	//private JFrame frame;
	private final String DELIMITER = "\\s*:\\s*";
	
	
	/**
	 * constructor of Human Player
	 * @param fleet the fleet of the player
	 * @param name  is a name of the Player
	 * @param width the width
	 * @param height the height 
	 */
	public HumanPlayer(ArrayList<Ship> fleet, String name, int width, int height){
		super(fleet, name,  width, height);
		shipPlacement();
	}
	
	/**
	 * ask the player by a dialog box the coord of the shot he want to do
	 * @return  the tab of new shot
	 */
	public int[] newShot(){
		int[] ret = new int[2];
		int x;
		int y;
		do{
			x = Integer.parseInt(JOptionPane.showInputDialog("coordonné en abscisse du shot"));
		}while(x < 0 || x >= this.width);
		
		do{
			y = Integer.parseInt(JOptionPane.showInputDialog("coordonné en ordonnée du shot"));
		}while(y < 0 || y >= this.height);
		ret[0] = x;
		ret[1] = y;
		return ret;
	}
	
	/**
	 * this method allow you to place your ship an tell you if there are a problem
	 */
	public void shipPlacement(){
		this.readConfiguration();
		
		for (int i = 0;i < this.width;i++){
			for(int j = 0; j< this.height;j++){
				for(Ship s : fleet){
					if(s.contains(i,j)){
						if(myGrid[j][i].isFree()){
							this.myGrid[j][i].setBusy();
						}else{
							System.out.println("Problème de placement de bateau : il faut interrompre la partie");
						}
					}
				}
			}
		}
		System.out.println("bateau placé");
		
		
	}
	
	/**
	 * this method allow you to read your configuration for your ship by a text file
	 */
	private void readConfiguration(){
		String path = JOptionPane.showInputDialog("Le chemin du fichier qui place les bateaux");
		ArrayList<String> liste = new ArrayList<String>();
		try{
			Scanner in = new Scanner(new FileReader(path));
			while(in.hasNextLine()){
				liste.add(in.nextLine());
			}
			in.close();
		}catch (FileNotFoundException e) {
			System.out.println("readfile : fichier non trouvé " + path); 
		}
		int i = 0;
		for(Ship s : fleet){
			String[] paramBoat = liste.get(i).split(DELIMITER);
			if(s.getName().equalsIgnoreCase(paramBoat[0]) && !(Integer.parseInt(paramBoat[1]) >= this.width) && !(Integer.parseInt(paramBoat[2])>= this.height)){
				s.setXOrigin(Integer.parseInt(paramBoat[1]));
				s.setYOrigin(Integer.parseInt(paramBoat[2]));
				if(paramBoat[3].equalsIgnoreCase("HORIZONTAL")){
					s.setHorizontal();
				}else{
					s.setVertical();
				}
			}else{
				System.out.println("erreur replacer les bateaux");
			}
			i++;
		}
		System.out.println(this.fleet);
	}
	
	
}
