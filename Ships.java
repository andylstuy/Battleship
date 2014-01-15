public class Ships {

  private String _ship;
  private int lives;

  public Ships(String name) {
 	  if(name.equals("aircraft carrier")) {
 	    _ship = "| | | | |";
 	  }
 	  else if(name.equals("battleship")) {
 	    _ship = "| | | |";
 	  }
 	  else if(name.equals("destroyer")) {
 	    _ship = "| |";
 	  }
 	  else {
 	    _ship = "| | |";
 	  }
  }
  
}
