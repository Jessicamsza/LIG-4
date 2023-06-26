
public class Jogo {
    
    public void jogar(){
        Tabuleiro tabuleiro = new Tabuleiro();
        Jogador jog1 = new Jogador(true, 'B');
        Jogada jogada = new Jogada();

        tabuleiro.displayTabuleiro();

        int escolhaJogador = jog1.seletcCol();

        if(tabuleiro.isValidCol(escolhaJogador)){

            System.out.println("O jogador escolheu uma coluna Válida");
            jogada.setCol(escolhaJogador);
            tabuleiro.posicionarPeca(jogada.getCol(), jog1.getPeca());

        } else {
            System.out.println("Posição inválida. A posição deve estar entre 1 e 7.");
        }

        tabuleiro.displayTabuleiro();
    }
}
