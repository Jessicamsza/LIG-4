package user;
import java.util.Scanner;

public class InputHandler {
    private static final Scanner scanner = new Scanner(System.in);

    public static int getIntInput() {
        System.out.print("Sua Escolha: ");
        return scanner.nextInt();
    }

    public static String getStringInput() {
        return scanner.next();
    }

    public static void closeScanner() {
        scanner.close();
    }
}
