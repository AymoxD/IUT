
/**
 * class with create a new human player
 * @author Leborgne Aymerick
 * @version 1.0
 */
package battle;
 import java.util.ArrayList;
 import java.util.Random;
public class AutoPlayer extends Player{

	
	/**
	 * constructor of Auto Player
	 * @param fleet the fleet of the player
	 * @param name  is a name of the Player
	 * @param width the width
	 * @param height the height 
	 */
	public AutoPlayer(ArrayList<Ship> fleet, String name, int width, int height){
		super(fleet,  name,  width, height);
		shipPlacement();
	}
	
	/**
	 * @return  the tab of new shot
	 */
	public int[] newShot(){
		Random rand = new Random();
		int randomX = rand.nextInt(this.width);
		int randomY = rand.nextInt(this.height);;
		int[] ret = {randomX,randomY};
		return ret;
	}
	
	/**
	 * this method allow th AI you to place your ship
	 */
	public void shipPlacement(){
		boolean placement = false;
		Random rand = new Random();
		// tant que les bateaux sont mal placés
		while(!placement){
			//nettoyage de mygrid
			for (int i = 0;i < this.height;i++){
					for(int j = 0; j< this.width;j++){
						myGrid[i][j].setFree();
					}
				}
			//placement des bateaux aléatoire
			// les +1 -1 dans les random permettent d'éviter de faire apparaitre les bateaux sur le côté d'une grille
			// ce qui limite les vérifications à faire
			for(Ship s : fleet){
				int sens = rand.nextInt(2);
				if(sens == 0){
					s.setHorizontal();
					s.setXOrigin(rand.nextInt(this.width - s.getSize()-1)+1);
					s.setYOrigin(rand.nextInt(this.height-1)+1);
				}else{
					s.setVertical();
					s.setXOrigin(rand.nextInt(this.width-1)+1);
					s.setYOrigin(rand.nextInt(this.height - s.getSize()-1)+1);
				}
			}
			placement = true;
			//vérification du placement des bateaux si ils sont pas bon on refait un tour de boucle
			for(Ship s : fleet){
				for (int i = 0;i < this.width;i++){
					for(int j = 0; j< this.height;j++){
						if(s.contains(i,j)){
							if(myGrid[j][i].isFree() && j+1 < this.height && i+1 < this.width && i > 1 && j > 1){
			
								if(myGrid[j-1][i].isFree() && myGrid[j+1][i].isFree() && myGrid[j][i-1].isFree() && myGrid[j][i+1].isFree() && myGrid[j+1][i+1].isFree() && myGrid[j-1][i-1].isFree() && myGrid[j-1][i+1].isFree() && myGrid[j+1][i-1].isFree()){
									myGrid[j][i].setBusy();
								}else if(s.getDirection() == Direction.HORIZONTAL && !myGrid[j][i-1].isFree()){
									if(myGrid[j-1][i].isFree() && myGrid[j+1][i].isFree() && myGrid[j][i+1].isFree() && myGrid[j+1][i+1].isFree() && myGrid[j-1][i-1].isFree() && myGrid[j-1][i+1].isFree() && myGrid[j+1][i-1].isFree()){
										myGrid[j][i].setBusy();
									}else{
										placement = false;
									}
								}else if(s.getDirection() == Direction.VERTICAL && !myGrid[j-1][i].isFree()){
									if(myGrid[j+1][i].isFree() && myGrid[j][i-1].isFree() && myGrid[j][i+1].isFree() && myGrid[j+1][i+1].isFree() && myGrid[j-1][i-1].isFree() && myGrid[j-1][i+1].isFree() && myGrid[j+1][i-1].isFree()){
										myGrid[j][i].setBusy();
									}else{
										placement = false;
									}
								}else{
									placement = false;
					
								}
							}else{
								placement = false;
					
							}
						}
					}
				}
			}
		}
	}
}
