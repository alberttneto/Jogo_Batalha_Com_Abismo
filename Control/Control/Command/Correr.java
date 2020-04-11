package Control.Command;

import Model.Personagem;

public class Correr implements Command {

	private Personagem p;
	
	public Correr(Personagem p) {
		this.p = p;
	}
	
	@Override
	public void execute() {
		p.correr();
	}

    @Override
    public String toString() {
    	return "Correr";
    }
}
