import java.util.Scanner;
import java.io.*;

public class Human extends Player {
  
    // Declarations
    static Scanner in = new Scanner(System.in);
    static String orient;
    static String letter;
    static int num;

    public static void setup(){
	System.out.println("\nFor each ship select the orientation(h for horizontal, v for vertical) and the top left coordinate of the ship. \nThe coordinates range from A0 to J9.\nSelect the letter(it must be uppercase) and the number and separate all entries with a space.");

	boolean set = false;

	while (set == false){
	    System.out.println("\nPlease place your aircraft carrier. This ship is five units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
    
	    set = airCraft.setShip(orient, letter, num);
	}
	set = false;

	while (set == false) {
	    System.out.println("\nPlease place your battleship. This ship is four units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
    
	    set = battle.setShip(orient, letter, num);
	}
	set = false;

	while (set == false) {
	    System.out.println("\nPlease place your cruiser. This ship is three units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
    
	    set = cruiser.setShip(orient, letter, num);
	}
	set = false;

	while (set == false) {
	    System.out.println("\nPlease place your submarine. This ship is three units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
    
	    set = submarine.setShip(orient, letter, num);
	}
	set = false;

	while (set == false) {
	    System.out.println("\nPlease place your destroyer. This ship is two units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
    
	    set = destroyer.setShip(orient, letter, num);
	}
    }

}
