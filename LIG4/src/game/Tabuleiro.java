package game;
public class Tabuleiro {
    private char[][] matrizTabuleiro = new char[6][7];
    private Mensagem mesage = new Mensagem();
    private String aviso = null;
    
    public Tabuleiro() {
    }
    
    public boolean isValidCol(int escolha) {
        if (escolha < 1 || escolha > 7) {
            aviso = "indice";
            return false;
        }else if (matrizTabuleiro[0][escolha-1] != '\0'){
            aviso = "fullCol";
            return false;
        }
            return true;
    }

    public void posicionarPeca(int col, char peca){
        int row = this.setRow(col);
        matrizTabuleiro[row][col-1] = peca;
        checkWin(peca);
    }

    // stackando as pecas
    protected int setRow(int col){
        for (int indiceY = (matrizTabuleiro.length-1); indiceY>=0; indiceY--){
            char row = matrizTabuleiro[indiceY][col-1];
            if (row == '\0'){
                return indiceY;
            }
        }
        // se a matriz estiver cheia, essa isso é previnido em isValidCol;
        return 0; 
    }

    // revela o conteúdo de uma determinada posicao na matriz
    protected char getOcupacao(int row,int col){
        return matrizTabuleiro[row][col-1];
    }
    // altera o conteudo de uma determinada posicao na matriz
    protected void setOcupacao(int row,int col, char peca){
        this.matrizTabuleiro[row][col-1] = peca;
    }

    public void displayTabuleiro(String jogRodada) {
        String divisoes = "*" + "-".repeat(27) + "*";

        mesage.displayMensagem(jogRodada, aviso);
        aviso = null;
        
        //System.out.print("\033[H\033[2J");
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
        aviso = "reset";
    }

    public boolean checkWin(char peca){
        return winVertical(peca) || winHorizontal(peca) || winDiagonal(peca);
    }


    /*
     * recebe como parâmetro a peça do jogador que fez a última jogada
     * 1° for serve para pecorrer todas as colunas da matriz
     * 2° for define o começo de todas as pessíveis sequencias de quatro ( 1 a 4, 2 a 5 e 3 a 6)
     * 3° for percorre do começo (j) até as proximas 3 de baixo e confere se é igual á peça do jogador da rodada
     * se a sequencia for imterrompida a qualquer momento, pode finalizar o loop
     * se não entrou no 1° if no ultimo valor de k(j+ 3), há uma sequencia de 4 pecas no Tabuleiro: retorna True
     * depois de não achar a sequencia entre todas possíveis posições retorna False
     */
    private boolean winVertical(char peca){
        for ( int i = 0; i < matrizTabuleiro[0].length - 1; i++){ // de 0 a 6
            for( int j = 0; j<3; j++){ // de 0 a 2
                for(int k = j; k < j + 4; k++){// de j(0,1,2) até j+3(3,4,5)
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
        for ( int i = matrizTabuleiro.length - 1; i >= 0; i--){ // pecorre cara linha de 5 a 0
            for(int j = 0;j<4; j++){ // de 0 a 3
                for(int k = j;k < j+4; k++){ //de j(0,1,2,3) a j+3(3,4,5,6)
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
        return false;
    }
}
