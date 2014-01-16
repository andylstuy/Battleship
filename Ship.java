import java.util.*;

public class Ship {

  private int _lives;
  private static int _size;
  private ArrayList<String> coors = new ArrayList<String>();

  public Ship(String name) {
	  if(name.equals("aircraft carrier")) {
 	    _lives = 5;
 	    _size = 5;
	  }
	  else if(name.equals("battleship")) {
 	    _lives = 4;
 	    _size = 4;
  	}
	  else if(name.equals("destroyer")) {
 	   _lives = 2;
 	    _size = 2;
	  }
	  else {
 	   _lives = 3;
 	   _size = 3;
  	}
  }
  
  public boolean setShip(String orient, String letter, int num) {
	
	if(orient.equals("horizontal")) {
	  if(num + _size > 9) {
		  System.out.println("Invalid position. Ship does not fit on board.");
		  return false;
	   }
	   else {
		    for(int x = 0; x < _size; x++) {
		      String coor = letter + num;
		      coors.add(coor);
		      num++;
		  }
		  return true;
	    }
	}
	if (orient.equals("vertical")) {
		if(letter + _size > 9) {
		  System.out.println("Invalid position. Ship does not fit on board.");
		  return false;
		   }
	   else {
		    for(int x = 0; x < _size; x++) {
		      String coor = letter + num;
		      coors.add(coor);
		      letter++;
		  }
		  return true;
	    }
	}
    }
  
}
