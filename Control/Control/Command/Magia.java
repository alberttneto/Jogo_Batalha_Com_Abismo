package Control.Command;

import Model.Personagem;

public class Magia implements Command {

	private Personagem p;
	
	public Magia(Personagem p) {
		this.p = p;
	}
	
	@Override
	public void execute() {
		p.magia();
	}

    @Override
    public String toString() {
    	return "Magia";
    }

}
