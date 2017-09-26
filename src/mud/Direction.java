package mud;

public enum Direction {
  	NORTH, SOUTH, EAST, WEST;
  
	public static Direction resolve(String input) {
		Direction result;
		
		switch (input.toLowerCase()) {
		case "up":
		case "north":
			result = Direction.NORTH;
			break;
		case "down":
		case "south":
			result = Direction.SOUTH;
			break;
		case "right":
		case "east":
			result = Direction.EAST; 
			break;
		case "left":
		case "west":
			result = Direction.WEST;
			break;
		default:
			result = null;
			break;
		}
		
		return result;
	}
	
}
