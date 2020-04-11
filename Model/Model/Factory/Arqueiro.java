package Model.Factory;

import Model.Personagem;
import Model.Strategy.Atacar;

public class Arqueiro extends Personagem {
	
	private static Arqueiro instancia = null;
	
	private Arqueiro(int x, int y, Atacar ataque) {
		super(x, y, "Arqueiro", ataque);
	}
	
	public static synchronized Arqueiro getInstancia(int x, int y, Atacar ataque) {
		if(instancia == null) {
			instancia = new Arqueiro(x, y, ataque);
		}
		return instancia;
	}

}
