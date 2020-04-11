package Model.Decorator;

import Model.Strategy.Atacar;

public class Poder_Gelo extends AtaqueDecorador{

	public Poder_Gelo(Atacar ataqueDecorado) {
		super(ataqueDecorado);
		setDano(7);
		setDescricao("Poder Gelo");
	}

}
