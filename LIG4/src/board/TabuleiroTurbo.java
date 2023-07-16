package board;

public class TabuleiroTurbo extends Tabuleiro{
    
    public void posicionarPeca(int col, char peca){
        int row = super.setRow(col);
        super.posicionarPeca(col, peca);

        if(col != 1 && (super.getOcupacao(row, col-1) != '\0')){
            super.setOcupacao(row, col-1, peca);
        }
        if(col != 7 && (super.getOcupacao(row, col+1) != '\0')){
            super.setOcupacao(row, col+1, peca);
        }
    }
}