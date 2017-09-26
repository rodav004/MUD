/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tres_caballeros.mud;

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
    
    public static Optional<Action> resolve(String str) {
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
	     default:
		  result = null;
		  break;
	 }
	 
	 return Optional.ofNullable(result);
    }
}


