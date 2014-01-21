// Something wrong with the randomizing omg

import java.util.Scanner;
import java.io.*;

public class Computar extends Player {

    private static final String ETTERS = "ABCDEFGHIJ";

    static String orientCPU;
    static String letterCPU;
    static int numCPU;
    
    public static String letterifyNumber(int number) {
	return ETTERS.substring(number, number+1);
    }

    public static void resetOther() {
	orientCPU = "";
	letterCPU = "";
	numCPU = 0;
    }

    public static void setupForCPU() {

	int randomOrientCPU = 0;

	//AircraftCPU Placement
	boolean set = false;
	while (set == false){
	    randomOrientCPU = (int) (2 * Math.random());
	    if (randomOrientCPU == 0)
		orientCPU = "h";
	    else
		orientCPU = "v";

	    if (orientCPU.equals("h")) {
		letterCPU = letterifyNumber( (int) (10 * Math.random()) );
		numCPU = (int) (5 * Math.random());
	    }
	    if (orientCPU.equals("v")) {
		letterCPU = letterifyNumber( (int) (5 * Math.random()) );
		numCPU = (int) (10 * Math.random());
	    }
    
	    set = aircraft.setShip(orientCPU, letterCPU, numCPU);
	}

	
	//Battleship Placement
	set = false;
	while (set == false) {

	    randomOrientCPU = (int) (2 * Math.random());

	    if (randomOrientCPU == 0)
		orientCPU = "h";
	    else if (randomOrientCPU == 1)
		orientCPU = "v";

	    if (orientCPU.equals("h")) {
		letterCPU = letterifyNumber( (int) (10 * Math.random()) );
		numCPU = (int) (6 * Math.random());
	    }
	    if (orientCPU.equals("v")) {
		letterCPU = letterifyNumber( (int) (6 * Math.random()) );
		numCPU = (int) (10 * Math.random());
	    }
	    
	    set = battle.setShip(orientCPU, letterCPU, numCPU);

	    if (battle.isOccupied(aircraft) == false) {
		set = false;
		resetCoors(battle);
		resetOther();
		
	    }
	    
	}

	
	//Cruiser Placement
	set = false;
	while (set == false) {

	    randomOrientCPU = (int) (2 * Math.random());
	    if (randomOrientCPU == 0)
		orientCPU = "h";
	    else
		orientCPU = "v";

	    if (orientCPU.equals("h")) {
		letterCPU = letterifyNumber( (int) (10 * Math.random()) );
		numCPU = (int) (7 * Math.random());
	    }
	    if (orientCPU.equals("v")) {
		letterCPU = letterifyNumber( (int) (7 * Math.random()) );
		numCPU = (int) (10 * Math.random());
	    }
    
	    set = cruiser.setShip(orientCPU, letterCPU, numCPU);
	    if (cruiser.isOccupied(aircraft) == false) {
		set = false;
		resetCoors(cruiser);
		resetOther();
	    }
	    if (cruiser.isOccupied(battle) == false) {
		set = false;
		resetCoors(cruiser);
		resetOther();
	    }

	}

	
	//Submarine Placement
	set = false;
	while (set == false) {

	    randomOrientCPU = (int) (2 * Math.random());
	    if (randomOrientCPU == 0)
		orientCPU = "h";
	    else
		orientCPU = "v";

	    if (orientCPU.equals("h")) {
		letterCPU = letterifyNumber( (int) (10 * Math.random()) );
		numCPU = (int) (7 * Math.random());
	    }
	    if (orientCPU.equals("v")) {
		letterCPU = letterifyNumber( (int) (7 * Math.random()) );
		numCPU = (int) (10 * Math.random());
	    }
    
	    set = submarine.setShip(orientCPU, letterCPU, numCPU);
	    if (submarine.isOccupied(aircraft) == false) {
		set = false;
		resetCoors(submarine);
		resetOther();
	    }
	    if (submarine.isOccupied(battle) == false) {
		set = false;
		resetCoors(submarine);
		resetOther();
	    }
	    if (submarine.isOccupied(cruiser) == false) {
		set = false;
		resetCoors(submarine);
		resetOther();
	    }

	}

	
	//Destroyer Placement
	set = false;
	while (set == false) {

	    randomOrientCPU = (int) (2 * Math.random());
	    if (randomOrientCPU == 1)
		orientCPU = "h";
	    else
		orientCPU = "v";

	    if (orientCPU.equals("h")) {
		letterCPU = letterifyNumber( (int) (10 * Math.random()) );
		numCPU = (int) (8 * Math.random());
	    }
	    if (orientCPU.equals("v")) {
		letterCPU = letterifyNumber( (int) (8 * Math.random()) );
		numCPU = (int) (10 * Math.random());
	    }
    
	    set = destroyer.setShip(orientCPU, letterCPU, numCPU);
	    if (destroyer.isOccupied(aircraft) == false) {
		set = false;
		resetCoors(destroyer);
		resetOther();
	    }
	    if (destroyer.isOccupied(battle) == false) {
		set = false;
		resetCoors(destroyer);
		resetOther();
	    }
	    if (destroyer.isOccupied(cruiser) == false) {
		set = false;
		resetCoors(destroyer);
		resetOther();
	    }
	    if (destroyer.isOccupied(submarine) == false) {
		set = false;
		resetCoors(destroyer);
		resetOther();
	    }
	    
	}
	gridifyCPU();
    }
}


    




