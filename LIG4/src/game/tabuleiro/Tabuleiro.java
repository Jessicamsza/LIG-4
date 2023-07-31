package game.tabuleiro;

public class Tabuleiro implements TabuleiroLIG4{
    private char[][] matrizTabuleiro = new char[6][7];

    public String isValidCol(int escolha) {
        if (escolha < 0 || escolha > 6) {
            return "indice";
        }
        else if (matrizTabuleiro[0][escolha] != '\0'){
            return "fullCol";
        }
            return "valid";
    }
    
    public void posicionarPeca(int col, char peca){
        int row = this.getLinhaDaJogada(col);
        matrizTabuleiro[row][col] = peca;
    }
    
    protected int getLinhaDaJogada(int col){
        for (int indiceY = (matrizTabuleiro.length-1); indiceY>=0; indiceY--){
            char row = matrizTabuleiro[indiceY][col];
            if (row == '\0'){
                return indiceY;
            }
        }
        // se a coluna estivesse cheia, essa isso é previnido em isValidCol;
        return 0; 
    }
    protected void trocarPecas(int row, int col, char peca){
        if(matrizTabuleiro[row][col] != '\0'){
            matrizTabuleiro[row][col] = peca;
        }
    }

    public void displayTabuleiro() {
        String divisoes = "*" + "-".repeat(27) + "*";
        
        System.out.println(divisoes);
        for (int row = 0; row < matrizTabuleiro.length; row++) {
            for (int col = 0; col < matrizTabuleiro[0].length; col++) {
                char ocupacao = matrizTabuleiro[row][col];
                if (ocupacao == '\0') {
                    ocupacao =' ';
                }
                System.out.print("| " + ocupacao + " " );
            }
            // fim de uma linha
            System.out.println("| ");
            System.out.println(divisoes);
            

        }
        // indicadores do n° da coluna
        for (int col = 0; col < matrizTabuleiro[0].length; col++) {
            System.out.print("  " + (col + 1) + " ");
        }
        System.out.println(" ");
    }

    public void reset(){
        for (int i = (matrizTabuleiro.length-1); i>=0; i--){
            for(int j = (matrizTabuleiro[0].length - 1); j>=0; j--){
                this.matrizTabuleiro[i][j] = '\0';
            }
        }
    }

    public boolean checkTie(){
        for (int i = 0; i<=6;i++){
            if (matrizTabuleiro[0][i] == '\0'){
                return false;
            }
        }
        return true;
    }

    public boolean checkWin(char peca){
        return winVertical(peca) || winHorizontal(peca) || winDiagonal(peca);
    }


    /*
     * recebe como parâmetro a peça do jogador que fez a última jogada
     * 1° for: pecorrer colunas da matriz
     *  2° for: definir o começo de todas as possíveis sequencias de quatro ( 0 a 3, 1 a 4 e 2 a 5)
     *    3° for: percorrer do começo (j) até as proximas 3 casas abaixo e conferir se são iguais a peça
     *       se qualquer casa não for igual a peça, já pode imterromper
     *       se, no ultimo valor para k (j+ 3), não entrou na primera condição: retorna true
     * depois de não achar a sequencia entre todas possíveis posições retorna False
     */
    private boolean winVertical(char peca){
        for ( int i = 0; i < 7; i++){ 
            for( int j = 0; j<3; j++){
                for(int k = j; k < j + 4; k++){
                    if (matrizTabuleiro[k][i] != peca){
                        break;
                    } else if( k == j+ 3){ 
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean winHorizontal(char peca){
        for ( int i = 5; i >= 0; i--){ 
            for(int j = 0;j<4; j++){ 
                for(int k = j;k < j+4; k++){ 
                    if(matrizTabuleiro[i][k] != peca){
                        break;
                    }else if( k == j+3){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    
    private boolean winDiagonal(char peca){

        // começo da coluna 0 e reta inclinada pra cima
        for(int i = 0;i<4; i++){ 
            for ( int j =5; j >= 3; j--){ 
                if(matrizTabuleiro[j][i] == peca && matrizTabuleiro[j-1][i+1]==peca && matrizTabuleiro[j-2][i+2]==peca && matrizTabuleiro[j-3][i+3]==peca){
                    return true;
                }
            }
        }
        // começo da coluna 0 e reta inclinada pra baixo
        for(int i = 0;i<4; i++){
            for (int j =0; j < 3; j++){
                if(matrizTabuleiro[j][i] == peca && matrizTabuleiro[j+1][i+1]==peca && matrizTabuleiro[j+2][i+2]==peca && matrizTabuleiro[j+3][i+3]==peca){
                    return true;
                }
            } 
        }

        // começo da coluna 6 e reta inclinada pra cima
        for( int i = 6; i<3; i--){
            for (int j =0; j >= 3; j++){ 
                if(matrizTabuleiro[j][i] == peca && matrizTabuleiro[j+1][i-1]==peca && matrizTabuleiro[j+2][i-2]==peca && matrizTabuleiro[j+3][i-3]==peca){
                    return true;
                }
            } 
        }
        // começo da coluna 6 e reta inclinada pra baixo
        for(int i = 6; i>=3; i--){
            for ( int j =5; j >= 3; j--){ 
                if((matrizTabuleiro[j][i] == peca) && (matrizTabuleiro[j-1][i-1]==peca) && (matrizTabuleiro[j-2][i-2]==peca) && (matrizTabuleiro[j-3][i-3]==peca)){
                    return true;
                }
            } 
        }
        return false;
    }
    
} 
