package game.tabuleiro;
import exceptions.ColunaInvalida;
import exceptions.ForaDoIndice;

public interface TabuleiroLIG4 {
    void isValidCol(int escolha) throws ColunaInvalida,ForaDoIndice;
    void posicionarPeca(int col, char peca);
    void displayTabuleiro();
    void reset();
    boolean checkTie();
    boolean checkWin(char peca);
}
