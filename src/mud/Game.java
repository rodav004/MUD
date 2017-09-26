package mud;
import java.util.ArrayList;

public class Game {
	public void start() {
		
		// Room 1
		
		// Room 1 items
		Item torch = Items.TORCH.make();
		Item apple = Items.APPLE.make();
		
		//Room 1 attributes
		ArrayList<Item> itemsRoom1 = new ArrayList<>();
			itemsRoom1.add(apple);
			itemsRoom1.add(torch);	
		
		//Room 1 constructed
		Room room1 = new Room("Nice Room","This is a nice room.",itemsRoom1,null,null);
		
		//Character constructed
		Character bob = new Character("Bob","Bob has brown hair.",room1,new ArrayList<Item>());
		
		//Character put in room
		room1.addCharacters(bob);
		
		//Room 2
		
		//Room 2 Items
		Item rock = Items.ROCK.make();
		Item pen = Items.PEN.make();
		
		//Room 2 attributes
		ArrayList<Item> itemsRoom2 = new ArrayList<>();
			itemsRoom2.add(rock);
			itemsRoom2.add(pen);
		
		//Room 2 constructed
		Room room2 = new Room("Okay Room","This room is okay.",itemsRoom2,null,null);
				
		//Assign doors to rooms
		room1.setDoor(new Door(room2), Direction.SOUTH);
		room2.setDoor(new Door(room1), Direction.NORTH);
		
	}
}
