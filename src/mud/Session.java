package mud.model;

public class Session {
	public Session(int sessionID, Character user) {
		this.sessionID = sessionID;
		this.user = user;
	}
	public final int sessionID;
	protected Character user;

	public void setDescription(String description) {
		assert description != null : "Parameter 'description' should not be null!";
		user.setDescription(description);
	}
}
