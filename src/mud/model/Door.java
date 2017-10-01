package mud.model;
/**
 * A Door points to a Room.
 * Although it does not inherit from GameObject,
 * Door is considered to be a model class.
 */
public class Door {
	/**
	 * The Room this Door points to.
         * This is a public final field, so it cannot be modified.
	 */
	public final Room room;
	
	/**
	 * Creates a new Door that points to a room.
	 * @param room The room this Door points to.
	 */	
	public Door(Room room) {
		this.room = room;
	}
	
}
