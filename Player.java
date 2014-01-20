import java.util.Scanner;

public class Player {

    static Ship airCraft = new Ship("aircraft carrier");
    static Ship battle = new Ship("battleship");
    static Ship cruiser = new Ship("cruiser");
    static Ship submarine = new Ship("submarine");
    static Ship destroyer = new Ship("destroyer");
  
    public static void setup(){

        Scanner in = new Scanner(System.in);

        int numPlayers = 0;
    
        System.out.println("Welcome to Battleship!");
    
        while(numPlayers != 1 && numPlayers != 2) {
            System.out.println("Would you like to play a one player or two player game?");
            System.out.print("Input 1 to play a one player game or 2 to play a two player game: ");
            numPlayers = in.nextInt();
	}
      
	if(numPlayers == 1) {
	    Human human1 = new Human();
	    Computar computar1 = new Computar();
	    human1.setup();
	    computar1.setup();
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

    public static void shipifyGrid(String[][] a) {
	for(int x = 0; x < airCraft.getCoors().size(); x++) {
	    a[(airCraft.getCoors().get(x)/10)][(airCraft.getCoors().get(x)%10)+1] = "+";
	}
	for(int x = 0; x < battle.getCoors().size(); x++) {
	    a[(battle.getCoors().get(x)/10)][(battle.getCoors().get(x)%10)+1] = "+";
	}
	for(int x = 0; x < cruiser.getCoors().size(); x++) {
	    a[(cruiser.getCoors().get(x)/10)][(cruiser.getCoors().get(x)%10)+1] = "+";
	}
	for(int x = 0; x < submarine.getCoors().size(); x++) {
	    a[(submarine.getCoors().get(x)/10)][(submarine.getCoors().get(x)%10)+1] = "+";
	}
	for(int x = 0; x < destroyer.getCoors().size(); x++) {
	    a[(destroyer.getCoors().get(x)/10)][(destroyer.getCoors().get(x)%10)+1] = "+";
	}
    }
    
    public static void gridify() {
      
	String[][] yourTargetGrid = new String[11][11];
        grid(yourTargetGrid);
        System.out.println("Player1 Target Grid:");
        print(yourTargetGrid);

        String[][] yourOceanGrid = new String[11][11];
	grid(yourOceanGrid);
	shipifyGrid(yourOceanGrid);
        System.out.println("Player1 Ocean Grid:");
        print(yourOceanGrid);

        System.out.println();
        System.out.println();

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
    //End - Things for gridification
    
  
    public static void play() {
	setup();
        gridify();
    }
}
