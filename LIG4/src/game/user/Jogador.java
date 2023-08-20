package game.user;

public class Jogador extends Pessoa{
	private int num;
	    
	public Jogador(int num, String nome) {
		super(nome);
		this.num = num;
	}

	public int getNum(){
		return num;
	}

}
