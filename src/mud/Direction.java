package mud;

public enum Direction {
  NORTH, SOUTH, EAST, WEST;
  
  public static Direction resolve(String input) {
    switch (input.toLowerCase()) {
      case "up":
      case "north":
        return Direction.NORTH;     
      case "down":
      case "south":
        return Direction.SOUTH;
	case "right":
      case "east":
        return Direction.EAST;       
      case "left":
      case "west":
        return Direction.WEST;
      default:
        return null;
      }
   }
   
}
