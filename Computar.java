import java.util.Scanner;
import java.io.*;

public class Computar extends Player {

  static String orient;
  static String letter;
  static int num;
  
  static Ship airCraft = new Ship("aircraft carrier");
  static Ship battle = new Ship("battleship");
  static Ship cruiser = new Ship("cruiser");
  static Ship submarine = new Ship("submarine");
  static Ship destroyer = new Ship("destroyer");

  public static void setupComp(){

    
    airCraft.setShip(orient, letter, num);


    battle.setShip(orient, letter, num);

    
    cruiser.setShip(orient, letter, num);


    submarine.setShip(orient, letter, num);

    
    destroyer.setShip(orient, letter, num);
  }

}
