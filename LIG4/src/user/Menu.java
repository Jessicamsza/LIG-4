package user;

import exceptions.ForaDoIndice;

public class Menu {

    private Prejogo prejogo = new Prejogo();

    public static void displayMenu(){
        System.out.print("\033[H\033[2J");
        System.out.println("\t  Bem-vindo ao Jogo Ligue 4!");
        System.out.println("\t"+ "*".repeat(28));
        System.out.println("1 - Jogar");
        System.out.println("2 - Regras");
        System.out.println("3 - Sair");
    }
    public void menu(){
        displayMenu();
        while(true){
            try {
                int escolha = InputHandler.getIntInput(3);
                if (escolha == 1) {
                    prejogo.escolherModo();
                    displayMenu();
                } else if (escolha == 2) {
                    regras();
                } else if (escolha == 3) {
                    System.out.println("Obrigado por jogar! Até logo!");
                    return;
                }
            } catch (ForaDoIndice e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void regras(){

        System.out.println("\033[H\033[2J");
        System.out.println("\t  Regras do Jogo Ligue 4:");
        System.out.println("\t"+"*".repeat(28));
        System.out.println("- O jogo é jogado em um tabuleiro vertical com 6 linhas e 7 colunas.");
        System.out.println("- Dois jogadores alternam em cada turno, colocando uma peça na coluna de sua escolha.");
        System.out.println("- O objetivo é formar uma sequência de 4 peças, seja na horizontal, vertical ou diagonal.");
        System.out.println("- O primeiro jogador a formar uma sequência de 4 peças vence o jogo.");
        System.out.println("- Se todas as casas do tabuleiro forem preenchidas sem que nenhuma sequência de 4 peças seja formada, o jogo termina em empate.\n");
        System.out.println("Modos de jogo alternativos:");
        System.out.println("LIG 4 TURBO: ao inserir uma peça, qualquer peça vizinha horizontalmente a ela deve se transformar na peça inserida.");
        System.out.println("LIG 4 TURBO MALUCO: qualquer peça vizinha em qualquer direção à peça inserida poderá se se transormar na peça inserida, de acordo com uma probabilidade definida pelo Nível de Maluquice");
        System.out.println("\t" + "*".repeat(28));
        
        while(true){
            System.out.println("\n Escolha 1 para voltar ao MENU \n ou 2 para começar a JOGAR.");
            try{
                int escolha = InputHandler.getIntInput(2);
                if (escolha ==1) {
                    break;
                }else if(escolha ==2 ){
                    prejogo.escolherModo();
                    break;
                }
            } catch(ForaDoIndice e){
                System.out.println(e.getMessage());
            }
        }
        displayMenu();
    }
}
