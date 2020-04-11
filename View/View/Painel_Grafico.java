package View;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;

import javax.swing.JPanel;

import Model.Personagem;
import Model.Observer.Inimigo;

@SuppressWarnings("serial")
public class Painel_Grafico extends JPanel{

	private Inimigo n1;
	private Personagem p1;
	
	public Painel_Grafico(Personagem p1, Inimigo n1) {
		this.p1 = p1;
		this.n1 = n1;
	}

	// Decide tamanho dos personagens no jogo de acordo com o life.
	public void paint(Graphics g) {
       super.paint(g); 
        
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        g2d.setColor(Color.GREEN);
        g2d.fillOval(this.p1.getX(), this.p1.getY(), this.p1.tamanho(), this.p1.tamanho());
       
        if(n1.getName() == "Dragao") {
        	g2d.setColor(Color.RED);        
        	g2d.fillOval(this.n1.getX(), this.n1.getY(), this.n1.tamanho(), this.n1.tamanho());        	
        }else if(n1.getName() == "Caveira") { 	
        	g2d.setColor(Color.GRAY);        
        	g2d.fillOval(this.n1.getX(), this.n1.getY(), this.n1.tamanho(), this.n1.tamanho());
        }else if(n1.getName() == "Gigante") {
        	g2d.setColor(Color.BLACK);        
        	g2d.fillOval(this.n1.getX(), this.n1.getY(), this.n1.tamanho(), this.n1.tamanho());
        }
         
    }
}
