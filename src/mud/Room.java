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
	
	public void populate(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			theCharacter.moveTo(this);
		}
	}
	
	//Ideally, only Character.moveTo() should call Room.addCharacters() and Room.removeCharacters().
	public void addCharacters(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			if (characters.contains(theCharacter)) {
				throw new AssertionError("Tried to add a character to a room a second time!");
			}
			characters.add(theCharacter);
		}
	}
	public void removeCharacters(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			characters.remove(theCharacter);
		}
	}
}
