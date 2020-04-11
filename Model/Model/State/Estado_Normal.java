package Model.State;

import Model.Personagem;
import Model.Strategy.Atacar_Medio;
import Model.Strategy.Correr_Medio;

public class Estado_Normal extends Estado {

	public Estado_Normal(Personagem personagem) {
		super(personagem);
		personagem.setAtacar(new Atacar_Medio());
		personagem.setCorrer(new Correr_Medio());
	}

	@Override
	protected void setLimites() {
		setlimitSup(70);
		setlimitInf(31);
	}

	@Override
	protected void verificaEstado() {
		if(this.getPersonagem().getlife() > getlimitSup()) {
			this.getPersonagem().setEstado(new Estado_Forte(getPersonagem()));
		}else if (this.getPersonagem().getlife() == 0){
			this.getPersonagem().setEstado(new Estado_Morto(getPersonagem()));
		} else if (this.getPersonagem().getlife() < getlimitInf()){
			this.getPersonagem().setEstado(new Estado_Perigo(getPersonagem()));		
		} else {
			this.getPersonagem().setEstado(new Estado_Normal(getPersonagem()));
		}
	}
	
	@Override
	public String toString() {
		return "Estado_Normal";
	}

}
