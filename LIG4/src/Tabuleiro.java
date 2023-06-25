public class Tabuleiro {
    private char[][] matrizTabuleiro = new char[6][7];
    Jogador jogador = new Jogador(true, 'X');
    int posicao = 4; // Exemplo de posição de coluna

    public Tabuleiro() {
    }

    public boolean validColumn() {
        
        boolean validColumn = isValidColumn(posicao);
        
        if (validColumn) {
            jogador.setColumn(posicao);
        } else {
            System.out.println("Coluna inválida!");
        }
        return validColumn;
    }
    
    public static boolean isValidColumn(int posicao) {
        return posicao >= 1 && posicao <= 7;
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
