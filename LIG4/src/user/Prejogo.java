package user;
import game.Jogo;

public class Prejogo {

    private Jogo jogo;
    private boolean modoJogo = false;
    private String nome1 = "Jogador 1";
    private String nome2 = "Jogador 2";

    public void escolherModo(){
        int escolha = 0;
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.println("\t\t Escolha o modo de Jogo");
            System.out.println(" 1 - Modo Clássico \n 2- LIG4 Turbo (Qualquer peça vizinha horizontalmente, se transforma na peça inserida \n");
            escolha = InputHandler.getIntInput();

            if(escolha ==1 || escolha ==2){
                if (escolha ==2){
                    modoJogo = true;
                }
                escolherNomes();
                break;
            }
        } 
        jogo = new Jogo(modoJogo, nome1, nome2);
        jogo.jogar();     
    }

    private void escolherNomes(){
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t Escolha do Nome dos Jogadores");
        System.out.println("  Digite \"1\" para pular essa etapa");

        System.out.print("digite o nome do jogador 1 --> ");
        nome1 = InputHandler.getStringInput();

        if(nome1.equals("1")){
            nome1 = "Jogador 1";
            return;
        }
        System.out.print("digite o nome do jogador 2 --> ");  
        nome2 = InputHandler.getStringInput();

        if(nome2.equals("1")){
            nome2 = "Jogador 2";
            return;
        }
    }  
}
