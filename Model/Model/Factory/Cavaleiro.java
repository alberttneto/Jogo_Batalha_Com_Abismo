package Model.Factory;

import Model.Personagem;
import Model.Strategy.Atacar;

public class Cavaleiro extends Personagem {

	private static Cavaleiro instancia = null;
	
	private Cavaleiro(int x, int y, Atacar ataque) {
		super(x, y, "Cavaleiro", ataque);
	}
	
	public static synchronized Cavaleiro getInstancia(int x, int y, Atacar ataque) {
		if(instancia == null) {
			instancia = new Cavaleiro(x, y, ataque);
		}
		return instancia;
	}
}
