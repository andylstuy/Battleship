import cs1.Keyboard;

public class Player {
  
  public void setup(){
	  int numPlayers = 0;
    
	  System.out.println("Welcome to Battleship!");
    
	while(numPlayers != 1 || numPlayers != 2) {
      		System.out.println("Would you like to play a one player or two player game?");
	    	System.out.print("Input 1 to play a one player game or 2 to play a two player game: ");
	    	numPlayers = Keyboard.readInt();
      
	    	if(numPlayers == 1) {
	    		Human player1 = new Human();
	    		setupHum();
	    		setupComp();
	    	}
	    	else if(numPlayers == 2) {
			 Human player1 = new Human();
			 Human player2 = new Human();
			 setupHum();
			 setupHum();
	    	}
	    	else {
	    		System.out.println("You did not enter valid input.");
			System.out.println("Please try again.");
	    	}
	}
  }
  
   
   //Start - Things for gridification
   private static final String NUMBERS = " 0123456789";
   private static final String LETTERS = "ABCDEFGHIJ";

    public static void print( String[][] a ) {
	for (int r = 0; r < a.length; r++) {
	    for (int c = 0; c < a[r].length; c++)
		System.out.print(a[r][c]);
	    System.out.println();
	}
    }

    public static void grid(String[][] a) {
	for (int r = 0; r < a.length; r++) {
	    for (int c = 0; c < a[r].length; c++) {
		if (r < 1)
		    a[r][c] = NUMBERS.substring(c,c+1) + " ";
		if (r > 0 && c < 1)
		    a[r][c] = LETTERS.substring(r-1,r) + " ";
		if (r > 0 && c > 0)
		    a[r][c] = "~ ";
	    }
	}
    }
    
    public static void gridify() {
	//Creates the Battleship grid, though it does not have any spaces yet and 10 is represented by 0
  	String[][] yourTargetGrid = new String[11][11];
	grid(yourTargetGrid);
	System.out.println("Your Target Grid:");
	print(yourTargetGrid);
	String[][] yourOceanGrid = new String[11][11];
	grid(yourOceanGrid);
	System.out.println("Your Ocean Grid:");
	print(yourOceanGrid);

	System.out.println();
	System.out.println();

	String[][] computarTargetGrid = new String[11][11];
	grid(computarTargetGrid);
	System.out.println("Computar's Target Grid:");
	print(computarTargetGrid);
	String[][] computarOceanGrid = new String[11][11];
	grid(computarOceanGrid);
	System.out.println("Computar's Ocean Grid:");
	print(computarOceanGrid);
        
    }
    //End - Things for gridification
    
  
    public static void play() {
    	setup();
	gridify();
    }


}


