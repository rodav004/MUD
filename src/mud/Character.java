package mud;
import java.util.ArrayList;

public class Character extends GameObject {
	Room location;
	ArrayList<Item> inventory;
	
	public Character(String name, String description, Room location, ArrayList<Item> inventory) {
		this.location = location;
		this.inventory = inventory;
	}
	
	public ArrayList<String> getItems() {
		ArrayList<Item> items = this.inventory;
		ArrayList<String> itemNames = new ArrayList<>();
		for (Item item : items) {
			itemNames.add(item.name);
		}
		return itemNames;
	}
	
	//add an item to a person's inventory
	/*public String addItem(String item) {
		Strint result = null;
		ArrayList<Item> roomItems = location.getItems();
		for (Item roomItems: itemX) {
			if (itemX.equal(item))
				inventory.add(item);
				roomItems.remove(item);
				result = "The item " + item " is now in your inventory. The description is " + item.getDescription();
			else 
				result = "The item is not in this room"
		}
		return result;
	} */
	
	//This isn't working right yet
	public String move(String direction) {
		String newRoom = null;
		
		if (direction.equals("north") || direction.equals("up")) {
			Door exit = location.doors[Constant.northIndex];
			if (exit != null) {
				newRoom = "You are in the " + exit.room1.name + ". "+ exit.room1.description;
				this.location = exit.room1;
			}
			else {newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction.equals("south") || direction.equals("down")) {
			Door exit = location.doors[Constant.southIndex];
			if (exit != null) {
				newRoom = "You are in the " + exit.room2.name + ". "+ exit.room2.description;
				this.location = exit.room2;
			}
			else {newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction.equals("east") || direction.equals("right")) {
			Door exit = location.doors[Constant.eastIndex];
			if (exit != null) {
				newRoom = "You are in the " + exit.room2.name + ". "+ exit.room2.description;
				this.location = exit.room2;
			}
			else {newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction.equals("west") || direction.equals("left")) {
			Door exit = location.doors[Constant.westIndex];
			if (exit != null) {
				newRoom = "You are in the " + exit.room1.name + ". "+ exit.room1.description;
				this.location = exit.room1;
			}
			else {newRoom = "There is not a door in that direction!";
			}
		}
		else{
			newRoom = "Sorry, that is not a valid direction!";
		}
		return newRoom;
	}
	
	
}
