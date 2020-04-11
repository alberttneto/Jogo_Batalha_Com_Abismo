package Model.Decorator;

import Model.Strategy.Atacar;

public class Poder_Fogo extends AtaqueDecorador{

	public Poder_Fogo(Atacar ataqueDecorado) {
		super(ataqueDecorado);
		setDano(5);
		setDescricao("Poder Fogo");
	}

}
