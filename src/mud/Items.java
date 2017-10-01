package mud;
import java.util.List;
import java.util.ArrayList;

/**
* An enum for mass-producing Item objects.
* To make a new Item, first add its name to the
* enum. Then, in the make() method, where it says switch(this),
* add a case for the enum value you added. In that case, return the 
* you want the enum value to represent/create.
*/
public enum Items {
    TORCH, APPLE, ROCK, PEN;
    
    public Description make() {
        switch(this) {
        case TORCH: return new Description("torch","This is a burning stick.");
        case APPLE: return new Description("apple","A yummy red fruit.");    
        case ROCK:  return new Description("rock","It's grayish and hard.");
        case PEN:   return new Description("pen","Useful for writing.");
        }
        throw new AssertionError("Could not create an Item for " + this.name() + "!"); 
    }

    /**
    * A convenience method for making Item objects
    * for each Items value in an Array.
    * @param theItems An array of Items values that you want made.
    * @return A list of Item objects corresponding to the input.
    */   
    public static List<Description> make(Items[] theItems) {
        List<Description> result = new ArrayList<>();
        for (Items theItem : theItems) {
            result.add(theItem.make());
        }
        return result;
    }
    
}
