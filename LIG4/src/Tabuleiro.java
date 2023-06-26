ppublic class Tabuleiro {
    private char[][] matrizTabuleiro = new char[6][7];
    
    public Tabuleiro() {
    }

    public boolean isValidCol(int escolha) {
        return escolha >= 1 && escolha <= 7;
    }

    public void posicionarPeca(int col, char peca){
        // 6° linha
        matrizTabuleiro[5][col - 1] = peca;
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
}
