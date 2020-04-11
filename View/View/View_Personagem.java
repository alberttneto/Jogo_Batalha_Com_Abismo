package View;

import Model.Personagem;

public class View_Personagem {

	private Personagem p;
	
	public View_Personagem(Personagem p) {
		this.p = p;
	}

	public void printAtaque(int tipoPers, int tipoAtaq) {
		
		if(tipoPers == 1) {
			System.out.println("\nInimigo: " + p.getName() + " atacou...");			
		}else {
			if(tipoAtaq == 1) {
				System.out.println("\nPersonagem: " + p.getName() + " atacou...");
			}else {
				System.out.println("\nPersonagem: " + p.getName() + " usou magia...");
			}
		}
	}
	
	public void printSofreAtaque(int escudo) {
		System.out.println(p.getName() + " perde " + escudo + " de energia! \nLife = " + p.getlife() + "\nEstado: " + p.getEstado());

	}
	
	public void printRecolheRecompensa(int pontos) {
		System.out.println("Ganha " + pontos + " de vida! \nlife = " + p.getlife() + "\nEstado: " + p.getEstado() + "\n");
	}
	
	public void printPoderAtaque() {
		System.out.println("Poder de Ataque: " + p.getAtaque().getDescricao());

	}
	
	public void printPos() {
		System.out.println("Posicao do Personagem: ("+p.getX()+","+p.getY()+")");
	}
	
}
