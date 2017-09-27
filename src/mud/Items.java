package mud;

import java.util.List;
import java.util.ArrayList;

public enum Items {
    TORCH, APPLE, ROCK, PEN;
    
    public Item make() {
        switch(this) {
        case TORCH: return new Item("torch","This is a burning stick.");
        case APPLE: return new Item("apple","A yummy red fruit.");    
        case ROCK:  return new Item("rock","It's grayish and hard.");
        case PEN:   return new Item("pen","Useful for writing.");
        }
        throw new AssertionError("Could not create an Item for " + this.name() + "!"); 
    }
    
    public static List<Item> make(Items[] theItems) {
        List<Item> result = new ArrayList<>();
        for (Items theItem : theItems) {
            result.add(theItem.make());
        }
        return result;
    }
    
}
