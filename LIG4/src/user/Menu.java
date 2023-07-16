package user;
import java.util.Scanner;

public class Menu {
    private static final Scanner scan = new Scanner(System.in);
    private Prejogo prejogo = new Prejogo();

    public void displayMenu(){
        System.out.print("\033[H\033[2J");
        System.out.println("\t  Bem-vindo ao Jogo Ligue 4!");
        System.out.println("\t"+ "*".repeat(28));
        System.out.println("1 - Jogar");
        System.out.println("2 - Regras");
        System.out.println("3 - Sair");

        int escolha = 0;
        try{
            System.out.print("Sua escolha: ");
            escolha = scan.nextInt();
        }catch (Exception e) {
            System.out.println("Sua escolha deve ser de 1 a 3: ");
            escolha = scan.nextInt();
        }

        switch (escolha) {
            case 1:
                prejogo.escolherModo();
                displayMenu();
                break;
            case 2:
                Regras();
                break;
            case 3:
                System.out.println("Obrigado por jogar! Até logo!");
                break;
            default:
                displayMenu();
                break;
            }
        scan.close();
    }

    private void Regras(){
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
        int escolha = scan.nextInt();

        switch (escolha) {
            case 2:
                prejogo.escolherModo();
                displayMenu();
                break;
            case 1:
                displayMenu();
                break;
            default:
                Regras();
                break;
        }
    }
}