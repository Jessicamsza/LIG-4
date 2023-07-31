package game.tabuleiro;

public interface TabuleiroLIG4 {
    String isValidCol(int escolha);
    void posicionarPeca(int col, char peca);
    void displayTabuleiro();
    void reset();
    boolean checkTie();
    boolean checkWin(char peca);
}
