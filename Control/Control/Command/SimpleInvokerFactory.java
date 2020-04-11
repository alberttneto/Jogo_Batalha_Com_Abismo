package Control.Command;

import Model.Personagem;

public class SimpleInvokerFactory {

	public static Controle getInvoker(Personagem p) {
		
		Controle c = new Controle();
		
			c.setCommand(new MoverBaixo(p), 0);
			c.setCommand(new MoverCima(p), 1);			
			c.setCommand(new MoverDir(p), 2);
			c.setCommand(new MoverEsq(p), 3);
			c.setCommand(new Control.Command.Correr(p), 4);
			c.setCommand(new Control.Command.Pular(p), 5);			
			c.setCommand(new Control.Command.Atacar(p), 6);
			c.setCommand(new Magia(p), 7);
		
		return c;
	}
}

