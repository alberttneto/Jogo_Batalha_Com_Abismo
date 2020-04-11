package Control.Command;
import Model.*;


public class MoverBaixo implements Command {

	private Personagem p;
	
	public MoverBaixo(Personagem p) {
		this.p = p;
	}
	
	@Override
	public void execute() {
		p.moverBaixo();
	}
	
    @Override
    public String toString() {
    	return "Mover baixo";
    }

}
