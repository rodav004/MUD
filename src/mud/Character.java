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
	
	//This isn't working right yet
	public String move(String direction) {
		String newRoom = null;
		
		if (direction == "north" || direction == "up") {
			Door exit = location.doors[0];
			if (exit != null) {
				newRoom = "You are in the " + exit.room2.name + ". "+ exit.room1.description;
				this.location = exit.room1;
			}
			else {newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction == "south" || direction == "down") {
			Door exit = location.doors[2];
			if (exit != null) {
				newRoom = "You are in the " + exit.room1.name + ". "+ exit.room2.description;
				this.location = exit.room1;
			}
			else {newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction == "east" || direction == "right") {
			Door exit = location.doors[1];
			if (exit != null) {
				newRoom = "You are in the " + exit.room1.name + ". "+ exit.room2.description;
				this.location = exit.room2;
			}
			else {newRoom = "There is not a door in that direction!";
			}
		}
		else if (direction == "west" || direction == "left") {
			Door exit = location.doors[3];
			if (exit != null) {
				newRoom = "You are in the " + exit.room1.name + ". "+ exit.room2.description;
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
