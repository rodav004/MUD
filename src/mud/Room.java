package mud;
import java.util.List;
import java.util.ArrayList;

public class Room extends GameObject {
	private List<Item> items;
	private List<Character> characters;
	private Door[] doors;
	
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
	
	public Room(String name, String description, Items[] items, List<Character> characters,Door[] doors) {
		this(name,description,Items.make(items),characters,doors);
	}
	
	public void setDoor(Door door, Direction doorDirection) {
		doors[doorDirection.index()] = door;
	}
	public Door getDoor(Direction doorDirection) {
		return doors[doorDirection.index()];
	}

	public boolean containsCharacter(Character theCharacter) {
		return this.characters.contains(theCharacter);
	}
	
	public void populate(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			theCharacter.moveTo(this);
		}
	}	
	
	public void addCharacters(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			assert theCharacter.getLocation() == null : "Can't add character currently in a room!";
			characters.add(theCharacter);
		}
	}
	public void removeCharacters(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			assert theCharacter.getLocation() == null : "Can't remove character currently in a room!";
			characters.remove(theCharacter);
		}
	}
}
