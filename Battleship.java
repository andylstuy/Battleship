public class Battleship {
  public static void main (String args[]){
    Player.play();
  }
  
  /* Should this be part of the play method?
     Creates the Battleship grid, though it does not have any spaces yet and 10 is represented by 0
  private static final String NUMBERS = " 1234567890";
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
		      a[r][c] = NUMBERS.substring(c,c+1);
		    if (r > 0 && c < 1)
		      a[r][c] = LETTERS.substring(r-1,r);
		    if (r > 0 && c > 0)
		      a[r][c] = "~";
	    }
	  }
  }

  public static void main(String[] args) {
	  String[][] battle = new String[11][11];
	  grid(battle);
	  print(battle);
  }*/
  
  
  
  
  
  
  
  
  
  
  
  
  
}
