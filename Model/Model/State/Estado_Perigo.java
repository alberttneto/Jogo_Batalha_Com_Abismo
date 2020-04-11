package Model.State;

import Model.Personagem;
import Model.Strategy.Atacar_Fraco;
import Model.Strategy.Correr_Devagar;

public class Estado_Perigo extends Estado {

	public Estado_Perigo(Personagem personagem) {
		super(personagem);
		personagem.setAtacar(new Atacar_Fraco());
		personagem.setCorrer(new Correr_Devagar());
	}

	@Override
	protected void setLimites() {
		this.setlimitSup(30);
		this.setlimitInf(1);
	}

	@Override
	protected void verificaEstado() {
		if(this.getPersonagem().getlife() > getlimitSup() || this.getPersonagem().getlife() < getlimitInf()) {
			new Estado_Normal(getPersonagem()).verificaEstado();
		}
	}
	
	@Override
	public String toString() {
		return "Estado_Perigo";
	}
	
}
