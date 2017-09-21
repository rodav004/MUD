package mud;

public class Room extends GameObject {
	List<Item> items;
	List<Character> characters;
	List<Door> doors;
	
	public Room(String name, String description, List<Item> items, List<Character> characters, List<Door> doors) {
		super(name, description);
		this.items = items;
		this.characters = characters;
		this.doors = doors;
	}

}
