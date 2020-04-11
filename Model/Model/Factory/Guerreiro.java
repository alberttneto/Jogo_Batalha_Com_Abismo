package Model.Factory;

import Model.Personagem;
import Model.Strategy.Atacar;

public class Guerreiro extends Personagem {
	
	private static Guerreiro instancia = null;
	
	private Guerreiro(int x, int y, Atacar ataque) {
		super(x, y, "Guerreiro", ataque);
	}
	
	public static synchronized Guerreiro getInstancia(int x, int y, Atacar ataque) {
		if(instancia == null) {
			instancia = new Guerreiro(x, y, ataque);
		}
		return instancia;
	}

}
