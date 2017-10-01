package mud;

/**
 * Action is an enum that represents the concrete
 * actions that the MUD supports.
 */
public enum Action {
    MOVE,
    TAKE,
    ATTACK,
    LOOK,
    EXIT;
        
        /**
         * Maps an input String to an Action value.
         * This method is intended to be where synonymous inputs get mapped
         * to a single Action.
         * @param str The input String, typically from the end user.
         * @return An action corresponding to the input, or null if the input
         * couldn't be mapped to an Action.
         */
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
		case "OBSERVE":
		case "INSPECT":
		case "PEEP":
		case "VIEW":
		case "SEE":
		case "INVESTIGATE":
		case "LOOK":
			result = Action.LOOK;
			break;
		case "ABORT":
		case "QUIT":
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


