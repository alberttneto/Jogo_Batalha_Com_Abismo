package Model.Observer;
import java.util.Random;

import View.View_Personagem;
import Model.Personagem;
import Model.Strategy.Atacar;

public class Inimigo extends Personagem implements Observador {

	private View_Personagem vp = new View_Personagem(this);
	
	public Inimigo(int x, int y, String name, Atacar ataque) {
		super(x, y, name, ataque);
	}
		
	// Inimigo ataca personagem quando na mesma posição, se não ele se aproxima.
	@Override
	public void update(Sujeito s) {
		
		Personagem personagem = (Personagem)s;
		Random r = new Random();
		
		if((Math.abs(this.getX() - personagem.getX()) == 0) && (Math.abs(this.getY() - personagem.getY()) == 0)) {
			vp.printAtaque(1,1);
			vp.printPoderAtaque();
			personagem.sofreAtaque(this.getAtaque().getDano());
			if(personagem.getlife() != 0) {
				personagem.setPos(r.nextInt(400), r.nextInt(400));				
			}

		} else {
			
			if(personagem.getX() > this.getX()) { 
				this.setX(this.getX()+1);	
			} else if(personagem.getX() < this.getY()) { 
				this.setX(this.getX()-1);
			}
				
			if(personagem.getY() > this.getY()) {
				this.setY(this.getY()+1);
			} else if(personagem.getY() < this.getY()) {
				this.setY(this.getY()-1);
			}
		}
	}
}
