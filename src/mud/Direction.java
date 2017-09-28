package mud;

public enum Direction {
  	NORTH, SOUTH, EAST, WEST;
  
	public static final int count = Direction.values().length;
        /**
         * A unique int representing the value of this enum value.
         * Primarily intended to be used to subscript the array of Door objects
         * each room contains, this value can conceivably be used for other things.
         * @return An int unique to the enum value. Please keep in mind that this int
         * is only guaranteed to be unique to the enum value it is obtained from, and that this
         * method may only return the same int for a given Direction within a single run of the application.
         * As such, please do not use the return value of this method for anything involving persistance.
         */
	public int index() {
		return this.ordinal();
	}
	/**
         * Maps an input String to a Direction value.
         * This method is intended to be where synonymous inputs
         * are mapped to a single Direction.
         * @param input The input, typically from the end user. Should not be null.
         * @return A Direction value, or null if unable to map input to a Direction.
         */
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
