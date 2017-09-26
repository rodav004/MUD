package mud;
import java.util.ArrayList;

public class Game {
	public static Character person;
	public static Room room1;
	
	public static void start() {
		
		// Room 1
		
		// Room 1 items
		Item torch = new Item("torch","This is a burning stick.");
		Item apple = new Item("apple","A yummy red fruit.");
		
		//Room 1 attributes
		ArrayList<Item> itemsRoom1 = new ArrayList<>();
			itemsRoom1.add(apple);
			itemsRoom1.add(torch);
		ArrayList<Character> peopleRoom1 = new ArrayList<>();
		Door[] doorsRoom1 = {null,null,null,null};
		
		//Room 1 constructed
		Room room1 = new Room("Nice Room","This is a nice room.",itemsRoom1,peopleRoom1,doorsRoom1);
		
		//Character Inventory
		ArrayList<Item> inventory = new ArrayList<>();
		
		//Character constructed
		person = new Character("Bob","Bob has brown hair.",room1,inventory);
		
		//Character put in room
		peopleRoom1.add(person);
		
		//Room 2
		
		//Room 2 Items
		Item rock = new Item("rock","It's grayish and hard.");
		Item pen = new Item("pen","Useful for writing.");
		
		//Room 2 attributes
		ArrayList<Item> itemsRoom2 = new ArrayList<>();
			itemsRoom2.add(rock);
			itemsRoom2.add(pen);
		ArrayList<Character> peopleRoom2 = new ArrayList<>();
		Door[] doorsRoom2 = {null,null,null,null};
		
		//Room 2 constructed
		Room room2 = new Room("Okay Room","This room is okay.",itemsRoom2,peopleRoom2,doorsRoom2);
		
		//Construct a door
		Door door1 = new Door(room2);
		Door door2 = new Door(room1);
		
		//Assign doors to rooms
		doorsRoom1[2] = door1;
		doorsRoom2[0] = door2;
		
		
	}
	


}
