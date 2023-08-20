package game.user;
import java.util.Random;

public class Maquina extends Jogador{
    private Random random = new Random();
	    
	public Maquina() {
        super(2,"Máquina");
	}

	public int escolherColuna(){
		return random.nextInt(7); 
	}
}
