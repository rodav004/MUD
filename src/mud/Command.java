package mud;

/**
 * Command is basically a glorified tuple holding an Action and a String.
 * @author michaelsavich
 */
public class Command {
    
    public Command(Action action, String target) {
	 assert action != null; assert target != null;
	 this.action = action;
	 this.target = target;
    }
    
    public Action getAction() { 
	 return this.action;
    }
    private final Action action;
    
    public String getTarget() {
	 return this.target;
    }
    private final String target;

    
}
