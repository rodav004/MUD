package mud;

public class OurWorld extends mud.model.World {

	public OurWorld() {
		newRoom("Nice Room", "This is a nice room.");
		addItem("Nice Room", Proto.Items.APPLE.make());

		newRoom("Okay Room", "This is an okay room.");
		addItem("Okay Room", Proto.Items.ROCK.make());
	}

	public boolean[] addItems(String roomName, Proto.Items... theItems) {
		boolean[] results = new boolean[theItems.length];

		for (int i = 0; i < theItems.length; i++) {
			results[i] = addItem(roomName, theItems[i].make());
		}
		return results;
	}
	public boolean addItem(String roomName, Description desc) {
		return addItem(roomName, desc.name, desc.description);
	}

}
