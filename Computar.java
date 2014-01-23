public class Computar extends Player {

    private static final String ETTERS = " ABCDEFGHIJ";

    static String orient;
    static String letter;
    static int num;
    
    public static String letterifyNumber(int number) {
	return ETTERS.substring(number, number+1);
    }

    public static void resetOther() {
	orient = "";
	letter = "";
	num = 0;
    }

    public static void setupForCPU() {

	int randomOrient = 0;

	boolean set = false;

	//Aircraft Placement
	while (set == false) {
	    randomOrient = (int) (2 * Math.random());
	    if (randomOrient == 0)
		orient = "h";
	    else if (randomOrient == 1)
		orient = "v";

	    if (orient.equals("h")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(9*Math.random())) ) / 10 );
		num = (int) (6 * Math.random());
	    }
	    if (orient.equals("v")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(6*Math.random())) ) / 10 );
		num = (int) (10 * Math.random());
	    }

	    set = aircraft.setShipCPU(orient, letter, num);

	}

	//Battleship Placement
	set = false;
	while (set == false) {
	    randomOrient = (int) (2 * Math.random());
	    if (randomOrient == 0)
		orient = "h";
	    else if (randomOrient == 1)
		orient = "v";

	    if (orient.equals("h")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(9*Math.random())) ) / 10 );
		num = (int) (7 * Math.random());
	    }
	    if (orient.equals("v")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(7*Math.random())) ) / 10 );
		num = (int) (10 * Math.random());
	    }

	    set = battle.setShipCPU(orient, letter, num);
	    if (battle.isOccupied(aircraft) == false) {
		set = false;
		resetCoors(battle);
		resetOther();
	    }
	    
	}

	//Cruiser Placement
	set = false;
	while (set == false) {
	    randomOrient = (int) (2 * Math.random());
	    if (randomOrient == 0)
		orient = "h";
	    else if (randomOrient == 1)
		orient = "v";

	    if (orient.equals("h")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(9*Math.random())) ) / 10 );
		num = (int) (8 * Math.random());
	    }
	    if (orient.equals("v")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(8*Math.random())) ) / 10 );
		num = (int) (10 * Math.random());
	    }
	    
	    set = cruiser.setShipCPU(orient, letter, num);
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
	    randomOrient = (int) (2 * Math.random());
	    if (randomOrient == 0)
		orient = "h";
	    else if (randomOrient == 1)
		orient = "v";

	    if (orient.equals("h")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(9*Math.random())) ) / 10 );
		num = (int) (8 * Math.random());
	    }
	    if (orient.equals("v")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(8*Math.random())) ) / 10 );
		num = (int) (10 * Math.random());
	    }

	    set = submarine.setShipCPU(orient, letter, num);
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
	    randomOrient = (int) (2 * Math.random());
	    if (randomOrient == 0)
		orient = "h";
	    else if (randomOrient == 1)
		orient = "v";

	    if (orient.equals("h")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(9*Math.random())) ) / 10 );
		num = (int) (9 * Math.random());
	    }
	    if (orient.equals("v")) {
		letter = letterifyNumber( ( 10 + (10 * (int)(9*Math.random())) ) / 10 );
		num = (int) (10 * Math.random());
	    }

	    set = destroyer.setShipCPU(orient, letter, num);
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
	System.out.println("\nComputar has set its ships...");
	System.out.println(aircraft.getCoors()); 
	System.out.println(battle.getCoors());
	System.out.println(cruiser.getCoors());
	System.out.println(submarine.getCoors());
	System.out.println(destroyer.getCoors());

    }

}


    




