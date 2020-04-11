package View;
import Model.*;
import Model.Decorator.Poder_Fogo;
import Model.Decorator.Poder_Gelo;
import Model.Decorator.Poder_Rocha;
import Model.Factory.SimplePersonagemFactory;
import Model.Observer.Inimigo;
import Model.Strategy.Atacar_Forte;
import Model.Strategy.Atacar_Fraco;
import Model.Strategy.Atacar_Medio;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.KeyListener;
import java.util.Random;

import javax.swing.*;

import Control.*;
import Control.Command.Controle;
import Control.Command.SimpleInvokerFactory;
import Control.Composite.Abismo;
import Control.Composite.Fase;
import Control.Composite.Fase_Jogo;
import Control.Composite.Saida;

public class Game {
		
	private Personagem list_pers[] = new Personagem[5];
	private Inimigo n1;
	private Inimigo n2;
	private Inimigo n3;
	private Controle co;

 
 	public void jogar() throws InterruptedException {
		
 		
 		Random ran = new Random();
		 
		int tipo = 0;
		
		// Criando lista de personagens
		for(int i = 0; i < 5; i++) {
				  
			 double N = Math.random();
			 
			 if(N <= 0.2) {
				 tipo = 1;
			 }else if(N > 0.2 || N <= 0.4) {
				 tipo = 2;
			 }else if(N > 0.4 || N <= 0.6) {
				 tipo = 3;
			 }else if(N > 0.6 || N <= 0.8) {
				 tipo = 4;
			 }else if(N > 0.8 || N <= 1.0) {
				 tipo = 5;
			 }
			 
			list_pers[i] = new SimplePersonagemFactory().createPersonagem(tipo);
		}
		
		Personagem p1 =  list_pers[0];
		
		// Criando ataques do decorator para o inimigo
		Model.Strategy.Atacar ataque1 = new Atacar_Forte();
		Model.Strategy.Atacar ataque2 = new Atacar_Medio();
		Model.Strategy.Atacar ataque3 = new Atacar_Fraco();
			
		ataque1 = new Poder_Fogo(ataque1);
		ataque2 = new Poder_Gelo(ataque2);
		ataque3 = new Poder_Gelo(ataque3);
		ataque3 = new Poder_Rocha(ataque3);
			
			
		n1 = new Inimigo(ran.nextInt(400), ran.nextInt(400), "Dragao", ataque1);
		n2 = new Inimigo(ran.nextInt(400), ran.nextInt(400), "Caveira", ataque2);
		n3 = new Inimigo(ran.nextInt(400), ran.nextInt(400), "Gigante", ataque3);
	    
		
		// Recebe comandos do controle para personagem
	    co = SimpleInvokerFactory.getInvoker(p1);	    
	    KeyListener listener = new Comandos_Teclado(p1, co);
		
	    // Criando JPanel e CardLayout
	    CardLayout card = new CardLayout();
	    JPanel cardPane = new JPanel();
	    cardPane.setLayout(card);
 		//JPanel cards = new JPanel(new CardLayout());
	    Painel_Grafico jp1 = new Painel_Grafico(p1, n1);
 		JPanel jp2 = new Painel_Grafico(p1, n2);
 		JPanel jp3 = new Painel_Grafico(p1, n3);
 		
 		// Set na cor de fundo de cada JPanel
 		jp1.setBackground(Color.WHITE);
 		jp2.setBackground(Color.YELLOW);
 		jp3.setBackground(Color.ORANGE);
 		
 		// Adicionando cada JPane ao CardLayout
 		cardPane.add(jp1);
 		cardPane.add(jp2);
 		cardPane.add(jp3);
 	
 		//Habilitando comandos no JPanel
 		cardPane.setFocusable(true);
 		cardPane.addKeyListener(listener);
 		
 		// Criando janela
		JFrame frame = new JFrame("Battle");
		frame.add(cardPane);
		frame.setSize(500, 500);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);    
	        
	    p1.addObserver(n1);
	   
	    // Fases do jogo
	    Fase_Jogo labirinto = new Fase( new Fase( new Fase( new Saida(), new Abismo(), n3), new Abismo(), n2),new Abismo(), n1);
	    
	    String encerramento = "Voce Morreu!!";
	    int flag = 0, fase = 0;
	    
	    while (p1.getlife() != 0) {
	        p1.show();           
	        cardPane.repaint();
	        Thread.sleep(80);
	        
	        if(fase == 1) {
	        	encerramento = "Abismo!! Voce Perdeu";
	        	break;
	        }else if(fase == 2){
	        	encerramento = "Saida!! Voce Ganhou o jogo";
	        	break;
	        }
	        
	        
	        // Se inimigo morrer remove observer, Passa de fase no labirinto e troca card no cardLayout
	        if(n3.getlife() == 0 && flag == 2) {
	        	p1.removeObserver(n3);
	        	fase = labirinto.passarFase(p1);
	        	card.next(cardPane);
	        	flag = 3;
	        }

	        if(n2.getlife() == 0 && flag == 1) {
	        	p1.removeObserver(n2);
	        	p1.addObserver(n3);
	        	fase = labirinto.passarFase(p1);
	        	card.next(cardPane);
	        	flag = 2;
	        }
	        
	        if(n1.getlife() == 0 && flag == 0) {
	        	p1.removeObserver(n1);
	        	p1.addObserver(n2);
	        	fase = labirinto.passarFase(p1);
	        	card.next(cardPane);
	        	flag = 1;
	        }
	    }
	    
	    //Mostra log de comandos
	    //co.showLog();
	    
	    // Encerra jogo
	    frame.dispose();
	    JOptionPane.showMessageDialog(null, encerramento);

 	}
}