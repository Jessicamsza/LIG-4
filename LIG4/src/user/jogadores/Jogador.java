package user.jogadores;
import exceptions.ColunaInvalida;
import exceptions.ForaDoIndice;
import user.InputHandler;

public class Jogador extends Pessoa{
	private boolean turn;
	private char peca;
	    
	public Jogador(boolean turn, char peca) {
	    this.turn = turn;
	    this.peca = peca;
	}

	public void setTurn(boolean turn){
		this.turn = turn;
	}

	public boolean getTurn(){
		return turn;
	}

	public char getPeca() {
		return peca;
	}

	public int escolherColuna() throws ColunaInvalida{
		System.out.println(" > Selecione uma COLUNA para Jogar <");
		return InputHandler.getColInput();
	}

	public boolean JogarNovamente(){
		int escolha = 0;
        while(true){
            try{
                escolha = InputHandler.getIntInput(2);
            } catch(ForaDoIndice e){
                System.out.println(e.getMessage());
            }
            if(escolha == 1){
                return true;
            } else if(escolha==2){
                return false;
            }
        }
    }
}
