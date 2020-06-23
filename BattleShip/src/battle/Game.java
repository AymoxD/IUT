/**
 * @author Leborgne Aymerick
 * @version 1.0
 * allow us to create a game of the application
 */
package battle;
import java.util.ArrayList;

public class Game implements IGame{
	
	private ShotResult result;
	private Player auto;
	private Player captain;
	private Player current;
	private ArrayList<Ship> fleet;
	
	/**
	 * the constructor of Game
	 * @param fleet an arraylist of ship
	 * @param playerName1 the name of the player 1
	 * @param playerName2 the name of the player 2
	 * @param width la longueur
	 * @param height the height of the board
	 * @param m the Mode game
	 */
	public Game(ArrayList<Ship> fleet,String playerName1, String playerName2, int width, int height, Mode m){
		if(fleet != null){
			this.fleet = fleet;
		}
		if(m == Mode.AA){
			this.auto = new AutoPlayer(fleet, playerName1,width,height);
			this.captain = new AutoPlayer(fleet, playerName2,width,height);
		}else if(m == Mode.HA){
			this.captain = new HumanPlayer(fleet, playerName1,width,height);
			this.auto = new AutoPlayer(fleet, playerName2,width,height);
		}else if(m == Mode.HH){
			this.auto = new HumanPlayer(fleet, playerName1,width,height);
			this.captain = new HumanPlayer(fleet, playerName2,width,height);
		}
		this.current = this.captain;
		start();
		endOfGame();
	}
	
	/**
	 * start method to start a game
	 */
	public void start(){
		System.out.println(this.description());
		System.out.println("Player 1 : " + current.name + " start");
		
		captain.displayOpponentGrid();
		current.displayMygrid();
		while(!current.allSunk() && !captain.allSunk()){
			ShotResult coup = analyzeShot(readShot(current));
			changeCurrent();
		
		}
	}
	
	/**
	 * allow to change current player
	 */
	private void changeCurrent(){
		this.captain = this.current;
		this.current = this.auto;
		this.auto = this.captain;
	
	}
	
	/**
	 * ask to shot and return all the shot 
	 * @param player a Player
	 * @return the shot coordinate in a int table
	 */
	public int[] readShot(Player player){
		return player.newShot();
	}
	
	/**
	 * return the result of the shor
	 * @param shot the int tab of shot
	 * @return ShotResult the result of the shot
	 */
	public ShotResult analyzeShot(int[] shot){
		ShotResult ret = ShotResult.MISS;
		int x = shot[0];
		int y = shot[1];
		if(captain.myGrid[y][x].isFree()){
			current.opponentGrid[y][x].setHit();
			current.opponentGrid[y][x].setFree();
			ret = ShotResult.MISS;
		}else if(!(captain.myGrid[y][x].isFree())){
			if(!(current.opponentGrid[y][x].isHit())){
				current.opponentGrid[y][x].setHit();
				current.opponentGrid[y][x].setBusy();
				ret = ShotResult.HIT;
				for(Ship s : captain.fleet){
					if(s.contains(x,y)){
						s.addHit();
						if(s.isSunk()){
							ret = ShotResult.SUNK;
						}
					}
				}
			}
			
		}
		System.out.println(ret);
		return ret;
	}
	
	/**
	 * ask to the player if all the ship are sunk
	 * @param aPlayer a Player
	 * @return true if all ship are sunk
	 */
	public boolean allSunk(Player aPlayer){
		boolean ret = false;
		if(aPlayer.allSunk()){
			ret = true;
		}
		return ret;
	}
	/**
	 * print the description on the screen
	 */
	 @Override
	public String description(){
		return "Les règles de la bataille navale : tirez sur les bonnes case, vos bateau doivent être à plus d'une case d'écart";
	}
	
	/**
	 * how the program react in
	 * the end of the game
	 */
	public void endOfGame(){
		if(current.allSunk()){
			System.out.println(captain.name +" a gagné");
			captain.displayOpponentGrid();
			current.displayMygrid();
		}else{
			System.out.println(current.name +" a gagné");
			current.displayOpponentGrid();
		}
		
	}
	
	
}


