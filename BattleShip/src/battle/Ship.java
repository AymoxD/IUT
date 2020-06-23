/**
 * @author Leborgne Aymerick
 * @version 1.0
 * this class modelize a ship in the game
 */
package battle;
public class Ship{
	
	private String name;
	private int size;
	private int xOrigin;
	private int yOrigin;
	private int hitNumber;
	private Direction direction;
	
	/**
	 * Constructor of the class ship
	 * @param name the name of the ship
	 * @param size th size of the ship
	 */
	public Ship(String name, int size){
		this.name = name;
		this.xOrigin = 0;
		this.yOrigin = 0;
		this.hitNumber =0;
		this.direction = null;
		if(size > 0){
			this.size = size;
		}else{
			System.out.println("Ship : problème de taille");
		}
	}
	
	/**
	 * add an hit on the shi^p
	 */
	public void addHit(){
		this.hitNumber ++;
	}
	
	/**
	 * tell if the ship is sunk
	 * @return ret true if the ship is sunk 
	 */
	public boolean isSunk(){
		boolean ret = false;
		if(this.hitNumber == size){
			ret = true;
		}
		return ret;
	}
	
	/**
	 * test if the coordinate x,y are own to the boat
	 * @param x the x coordinate
	 * @param y the y coordinate
	 * @return true if the param coordinate own the boat
	 */
	 public boolean contains(int x, int y){
		 boolean ret = false;
		 
		 if(this.direction == Direction.HORIZONTAL){
			 
			 for(int i = this.xOrigin; i < this.xOrigin + size; i++){
				 if(x == i && y == this.yOrigin){
					 ret = true;
				 }
			 }
		 }else if(this.direction == Direction.VERTICAL){
			 for(int i = this.yOrigin; i < this.yOrigin + size; i++){
				 if(x == this.xOrigin && y == i){
					 ret = true;
				 }
			 }
		 }
		 
		 return ret;
	 }
	 /**
	  * getter of string atibute
	  * @return the name of the ship
	  */
	 public String getName(){return this.name;}
	 /**
	  * getter of the size attribute
	  * @return th size of the ship
	  */
	 public int getSize(){return this.size;}
	 /**
	  * setter of the xOrigin attribute
	  * @param x the origin X
	  */
	 public void setXOrigin(int x){this.xOrigin = x;}
	  /**
	  * setter of the yOrigin attribute
	  * @param y the origin Y
	  */
	 public void setYOrigin(int y){this.yOrigin = y;}
	 /**
	  * set the ship in a HORIZONTAL way
	  */
	 public void setHorizontal(){this.direction = Direction.HORIZONTAL;}
	 /**
	  * set the ship in a VERTICAL way
	  */
	 public void setVertical(){this.direction = Direction.VERTICAL;}
	 /**
	  * getter of the attribute direction 
	  * @return the direction of the ship
	  */
	 public Direction getDirection(){return this.direction;}
	/**
	 * method which allow to print a ship
	 * @return the String of a ship
	 */
	public String toString(){
		return name + " : " + size + ":" + xOrigin + ":" + yOrigin +":" +direction ;
	}
	
}
