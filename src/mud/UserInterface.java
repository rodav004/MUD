package mud;
import java.util.Scanner;

public class UserInterface {
	
	public static void main(String[] args) {
		String start = "Set your name.";
		Scanner input = new Scanner(System.in);
		System.out.println(start);
		String name = input.nextLine();
		System.out.println("Great! Your name is " + name + ".");
	}

}
