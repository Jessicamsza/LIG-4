package user;

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

	public int escolherColuna(){
		System.out.println(" > Selecione uma COLUNA para Jogar <");
        return InputHandler.getIntInput();
	}

	public boolean JogarNovamente(){
		int escolha = 0;
        while(true){
            escolha = InputHandler.getIntInput();
            if(escolha == 1){
                return true;
            } else if(escolha==2){
                return false;
            }
        }
    }
}
