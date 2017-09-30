package mud;
import java.util.ArrayList;
import java.util.List;

/**
 * An abstract class that represents a character in the game's model.
 * As it is abstract, this class cannot be instantiated. Consider using
 * Player or Mob, or create your own subclass.
 */
public abstract class Character extends GameObject {
        /**
         * Gets the Room this Character is in.
         * This method should not be called by classes other
         * than Game. In a formal project, this would be enforced using
         * multiple packages, but for now just avoid using it in places like UserInterface.
         */
        public Room getLocation() {
		return this.location;
	}
        /**
         * Sets the Room this Character is in.
         * Not a public method.
         */
	private void setLocation(Room theRoom) {
		assert theRoom != null : "Parameter 'theRoom' should not be null!";

		/*
		 * Note that the location field of this object
		 * must be null before attempting to call Room.add/removeCharacters
		 * or else an assertion will fail.
		 */
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
	
	/**
         * Creates a new Chracter with the supplied parameters. This is
         * the primary constructor of Character; all other constructors are convenince.
         */
	public Character(String name, String description, Room location, List<Item> inventory) {
		super(name, description);
		setLocation(location);
		this.inventory = inventory;
	}
        /**
         * Creates a new Character. Equivalent to passing an empty list to the inventory parameter
         * of the primary constructor.
         */
	public Character(String name, String description, Room location) {
		this(name, description, location, new ArrayList<Item>());
	}
        /**
         * Gets a description of this Character's inventory.
         * @return A list of Strings representing the names of the Item objects in this Character's inventory.
         */
	public List<String> getItems() {
		List<String> itemNames = new ArrayList<>();
		for (Item item : this.inventory) {
			itemNames.add(item.getName());
		}
		return itemNames;
	}
	
	//add an item to a person's inventory
 	public String addItem(Item item) {
		assert item != null : "Parameter 'item' should not be null!";

		String result = null;

		String name = item.getName();
		Item foundItem = location.removeItem(name);
  		if (foundItem != null) {
  			inventory.add(item);
			result = "The item " + name + " is now in your inventory. The description is " + item.getDescription();
 		}
 		else {
 			result = "That item is not in this room.";
 		}
		
		return result;
 	}
	
	//remove an item from a person's inventory
	public String removeItem(Item item){
		assert item != null : "Parameter 'item' should not be null!";

		String result = null;

		String name = item.getName();
		for (Item itemX : inventory) {
			if (itemX.getName().equals(name)) {
				location.addItem(item);
				inventory.remove(item);
				result = "The item " + name + " is now in the room " + location.getName() + ".";
			}
			else {
				result = "That item is not in your inventory.";
			}
		}
		return result;
	}
        /**
         * Move this character in a direction.
         * @param direction A String representing the direction to move the Character in.
         * @return A String representing the result of this method, suitable for display to the end user.
         */
	public String move(String direction) {
		assert direction != null : "Parameter 'direction' should not be null!";
		assert location != null : "Character isn't in a room yet!";
	
		Direction theDirection = Direction.resolve(direction);
		if (theDirection == null) {
		     return "Sorry, that is not a valid direction!"; 
		}
		
		Door exit = location.getDoor(theDirection);
		if (exit != null) {
			setLocation(exit.room);
			return "You are in the " + location.getName() + ". "+ location.getDescription();
		}
		else {
			return "There is not a door in that direction!";
		}
	}
}
