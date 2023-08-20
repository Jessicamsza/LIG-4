package game.tabuleiro;
import exceptions.ColunaInvalida;


public class Tabuleiro implements TabuleiroLIG4{
    private int[][] matrizTabuleiro = new int[6][7];


    public int[][] getTabuleiro() { 
        return matrizTabuleiro;
    }

    public void isValidCol(int col) throws ColunaInvalida{
        if (matrizTabuleiro[0][col] != 0){
            throw new ColunaInvalida("! Essa coluna está cheia !\n" );
        }
        if (col < 0 || col > 6 ){
            throw new ColunaInvalida("! Coluna fora do índice !\n" );
        }
    }
    
    public void posicionarPeca(int col, int peca){
        int row = this.setRow(col);
        matrizTabuleiro[row][col] = peca;
    }
    
    protected int setRow(int col){
        for (int indiceY = (matrizTabuleiro.length-1); indiceY>=0; indiceY--){
            int row = matrizTabuleiro[indiceY][col];
            if (row == 0){
                return indiceY;
            }
        }
        // se a coluna estivesse cheia, essa isso é previnido em isValidCol;
        return 0; 
    }
    protected void trocarPecas(int row, int col, int peca){
        if(matrizTabuleiro[row][col] != 0){
            matrizTabuleiro[row][col] = peca;
        }
    }

    public void reset(){
        for (int i = (matrizTabuleiro.length-1); i>=0; i--){
            for(int j = (matrizTabuleiro[0].length - 1); j>=0; j--){
                this.matrizTabuleiro[i][j] = 0;
            }
        }
    }

    public boolean checkTie(){
        for (int i = 0; i<=6;i++){
            if (matrizTabuleiro[0][i] == 0){
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(int peca){
        return winVertical(peca) || winHorizontal(peca) || winDiagonal(peca);
    }


    /*
     * recebe como parâmetro a peça do jogador que fez a última jogada
     * 1°: pecorrer colunas da matriz
     *  2°: definir o começo de todas as possíveis sequencias de quatro ( 0 a 3, 1 a 4 e 2 a 5)
     *    3°: percorrer do começo (j) até as proximas 3 casas acima e conferir se são iguais a peça
     *       se qualquer casa não for igual a peça, interromper
     *       se, no ultimo valor para k (j+ 3), não entrou na primera condição: retorna true
     * depois de não achar a sequencia entre todas possíveis posições retorna False
     * 
     * além de checar a vitória, também transforma as peças em "4" para indicar a sequencia de 4 peças.
     */
    private boolean winVertical(int peca){
        for ( int i = 0; i < 7; i++){ 
            for( int j = 0; j<3; j++){
                for(int k = j; k < j + 4; k++){
                    if (matrizTabuleiro[k][i] != peca){
                        break;
                    } else if(k == j+ 3){ 
                        matrizTabuleiro[k][i] = matrizTabuleiro[k-1][i] = matrizTabuleiro[k-2][i]  = matrizTabuleiro[k-3][i] = 4;
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean winHorizontal(int peca){
        for ( int i = 5; i >= 0; i--){ 
            for(int j = 0;j<4; j++){ 
                for(int k = j;k < j+4; k++){
                    if(matrizTabuleiro[i][k] != peca){
                        break;
                    }else if( k == j+3){
                        matrizTabuleiro[i][k] = matrizTabuleiro[i][k-1] = matrizTabuleiro[i][k-2] = matrizTabuleiro[i][k-3] = 4;
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean winDiagonal(int peca){

        // começo da coluna 0 inclinação para cima
        for(int i = 0;i<4; i++){ 
            for ( int j =5; j >= 3; j--){ 
                if(matrizTabuleiro[j][i] == peca && matrizTabuleiro[j-1][i+1]==peca && matrizTabuleiro[j-2][i+2]==peca && matrizTabuleiro[j-3][i+3]==peca){
                    
                    matrizTabuleiro[j][i] = matrizTabuleiro[j-1][i+1] = matrizTabuleiro[j-2][i+2] = matrizTabuleiro[j-3][i+3]= 4;
                    return true;
                }
            }
        }
        // começo da coluna 0 inclinação para baixo
        for(int i = 0;i<4; i++){
            for (int j =0; j < 3; j++){
                if(matrizTabuleiro[j][i] == peca && matrizTabuleiro[j+1][i+1]==peca && matrizTabuleiro[j+2][i+2]==peca && matrizTabuleiro[j+3][i+3]==peca){
                    
                    matrizTabuleiro[j][i] = matrizTabuleiro[j+1][i+1] = matrizTabuleiro[j+2][i+2] = matrizTabuleiro[j+3][i+3] = 4;
                    return true;
                }
            } 
        }

        // começo da coluna 6 inclinação para cima
        for( int i = 6; i<3; i--){
            for (int j =0; j >= 3; j++){ 
                if(matrizTabuleiro[j][i] == peca && matrizTabuleiro[j+1][i-1]==peca && matrizTabuleiro[j+2][i-2]==peca && matrizTabuleiro[j+3][i-3]==peca){
                    
                    matrizTabuleiro[j][i] = matrizTabuleiro[j+1][i-1] = matrizTabuleiro[j+2][i-2] = matrizTabuleiro[j+3][i-3] = 4;
                    return true;
                }
            } 
        }
        // começo da coluna 6 inclinação para baixo
        for(int i = 6; i>=3; i--){
            for ( int j =5; j >= 3; j--){ 
                if((matrizTabuleiro[j][i] == peca) && (matrizTabuleiro[j-1][i-1]==peca) && (matrizTabuleiro[j-2][i-2]==peca) && (matrizTabuleiro[j-3][i-3]==peca)){
                    
                    matrizTabuleiro[j][i] = matrizTabuleiro[j-1][i-1] = matrizTabuleiro[j-2][i-2] = matrizTabuleiro[j-3][i-3] = 4;
                    return true;
                }
            } 
        }
        return false;
    }
    
} 
