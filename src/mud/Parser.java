/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tres_caballeros.mud;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

/**
 *
 * @author michaelsavich
 */
public class Parser {
    
    public static Optional<Command> parse(String input) {
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
	 
	 return Optional.ofNullable(result);
    }
}

class ParserFailureException extends Exception {}
