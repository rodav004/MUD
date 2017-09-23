package mud;
import java.util.Scanner;

public class UserInterface {
	
	private static Scanner input;

	public static void main(String[] args) {
		
		Game.start();
		input = new Scanner(System.in);
		String start = "Hello! Your name is Bob and you are in the Nice Room.";
		System.out.println(start);
		String direction = input.nextLine();
		
		String r = Game.person.move(direction);
		System.out.println(r);
	
	}

}
