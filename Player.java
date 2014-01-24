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
    static String[][] otherTargetGrid = new String[11][11];
    static String[][] otherOceanGrid = new String[11][11];
    static String[][] computarTargetGrid = new String[11][11];
    static String[][] computarOceanGrid = new String[11][11];

    static String attackLetter;
    static int attackNum;

    private static int _totalLives = 17;
    private static int _totalLivesPlayer1 = 17;
    private static int _totalLivesPlayer2 = 17;
    private static int _totalLivesCPU = 17;

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

	for (int x = 0; x < storeCoors(p).size(); x++) {
	    if (already.size() == 0 || 
		!( already.get(x) == (10 * (Ship.numifyLetter(s)+1) + i) ) ) {
		if ( storeCoors(p).get(x) == (10 * (Ship.numifyLetter(s)+1) + i) ) {
		    already.add(storeCoors(p).get(x));
		    g[(Ship.numifyLetter(s)+1)][i+1] = "X";
		    _totalLivesCPU -= 1;
		    System.out.println("\nSuccessful hit! \nComputar's Ocean Grid:");
		    break;
		}
		else {
		    g[(Ship.numifyLetter(s)+1)][i+1] = "O";
		    //System.out.println("\nWow, that was a bad miss...");
		}
	    }

	    else {
		System.out.println("You've already tried attacking this spot!");
		break;

	    }
	}
	print(g);
    }

    public static void hit1(Player p, String[][] g, String s, int i) {
	ArrayList<Integer> already = new ArrayList<Integer>();

	for (int x = 0; x < storeCoors(p).size(); x++) {
	    if (already.size() == 0 || 
		!( already.get(x) == (10 * (Ship.numifyLetter(s)+1) + i) ) ) {
		if ( storeCoors(p).get(x) == (10 * (Ship.numifyLetter(s)+1) + i) ) {
		    already.add(storeCoors(p).get(x));
		    g[(Ship.numifyLetter(s)+1)][i+1] = "X";
		    _totalLivesPlayer2 -= 1;
		    System.out.println("\nSuccessful hit! \nPlayer 2's Ocean Grid:");
		    break;
		}
		else {
		    g[(Ship.numifyLetter(s)+1)][i+1] = "O";
		    //System.out.println("\nWow, that was a bad miss...");
		}
	    }

	    else {
		System.out.println("You've already tried attacking this spot!");
		break;

	    }
	}
	print(g);
    }

    public static void hit2(Player p, String[][] g, String s, int i) {
	ArrayList<Integer> already = new ArrayList<Integer>();

	for (int x = 0; x < storeCoors(p).size(); x++) {
	    if (already.size() == 0 || 
		!( already.get(x) == (10 * (Ship.numifyLetter(s)+1) + i) ) ) {
		if ( storeCoors(p).get(x) == (10 * (Ship.numifyLetter(s)+1) + i) ) {
		    already.add(storeCoors(p).get(x));
		    g[(Ship.numifyLetter(s)+1)][i+1] = "X";
		    _totalLivesPlayer1 -= 1;
		    System.out.println("\nSuccessful hit! \nPlayer 1's Ocean Grid:");
		    break;
		}
		else {
		    g[(Ship.numifyLetter(s)+1)][i+1] = "O";
		    //System.out.println("\nWow, that was a bad miss...");
		}
	    }

	    else {
		System.out.println("You've already tried attacking this spot!");
		break;

	    }
	}
	print(g);
    }

    public static void hitCPU(Player p, String[][] g, String s, int i) {
	if ( g[Ship.numifyLetter(s)+1][i+1].equals("a") ||
	     g[Ship.numifyLetter(s)+1][i+1].equals("b") ||
	     g[Ship.numifyLetter(s)+1][i+1].equals("c") ||
	     g[Ship.numifyLetter(s)+1][i+1].equals("s") ||
	     g[Ship.numifyLetter(s)+1][i+1].equals("d") ) {
	    g[Ship.numifyLetter(s)+1][i+1] = "X";
	    _totalLives -= 1;
	    System.out.println("\nComputar has struck you! \nYour Board:");
	}
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

    public static void shipifyGridMe(String[][] a) {
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
        
	grid(yourOceanGrid);
	shipifyGrid(yourOceanGrid);
        System.out.println("Your Ocean Grid:");
        print(yourOceanGrid);

    }

    public static void gridifyMe() {
        
	grid(yourOceanGrid);
	shipifyGridMe(yourOceanGrid);
        System.out.println("Your Ocean Grid:");
        print(yourOceanGrid);

    }

    public static void gridifyOther() {
        
	grid(otherOceanGrid);
	shipifyGridCPU(otherOceanGrid);
        System.out.println("Opponent's Ocean Grid:");
        print(otherOceanGrid);

    }

    public static void gridifyCPU() {

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
	    while( (_totalLives > 0) ||
		   (_totalLivesCPU > 0) ) {
		human1.play();
		if (_totalLivesCPU < 1) {
		    System.out.println("\nYOU WIN!!!!!");
		    break;
		}

		computar1.play();
		if (_totalLives < 1) {
		    System.out.println("Awwwwww... you lost. ):");
		    break;
		}
	    }

	    
	}
	else if(numPlayers == 2) {
	    human1 = new Human();
	    human2 = new Human();

	    human1.setupForFirstHuman();
	    human2.setupForSecondHuman();
	    while( (_totalLivesPlayer1 > 0) &&
		   (_totalLivesPlayer2 > 0) ) {
		human1.play1();
		if (_totalLivesPlayer2 < 1) {
		    System.out.println("\nPLAYER 1 WINS!!!!!");
		    break;
		}
	
		human2.play2();	
		if (_totalLivesPlayer1 < 1) {
		    System.out.println("\nPLAYER 2 WINS!!!!!");	
		    break;
		}

	    }

	}
	
    }


}
