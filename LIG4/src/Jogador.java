import java.util.Scanner;

public class Jogador {
	private boolean turn;
	private char peca;
	    
	public Jogador(boolean turn, char peca) {
	    this.turn = turn;
	    this.peca = peca;
	}

	public char getPeca() {
		return peca;
	}
	
	public int seletcCol(){
		Scanner scan = new Scanner(System.in);
		int escolhaJogador;

		System.out.print("Selecione uma coluna para Jogar: ");
        escolhaJogador = scan.nextInt();
		scan.close();

		return escolhaJogador;
	}
}
