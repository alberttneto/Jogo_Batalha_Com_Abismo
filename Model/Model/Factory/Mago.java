package Model.Factory;

import Model.Personagem;
import Model.Strategy.Atacar;

public class Mago extends Personagem{

	private static Mago instancia = null;
	
	private Mago(int x, int y, Atacar ataque) {
		super(x, y, "Mago", ataque);
	}
	
	public static synchronized Mago getInstancia(int x, int y, Atacar ataque) {
		if(instancia == null) {
			instancia = new Mago(x, y, ataque);
		}
		return instancia;
	}
}
