public class Jogador {
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
}
