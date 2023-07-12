package user;
import game.Jogo;
import util.*;

public class Menu {
    private Util util = new Util();

    public void displayMenu() throws InputInvalido{
        Jogo jogo = new Jogo();

        System.out.print("\033[H\033[2J");
        System.out.println("\t\tBem-vindo ao Jogo Ligue 4!");
        System.out.println("*************************");
        System.out.println("1 - Jogar");
        System.out.println("2 - Regras");
        System.out.println("3 - Sair");

        int escolha = util.intInput();

        switch (escolha) {
            case 1:
                jogo.jogar();
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
    }

    public void Regras() throws InputInvalido{
        System.out.println("\033[H\033[2J");
        System.out.println("\t\tRegras do Jogo Ligue 4:");
        System.out.println("************************");
        System.out.println("- O jogo é jogado em um tabuleiro vertical com 6 linhas e 7 colunas.");
        System.out.println("- Dois jogadores alternam em cada turno, colocando uma peça na coluna de sua escolha.");
        System.out.println("- O objetivo é formar uma sequência de 4 peças, seja na horizontal, vertical ou diagonal.");
        System.out.println("- O primeiro jogador a formar uma sequência de 4 peças vence o jogo.");
        System.out.println("- Se todas as casas do tabuleiro forem preenchidas sem que nenhuma sequência de 4 peças seja formada, o jogo termina em empate.");
        System.out.println("************************");

        System.out.println("\n Pressione qualquer tecla para voltar ao menu.");
        int escolha = util.intInput();
    }
}
