package mud;
import java.util.List;
import java.util.ArrayList;

public class Proto {
    /**
     * An enum for mass-producing Item objects.
     * To make a new Item, first add its name to the
     * enum. Then, in the make() method, where it says switch(this),
     * add a case for the enum value you added. In that case, return the
     * you want the enum value to represent/create.
     */
    enum Items {
        TORCH, APPLE, ROCK, PEN;
        
        public Proto.Description make() {
            switch(this) {
                case TORCH: return new Proto.Description("torch","This is a burning stick.");
                case APPLE: return new Proto.Description("apple","A yummy red fruit.");
                case ROCK:  return new Proto.Description("rock","It's grayish and hard.");
                case PEN:   return new Proto.Description("pen","Useful for writing.");
            }
            throw new AssertionError("Could not create an Item for " + this.name() + "!");
        }
        
        /**
         * A convenience method for making Item objects
         * for each Items value in an Array.
         * @param theItems An array of Items values that you want made.
         * @return A list of Item objects corresponding to the input.
         */
        public static List<Proto.Description> make(Items[] theItems) {
            List<Proto.Description> result = new ArrayList<>();
            for (Items theItem : theItems) {
                result.add(theItem.make());
            }
            return result;
        }
        
    }
    
    /**
     * A tuple combining a name
     * and a description.
     */
    public static class Description {
        public Description(String name, String description) {
            this.name = name;
            this.description = description;
        }
        public final String name;
        public final String description;
    }
}