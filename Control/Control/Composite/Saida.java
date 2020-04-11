package Control.Composite;

import Model.Personagem;

public class Saida implements Fase_Jogo{
	
	@Override
	public int passarFase(Personagem p) {		
		return 2;
	}
	

}
