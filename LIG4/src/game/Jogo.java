package game;
import user.Jogador;

import java.util.Scanner;

public class Jogo {
    private static final Scanner scan = new Scanner(System.in);
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
        tabuleiro.displayTabuleiro(jog1.getNome());
        Jogador jogador = jogadorDaRodada();
        while(true){

            String nome = jogador.getNome();
            char peca = jogador.getPeca();
            
            System.out.print("Selecione uma coluna para Jogar: ");
            this.escolhaJogador = scan.nextInt();
            
            if(this.escolhaJogador == 9){
                scan.close();
                System.out.println("Obrigado por jogar! Até logo!");
                return;
            }else if(this.escolhaJogador == 0){
                tabuleiro.reset();
                tabuleiro.displayTabuleiro(nome);
                continue;
            }
            
            if(tabuleiro.isValidCol(escolhaJogador)){
                tabuleiro.posicionarPeca(escolhaJogador,peca);
                boolean win = tabuleiro.checkWin(peca);
                if (win){
                    vitoria(nome);
                    scan.close();
                    return;
                }else{
                    tabuleiro.displayTabuleiro(nome);
                }
            }else{
                tabuleiro.displayTabuleiro(nome);
                continue;
            }
            jogador = jogadorDaRodada();
        }
    }

    private void vitoria(String nome){
        Mensagem mensagem = new Mensagem();
        mensagem.displayVitoria(nome);
        tabuleiro.displayTabuleiro(nome);
        // input de menu/sair/jogar novamente
    }
}
