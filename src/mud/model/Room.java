package mud.model;
import java.util.List;
import java.util.ArrayList;

/**
 * A discrete place within the MUD's model.
 * At its heart, a world in this MUD is simply a collection
 * of Room objects. Rooms can contain Items and Characters, though
 * Character objects also know what Room they are in and are the ones
 * primarily responsible for managing that relationship.
 */
class Room extends GameObject {
	private List<Item> items;
	private List<Character> characters;
	private Door[] doors;
	
	/**
	* Creates a new Room object. This is the primary constructor.
	* @param name The name of this Room.
	* @param description The description of this Room.
	* @param items The Item objects that this Room 'contains'.
	* @param characters The Character objects initially in this Room.
	* @param doors The exits to this room, as an array of Door objects, where each position in the array 
	* maps to a specific direction. The length of this array should be equal to the number of values in Direction. If
 	* there is no door in a certain direction, that position in the array should have a value of null.
	*/
	public Room(String name, String description, List<Item> items, List<Character> characters,Door[] doors) {
		super(name, description);
		this.items = items != null ? items : new ArrayList<>();
		this.characters = characters != null ? characters : new ArrayList<>();
		if (doors != null) {
			assert doors.length == Direction.count : "Creating Room with array of wrong size!!";
			this.doors = doors;
		}
		else {
			this.doors = new Door[Direction.count];
		}
	}

	/**
	* Installs a Door in a given Direction.
	* @param door The door to install.
	* @param doorDirection The direction this Door is set to. For
	* example, setting a Door in the NORTH direction means it is the Door
	* that a Character would reach if they moved NORTH within this Room.
	*/
	public void setDoor(Door door, Direction doorDirection) {
		assert door != null : "Parameter 'door' should not be null!";
		assert doorDirection != null : "Parameter 'doorDirection' should not be null!";

		doors[doorDirection.index()] = door;
	}
	/**
	* Gets the Door in a given Direction.
	* @param doorDirection The direction the Door you are looking for is in.
	* @return The Door in the supplied Direction, or null if there is no Door in that Direction.
	*/
	public Door getDoor(Direction doorDirection) {
		return doors[doorDirection.index()];
	}
	/**
	* Checks if a Character is located in this Room.
	* @return True if the supplied Character is within this Room,
	* or false otherwise.
	*/
	public boolean containsCharacter(Character theCharacter) {
		assert theCharacter != null : "Parameter 'theCharacter' should not be null!";

		return this.characters.contains(theCharacter);
	}
	/**
	* Adds the supplied Character objects to this Room.
	* Please avoid using this method directly. At the time of writing,
	* if assertions are enabled, and a supplied Character is in a location other null, the
	* MUD will crash. If assertions are disabled, then the ensuing behaviour will be undefined and
	* dependent on how well subsequent methods handle unexpected null values.
	* @param theCharacters A variable number of Character objects to add to this Room. It
	* is perfectly acceptable to supply one Character object if that is all that is needed.
	*/
	public void addCharacters(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			assert theCharacter.getLocation() == null : "Can't add character currently in a room!";
			characters.add(theCharacter);
		}
	}
	/**
	* Removes the supplied Character objects from this Room.
	* Please avoid using this method directly. At the time of writing,
	* if assertions are enabled, and a supplied Character is in a location other null, the
	* MUD will crash. If assertions are disabled, then the ensuing behaviour will be undefined and
	* dependent on how well subsequent methods handle unexpected null values.
	* @param theCharacters A variable number of Character objects to remove from this Room. It
	* is perfectly acceptable to supply one Character object if that is all that is needed.
	*/
	public void removeCharacters(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			assert theCharacter.getLocation() == null : "Can't remove character currently in a room!";
			characters.remove(theCharacter);
		}
	}
	/**
	* Finds a Character object with the given name.
	* @param charName The name of the Character to search for.
	* @return The Character found, or none if no Character with that
	* name is within this Room.
	*/
	public Character findCharacter(String charName) {
		assert charName != null : "Parameter 'charName' should not be null!";

		Character result = null;
		for (Character character : characters) {
			if (character.getName().equals(charName)) {
				result = character;
				break;
			}
		}
		return result;
	}
	/**
	* Gets the Items in the Room.
	* @return An array of the names of the Item objects in this Room.
	*/
	public String[] getItems() {
		return (String[]) items.toArray();
	}
	
	/**
	* Adds an Item to this Room.
	* @param item The Item to add.
	*/
	public void addItem(Item item) {
		assert item != null : "Parameter 'item' should not be null!";

		items.add(item);
	}
	/**
	* Attempts to remove the specified Item from this Room.
	* @param itemName The name of the Item you hope to remove.
	* @return The Item that was removed, or null if no Item was found.
	*/ 
	public Item removeItem(String itemName) {
		for (Item item : items) {
			if (item.getName().equals(itemName)) {
				items.remove(item);
				return item; //success
			}
		}
		return null; //failure
	}
}
