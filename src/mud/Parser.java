package mud;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 *
 * @author michaelsavich
 */
public class Parser {
    
    public static Command parse(String input) {
	 Command result;
	 List<String> splitStrings = Arrays.asList(input.split(" "));
	 
	 try {
	     if (splitStrings.size() < 2) {
		throw new ParserFailureException();
	     }
	     String first  = splitStrings.get(0);
	     Action action = Action.resolve(first);
	     if (action == null) {
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
