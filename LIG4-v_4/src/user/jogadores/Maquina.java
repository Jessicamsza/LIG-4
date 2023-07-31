package user.jogadores;
import java.util.Random;

public class Maquina extends Jogador{
    private Random random = new Random();
	    
	public Maquina(boolean turn, char peca) {
        super(turn, peca);
	}

	public int escolherColuna(){
         try {
            Thread.sleep(200);
        } catch (InterruptedException e){
            return 1;
        }
		return random.nextInt(7) + 1;
        
	}
}
