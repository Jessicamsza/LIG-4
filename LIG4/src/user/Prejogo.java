package user;
import java.util.Scanner;
import game.Jogo;

public class Prejogo {

    private static final Scanner scan = new Scanner(System.in);

    private Jogo jogo;

    boolean modoJogo = false;
    private String nome1;
    private String nome2;

    public void escolherModo(){
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t Escolha o modo de Jogo");
        System.out.println(" 1 - Modo Clássico \n 2- LIG4 Turbo (Qualquer peça vizinha horizontalmente, se transforma na peça inserida \n");
        System.out.println(" 3- voltar ao menu");
        int escolha = 0;
        escolha = scan.nextInt();
        if (escolha == 2) {
            modoJogo = true;
        }else if(escolha == 3){
            return;
        }
        escolherNomes();
        jogo = new Jogo(modoJogo, nome1, nome2);
        jogo.jogar();
        scan.close();
    }
    private void escolherNomes(){
        String modo = "MODO CLÁSSICO";
        if (modoJogo){
            modo = "LIG 4 TURBO";
        }
        System.out.print("\033[H\033[2J");
        System.out.println("\t\t Escolhas nome dos Jogadores");
        System.out.println("\tO modo de jogo selecionado foi " + modo );
        System.out.println("\n\t\"1\" para escolher o modo de Jogo novamente");
        System.out.println("\t\"2\" para pular essa etapa \n");

        System.out.print("digite o nome do jogador 1 --> ");
        nome1 = scan.next();
        if (nome1.equals("1")){
            escolherModo();
            return;
        } else if(nome1.equals("2")){
                nome1 = "Jogador 1";
                return;
            }

        System.out.print("digite o nome do jogador 2 --> ");  
        nome2 = scan.next();
            if (nome1.equals("1")){
                escolherModo();
                return;
            } else if(nome2.equals("2")){
                nome2 = "Jogador 2";
                return;
            }
    }  
}
