package Model.Factory;
import java.util.Random;

import Model.Personagem;
import Model.Decorator.Poder_Fogo;
import Model.Decorator.Poder_Gelo;
import Model.Decorator.Poder_Rocha;
import Model.Strategy.Atacar_Forte;
import Model.Strategy.Atacar_Fraco;
import Model.Strategy.Atacar_Medio;


public class AdvancedPersonagemFactory extends PersonagemFactory {

	@Override
	public Personagem createPersonagem(int tipo) {
		
		Personagem p = null;
		
		Random r = new Random();
		
		if(tipo == 1) {
			p = Guerreiro.getInstancia(r.nextInt(400), r.nextInt(400), new Poder_Gelo(new Atacar_Forte()));
		} else if(tipo == 2) {
			p = Mago.getInstancia(r.nextInt(400), r.nextInt(400), new Poder_Fogo(new Atacar_Forte()));
		} else if(tipo == 3) {
			p = Arqueiro.getInstancia(r.nextInt(400), r.nextInt(400), new Poder_Gelo(new Atacar_Fraco()));
		} else if(tipo == 4) {
			p = Curandeiro.getInstancia(r.nextInt(400), r.nextInt(400), new Poder_Rocha(new Atacar_Medio()));
		} else if(tipo == 5) {
			p = Cavaleiro.getInstancia(r.nextInt(400), r.nextInt(400), new Poder_Gelo(new Poder_Fogo(new Atacar_Medio())));
		}
		
		return p;
	}

}
