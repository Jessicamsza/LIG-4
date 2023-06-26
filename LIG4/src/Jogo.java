import java.util.Scanner;
public class Jogo {
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Jogador jog1 = new Jogador(true, 'X');
    private Jogador jog2 = new Jogador(false, 'O');
    private int escolhaJogador;
    

    public Jogador jogadorDaRodada(){
        if(jog1.getTurn()){
                jog1.setTurn(false);
                jog2.setTurn(true);
                return jog1;
            }else{
                jog2.setTurn(false);
                jog1.setTurn(true);
                return jog2;
            }
    }

    public void jogar(){
        Scanner scan = new Scanner(System.in);
        Jogada jogada = new Jogada();

        System.out.println("Digite 9 para finzalizar; 0 para Resetar");
        tabuleiro.displayTabuleiro();
        while(true){
            Jogador jogador = jogadorDaRodada();

            System.out.print("Selecione uma coluna para Jogar: ");
            this.escolhaJogador = scan.nextInt();
            
            if(this.escolhaJogador == 9){
                scan.close();
                System.out.println("Fim do Jogo");
                break;
            }
            if(this.escolhaJogador == 0){
                tabuleiro.reset();
                System.out.println("O jogo foi resetado!");
                tabuleiro.displayTabuleiro();
                continue;
            }

            if(tabuleiro.isValidCol(escolhaJogador)){
                jogada.setCol(escolhaJogador);
                tabuleiro.posicionarPeca(jogada.getCol(), jogador.getPeca());

            } else {
                System.out.println("Escolha inválida.");
                continue;
            }

            tabuleiro.displayTabuleiro();
        }
    }
}
