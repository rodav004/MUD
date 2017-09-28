package mud;

import java.util.Locale;
import java.util.Optional;

/**
 *
 * @author michaelsavich
 */
public enum Action {
    MOVE,
    TAKE,
    ATTACK,
    EXIT;
    
    public static Action resolve(String str) {
	 Action result;
	 switch (str.toUpperCase(Locale.ROOT)) {
	     case "MOVE":
		  result = Action.MOVE;
		  break;
	     case "TAKE":
		  result = Action.TAKE;
		  break;
	     case "ATTACK":
		  result = Action.ATTACK;
		  break;
	     case "EXIT":
	          result = Action.EXIT;
                  break; 
	     default:
		  result = null;
		  break;
	 }
	return result;	 
    }
}


