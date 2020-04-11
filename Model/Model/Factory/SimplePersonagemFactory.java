package Model.Factory;
import java.util.Random;

import Model.Personagem;
import Model.Strategy.Atacar_Forte;
import Model.Strategy.Atacar_Fraco;
import Model.Strategy.Atacar_Medio;

public class SimplePersonagemFactory extends PersonagemFactory{
	
	public Personagem createPersonagem(int tipo) {
		Personagem p = null;
		
		Random r = new Random();
		
		if(tipo == 1) {
			p = Mago.getInstancia(r.nextInt(400), r.nextInt(400), new Atacar_Forte());
		} else if(tipo == 2) {
			p = Guerreiro.getInstancia(r.nextInt(400), r.nextInt(400), new Atacar_Fraco());
		} else if(tipo == 3) {
			p = Curandeiro.getInstancia(r.nextInt(400), r.nextInt(400), new Atacar_Medio());
		} else if(tipo == 4) {
			p = Cavaleiro.getInstancia(r.nextInt(400), r.nextInt(400), new Atacar_Fraco());
		} else if(tipo == 5) {
			p = Arqueiro.getInstancia(r.nextInt(400), r.nextInt(400), new Atacar_Medio());
		}
		
		return p;
	}

}
