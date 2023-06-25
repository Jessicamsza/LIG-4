public class Tabuleiro {
    private int[] matrizTabuleiro = new int[42]; 
    public Tabuleiro() {
        Jogador jogador = new Jogador(true, 'X');
        int posicao = 4; // Exemplo de posição de coluna
    }

    public void displayTabuleiro() {
        
    }
    public boolean validColumn() {
        
        boolean validColumn = isValidColumn(posicao);
        
        if (validColumn) {
            jogador.setColumn(posicao);
        } else {
            System.out.println("Coluna inválida!");
        }
    }
    
    public static boolean isValidColumn(int posicao) {
        return posicao >= 1 && posicao <= 7;
    }
}
