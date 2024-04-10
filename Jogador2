import java.awt.Color;
import java.awt.Graphics;

public class Jogador2 {
    public boolean up;
    public boolean down;
    public int x;
    public int y;
    public int larguraJogador;
    public int alturaJogador;

    public Jogador2(int x, int y) {
        this.x = x;
        this.y = y;
        this.larguraJogador = 10;
        this.alturaJogador = 100;
    }

    public void desenharjogador(Graphics g) {
        g.setColor(new Color(0, 190, 200));
        g.fillRect(x, y, larguraJogador, alturaJogador);
    }

    public void atualizar() {
        if (up) {
            y = y - 4;

        } else if (down) {
            y = y + 4;

        }
        if (y + alturaJogador > Jogo.Altura) {
            y = Jogo.Altura - alturaJogador;
        } else if (y < 0) {
            y = 1;
        }
    }
}
