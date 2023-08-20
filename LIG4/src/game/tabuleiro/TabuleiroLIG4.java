package game.tabuleiro;

import exceptions.ColunaInvalida;

public interface TabuleiroLIG4 {
    void isValidCol(int escolha) throws ColunaInvalida;
    void posicionarPeca(int col, int peca);
    void reset();
    boolean checkTie();
    boolean checkWin(int peca);
}
