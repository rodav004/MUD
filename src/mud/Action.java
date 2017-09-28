package mud;

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
		switch (str.toUpperCase()) {
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


