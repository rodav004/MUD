package mud;

	public class Constant {

	  public static int northIndex = 0;
	  public static int eastIndex = 1;
	  public static int southIndex  = 2;
	  public static int westIndex  = 3;
		

	  public static int indexForDirection(Direction d) {
	    switch (d) {
              case NORTH: 
	        return Constant.northIndex;
	      case SOUTH:
	        return Constant.southIndex;
	      case EAST:
	        return Constant.eastIndex;
	      case WEST:
	        return Constant.westIndex;
	      default:
	        throw new AssertionError();
	  }

	}
}
