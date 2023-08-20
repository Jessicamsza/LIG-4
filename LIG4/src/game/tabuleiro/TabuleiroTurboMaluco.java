package game.tabuleiro;
import java.util.Random;

public class TabuleiroTurboMaluco extends Tabuleiro{
    private Random random = new Random();
    private double probabilidade;

    public TabuleiroTurboMaluco(double nivelMaluco){
        this.probabilidade = nivelMaluco;
    }

    public void posicionarPeca(int col, int peca){
        int row = super.setRow(col); 

        if(row!=5 && vaiTrocarPecas()){
            super.trocarPecas(row+1, col, peca);
        }
        if(col!=0 && vaiTrocarPecas()){
            super.trocarPecas(row, col-1, peca);
        }
        if(col!=6 && vaiTrocarPecas()){
            super.trocarPecas(row, col+1, peca);
        }
        if(row!=0 && col!=0 && vaiTrocarPecas()){
            super.trocarPecas(row-1, col-1, peca);
        }
        if(row!=0 && col!=6 && vaiTrocarPecas()){
            super.trocarPecas(row-1, col+1, peca);
        }
        if(row!=5 && col!=0 && vaiTrocarPecas()){
            super.trocarPecas(row+1, col-1, peca);
        }
        if(row!=5 && col!=6 && vaiTrocarPecas()){
            super.trocarPecas(row+1, col+1, peca);
        }

        super.posicionarPeca(col, peca);
    }

    private boolean vaiTrocarPecas(){
        return random.nextDouble() < this.probabilidade;
    }

}