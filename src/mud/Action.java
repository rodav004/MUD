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
	ATTACK;
    
	public static Action resolve(String str) {
		Action result;
		switch (str.toUpperCase(Locale.ROOT)) {
		case "GO":
		case "TRAVEL":
		case "JOURNEY":
		case "VENTURE":
		case "WALK":
		case "RUN":
		case "DASH":
		case "SPINDASH":
		case "LOCOMOTE":
	     	case "MOVE":
			result = Action.MOVE;
			break;
		case "GET":
		case "PICK":
		case "ACQUIRE":
		case "PILFER":
		case "ASSIMILATE":
	     	case "TAKE":
			result = Action.TAKE;
		  	break;
		case "HIT":
		case "ASSAULT":
		case "DAMAGE":
		case "PUNCH":
		case "KICK":
		case "DESTROY":
	        case "ATTACK":
			result = Action.ATTACK;
		  	break;
	   	default:
			result = null;
			break;
	 	}
		return result;	 
	}
}


