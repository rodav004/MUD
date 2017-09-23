package mud;

public class GameObject {
	String name;
	String description;
	
	public GameObject(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	/**
	* Sets the name of this GameObject
	*/
	public void setName(String newName) {
		this.name = newName;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}
	
	public String getDescription() {
		return this.description;
	}
	
	
}
