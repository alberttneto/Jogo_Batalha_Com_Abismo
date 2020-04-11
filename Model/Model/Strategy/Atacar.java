package Model.Strategy;


public abstract class Atacar {

	protected int dano;
	protected String descricao;
	
	public void setDano(int dano) {
		this.dano = dano;
	}
	
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	
	public int getDano() {
		return this.dano;
	}
	
	public String getDescricao() {
		return this.descricao;
	}
}
