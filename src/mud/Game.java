package mud;

public class Game {
	
	private Room[] world;

	public void start() {
		
		// Room 1
		
		// Room 1 items
		Items[] itemsRoom1 = { Items.TORCH, Items.APPLE };
		
		//Room 1 constructed
		Room room1 = new Room("Nice Room","This is a nice room.",itemsRoom1,null,null);
		
		//Player constructed
		
		//Player put in room
		
		//Room 2
		
		//Room 2 Items
		Items[] itemsRoom2 = { Items.ROCK, Items.PEN };
		
		//Room 2 constructed
		Room room2 = new Room("Okay Room","This room is okay.",itemsRoom2,null,null);
				
		//Assign doors to rooms
		room1.setDoor(new Door(room2), Direction.SOUTH);
		room2.setDoor(new Door(room1), Direction.NORTH);
		
		world = new Room[]{ room1, room2 };
		
	}
	
	public String performCommand(String userName, Command cmd) {
		String result = null;

		Character user = findCharacter(userName);
		Action act = cmd.getAction();
		if (user == null) { 
			return "Couldn't find user " + userName + "!"; 
		}
		
		switch (act) {
			case MOVE:
				result = user.move(cmd.getTarget());
				break;
			case TAKE:
				throw new UnsupportedOperationException("Take not yet implemented");
				// break;
			case ATTACK:
				throw new UnsupportedOperationException("Attack not yet implemented");
				// break;
			default:
				result = "Could not parse command!";
		}
		assert result != null;

		return result;
	}
	
	private Character findCharacter(String charName) {
		assert world != null;

		Character result = null;
		for (Room aRoom : world) {
			result = aRoom.findCharacter(charName);
			if (result != null) {
				break;
			}
		}
		return result;
	}
}
