package user;
import java.util.Scanner;
import exceptions.ForaDoIndice;
import java.util.InputMismatchException;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput(int upperIndice) throws ForaDoIndice {
        int escolha;
        while (true) {
            System.out.print("Sua Escolha: ");
            try {
                escolha = scanner.nextInt();
                if (escolha >= 1 && escolha <= upperIndice) {
                    return escolha;
                } else {
                    throw new ForaDoIndice("Opção inválida. Escolha um número entre 1 e " + upperIndice);
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Consome a entrada inválida
                throw new ForaDoIndice("Entrada inválida. Digite apenas números inteiros.");
            }
        }
    }

    public static int getColInput() {
        while (true) {
            System.out.print("Sua Escolha: ");
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Consome a entrada inválida
                // Retorna -1 para indicar erro na Mensagem
                return -1;
            }
        }
    }

    public static String getStringInput() {
        return scanner.next();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
