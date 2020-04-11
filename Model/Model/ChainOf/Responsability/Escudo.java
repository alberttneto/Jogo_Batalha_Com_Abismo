package Model.ChainOf.Responsability;


public abstract class Escudo {

	private Escudo sucessor;
	
	public void setSucessor(Escudo sucessor) {
		this.sucessor = sucessor;
	}

	public Escudo getSucessor() {
		return this.sucessor;
	}
	
	// Reduz dano de ataque
	public abstract int usaEscudo(int poderAtaque);
}

