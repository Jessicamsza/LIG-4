package game.tabuleiro;

public class TabuleiroTurbo extends Tabuleiro{
    public void posicionarPeca(int col, char peca){
        int row = super.getLinhaDaJogada(col);

        if(col != 0){
            super.trocarPecas(row, col-1, peca);
        }if(col != 6){
            super.trocarPecas(row, col+1, peca);
        }
        super.posicionarPeca(col, peca);
    }
}
