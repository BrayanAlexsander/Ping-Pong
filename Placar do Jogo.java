import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class Placar {
    private int pontuacaoJogador1 = 0;
    private int pontuacaoJogador2 = 0;

    public void marcarPontoJogador1() {
        pontuacaoJogador1++;
    }

    public void marcarPontoJogador2() {
        pontuacaoJogador2++;
    }

    public void desenhar(Graphics g) {
        // Cor da sombra
        g.setColor(new Color(128, 128, 128));
        g.setFont(new Font("Verdana", Font.BOLD, 24));
        g.drawString("PLACAR", Jogo.Largura / 2 - 42, 32); // Desenha a sombra ligeiramente deslocada

        // Cor do texto principal
        g.setColor(new Color(192, 192, 192));
        g.drawString("PLACAR", Jogo.Largura / 2 - 40, 30);

        g.drawString("Jogador 1: " + pontuacaoJogador1, 20, 60);
        g.drawString("Jogador 2: " + pontuacaoJogador2, Jogo.Largura - 180, 60);
    }
}
