package mud;
import java.util.ArrayList;

public class Game {
	
	public static void start() {
		
		Item torch = new Item("torch","This is a burning stick.");
		Item apple = new Item("apple","A yummy red fruit.");
		
		ArrayList<Item> items = new ArrayList<>();
			items.add(apple);
			items.add(torch);
			
		ArrayList<Item> inventory = new ArrayList<>();
		
		ArrayList<Character> people = new ArrayList<>();
		
		ArrayList<Door> doors = new ArrayList<>();
		
			
		Room room1 = new Room("Nice room","This is a nice room.",items,people,doors);
		Character person = new Character("Bob","Bob has brown hair.",room1,inventory);
		
		people.add(person);
	}

}
