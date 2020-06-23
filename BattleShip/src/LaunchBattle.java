/**
 * @author Leborgne Aymerick
 * @version 1.0
 * this class is the launcher of the battle
 */
import battle.BattleShip;
public class LaunchBattle{
	
	public static void main(String[] args){
		
		if(args.length > 0){
			System.out.println(args[0]);
			if(args[0].equals("1")){
				BattleShip a = new BattleShip("data/config1.txt","Joueur A", "Joueur B");
			}else if(args[0].equals("2")){
				BattleShip b = new BattleShip("data/config3.txt","Joueur A", "Joueur B");
			}
		}else{
			BattleShip c = new BattleShip("data/config2.txt","Joueur A", "Joueur B");
		}
	}
}
