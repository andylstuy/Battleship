import java.util.Scanner;
import java.util.*;

public class Player {

    static Ship aircraft = new Ship("aircraft carrier");
    static Ship battle = new Ship("battleship");
    static Ship cruiser = new Ship("cruiser");
    static Ship submarine = new Ship("submarine");
    static Ship destroyer = new Ship("destroyer");

    static Human human1;
    static Computar computar1;
    static Human human2;
    static String[][] yourTargetGrid = new String[11][11];
    static String[][] yourOceanGrid = new String[11][11];
    static String[][] computarTargetGrid = new String[11][11];
    static String[][] computarOceanGrid = new String[11][11];

    static String attackLetter;
    static int attackNum;

    static int numPlayers = 0;
    
    public static Ship getAircraft(){
    	return aircraft;
    }
    
    public static Ship getBattle(){
    	return battle;
    }
    
    public static Ship getCruiser(){
    	return cruiser;
    }
    
    public static Ship getSubmarine(){
    	return submarine;
    }
    
    public static Ship getDestroyer(){
    	return destroyer;
    }

    public static ArrayList<Integer> storeCoors(Player p){
	ArrayList<Integer> storage = new ArrayList<Integer>();
	for (int i = 0; i < p.getAircraft().getCoors().size(); i++)
	    storage.add(getAircraft().getCoors().get(i));
	for (int i = 0; i < p.getBattle().getCoors().size(); i++)
	    storage.add(getBattle().getCoors().get(i));
	for (int i = 0; i < p.getCruiser().getCoors().size(); i++)
	    storage.add(getCruiser().getCoors().get(i));
	for (int i = 0; i < p.getSubmarine().getCoors().size(); i++)
	    storage.add(getSubmarine().getCoors().get(i));
	for (int i = 0; i < p.getDestroyer().getCoors().size(); i++)
	    storage.add(getDestroyer().getCoors().get(i));	
	return storage;
    }
   
    public static void hit(Player p, String[][] g, String s, int i) {
	ArrayList<Integer> already = new ArrayList<Integer>();
	already.add(1);
	for (int x = 0; x < storeCoors(p).size(); x++) {
	    if ( already.get(x) != (10 * (Ship.numifyLetter(s)+1) + i) ) {
		already.add(storeCoors(p).get(x));
		System.out.println("You've already tried attacking this spot!");
		break;
	    }
	    else {
		if ( storeCoors(p).get(x) == (10 * (Ship.numifyLetter(s)+1) + i) ) {
		    g[(Ship.numifyLetter(s)+1)][i+1] = "X";
		    System.out.println("\nSuccessful hit!");
		    break;
		}
		else {
		    g[(Ship.numifyLetter(s)+1)][i+1] = "O";
		    //System.out.println("\nWow, that was a bad miss...");
		}
	    }
	}
	print(g);
    }

    public static void hitCPU(Player p, String[][] g, String s, int i) {
	if ( g[Ship.numifyLetter(s)+1][i+1].equals("a") ||
	     g[Ship.numifyLetter(s)+1][i+1].equals("b") ||
	     g[Ship.numifyLetter(s)+1][i+1].equals("c") ||
	     g[Ship.numifyLetter(s)+1][i+1].equals("s") ||
	     g[Ship.numifyLetter(s)+1][i+1].equals("d") )  
	    g[Ship.numifyLetter(s)+1][i+1] = "X";
	else
	    g[Ship.numifyLetter(s)+1][i+1] = "O";
	print(g);
    }

    
    public static void resetCoors(Ship ship){
	for (int i = 0; i < ship.getCoors().size(); i++)
	    ship.getCoors().set(i, null);
    }


    public static void shipifyGrid(String[][] a) {
	for(int x = 0; x < aircraft.getCoors().size(); x++) {
	    a[(aircraft.getCoors().get(x)/10)][(aircraft.getCoors().get(x)%10)+1] = "a";
	}
	for(int x = 0; x < battle.getCoors().size(); x++) {
	    a[(battle.getCoors().get(x)/10)][(battle.getCoors().get(x)%10)+1] = "b";
	}
	for(int x = 0; x < cruiser.getCoors().size(); x++) {
	    a[(cruiser.getCoors().get(x)/10)][(cruiser.getCoors().get(x)%10)+1] = "c";
	}
	for(int x = 0; x < submarine.getCoors().size(); x++) {
	    a[(submarine.getCoors().get(x)/10)][(submarine.getCoors().get(x)%10)+1] = "s";
	}
	for(int x = 0; x < destroyer.getCoors().size(); x++) {
	    a[(destroyer.getCoors().get(x)/10)][(destroyer.getCoors().get(x)%10)+1] = "d";
	}
    }

    public static void shipifyGridCPU(String[][] a) {
	for(int x = 0; x < aircraft.getCoors().size(); x++) {
	    a[(aircraft.getCoors().get(x)/10)][(aircraft.getCoors().get(x)%10)+1] = "~";
	}
	for(int x = 0; x < battle.getCoors().size(); x++) {
	    a[(battle.getCoors().get(x)/10)][(battle.getCoors().get(x)%10)+1] = "~";
	}
	for(int x = 0; x < cruiser.getCoors().size(); x++) {
	    a[(cruiser.getCoors().get(x)/10)][(cruiser.getCoors().get(x)%10)+1] = "~";
	}
	for(int x = 0; x < submarine.getCoors().size(); x++) {
	    a[(submarine.getCoors().get(x)/10)][(submarine.getCoors().get(x)%10)+1] = "~";
	}
	for(int x = 0; x < destroyer.getCoors().size(); x++) {
	    a[(destroyer.getCoors().get(x)/10)][(destroyer.getCoors().get(x)%10)+1] = "~";
	}
    }


    public static void gridifyYou() {
        
	/*       grid(yourTargetGrid);
        System.out.println("Your Target Grid:");
        print(yourTargetGrid);*/

        
	grid(yourOceanGrid);
	shipifyGrid(yourOceanGrid);
        System.out.println("Your Ocean Grid:");
        print(yourOceanGrid);

    }

    public static void gridifyCPU() {

	/*        
        grid(computarTargetGrid);
        System.out.println("Player2 Target Grid:");
        print(computarTargetGrid);*/

        
        grid(computarOceanGrid);
	shipifyGridCPU(computarOceanGrid);
	System.out.println("Computar's Ocean Grid:");
        print(computarOceanGrid);
        
    }

    //Start - Things for gridification
    private static final String NUMBERS = " 0123456789";
    private static final String LETTERS = "ABCDEFGHIJ";

    public static void print( String[][] a ) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[r].length; c++)
                System.out.print(a[r][c] + " ");
            System.out.println();
        }
    }

    public static void grid(String[][] a) {
        for (int r = 0; r < a.length; r++) {
            for (int c = 0; c < a[r].length; c++) {
                if (r < 1)
                    a[r][c] = NUMBERS.substring(c,c+1);
                if (r > 0 && c < 1)
                    a[r][c] = LETTERS.substring(r-1,r);
                if (r > 0 && c > 0)
                    a[r][c] = "~";
            }
        }
    }
    //End - Things for gridification
    
    
    public static void play(){

        Scanner in = new Scanner(System.in);
    
        System.out.println("Welcome to Battleship!");
    
        while(numPlayers != 1 && numPlayers != 2) {
            System.out.println("Would you like to play a one player or two player game?");
            System.out.print("Input 1 to play a one player game or 2 to play a two player game: ");
            numPlayers = in.nextInt();
	}
      
	if(numPlayers == 1) {
	    human1 = new Human();
	    computar1 = new Computar();
	    human1.setupForOneHuman();
	    computar1.setupForCPU();
	    while( (human1.getAircraft().getLives() > 0 ||
		human1.getBattle().getLives() > 0 ||
		human1.getCruiser().getLives() > 0 ||
		human1.getSubmarine().getLives() > 0 ||
		human1.getDestroyer().getLives() > 0) ||
	       (computar1.getAircraft().getLives() > 0 ||
		computar1.getBattle().getLives() > 0 ||
		computar1.getCruiser().getLives() > 0 ||
		computar1.getSubmarine().getLives() > 0 ||
		computar1.getDestroyer().getLives() > 0)) {
	    human1.play();
	    computar1.play();
	    }
	}
	else if(numPlayers == 2) {
	    human1 = new Human();
	    human2 = new Human();
	    //human1.setup();
	    //human2.setup();
	}
	else {
	    System.out.println("You did not enter valid input.");
	    System.out.println("Please try again.");
	}
    }



    /*    public static void play() {
	setup();
	if (numPlayers == 2){
	    
		human1.play();
		human2.play();
	    
	}
	else{
	    	
		human1.play();
		computar1.play();
	}
	}*/




}
