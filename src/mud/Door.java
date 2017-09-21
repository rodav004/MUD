package mud;

public class Door {
	
	public String getDirection() {
		return this.direction;
	}
	String direction;
	
	public Room getRoom() {
		return this.room;
	}
	Room room;

	public Door(Room room, String direction) {
		this.room = room;
	}
	
}
