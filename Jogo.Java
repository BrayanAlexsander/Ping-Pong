import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferStrategy;
import javax.swing.JFrame;

public class Jogo extends Canvas implements Runnable, KeyListener {
    public static int Largura = 1080;
    public static int Altura = 650;
    public static Jogador1 Jogador;
    public static Jogador2 Jogador2;
    public static Ball Ball;
    public static Placar Placar;

    public Jogo() {
        this.setPreferredSize(new Dimension(Largura, Altura));
        this.addKeyListener(this);
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        Jogador = new Jogador1(15, 150);
        Jogador2 = new Jogador2(1060, 150);
        Ball = new Ball(Largura / 2, Altura / 2); // Inicializa a bola no centro da tela
        Placar = new Placar(); // Inicializando o placar

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
            while (true) {
                Thread.sleep(1000 / 60);
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
        g.setColor(new Color(0, 0, 0));
        g.fillRect(0, 0, Largura, Altura);
        Jogador.desenharjogador(g);
        Jogador2.desenharjogador(g);
        Ball.desenharBall(g);
        Placar.desenhar(g); // Desenhar o placar
        bs.show();

    }

    private void Atualizar() {
        Jogador.atualizar();
        Jogador2.atualizar();
        Ball.atualizar();
        // Atualiza o placar
        if (Ball.x < 0) {
            Placar.marcarPontoJogador2();
            Ball.reset(); // Reinicia a bola para o centro
        } else if (Ball.x > Largura) {
            Placar.marcarPontoJogador1();
            Ball.reset(); // Reinicia a bola para o centro
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // Não foi preciso implementar aqui
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();

        if (keyCode == KeyEvent.VK_W) {
            Jogador.up = true;
        } else if (keyCode == KeyEvent.VK_S) {
            Jogador.down = true;

        }

        if (keyCode == KeyEvent.VK_UP) {
            Jogador2.up = true;
        } else if (keyCode == KeyEvent.VK_DOWN) {
            Jogador2.down = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) {
            Jogador.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_S) {
            Jogador.down = false;
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            Jogador2.up = false;
        } else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            Jogador2.down = false;

        }
    }

}
