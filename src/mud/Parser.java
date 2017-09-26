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
	 
	 Supplier<ParserFailureException> fail = () -> new ParserFailureException();
	 try {
	     String first  = Safely.get(splitStrings, 0).orElseThrow(fail);
	     Action action = Action.resolve(first).orElseThrow(fail);
	     String target = Safely.get(splitStrings, 1).orElseThrow(fail);
	     result = new Command(action, target);
	 }
	 catch (ParserFailureException e) {
	     result = null;
	 }
	 
	 return result;
    }
}

class ParserFailureException extends Exception {}

/**
 * Provides static methods for performing various operations in an Optional-friendly manner
 * @author michaelsavich
 */
class Safely {
    public static <T> Optional<T> get(List<T> list, int index) {
	 T result;
	 try {
	     result = list.get(index);
	 }
	 catch (IndexOutOfBoundsException ex) {
	     result = null;
	 }
	 
	 return Optional.ofNullable(result);
    }
}
