package mud;
import java.util.List;
import java.util.ArrayList;
public class Player extends Character {
	public Player(String name, String description, Room location, List<Item> inventory) {
                super(name, description,location,inventory);
        }
        public Player(String name, String description, Room location) {
                super(name, description, location, new ArrayList<Item>());
        }

}
