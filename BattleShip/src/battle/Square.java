/**
 * @author Leborgne Aymerick
 * @version 1.0
 * Square class 
 */
 package battle;
public class Square{
	private int x;
	private int y;
	private boolean free;
	private boolean hit;
	
	/**
	 * constructor of the class Square
	 * @param x an int
	 * @param y an int
	 */
	public Square(int x, int y){
		if(x >= 0 && x <= 15 && y >= 0 && y <= 15){
			this.x = x;
			this.y = y;
		}
		this.free = true;
		this.hit = false;
	}
	
	/**
	 * set Busy the square
	 */
	public void setBusy(){
		this.free = false;
	}
	
	/**
	 * set Hit the square
	 */
	public void setHit(){
		this.hit =true;
	}
	
	/**
	 * getter of x
	 * @return x attribute
	 */
	public int getX(){return this.x;}
	
	/**
	 * getter of y
	 * @return y attribute
	 */
	public int getY(){return this.y;}
	
	/**
	 * getter of free
	 * @return free attribute
	 */
	public boolean isFree(){
		return this.free;
	}
	
	/**
	 * getter of hit
	 * @return Hit attribute
	 */
	public boolean isHit(){
		return this.hit;
	}
	/**
	 * setter of the attribute free
	 * set free a Square
	 */
	public void setFree(){
		this.free = true;
	}
	
	/**
	 * toString of Square
	 * @return the string chain to print
	 */
	public String toString(){
		return "x:" + this.x + "y:" + this.y + "\t" + "hit:" + this.hit + "free:" + this.free;
	}
}
