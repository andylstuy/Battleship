import java.util.*;

public class Ship {

    private static final String LETTERS = "ABCDEFGHIJ ";
    private int _lives;
    private int _size;
    private static String _name;
    private ArrayList<Integer> coors = new ArrayList<Integer>();


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
    
    public int getLives(){
    	return _lives;
    }



    public static int numifyLetter(String letter) {
        for(int x = 0; x < LETTERS.length(); x++)
            if(LETTERS.substring(x, x+1).equals(letter))
                return x;
        return -1;
    }
  
    public ArrayList<Integer> getCoors(){
	return coors;
    }

    public boolean isOccupied(Ship ship) {
	boolean retBoo = true;
	for (int i = 0; i < this.getCoors().size(); i++)
	    for (int j = 0; j < ship.getCoors().size(); j++)
		if ( ship.getCoors().get(j) == this.getCoors().get(i) ) {
		    retBoo = false;
		    break;
		}
	return retBoo;
    }

    public boolean setShip(String orient, String letter, int num) {
        
        if(orient.equals("h")) {
            if(num + _size > 10) {
                System.out.println("\nInvalid position. Ship does not fit on board.");
                return false;
            }
            else {
                for(int x = 0; x < _size; x++) {
		    int coor = (numifyLetter(letter)+1) * 10 + num;
		    coors.add(coor);
		    num++;
                }
                return true;
            }
        }
        else {
            if(numifyLetter(letter) + _size > 10) {
                System.out.println("\nInvalid position. Ship does not fit on board.");
                return false;
            }
            else {
                for(int x = 0; x < _size; x++) {
                    int coor = (numifyLetter(letter)+1) * 10 + num;
                    coors.add(coor);
                    letter = LETTERS.substring(numifyLetter(letter) + 1, numifyLetter(letter) + 2);
                }
                return true;
            }
        }
    }

    public boolean setShipCPU(String orient, String letter, int num) {
        
        if(orient.equals("h")) {
            if(num + _size > 10) {
                System.out.println("\nInvalid position. Ship does not fit on board.");
                return false;
            }
            else {
                for(int x = 0; x < _size; x++) {
		    int coor = (numifyLetter(letter)+1) * 10 + num;
		    coors.set(x,coor);
		    num++;
                }
                return true;
            }
        }
        else {
            if(numifyLetter(letter) + _size > 10) {
                System.out.println("\nInvalid position. Ship does not fit on board.");
                return false;
            }
            else {
                for(int x = 0; x < _size; x++) {
                    int coor = (numifyLetter(letter)+1) * 10 + num;
                    coors.set(x,coor);
                    letter = LETTERS.substring(numifyLetter(letter) + 1, numifyLetter(letter) + 2);
                }
                return true;
            }
        }
    }

}
