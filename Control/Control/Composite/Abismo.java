package Control.Composite;
import Model.Personagem;

public class Abismo implements Fase_Jogo{

	@Override
	public int passarFase(Personagem p) {		
		return 1;
	}
	
	
}
