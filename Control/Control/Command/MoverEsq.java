package Control.Command;

import Model.Personagem;

public class MoverEsq implements Command {

	private Personagem p;
	
	public MoverEsq(Personagem p) {
		this.p = p;
	}
	
	@Override
	public void execute() {
		p.moverEsq();
	}
	
    @Override
    public String toString() {
    	return "Mover Esquerda";
    }

}
