package Model.Decorator;

import Model.Strategy.Atacar;

public abstract class AtaqueDecorador extends Atacar{

	private Atacar ataqueDecorado;
	
	public AtaqueDecorador(Atacar ataqueDecorado) {
		this.ataqueDecorado = ataqueDecorado;
	}
	
	@Override
	public int getDano() {
		return this.ataqueDecorado.getDano() + dano;
	}
	
	
	public String getDescricao() {
		return this.ataqueDecorado.getDescricao() + ", " + descricao;
	}
	
}
