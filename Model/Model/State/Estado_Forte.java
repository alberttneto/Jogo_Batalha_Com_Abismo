package Model.State;

import Model.Personagem;
import Model.Strategy.Atacar_Forte;
import Model.Strategy.Correr_Rapido;

public class Estado_Forte extends Estado {

	public Estado_Forte(Personagem personagem) {
		super(personagem);
		personagem.setAtacar(new Atacar_Forte());
		personagem.setCorrer(new Correr_Rapido());
	}

	@Override
	protected void setLimites() {
		this.setlimitInf(71);
		this.setlimitSup(100);
	}

	@Override
	protected void verificaEstado() {
		if(this.getPersonagem().getlife() < getlimitInf()) {
			new Estado_Normal(getPersonagem()).verificaEstado();
		} 
	}

	@Override
	public String toString() {
		return "Estado_Forte";
	}
		
}
