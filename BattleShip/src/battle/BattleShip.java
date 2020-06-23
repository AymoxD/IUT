/**
 * @author Leborgne Aymerick
 * @version 1.0
 * this class modelize a Battleship in the game
 */
package battle;
import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.ArrayList;
public class BattleShip{
	private Mode mode;
	private int width;
	private int height;
	private final String DELIMITER = "\\s*:\\s*";
	private Game gamePlay;
	private ArrayList<Ship> fleet;
	
	/**
	 * Constructor of the BattleShip
	 * @param fileName the path to the config
	 * @param playerName1 the name of the player 1
	 * @param playerName2 the name of the player 2
	 */
	public BattleShip(String fileName, String playerName1, String playerName2){
		this.mode = null;
		this.width = 0;
		this.height = 0;
		this.fleet = new ArrayList<Ship>();
		configure(fileName);
		printConfiguration();
		this.gamePlay = new Game(fleet, playerName1, playerName2, this.width, this.height,this.mode);
		
	}
	
	/**
	 * this method initialize from the config file the attribute of the class
	 * @param fileName the name of the file 
	 * */
	private void configure(String fileName){
		ArrayList<String> liste = new ArrayList<String>();
		ArrayList<String[]> config = new ArrayList<String[]>();
		try{
			Scanner in = new Scanner(new FileReader(fileName));
			while(in.hasNextLine()){
				liste.add(in.nextLine());
			}
			in.close();
		}catch (FileNotFoundException e) {
			System.out.println("readfile : fichier non trouvé " + fileName); 
		}
		for(String e : liste){
			config.add(e.split(DELIMITER));
		}
		if (Integer.parseInt(config.get(0)[0]) >= 3 && Integer.parseInt(config.get(0)[0]) <= 15){
			this.width =  Integer.parseInt(config.get(0)[0]);
		}
		if(Integer.parseInt(config.get(0)[1]) >=3 && Integer.parseInt(config.get(0)[1]) <= 15){
			this.height =  Integer.parseInt(config.get(0)[1]);
		}
		
		if(config.get(1)[1].equalsIgnoreCase("HH")){
			this.mode = Mode.HH;
		}else if(config.get(1)[1].equalsIgnoreCase("HA")){
			this.mode = Mode.HA;
		}else if(config.get(1)[1].equalsIgnoreCase("AA")){
			this.mode = Mode.AA;
		}else{
			System.out.println("configure : probleme de mode");
		}
		
		for(int i = 2; i < config.size();i++){
			if(Integer.parseInt(config.get(i)[1]) > 0 && Integer.parseInt(config.get(i)[1]) <= 5){
				this.fleet.add( new Ship(config.get(i)[0],Integer.parseInt(config.get(i)[1])));
			}
		}
	}
	
	/**
	 * this method print the configuration of the BattleShip class
	 */
	public void printConfiguration(){
		System.out.println("longueur : " + width);
		System.out.println("hauteur : " + height);
		System.out.println("Mode : " + mode);
		
		for(Ship s : fleet){
			System.out.println(s);
		}
	}
	/**
	 * return the width of the grid
	 * @return the width
	 */
	public int getWidth(){
		return this.width;
	}
	/**
	 * return the height of the grid
	 * @return the height
	 */
	public int getHeight(){
		return this.height;
	}
	/**
	 * return the gamePlay of the game
	 * @return the gamePlay
	 */
	public Game getGamePlay(){
		return this.gamePlay;
	}
	
}
