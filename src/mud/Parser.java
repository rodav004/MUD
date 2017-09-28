package mud;

import java.util.Arrays;
import java.util.List;

/**
 * A class for parsing Command objects from user input.
 *
 */
public class Parser {
    /*
    * The parse method returns a Command object.
    * @param An input string representing the user's input.
    * @return A Command object that was parsed from input, or null
    * if nothing could be parsed.
    */
    public static Command parse(String input) {
	 Command result;
	 List<String> splitStrings = Arrays.asList(input.split(" "));
	 
	 try {
	     String first  = splitStrings.get(0);
	     Action action = Action.resolve(first);
	     if (action == null) {
		throw new ParserFailureException();
	     }
	     
             if (action == Action.EXIT) {
		 System.out.println("You have ended the game");
		 System.exit(0);
	     }
	     
	     if (splitStrings.size() < 2) {
		throw new ParserFailureException();
	     }
	     String target = splitStrings.get(1);
	     result = new Command(action, target);
	 }
	 catch (ParserFailureException e) {
	     result = null;
	 }
	 
	 return result;
    }
}

class ParserFailureException extends Exception {}
