package Control.Composite;

import Model.Personagem;
import Model.Observer.Inimigo;

public class Fase implements Fase_Jogo {

	private Fase_Jogo f1;
	private Fase_Jogo f2;
	private Inimigo inim;
	
	public Fase(Fase_Jogo f1, Fase_Jogo f2, Inimigo i){
		this.f1 = f1;
		this.f2 = f2;
		this.inim = i;
	}
	
	@Override
	public int passarFase(Personagem p) {		
		
		int fase = 0;
		if(inim.getlife() == 0) {
			
			double num =  Math.random();
			
			if(num < 0.8) {
				fase = f1.passarFase(p);
			}else {
				fase = f2.passarFase(p);
			}
		
		}
		return fase;
	}

	
}
