import java.util.Scanner;
import java.io.*;

public class Human extends Player {
    
    // Declarations
    static Scanner in = new Scanner(System.in);
    static String orient;
    static String letter;
    static int num;

    public static void setupForOneHuman(){
	System.out.println("\nFor each ship select the orientation(h for horizontal, v for vertical) and the top left coordinate of the ship. \nThe coordinates range from A0 to J9.\nSelect the letter(it must be uppercase) and the number and separate all entries with a space. \ni.e. h F 7");

	
	//Aircraft Placement
	boolean set = false;
	while (set == false){
	    System.out.println("\nPlease place your aircraft carrier. This ship is five units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
    
	    set = aircraft.setShip(orient, letter, num);
	    
	}
	gridifyYou();
	
	//Battleship Placement
	set = false;
	while (set == false) {
	    
	    System.out.println("\nPlease place your battleship. This ship is four units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
	    
	    set = battle.setShip(orient, letter, num);
	    if (battle.isOccupied(aircraft) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(battle);
	    }
	    
	}
	gridifyYou();
	
	//Cruiser Placement
	set = false;
	while (set == false) {

	    System.out.println("\nPlease place your cruiser. This ship is three units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
    
	    set = cruiser.setShip(orient, letter, num);
	    if (cruiser.isOccupied(aircraft) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(cruiser);
	    }
	    if (cruiser.isOccupied(battle) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(cruiser);
	    }

	}
	gridifyYou();
	
	//Submarine Placement
	set = false;
	while (set == false) {

	    System.out.println("\nPlease place your submarine. This ship is three units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
    
	    set = submarine.setShip(orient, letter, num);
	    if (submarine.isOccupied(aircraft) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(submarine);
	    }
	    if (submarine.isOccupied(battle) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(submarine);
	    }
	    if (submarine.isOccupied(cruiser) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(submarine);
	    }

	}
	gridifyYou();
	
	//Destroyer Placement
	set = false;
	while (set == false) {

	    System.out.println("\nPlease place your destroyer. This ship is two units long.");
	    System.out.print("Orientation, letter of coordinate, number of coordinate: ");
    
	    orient = in.next();
	    letter = in.next();
	    num = in.nextInt();
    
	    set = destroyer.setShip(orient, letter, num);
	    if (destroyer.isOccupied(aircraft) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(destroyer);
	    }
	    if (destroyer.isOccupied(battle) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(destroyer);
	    }
	    if (destroyer.isOccupied(cruiser) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(destroyer);
	    }
	    if (destroyer.isOccupied(submarine) == false) {
		System.out.println("Ship already here! \nTry again.");
		set = false;
		resetCoors(destroyer);
	    }
 
	}
	gridifyYou();

    }

    public static void play() {
	/* {
	    ;
	    }*/
	
	    System.out.println("It's your turn, Player. Make your move... \nWhere would you like to attack?");
	    attackLetter = in.next();
	    attackNum = in.nextInt();
	    hit(computar1, computarOceanGrid, attackLetter, attackNum);
	    	

    }







}
