package mud;
import java.util.List;
import java.util.ArrayList;
public class Mob extends Character {
	public Mob(String name, String description, Room location, List<Item> inventory) {
		super(name, description,location,inventory);
	}
	public Mob(String name, String description, Room location) {
		super(name, description, location, new ArrayList<Item>());
	}
}
