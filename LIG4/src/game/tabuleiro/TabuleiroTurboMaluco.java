package game.tabuleiro;
import java.util.Random;

public class TabuleiroTurboMaluco extends Tabuleiro{
    private Random random = new Random();
    private double probabilidade;

    public TabuleiroTurboMaluco(double nivelMaluco){
        this.probabilidade = nivelMaluco;
    }

    public void posicionarPeca(int col, char peca){
        int row = super.getLinhaDaJogada(col); 
        // cada peça vizinha (se existir) tem chance de virar a peca da rodada
        if(row!=5 && vaiTrocarPecas()){//peça vizinha de baixo
            super.trocarPecas(row+1, col, peca);
        }
        if(col!=0 && vaiTrocarPecas()){//peça vizinha esqueda
            super.trocarPecas(row, col-1, peca);
        }
        if(col!=6 && vaiTrocarPecas()){//peça vizinha direita
            super.trocarPecas(row, col+1, peca);
        }
        if(row!=0 && col!=0 && vaiTrocarPecas()){//peça vizinha diagonal superior esquerda
            super.trocarPecas(row-1, col-1, peca);
        }
        if(row!=0 && col!=6 && vaiTrocarPecas()){//peça vizinha diagonal superior direita
            super.trocarPecas(row-1, col+1, peca);
        }
        if(row!=5 && col!=0 && vaiTrocarPecas()){//peça vizinha diagonal inferior esquerda
            super.trocarPecas(row+1, col-1, peca);
        }
        if(row!=5 && col!=6 && vaiTrocarPecas()){//peça vizinha diagonal infeiror direita
            super.trocarPecas(row+1, col+1, peca);
        }

        super.posicionarPeca(col, peca);
    }

    private boolean vaiTrocarPecas(){
        return random.nextDouble() < this.probabilidade;
    }

}
