package Control.Command;
// Obs
import Model.Personagem;

public class Atacar implements Command {

	private Personagem p;
	
	public Atacar(Personagem p) {
		this.p = p;
	}
	
	@Override
	public void execute() {
		p.atacar();
	}

    @Override
    public String toString() {
    	return "Atacar";
    }
}
