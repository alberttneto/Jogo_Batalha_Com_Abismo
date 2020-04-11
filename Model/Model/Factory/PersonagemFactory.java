package Model.Factory;

import Model.Personagem;

public abstract class PersonagemFactory {
	public abstract Personagem createPersonagem(int tipo);
}
