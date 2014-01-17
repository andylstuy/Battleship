public class Human extends Player {
  
  Ship airCraft = new Ship("aircraft carrier");
  Ship battle = new Ship("battleship");
  Ship cruiser = new Ship("cruiser");
  Ship submarine = new Ship("submarine");
  Ship destroyer = new Ship("destroyer");

  public void setupHum(){
    System.out.println("Please place your aircraft carrier. This ship is five units long.");
    System.out.println("Choose the orientation(horizontal or vertical) and the top left coordinate of the ship.");
    System.out.println("The coordinates range from A0 to J9");
    System.out.println("Separate each entry by a space.");
    System.out.print("Orientation, letter of coordinate, number of coordinate: ")
    
  }

}
