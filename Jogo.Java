import java.awt.Canvas;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;


public class Jogo extends Canvas implements Runnable, KeyListener {
	public static int Largura = 650;
	public static int Altura = 600;
	public static Jogador1 Jogador;
	
	public Jogo() {
		this.setPreferredSize(new Dimension(Largura, Altura));
		this.addKeyListener(this);	
	}		
	
	public static void main(String[] args) {
		Jogo jogo = new Jogo();
		Jogador = new Jogador1(15, 150);
		JFrame jframe = new JFrame();
		jframe.setVisible(true);
		jframe.add(jogo);
		jframe.pack();
		jframe.setLocationRelativeTo(null);
		jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		new Thread(jogo).start();	
	}

	@Override
	public void run() {
		try {
			while(true) {
				Thread.sleep(1000/60);
				Desenhar();
				Atualizar();
						}
			} catch (InterruptedException e) {
			e.printStackTrace();
			}
			
		}
	
	private void Desenhar() {
		BufferStrategy bs = this.getBufferStrategy();
		if (bs == null) {
			this.createBufferStrategy(3);
			return;
				}
		Graphics g = bs.getDrawGraphics(); 
		g.setColor(new Color (0 , 0 , 0));
		g.fillRect(0, 0, Largura, Altura);
		Jogador.desenharjogador(g);
		bs.show();
		
	}
	
	private void Atualizar() {
		Jogador.atualizar();
		
		}
@Override
public void keyTyped(KeyEvent e) {
		}

@Override
public void keyPressed(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_W) {
		Jogador.up = true;
	}else if(e.getKeyCode() == KeyEvent.VK_S) {
		Jogador.down = true;
	
	}
		}

@Override
public void keyReleased(KeyEvent e) {
	if(e.getKeyCode() == KeyEvent.VK_W) {
		Jogador.up = false;
	}else if(e.getKeyCode() == KeyEvent.VK_S) {
		Jogador.down = false;
	
	
		}
   }
}
