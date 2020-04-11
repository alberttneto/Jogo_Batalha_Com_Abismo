package Model.State;

import Model.Personagem;

public class Estado_Morto extends Estado {

	public Estado_Morto(Personagem personagem) {
		super(personagem);
	}

	@Override
	protected void setLimites() {
		
	}

	@Override
	protected void verificaEstado() {
		
	}

	@Override
	public String toString() {
		return "Estado_Morto";
	}
}
