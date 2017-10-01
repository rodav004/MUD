package mud.model;
import java.util.List;
import java.util.ArrayList;
public class World {
        /**
         * Represents the game world.
         * Currently this is an array of Room objects,
         * but that may change in the future. Therefore,
         * it is imperative that this field is not simply
         * exposed via a getter.
         */
	private List<Room> world = new ArrayList<>();
        /**
         * Creates a new player in the game's world. Since the Character class needs to be initialized
         * with a location, and the Room class shouldn't be exposed to UserInterface if at all possible,
         * it would be inappropriate to place a Character directly in a Room. Instead, use this method to
         * create a Player with the supplied parameters.
         * @param newName The name to give the new Player. Should not be null.
         * @param newDescription The description to give the new Player. Should not be null.
         * @param startingRoomName The name of the room to put the player in. If this value cannot be mapped to a
         * Room in the Game, this method will fail. Should not be null.
         * @return A reference to the created object.
         */
	public Object newPlayer(String newName, String newDescription, String startingRoomName) {
		assert newName != null; assert newDescription != null; assert startingRoomName != null;
		assert world != null;
		
		if (findCharacter(newName) != null) {
			return null;
		}

		Room startingRoom = findRoom(startingRoomName);
		
		if (startingRoom == null) {
			return null;
		}
		
		Player p = new Player(newName, newDescription, startingRoom);
		return p;	
	}
	
	public boolean newRoom(String roomName, String roomDescription) {
		if (findRoom(roomName) != null) {
			return false;
		}
		world.add(new Room(roomName, roomDescription, null, null, null));
		return true;
	}

	public boolean addItem(String roomName, String itemName, String itemDescription) {
		Room theRoom = findRoom(roomName);
		if (theRoom == null) {
			return false;
		}
		theRoom.addItem(new Item(itemName,itemDescription));
		return true;
	}
	
	public boolean characterExists(String charName) {
		assert charName != null : "Parameter 'charName' should not be null!";
		return findCharacter(charName) != null;
	}
	
	public String moveCharacter(Object charRef, String direction) {
		return moveCharacter((Character) charRef, direction);
	}

	private String moveCharacter(Character character, String direction) {
		return character.move(direction);
	}

	public String locationOfCharacter(String charName) {
		assert charName != null : "Parameter 'charName' should not be null!";

		String result = null;
		Character theCharacter = findCharacter(charName);
		if (theCharacter != null) {
			result = theCharacter.getLocation().getName();
		}
		return result;
	}

	public String[] nearbyItems(Object charRef) {
		return getNearbyItems( (Character) charRef);
	}
	private String[] nearbyItems(Character theCharacter) {
		return theCharacter.getLocation().getItems();
	}

	public String nearbyDescription(Object charRef) {
		return nearByDescription((Character) charRef);
	}

	private String nearbyDescription(Character theCharacter) {
		return theCharacter.getLocation().getDescription();
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
