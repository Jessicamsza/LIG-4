package user;

public class Menu {

    private Prejogo prejogo = new Prejogo();

    public void displayMenu(){
        int escolha = 0;
        while(true){
            System.out.print("\033[H\033[2J");
            System.out.println("\t  Bem-vindo ao Jogo Ligue 4!");
            System.out.println("\t"+ "*".repeat(28));
            System.out.println("1 - Jogar");
            System.out.println("2 - Regras");
            System.out.println("3 - Sair");
            
            escolha = InputHandler.getIntInput();
         
            if (escolha == 1){
                prejogo.escolherModo();
                return;
            } else if (escolha==2) {
                regras();
            } else if(escolha==3){
                System.out.println("Obrigado por jogar! Até logo!");
                return;   
            }
        }
    }

    private void regras(){
        while(true){
            System.out.println("\033[H\033[2J");
            System.out.println("\t  Regras do Jogo Ligue 4:");
            System.out.println("\t"+"*".repeat(28));
            System.out.println("- O jogo é jogado em um tabuleiro vertical com 6 linhas e 7 colunas.");
            System.out.println("- Dois jogadores alternam em cada turno, colocando uma peça na coluna de sua escolha.");
            System.out.println("- O objetivo é formar uma sequência de 4 peças, seja na horizontal, vertical ou diagonal.");
            System.out.println("- O primeiro jogador a formar uma sequência de 4 peças vence o jogo.");
            System.out.println("- Se todas as casas do tabuleiro forem preenchidas sem que nenhuma sequência de 4 peças seja formada, o jogo termina em empate.");
            System.out.println("\t" + "*".repeat(28));

            System.out.println("\n Escolha 1 para voltar ao MENU \n ou 2 para começar a JOGAR.");
            int escolha = InputHandler.getIntInput();

            if (escolha ==1) {
                break;
            }else if(escolha ==2 ){
                prejogo.escolherModo();
                break;
            }
        }
    }
}
