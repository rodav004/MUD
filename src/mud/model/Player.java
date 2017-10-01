package mud.model;
import java.util.List;
import java.util.ArrayList;

/**
 * A Player is a human controlled
 * Character within the MUD.
 */
class Player extends Character {
	public Player(String name, String description, Room location, List<Item> inventory) {
                super(name, description,location,inventory);
        }
        public Player(String name, String description, Room location) {
                super(name, description, location, new ArrayList<Item>());
        }

}
