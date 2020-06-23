/**
 * @author Leborgne Aymerick
 * @version 1.0
 * this is the abstract class of Player
 */
 package battle;
 import view.GridTableFrame;
 import java.util.ArrayList;
public abstract class Player{
	protected String name;
	protected int width;
	protected int height;
	protected ArrayList<Ship> fleet;
	protected Square[][] myGrid;
	protected Square[][] opponentGrid;
	
	/**
	 * constructor of Player
	 * @param fleet the fleet of the player
	 * @param name  is a name of the Player
	 * @param width the width
	 * @param height the height 
	 */
	public Player(ArrayList<Ship> fleet, String name, int width, int height){
		if(fleet != null){
			this.createCopy(fleet);
		}
		this.name = name;
		this.width = width;
		this.height = height;
		
		this.initializeMyGrid();
		this.initializeOpponentGrid();
		
	}
	
	/**
	 * abstract method which ask to the player to shot
	 * @return the coord of a shot
	 */
	public abstract int[] newShot();
	/**
	 * abstract method which allow the player to pace their ship
	 */
	public abstract void shipPlacement();
	
	
	/**
	 * create a copy of the fleet in parameters
	 * and put it in the attribute fleet
	 * @param fleet the fleet to copy
	 */
	protected void createCopy(ArrayList<Ship> fleet){
		ArrayList<Ship> fleetBis = new ArrayList<Ship>();
		for(Ship s : fleet){
			fleetBis.add(new Ship(s.getName(),s.getSize()));
		}
		this.fleet = fleetBis;
	}
	
	/**
	 * initialize My grid
	 */
	protected void initializeMyGrid(){
		this.myGrid = new Square[this.height][this.width];
		
		for(int i = 0; i < this.height; i++){
			for(int j = 0; j < this.width; j++){
				myGrid[i][j] = new Square(j,i);
			}
		} 
	}
	/**
	 * initialize oponnent grid
	 */
	protected void initializeOpponentGrid(){
		this.opponentGrid = new Square[this.height][this.width];
		
		for(int i = 0; i < this.height; i++){
			for(int j = 0; j < this.width; j++){
				opponentGrid[i][j] = new Square(j,i);
			}
		} 
	}
	/**
	 * return true if a boat is sunk at the param
	 * @param x the coordinate on x of the boat
	 * @param y coordinate on y of the boat
	 * @return true if the boat of the coord is sunk
	 */
	public boolean isSunk(int x, int y){
		boolean ret = false;
		for(Ship s : fleet){
			if(s.contains(x,y)){
				if(s.isSunk()){
					ret = true;
				}
			}
		}
		
		return ret;
	}
	/**
	 * tell if all boats are sunk
	 * @return true if all the boat of a player is Sunk
	 */
	public boolean allSunk(){
		boolean ret = true;
		for(Ship s : fleet){
			if(ret){
				if(s.isSunk()){
					ret = true;
				}else{
					ret = false;
				}
			}
		}
		return ret;
	}
	
	/**
	 *this method display the grid of the current player
	 */
	public void displayMygrid() {
		GridTableFrame otframe = new GridTableFrame(myGrid);
		otframe.showIt("MyGrid : " + this.name);
	}
	/**
	 * this method display the grid of the opponent to the current player
	 */
	public void displayOpponentGrid() {
		GridTableFrame otframe = new GridTableFrame(opponentGrid);
		otframe.showIt("OpponentGrid + : " + this.name);
	}
	
}
