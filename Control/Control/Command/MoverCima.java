package Control.Command;

import Model.Personagem;

public class MoverCima implements Command {

	private Personagem p;
	
	public MoverCima(Personagem p) {
		this.p = p;
	}
	
	@Override
	public void execute() {
		p.moverCima();
	}
	
    @Override
    public String toString() {
    	return "Mover Cima";
    }

}