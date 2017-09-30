package mud;
import mud.model.*;

/**
 * Represents the game. Contains the model as
 * well as logic for interacting with said model.
 */
public class Game {
        /**
         * Represents the game world.
         * Currently this is an array of Room objects,
         * but that may change in the future. Therefore,
         * it is imperative that this field is not simply
         * exposed via a getter.
         */
	private Room[] world;
        
        /**
         * Starts the game. Many other methods on Game will fail
         * if this method hasn't been called first, so call start as soon as you create
         * an object of type Game.
         */
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
        /**
         * Attempts to perform a Command with the specified user and Command.
         * @param userName The name of the Player. It is assumed that no two Player objects
         * will have the same name. How this method maps the userName to a Player is considered an
         * implementation detail. Should not be null.
         * @param cmd The command to execute. This method will attempt to perform the specified action
         * using the Player and the Command's target, but it may fail if the command's target cannot be mapped
         * to an object in the game world. Should not be null.
         * @return A String describing the result of the action taken. This String is intended to be printed directly
         * to the end user's console.
         */
	public String performCommand(String userName, Command cmd) {
		assert userName != null; assert cmd != null;
		String result = null;

		mud.model.Character user = findCharacter(userName);
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
			case EXIT:
				System.exit(0);
			default:
				result = "Could not parse command!";
				break;
		}
		assert result != null;

		return result;
	}
        /**
         * Creates a new player in the game's world. Since the Character class needs to be initialized
         * with a location, and the Room class shouldn't be exposed to UserInterface if at all possible,
         * it would be inappropriate to place a Character directly in a Room. Instead, use this method to
         * create a Player with the supplied parameters.
         * @param newName The name to give the new Player. Should not be null.
         * @param newDescription The description to give the new Player. Should not be null.
         * @param startingRoomName The name of the room to put the player in. If this value cannot be mapped to a
         * Room in the Game, this method will fail. Should not be null.
         * @return A boolean representing whether the Player was successfully created.
         */
	public boolean newPlayer(String newName, String newDescription, String startingRoomName) {
		assert newName != null; assert newDescription != null; assert startingRoomName != null;
		assert world != null;
		
		Room startingRoom = findRoom(startingRoomName);
		
		if (startingRoom == null) {
			return false;
		}
		
		Player p = new Player(newName, newDescription, startingRoom);
		return true;	
	}
        /**
         * Finds a Room with a given name within the model.
         * This method is private and should not be used by other classes,
         * as that would expose the Room class.
         * @param roomName The name of the Room to find. Should not be null.
         * @return The found Room, or null if no Room was found.
         */
	private Room findRoom(String roomName) {
		assert roomName != null;
		assert world != null;
		for (Room aRoom : world) {
			if (aRoom.getName().equals(roomName)) {
				return aRoom;
			}
		}
		return null;
	}
        /**
         * Finds a Character with a given name within the model.
         * This method is private and should not be used by other classes,
         * as that would expose the Character class.
         * @param charName The name of the Character to find. Should not be null.
         * @return The found Character, or null if no Character was found.
         */
	private mud.model.Character findCharacter(String charName) {
		assert charName != null;
		assert world != null;

		mud.model.Character result = null;
		for (Room aRoom : world) {
			result = aRoom.findCharacter(charName);
			if (result != null) {
				break;
			}
		}
		return result;
	}
}
