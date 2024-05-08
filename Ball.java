import java.util.Random;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Ball {

    public double x;
    public double y;
    public int diametroBall;
    public double dx;
    public double dy;
    public double speed = 6; // Velocidade inicial da bola
    public double speedIncrement = 0.5; // Taxa de aumento de velocidade

    public Ball(int x, int y) {
        this.x = x;
        this.y = y;
        this.diametroBall = 25; // Define o diâmetro da bola
        int angulo = new Random().nextInt(70);
        dx = Math.cos(Math.toRadians(angulo));
        dy = Math.sin(Math.toRadians(angulo));
    }

    public void desenharBall(Graphics g) {
        g.setColor(new Color(255, 255, 255));
        g.fillOval((int) x, (int) y, diametroBall, diametroBall); // Desenha a bola como um círculo
    }

    public void atualizar() {
        // Verifica colisão com a borda superior e inferior
        if (y + (dy * speed) + diametroBall >= Jogo.Altura || y + (dy * speed) < 0) {
            dy *= -1;
        }
    
        // Verifica colisão com as raquetes
        Rectangle Ball = new Rectangle((int) (x + (dx * speed)), (int) (y + (dy * speed)), diametroBall, diametroBall);
        Rectangle Jogador = new Rectangle((int) Jogo.Jogador.x, (int) Jogo.Jogador.y, (int) Jogo.Jogador.larguraJogador,
                (int) Jogo.Jogador.alturaJogador);
        Rectangle Jogador2 = new Rectangle((int) Jogo.Jogador2.x, (int) Jogo.Jogador2.y,
                (int) Jogo.Jogador2.larguraJogador, (int) Jogo.Jogador2.alturaJogador);
    
        if (Ball.intersects(Jogador)) {
            int angulo = new Random().nextInt(70);
            dx = Math.cos(Math.toRadians(angulo));
            dy = Math.sin(Math.toRadians(angulo));
            if (dx < 0) {
                dx *= -1;
            }
           // speedIncrement(); // Aumenta a velocidade quando a bola acerta a raquete
        } else if (Ball.intersects(Jogador2)) {
            int angulo = new Random().nextInt(70);
            dx = Math.cos(Math.toRadians(angulo));
            dy = Math.sin(Math.toRadians(angulo));
            if (dx > 0) {
                dx *= -1;
            }
           // speedIncrement(); // Aumenta a velocidade quando a bola acerta a raquete
        }
    
        x += dx * speed;
        y += dy * speed;
    }

    public void reset() {
        x = Jogo.Largura / 2;
        y = Jogo.Altura / 2;
        int angulo = new Random().nextInt(180);
        dx = Math.cos(Math.toRadians(angulo));
        dy = Math.sin(Math.toRadians(angulo));
    }
}
