package game;
import game.tabuleiro.*;
import user.jogadores.*;
import exceptions.ColunaInvalida;
import exceptions.ForaDoIndice;

public class Jogo{
    
    private Tabuleiro tabuleiro;
    private Jogador jogador1 = new Jogador(true, 'X');
    private Jogador jogador2;
    private int escolhaJogador;
    private Mensagem mensagem;

    public Jogo(String modoJogo, boolean singlePlayer, String nomeJ1, String nomeJ2){
        if (modoJogo.equals("normal")){
            tabuleiro = new Tabuleiro();
        }
        else if (modoJogo.equals("turbo")){
            tabuleiro = new TabuleiroTurbo();
        } 
        else if (modoJogo.equals("turbo maluco 1")){
            tabuleiro = new TabuleiroTurboMaluco(0.1);
        } 
        else if (modoJogo.equals("turbo maluco 2")){
            tabuleiro = new TabuleiroTurboMaluco(0.3);
        }
        else if (modoJogo.equals("turbo maluco 3")){
            tabuleiro = new TabuleiroTurboMaluco(0.6);
        }

        jogador2 = singlePlayer ? new Maquina(false, 'Y') : new Jogador(false, 'Y');

        mensagem = new Mensagem(jogador1, jogador2);
        jogador1.setNome(nomeJ1);
        jogador2.setNome(nomeJ2);
    }

    public Jogador jogadorDaRodada(){
        if(jogador1.getTurn()){
            jogador1.setTurn(false);
            jogador2.setTurn(true);
            return jogador1;
        }else{
            jogador2.setTurn(false);
            jogador1.setTurn(true);
            return jogador2;
        }
    }
    
    public void jogar(){
        Jogador jogador = jogadorDaRodada();
        mensagem.displayMensagem(jogador);
        
        while(true){

            char peca = jogador.getPeca();
            tabuleiro.displayTabuleiro();
            
            try{
                this.escolhaJogador = jogador.escolherColuna(); 
            }catch (ColunaInvalida e){
                mensagem.displayMensagem(jogador, e.getMessage());
                continue;
            }

            if(escolhaJogador == 9){
                return;
            }else if(escolhaJogador == 0){
                tabuleiro.reset();
                mensagem.displayMensagem(jogador,"! O jogo foi Resetado !\n");
                continue;
            }


            try{
                tabuleiro.isValidCol(escolhaJogador-1);
            }catch (ColunaInvalida e){
                mensagem.displayMensagem(jogador, e.getMessage());
                continue;
            }catch (ForaDoIndice e){
                mensagem.displayMensagem(jogador, e.getMessage());
                continue;
            }

                
            tabuleiro.posicionarPeca(escolhaJogador - 1,peca);
            boolean win = tabuleiro.checkWin(peca);
            boolean tie = tabuleiro.checkTie();

            
            if(win || tie){
                
                if (win){
                    jogador.addWin();
                    mensagem.displayVitoria(jogador);
                } else if(tie){
                    mensagem.displayEmpate();
                }

                tabuleiro.displayTabuleiro();
                if(jogador.JogarNovamente()){
                    tabuleiro.reset();
                    mensagem.displayMensagem(jogador,"! O jogo Recomeçou !\n");
                } 
                else{
                    return;
                }
            } else{ 
                jogador = jogadorDaRodada(); 
                mensagem.displayMensagem(jogador);
            } 
            
        }
    }
}
