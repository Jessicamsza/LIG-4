package game;
import board.Tabuleiro;
import board.TabuleiroTurbo;
import user.Jogador;

public class Jogo {
    
    private Tabuleiro tabuleiro;
    private Jogador jog1 = new Jogador(true, 'X');
    private Jogador jog2 = new Jogador(false, 'O');
    private int escolhaJogador;
    private Mensagem mensagem = new Mensagem();

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
        Jogador jogador = jogadorDaRodada();
        mensagem.displayMensagem(jogador.getNome(), null);
        tabuleiro.displayTabuleiro();
        while(true){

            String nome = jogador.getNome();
            char peca = jogador.getPeca();
            this.escolhaJogador = jogador.escolherColuna();
            
            if(this.escolhaJogador == 9){
                System.out.print("\033[H\033[2J");
                System.out.println("Obrigado por jogar! Até logo!");
                return;
            }else if(this.escolhaJogador == 0){
                tabuleiro.reset();
                mensagem.displayMensagem(nome, "reset");
                tabuleiro.displayTabuleiro();
                continue;
            }
            
            if(tabuleiro.isValidCol(escolhaJogador) == 1){
                tabuleiro.posicionarPeca(escolhaJogador,peca);
                boolean win = tabuleiro.checkWin(peca);

                if (win){
                    mensagem.displayVitoria(nome); //  mensagem de vítória, mostra o tabuleiro e finaliza
                    tabuleiro.displayTabuleiro();
                    if(jogador.JogarNovamente()){
                        tabuleiro.reset();
                        mensagem.displayMensagem(nome, "reset");
                        tabuleiro.displayTabuleiro();
                        continue;
                    } else{
                        System.out.print("\033[H\033[2J");
                        System.out.println("Obrigado por jogar! Até logo!");
                        return;
                    }

                }else{ // mensagem regular sem aviso
                    jogador = jogadorDaRodada(); // trocar jogador da rodade só se ele tiver realizado uma jogada
                    mensagem.displayMensagem(jogador.getNome(), null); //mensagem regular sem aviso
                }
            } 
            else if(tabuleiro.isValidCol(escolhaJogador) == 2){
                mensagem.displayMensagem(nome, "indice"); //mensagem regular com aviso
            } 
            else if(tabuleiro.isValidCol(escolhaJogador) == 3){ 
                mensagem.displayMensagem(nome, "fullCol");
            }

            tabuleiro.displayTabuleiro(); // mostar Tabuleiro com a mensagem regular; com aviso ou sem aviso;
        }
    }
}
