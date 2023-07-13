package game;
import user.Jogador;
import java.util.Scanner;

public class Jogo {
    private Tabuleiro tabuleiro;
    private Jogador jog1 = new Jogador(true, 'X');
    private Jogador jog2 = new Jogador(false, 'O');
    private int escolhaJogador;

    public Jogo(boolean modoJogo, String nomeJ1, String nomeJ2){
        if(modoJogo){
            tabuleiro = new TabuleiroTurbo();
        }else{
           tabuleiro = new Tabuleiro();
        }
        jog1.setNome(nomeJ1);

        jog2.setNome(nomeJ2);
    }

    private Jogador jogadorDaRodada(){
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
        tabuleiro.displayTabuleiro();
        while(true){

            Jogador jogador = jogadorDaRodada();
            
            System.out.print("VEZ DE: "+ jogador.getNome()+"\n Selecione uma coluna para Jogar: ");
            this.escolhaJogador = scan.nextInt();
            
            if(this.escolhaJogador == 9){
                scan.close();
                System.out.println("Obrigado por jogar! Até logo!");
                break;
            }
            if(this.escolhaJogador == 0){
                tabuleiro.reset();
                tabuleiro.displayTabuleiro();
                continue;
            }
            
            if(tabuleiro.isValidCol(escolhaJogador)){
                tabuleiro.posicionarPeca(escolhaJogador,jogador.getPeca());
                
            } else {
                System.out.println("Escolha inválida.");
                continue;
            }
            tabuleiro.displayTabuleiro();
        }
    }
}
