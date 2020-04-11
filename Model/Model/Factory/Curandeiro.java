package Model.Factory;

import Model.Personagem;
import Model.Strategy.Atacar;

public class Curandeiro extends Personagem{

	private static Curandeiro instancia = null;
	
	private Curandeiro(int x, int y, Atacar ataque) {
		super(x, y, "Curandeiro", ataque);
	}
	
	public static synchronized Curandeiro getInstancia(int x, int y, Atacar ataque) {
		if(instancia == null) {
			instancia = new Curandeiro(x, y, ataque);
		}
		return instancia;
	}
}
