package mud;

public class OurWorld extends mud.model.World {

	public OurWorld() {
		newRoom("Nice Room", "This is a nice room.");
		addItems("Nice Room", Proto.Items.APPLE, Proto.Items.TORCH);

		newRoom("Okay Room", "This is an okay room.");
		addItems("Okay Room", Proto.Items.ROCK, Proto.Items.PEN);
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
