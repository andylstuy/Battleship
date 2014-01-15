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
		    return setupComp();
	    }
	    else if(numPlayers == 2) {
		    return setupHum();
	    }
	    else {
	    	System.out.println("You did not enter valid input.");
		    System.out.println("Please try again.");
	    }
	  }
  }
  
  public void play(){
  }

}
