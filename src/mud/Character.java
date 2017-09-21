package mud;
import java.util.List;

public class Character extends GameObject {
	Room location;
	List<Item> inventory;
	
	public Character(String name, String description, Room location, List<Item> inventory) {
		super(name, description);
		this.location = location;
		this.inventory = inventory;
	}
	
	/** 
	* Retrieve the items objects in this Character's inventory.
	* @return A list of the names in this character's inventory.
	*/
	public List<String> getItems() {
		throw new UnsupportedOperationException();
	}
	
	/**
	* Moves the character.
	* @param direction The direction to move the player in, for example, "North".
	* @return A String describing the result of the move, for example, "Can't move North!".
	*/
	public String move(String direction) {
		throw new UnsupportedOperationException();
	}
	
	
}
