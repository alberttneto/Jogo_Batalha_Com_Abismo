package Model.State;

import Model.Personagem;

public abstract class Estado {

	private Personagem personagem;
	private int limitSup;
	private int limitInf;
	
	public Estado(Personagem personagem) {
		this.personagem = personagem;
		setLimites();
	}
	
	public void setlimitSup(int limitSup) {
		this.limitSup = limitSup;
	}
	
	public void setlimitInf(int limitInf) {
		this.limitInf = limitInf;
	}
	
	public int getlimitSup() {
		return limitSup;
	}
	
	public int getlimitInf() {
		return limitInf;
	}
	
	public Personagem getPersonagem() {
		return personagem;
	}
	
	protected abstract void setLimites();
	
	public void sofreAtaque(int pontos) {
		if ((this.personagem.getlife() - pontos) < 0) {
			this.personagem.setlife(0);
		}else {
			this.personagem.setlife(this.personagem.getlife() - pontos);
		}
		this.verificaEstado();
	}
	
	public void recolheRecompensa(int pontos) {
		if((this.personagem.getlife() + pontos) > 100) {
			this.personagem.setlife(100);
		}else {			
			this.personagem.setlife(this.personagem.getlife() + pontos);
		}
		this.verificaEstado();
	}
	
	protected abstract void verificaEstado();
}
