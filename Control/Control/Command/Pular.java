package Control.Command;

import Model.Personagem;

public class Pular implements Command {

	private Personagem p;
	
	public Pular(Personagem p) {
		this.p = p;
	}
	
	@Override
	public void execute() {
		p.moverCima();
		p.moverCima();
	}
	
    @Override
    public String toString() {
    	return "Pular";
    }

}
