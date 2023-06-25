public class Jogador {
	   private boolean turn;
	   private char peca;
	    
	   public Jogador(boolean turn, char peca) {
	       this.turn = turn;
	       this.peca = peca;
	    }
	    
	    public void setColumn(int posicao) {
	        if (posicao < 1 || posicao > 7) {
	            System.out.println("Posição inválida. A posição deve estar entre 1 e 7.");
	            return;
	        }
	        
	        System.out.println("Jogador " + (turn ? "A" : "B") + " jogou a peça " + peca + " na posição " + posicao + ".");
	        
	    }
	}
