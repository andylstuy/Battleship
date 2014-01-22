import java.util.Scanner;
import java.util.*;

public class Player {

    static Ship aircraft = new Ship("aircraft carrier");
    static Ship battle = new Ship("battleship");
    static Ship cruiser = new Ship("cruiser");
    static Ship submarine = new Ship("submarine");
    static Ship destroyer = new Ship("destroyer");
    
    static int numPlayers = 0;
  
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

    public static void gridifyYou() {
      
        String[][] yourTargetGrid = new String[11][11];
        grid(yourTargetGrid);
        System.out.println("Player1 Target Grid:");
        print(yourTargetGrid);

        String[][] yourOceanGrid = new String[11][11];
	grid(yourOceanGrid);
	shipifyGrid(yourOceanGrid);
        System.out.println("Player1 Ocean Grid:");
        print(yourOceanGrid);

    }

    public static void gridifyCPU() {

        String[][] computarTargetGrid = new String[11][11];
        grid(computarTargetGrid);
        System.out.println("Player2 Target Grid:");
        print(computarTargetGrid);

        String[][] computarOceanGrid = new String[11][11];
        grid(computarOceanGrid);
	shipifyGrid(computarOceanGrid);
	System.out.println("Player2 Ocean Grid:");
        print(computarOceanGrid);
        
    }


    public static void setup(){

        Scanner in = new Scanner(System.in);
    
        System.out.println("Welcome to Battleship!");
    
        while(numPlayers != 1 && numPlayers != 2) {
            System.out.println("Would you like to play a one player or two player game?");
            System.out.print("Input 1 to play a one player game or 2 to play a two player game: ");
            numPlayers = in.nextInt();
	}
      
	if(numPlayers == 1) {
	    Human human1 = new Human();
	    Computar computar1 = new Computar();
	    human1.setupForOneHuman();
	    computar1.setupForCPU();
	}
	else if(numPlayers == 2) {
	    Human human1 = new Human();
	    Human human2 = new Human();
	    human1.setup();
	    human2.setup();
	}
	else {
	    System.out.println("You did not enter valid input.");
	    System.out.println("Please try again.");
	}
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
    
  
    public static void play() {
	setup();
    }
}
