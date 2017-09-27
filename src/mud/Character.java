package mud;
import java.util.ArrayList;
import java.util.List;

public class Character extends GameObject {
	private Room location;
	private List<Item> inventory;
	
	public Character(String name, String description, Room location, List<Item> inventory) {
		super(name, description);
		this.location = location;
		this.inventory = inventory;
	}
	public Character(String name, String description, Room location) {
		this(name, description, location, new ArrayList<Item>());
	}
	public Character(String name, String description) {
		this(name,description,null);
	}
	
	
	public List<String> getItems() {
		List<String> itemNames = new ArrayList<>();
		for (Item item : this.inventory) {
			itemNames.add(item.name);
		}
		return itemNames;
	}
	
	//add an item to a person's inventory
 -	/*public String addItem(String item){
 +	/*public String addItem(String item) {
 +		String result = null;
  		ArrayList<Item> roomItems = location.getItems();
  		for (Item roomItems: itemX) {
  			if (itemX.equal(item))
  				inventory.add(item);
  				roomItems.remove(item);
 +				result = "The item " + item " is now in your inventory. The description is " + item.getDescription();
 +			else 
 +				result = "That item is not in this room."
  		}
 -	}
 +		return result;
 +	} */
  	
	//this IS working! hooray!
	public String move(String direction) {
		assert location != null : "Character isn't in a room yet!"
	
		Direction theDirection = Direction.resolve(direction);
		if (theDirection == null) {
		     return "Sorry, that is not a valid direction!"; 
		}
		
		Door exit = location.getDoor(theDirection);
		
		return exit != null ? moveTo(exit.room) : "There is not a door in that direction!";
	}

	public String moveTo(Room theRoom) {
		assert theRoom != null;
		if (location != null) {
			location.removeCharacters(this);
		}
		location = theRoom;
		location.addCharacters(this);
		return "You are in the " + theRoom.name + ". "+ theRoom.description;
	}	

}
