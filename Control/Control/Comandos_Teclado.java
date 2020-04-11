package Control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import Control.Command.Controle;
import Control.Command.Macro;
import Control.Command.MoverBaixo;
import Control.Command.MoverCima;
import Control.Command.MoverEsq;
import Model.Personagem;

// Recebendo comandos do teclado
public class Comandos_Teclado implements KeyListener {
 	
	private Controle co;
	private Macro r, l;
	
	// Construtor recebe comandos Controle do jogo e o personagem que vai ter os Macros L e R
	public Comandos_Teclado(Personagem p1, Controle co) {
		this.co = co;
		
	    // Macro L
	    l = new Macro();
	    l.addMacro(new MoverCima(p1));
	    l.addMacro(new MoverEsq(p1));
	    
	    // Macro R
	    r = new Macro();
	    r.addMacro(new MoverBaixo(p1));
	    r.addMacro(new MoverEsq(p1));
	}

	@Override
    public void keyTyped(KeyEvent e) {
    }

	
	// Recebendo comandos do teclado e executando controle.
    @Override
    public void keyPressed(KeyEvent e) {

    	if (e.getKeyCode() == KeyEvent.VK_LEFT){                
            co.pressionar(3);    
    	}
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            co.pressionar(2);    
    	}   
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            co.pressionar(1);    
        }
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            co.pressionar(0);    
        }
        if (e.getKeyCode() == KeyEvent.VK_V) {
            co.pressionar(4);    
        }
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
        	co.pressionar(5);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_A) {
        	co.pressionar(6);
        }

        if (e.getKeyCode() == KeyEvent.VK_M) {
        	co.pressionar(7);
        }
    
        if (e.getKeyCode() == KeyEvent.VK_L) {
        	l.executeMacro();
        }
    
        if (e.getKeyCode() == KeyEvent.VK_R) {
        	r.executeMacro();
        }
    }

	@Override
	public void keyReleased(KeyEvent e) {	
	}
}

