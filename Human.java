import java.util.Scanner;
import java.io.*;

public class Human extends Player {
  
  // Declarations
  static Scanner in = new Scanner(System.in);
  static String orient;
  static String letter;
  static int num;
  
  static Ship airCraft = new Ship("aircraft carrier");
  static Ship battle = new Ship("battleship");
  static Ship cruiser = new Ship("cruiser");
  static Ship submarine = new Ship("submarine");
  static Ship destroyer = new Ship("destroyer");

  public static void setupHum(){
    System.out.println("Please place your aircraft carrier. This ship is five units long.");
    System.out.println("Choose the orientation(horizontal or vertical) and the top left coordinate of the ship.");
    System.out.println("The coordinates range from A0 to J9");
    System.out.println("Separate each entry by a space.");
    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
    orient = in.next();
    letter = in.next();
    num = in.nextInt();
    
    airCraft.setShip(orient, letter, num);

    System.out.println("Please place your battleship. This ship is four units long.");
    System.out.println("Choose the orientation(horizontal or vertical) and the top left coordinate of the ship.");
    System.out.println("The coordinates range from A0 to J9");
    System.out.println("Separate each entry by a space.");
    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
    orient = in.next();
    letter = in.next();
    num = in.nextInt();
    
    battle.setShip(orient, letter, num);

    System.out.println("Please place your cruiser. This ship is three units long.");
    System.out.println("Choose the orientation(horizontal or vertical) and the top left coordinate of the ship.");
    System.out.println("The coordinates range from A0 to J9");
    System.out.println("Separate each entry by a space.");
    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
    orient = in.next();
    letter = in.next();
    num = in.nextInt();
    
    cruiser.setShip(orient, letter, num);

    System.out.println("Please place your submarine. This ship is three units long.");
    System.out.println("Choose the orientation(horizontal or vertical) and the top left coordinate of the ship.");
    System.out.println("The coordinates range from A0 to J9");
    System.out.println("Separate each entry by a space.");
    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
    orient = in.next();
    letter = in.next();
    num = in.nextInt();
    
    submarine.setShip(orient, letter, num);

    System.out.println("Please place your destroyer. This ship is two units long.");
    System.out.println("Choose the orientation(horizontal or vertical) and the top left coordinate of the ship.");
    System.out.println("The coordinates range from A0 to J9");
    System.out.println("Separate each entry by a space.");
    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
    orient = in.next();
    letter = in.next();
    num = in.nextInt();
    
    destroyer.setShip(orient, letter, num);
  }

}
