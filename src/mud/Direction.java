package mud;

public enum Direction {
  NORTH, SOUTH, EAST, WEST;
  
  public static Direction resolve(String input) {
    switch (input.toLowercase()) {
      case "up":
      case "north":
        return Direction.NORTH;
        break;
      case "down":
      case "south":
        return Direction.SOUTH;
        break;
      case "right":
      case "east":
        return Direction.EAST;
        break;
      case "left":
      case "west":
        return Direction.WEST;
        break;
      default:
        return null;
      }
   }
   
}
