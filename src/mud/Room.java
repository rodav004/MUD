package mud;
import java.util.ArrayList;

public class Room extends GameObject {
	ArrayList<Item> items;
	ArrayList<Character> characters;
	
	/*
	* For example, to set the northern door, 
	* write "doors[Direction.NORTH.ordinal()] = someDoor;"
	*/
	Door[] doors;
	
	public Room(String name, String description, ArrayList<Item> items, ArrayList<Character> characters,Door[] doors) {
		this.name = name;
		this.description = description;
		this.items = items;
		this.characters = characters;
		this.doors = doors;
	}
}
