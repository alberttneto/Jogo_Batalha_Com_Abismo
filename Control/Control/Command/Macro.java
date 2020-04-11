package Control.Command;

import java.util.ArrayList;

public class Macro {

	private ArrayList<Command> macro = new ArrayList<Command>();
	
	public void addMacro(Command c) {
		macro.add(c);
	}
	
	public void executeMacro() {
		for(Command c: macro) {
			c.execute();
		}
	}
}
