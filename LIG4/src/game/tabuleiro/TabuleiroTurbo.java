package game.tabuleiro;
public class TabuleiroTurbo extends Tabuleiro{
    public void posicionarPeca(int col, int peca){
        int row = super.setRow(col);

        super.posicionarPeca(col, peca);
        if(col != 0){
            super.trocarPecas(row, col-1, peca);
        }
        if(col != 6){
            super.trocarPecas(row, col+1, peca);
        }
    }
}
