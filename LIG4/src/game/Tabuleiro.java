package game;
public class Tabuleiro {
    private char[][] matrizTabuleiro = new char[6][7];
    
    public Tabuleiro() {
    }
    
    public boolean isValidCol(int escolha) {
        if (escolha < 1 || escolha > 7) {
            System.out.println("! A posição deve estar entre 1 e 7 !");
            return false;
        }else if (matrizTabuleiro[0][escolha-1] != '\0'){
            System.out.println("! Essa coluna está cheia !");
            return false;
        }else{
            return true;
        }
    }

    public void posicionarPeca(int col, char peca){
        int row = this.setRow(col);
        matrizTabuleiro[row][col-1] = peca;
    }

    // stackando as pecas
    protected int setRow(int col){
        for (int indiceY = (matrizTabuleiro.length-1); indiceY>=0; indiceY--){
            char row = matrizTabuleiro[indiceY][col-1];
            if (row == '\0'){
                return indiceY;
            }
        }
        // se a matriz estiver cheia, essa isso é previnido em isValidCol(int escolha);
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

    public void displayTabuleiro() {
        String divisoes = "*" + "-".repeat(27) + "*";


        System.out.print("\033[H\033[2J");
        System.out.println("Selecione 9 para finalizar; 0 para resetar \n");
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
}
