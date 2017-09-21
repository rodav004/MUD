package mud;

public class Room extends GameObject {
	Item[] items;
	Character[] characters;
	Door[] doors;
	
	public Room(String name, String description, Item[] items, Character[] characters, Door[] doors) {
		super(name, description);
		this.items = items;
		this.characters = characters;
		this.doors = doors;
	}

}
