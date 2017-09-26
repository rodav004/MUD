package mud;
import java.util.ArrayList;

public class Room extends GameObject {
	ArrayList<Item> items;
	ArrayList<Character> characters;
	Door[] doors;
	
	public Room(String name, String description, ArrayList<Item> items, ArrayList<Character> characters,Door[] doors) {
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
	
	public void setDoor(Door door, Direction doorDirection) {
		doors[doorDirection.ordinal()] = door;
	}
	public Door getDoor(Direction doorDirection) {
		return doors[doorDirection.ordinal()];
	}
	
	public void addCharacters(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			if (characters.contains(theCharacter)) {
				throw new AssertionError("Tried to add a character to a room a second time!");
			}
			characters.add(theCharacter);
		}
	}
	public void removeCharacter(Character ...theCharacters) {
		for (Character theCharacter : theCharacters) {
			characters.remove(theCharacter);
		}
	}
}
