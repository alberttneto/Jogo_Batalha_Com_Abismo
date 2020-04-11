package Control.Command;

import Model.Personagem;

public class MoverDir implements Command {

	private Personagem p;
	
	public MoverDir(Personagem p) {
		this.p = p;
	}
	
	@Override
	public void execute() {
		p.moverDir();
	}
	
    @Override
    public String toString() {
    	return "Mover Direita";
    }

}