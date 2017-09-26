/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tres_caballeros.mud;

/**
 *
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
