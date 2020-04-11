package Model;

import java.util.ArrayList;

import View.View_Personagem;
import Model.ChainOf.Responsability.Escudo;
import Model.ChainOf.Responsability.Escudo_Adamantium;
import Model.ChainOf.Responsability.Escudo_Ferro;
import Model.ChainOf.Responsability.Escudo_Madeira;
import Model.Observer.Observador;
import Model.Observer.Sujeito;
import Model.State.Estado;
import Model.State.Estado_Normal;
import Model.Strategy.Atacar;
import Model.Strategy.Correr;
import Model.Strategy.Correr_Devagar;
import Model.Strategy.Correr_Rapido;
import Model.Strategy.Pular;


public abstract class Personagem implements Sujeito {

	// Atributos
	private String name;
	private Estado estado;
	private Atacar a;
	private Correr c;
	private Pular p;
	private int life;
	private int x = 0;
	private int y = 0;
	private int ativaCorrer = 0;
	private ArrayList<Observador> lista = new ArrayList<Observador>();
	Escudo escudo_Mad = new Escudo_Madeira();
	Escudo escudo_Ferro = new Escudo_Ferro();
	Escudo escudo_ad = new Escudo_Adamantium();
	private View_Personagem vp = new View_Personagem(this);
	
	
	// Construtor
	public Personagem(int x, int y, String name, Atacar ataque) {
		this.x = x;
		this.y = y;
		this.name = name;
		this.life = 100;
		this.estado = new Estado_Normal(this);
		this.escudo_Mad.setSucessor(escudo_Ferro);
		this.escudo_Ferro.setSucessor(escudo_ad);
		this.escudo_ad.setSucessor(null);
		this.c = new Correr_Devagar();
		;
	}
	
	// Setters
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void setAtacar(Atacar a) {
		this.a = a;
	}
	
	public void setCorrer(Correr c) {
		this.c = c;
	}
	
	public void setPular(Pular p) {
		this.p = p;
	}
	
	public void setlife(int life) {	
		this.life = life;
	}
	
	public void setEstado(Estado estado) {
		this.estado = estado;
	}
	
	//Modifica posição e mostra nova posição do personagem
	public void setPos(int x, int y) {
		this.x = x;
		this.y = y;
		vp.printPos();
	}
	
	
	// Getters
	public Correr getCorrer() {
		return this.c;
	}
	
	public Pular Pular() {
		return this.p;
	}
	
	public int getlife() {
		return life;
	}
	
	public Estado getEstado() {
		return estado;
	}
	
	public int getX() {
		return this.x;
	}
	
	public int getY() {
		return this.y;
	}
	
	public String getName() {
		return this.name;
	}
	
	public Atacar getAtaque() {
		return this.a;
	}
	
	// Calcula tamanho do personagem de acordo com a vida
	public int tamanho() {
		
		int tam;
		
        if(life >= 50) {
        	tam = life/2;
        }else if (life < 50 && life > 0) {
        	tam = 20;
        } else {
        	tam = 0;
        }
		
		return tam;
	}
	
	
	// Padrï¿½o Observer
	public void addObserver(Observador o) {
		lista.add(o);
	}
	
	public void removeObserver(Observador o) {
		lista.remove(o);
	}
	
	public void notifyObservers() {
		for(Observador o:lista)
			o.update(this);
	}
	
	public void show() {
		notifyObservers();
	}
	
	//Padrï¿½o Commands
	public void moverBaixo() {
		setY(getY()+c.getVelocidade());
	}
	
	public void moverCima() {
		setY(getY()-c.getVelocidade());
	}
	
	public void moverDir() {
		setX(getX()+c.getVelocidade());
	}
	
	public void moverEsq() {
		setX(getX()-c.getVelocidade());
	}
	
	// Modifica velocidade de correr de acordo com comando
	public void correr() {
		
		if(ativaCorrer == 0) {
			this.c = new Correr_Rapido();
			ativaCorrer = 1;
		}else {
			this.c = new Correr_Devagar();
			ativaCorrer = 0;
		}
	}
	
	// Verifica personagens na linha de visão para sofrer ataque ou magia
	public void atacar() {
		
		for(Observador o: lista) {
			Personagem p = (Personagem)o;
			if((Math.abs(this.getX() - p.getX()) <= 10) && (Math.abs(this.getY() - p.getY()) <= 10)) {
				if(p.getlife() != 0) {		
					vp.printAtaque(2, 1);
					p.sofreAtaque(this.getAtaque().getDano());
				}
			}
		}
	}
	
	public void magia() {
		
		for(Observador o: lista) {
			Personagem p = (Personagem)o;
			if(Math.abs(this.getX() - p.getX()) <= 5) {
				if(p.getlife() != 0) {		
					vp.printAtaque(2, 2);
					p.sofreAtaque(this.getAtaque().getDano());
				}
			}
		}
	}

	// Se personagem sofre ataque distribui ataque nos escudos
	public void sofreAtaque(int pontos) {
		// Toda vez que sofre ataque verifica estado.
		estado.sofreAtaque(escudo_Mad.usaEscudo(pontos));
		vp.printSofreAtaque(escudo_Mad.usaEscudo(pontos));
	}
	
	public void recolheRecompensa(int pontos) {
		estado.recolheRecompensa(pontos);
		vp.printRecolheRecompensa(pontos);
	}
}
