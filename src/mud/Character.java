package mud;
import java.util.ArrayList;

public class Character extends GameObject {
	Room location;
	ArrayList<Item> inventory;
	
	public Character(String name, String description, Room location, ArrayList<Item> inventory) {
		this.description = description;
		this.name = name;
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
 -	/*public String addItem(String item){
 +	/*public String addItem(String item) {
 +		Strint result = null;
  		ArrayList<Item> roomItems = location.getItems();
  		for (Item roomItems: itemX) {
  			if (itemX.equal(item))
  				inventory.add(item);
  				roomItems.remove(item);
 +				result = "The item " + item " is now in your inventory. The description is " + item.getDescription();
 +			else 
 +				result = "The item is not in this room"
  		}
 -	}*/
 +		return result;
 +	} */
  	
	
	//This isn't working right yet
	public String move(String direction) {
		
		Direction theDirection = Direction.resolve(direction);
		if (theDirection == null) {
		     return "Sorry, that is not a valid direction!"; 
		}
		int theIndex = Constant.indexForDirection(theDirection);
		
		Door exit = location.doors[theIndex];
	        if (exit != null) {
		     this.location = exit.room;
		     return "You are in the " + exit.room.name + ". "+ exit.room.description;
		}
		else {
		     return "There is not a door in that direction!";
		}
	}
	
	
}
