import user.InputHandler;
import user.Menu;

public class App {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.menu();
        
        InputHandler.closeScanner();
    }
}
