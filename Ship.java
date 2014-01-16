import java.util.*;

public class Ship {

    private static final String LETTERS = "ABCDEFGHIJ";
    private int _lives;
    private static int _size;
    private static String _name;
    private ArrayList<String> coors = new ArrayList<String>();

    public Ship(String name) {
	if(name.equals("aircraft carrier")) {
	    _name = name;
 	    _lives = 5;
 	    _size = 5;
	}
	else if(name.equals("battleship")) {
	    _name = name;
 	    _lives = 4;
 	    _size = 4;
	}
	else if(name.equals("destroyer")) {
	    _name = name;
 	    _lives = 2;
 	    _size = 2;
	}
	else {
	    _name = name;
 	    _lives = 3;
 	    _size = 3;
	}
    }

    public int numifyLetter(String letter) {
	for(int x = 0; x < LETTERS.length(); x++) {
	    if(LETTERS.substring(x, x+1).equals(letter)) {
		return x;
	    }
	}
	return -1;
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
	else {
	    if(numifyLetter(letter) + _size > 9) {
		System.out.println("Invalid position. Ship does not fit on board.");
		return false;
	    }
	    else {
		for(int x = 0; x < _size; x++) {
		    String coor = letter + num;
		    coors.add(coor);
		    letter = LETTERS.substring(numifyLetter(letter), numifyLetter(letter) + 1);
		}
		return true;
	    }
	}
    }
  
}
