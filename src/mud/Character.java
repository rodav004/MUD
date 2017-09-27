package mud;
import java.util.ArrayList;
import java.util.List;

public abstract class Character extends GameObject {
        public Room getLocation() {
		return this.location;
	}
	public void setLocation(Room theRoom) {
		assert theRoom != null;
                if (location != null) {
			Room lastLocation = location;
			location = null;
			lastLocation.removeCharacters(this);
		}

                theRoom.addCharacters(this);
		location = theRoom;
	}
	private Room location;
	private List<Item> inventory;
	
	public Character(String name, String description, Room location, List<Item> inventory) {
		super(name, description);
		setLocation(location);	
		this.inventory = inventory;
	}
	public Character(String name, String description, Room location) {
		this(name, description, location, new ArrayList<Item>());
	}

	public List<String> getItems() {
		List<String> itemNames = new ArrayList<>();
		for (Item item : this.inventory) {
			itemNames.add(item.name);
		}
		return itemNames;
	}
	
	//add an item to a person's inventory
 	/*public String addItem(String item){
 	/*public String addItem(String item) {
 		String result = null;
  		ArrayList<Item> roomItems = location.getItems();
  		for (Item roomItems: itemX) {
  			if (itemX.equal(item))
  				inventory.add(item);
  				roomItems.remove(item);
 				result = "The item " + item " is now in your inventory. The description is " + item.getDescription();
 			else 
 				result = "That item is not in this room."
  		}
 	}
 		return result;
 	} */
  	
	//this IS working! hooray!
	public String move(String direction) {
		assert location != null : "Character isn't in a room yet!";
	
		Direction theDirection = Direction.resolve(direction);
		if (theDirection == null) {
		     return "Sorry, that is not a valid direction!"; 
		}
		
		Door exit = location.getDoor(theDirection);
		if (exit != null) {
			setLocation(exit.room);
			return "You are in the " + exit.room.getName() + ". "+ exit.room.getName();
		}
		else {
			return "There is not a door in that direction";
		}

	}


}
