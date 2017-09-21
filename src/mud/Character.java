package mud;
import java.util.List;

public class Character extends GameObject {
	Room location;
	List<Item> inventory;
	
	public Character(String name, String description, Room location, List<Item> inventory) {
		this.location = location;
		this.inventory = inventory;
	}
	
	public String getItems() {
		List<Item> items = this.inventory;
		for (Item item : items) {
			return item.name;
		}
	}
	
	/**
	* Moves the character.
	* @param direction The direction to move the player in, for example, "North".
	* @return A String describing the result of the move, for example, "Can't move North!".
	*/
	public String move(String direction) {
		return "hi";
	}
	
	
}
