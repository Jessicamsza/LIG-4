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
	public void setPeca(char peca_nova) {
		this.peca = peca_nova;
	}

	public void setNome(String nome){
		super.setNome(nome);
	}
	public String getnome() {
		return super.getNome();
	}
}
