import java.util.Scanner;
import java.io.*;

public class Computar extends Player {

    static String orient;
    static String letter;
    static int num;

    public static void setup(){

    
	aircraft.setShip(orient, letter, num);


	battle.setShip(orient, letter, num);

    
	cruiser.setShip(orient, letter, num);


	submarine.setShip(orient, letter, num);

    
	destroyer.setShip(orient, letter, num);
    }
}
