package mud;
import java.util.Scanner;

public class UserInterface {
	
	private static Scanner input;

	public static void main(String[] args) {
		Game game = new Game();
		game.start();

// 		String start = "Hello! Your name is Bob and you are in the Nice Room.";
// 		System.out.println(start);
// 		input = new Scanner(System.in);
// 		String direction = input.next();
// 		direction = direction.toString();
// 		String r = Game.person.move(direction);
// 		System.out.println(r);
		
		//creating a new charcater hopefully
		input = new Scanner(System.in);
		System.out.println("What is your name?");
		String name = input.nextLine();
		
		boolean success = game.newPlayer(name, "You have no description yet", "Nice Room");
	
		assert success; //Not sure what to do if player creation fails. For now let's just kill ourselves…
			
		System.out.println("Hello " + name + "! You are in " + "Nice Room");
		
		System.out.println("Enter command:"); //for example "move west"	
		Command cmd = Parser.parse(input.nextLine());
		assert cmd != null; //Again, not sure what we should do if parsing fails…
		
		String output = game.performCommand(name,cmd);
		System.out.println(output);		
	}

}
