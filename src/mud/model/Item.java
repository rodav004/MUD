package mud.model;

/**
 * An inert object in the MUD.
 * Can be contained by a Room or owned by a Character,
 * though not both at the same time.
 */
class Item extends GameObject {

	public Item(String name, String description) {
		super(name, description);
	}
	
}