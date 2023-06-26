public class Tabuleiro {
    private char[][] matrizTabuleiro = new char[6][7];
    
    public Tabuleiro() {
    }

    public boolean isValidCol(int escolha) {
        if (escolha < 1 && escolha > 7) {
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
        for (int i = (matrizTabuleiro.length-1); i>=0; i--){
            char linha = matrizTabuleiro[i][col-1];
            if (linha == '\0'){
                matrizTabuleiro[i][col-1] = peca;
                break;
            }
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
}
