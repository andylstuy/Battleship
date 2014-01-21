// Something wrong with the randomizing omg

import java.util.Scanner;
import java.io.*;

public class Computar extends Player {

    static Ship aircraftCPU = new Ship("aircraft carrierCPU");
    static Ship battleCPU = new Ship("battleshipCPU");
    static Ship cruiserCPU = new Ship("cruiserCPU");
    static Ship submarineCPU = new Ship("submarineCPU");
    static Ship destroyerCPU = new Ship("destroyerCPU");


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
    
	    set = aircraftCPU.setShip(orientCPU, letterCPU, numCPU);
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
	    
	    set = battleCPU.setShip(orientCPU, letterCPU, numCPU);

	    if (battleCPU.isOccupied(aircraftCPU) == false) {
		set = false;
		resetCoors(battleCPU);
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
    
	    set = cruiserCPU.setShip(orientCPU, letterCPU, numCPU);
	    if (cruiserCPU.isOccupied(aircraftCPU) == false) {
		set = false;
		resetCoors(cruiserCPU);
		resetOther();
	    }
	    if (cruiserCPU.isOccupied(battleCPU) == false) {
		set = false;
		resetCoors(cruiserCPU);
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
    
	    set = submarineCPU.setShip(orientCPU, letterCPU, numCPU);
	    if (submarineCPU.isOccupied(aircraftCPU) == false) {
		set = false;
		resetCoors(submarineCPU);
		resetOther();
	    }
	    if (submarineCPU.isOccupied(battleCPU) == false) {
		set = false;
		resetCoors(submarineCPU);
		resetOther();
	    }
	    if (submarineCPU.isOccupied(cruiserCPU) == false) {
		set = false;
		resetCoors(submarineCPU);
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
    
	    set = destroyerCPU.setShip(orientCPU, letterCPU, numCPU);
	    if (destroyerCPU.isOccupied(aircraftCPU) == false) {
		set = false;
		resetCoors(destroyerCPU);
		resetOther();
	    }
	    if (destroyerCPU.isOccupied(battleCPU) == false) {
		set = false;
		resetCoors(destroyerCPU);
		resetOther();
	    }
	    if (destroyerCPU.isOccupied(cruiserCPU) == false) {
		set = false;
		resetCoors(destroyerCPU);
		resetOther();
	    }
	    if (destroyerCPU.isOccupied(submarineCPU) == false) {
		set = false;
		resetCoors(destroyerCPU);
		resetOther();
	    }
	    
	}
	gridifyCPU();
    }
}


    




