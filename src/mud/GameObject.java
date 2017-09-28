package mud;

/**
* GameObject is the root object for all model
* objects in the MUD. Model objects are not intended to be used by classes other than Game,
* so please refrain from using GameObject subclasses elsewhere.
*/
public abstract class GameObject {
	private String name;
	private String description;
	
	/**
	* Creates a new GameObject
	* @param name The display name of this object.
	* @param description The display description of this object.
	*/
	public GameObject(String name, String description) {
		this.name = name;
		this.description = description;
	}
	
	/**
	* Sets the name of this GameObject.
	* @param name The display name of this object
	*/
	public void setName(String newName) {
		assert newName != null;
		this.name = newName;
	}
	
	/**
	* Get the name of this GameObject.
	* @return The display name of this GameObject.
	*/	
	public String getName() {
		return this.name;
	}
	
	/** 
	* Sets the description of this GameObject.
	* The value passed into setDescription will be returned by
	* getDescription until setDescription is called again.
	* @param newDescription The display description to set.
	*/
	public void setDescription(String newDescription) {
		assert newDescription != null;
		this.description = newDescription;
	}
	/**
	* Get the description of this GameObject.
	* @return The display description of this object.
	*/
	public String getDescription() {
		return this.description;
	}
	
	
}
