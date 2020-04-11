package Control.Command;

import java.util.ArrayList;

public class Controle{

	private Command[] c = new Command[9];
	private ArrayList<Command> log = new ArrayList<Command>();
	
	// Armazena comando
	public void setCommand(Command co, int i) {
		this.c[i] = co;
	}
	
	// Executa comando especifico
	public void pressionar(int i) {
		this.c[i].execute();
		log.add(c[i]);
	}
	
	public void showLog() {
		for(Command c : log) {
			System.out.println(c.toString());
		}
	}
	
	public void executa(Command co) {
		co.execute();
		log.add(co);
	}
}
