package Model.Decorator;

import Model.Strategy.Atacar;

public class Poder_Rocha extends AtaqueDecorador{

	public Poder_Rocha(Atacar ataqueDecorado) {
		super(ataqueDecorado);
		setDano(4);
		setDescricao("Poder Rochar");
	}

}
