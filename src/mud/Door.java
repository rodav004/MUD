package mud;

public class Door {
	
	public String getDirection() {
		return this.direction;
	}
	private final String direction;
	
	public Room getRoom() {
		return this.room;
	}
	private final Room room;

	public Door(Room room, String direction) {
		this.room = room;
	}
	
}
