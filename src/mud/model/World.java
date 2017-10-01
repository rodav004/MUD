package mud.model;

public class World {
        /**
         * Represents the game world.
         * Currently this is an array of Room objects,
         * but that may change in the future. Therefore,
         * it is imperative that this field is not simply
         * exposed via a getter.
         */
	private Room[] world;
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
	private Character findCharacter(String charName) {
		assert charName != null;
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