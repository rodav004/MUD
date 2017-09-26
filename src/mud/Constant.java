package mud;

	public class Constant {

	  public static int northIndex = 0;
	  public static int eastIndex = 1;
	  public static int southIndex  = 2;
	  public static int westIndex  = 3;
		

	  public static indexForDirection(Direction d) {
	    switch (d) {
              case NORTH: 
	        return Constant.northIndex;
	        break;
	      case SOUTH:
	        return Constant.southIndex;
	        break;	
	      case EAST:
	        return Constant.eastIndex;
	        break;
	      case WEST:
	        return Constant.westIndex;
	        break;
	      default:
	        throw new AssertionErrorException();
	  }

	}

