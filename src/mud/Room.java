package mud;
import java.util.ArrayList;

public class Room extends GameObject {
	ArrayList<Item> items;
	ArrayList<Character> characters;
	Door[] doors;
	
	public Room(String name, String description, ArrayList<Item> items, ArrayList<Character> characters,Door[] doors) {
		this.name = name;
		this.description = description;
		this.items = items;
		this.characters = characters;
		this.doors = doors;
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
