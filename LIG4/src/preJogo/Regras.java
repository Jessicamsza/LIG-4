package preJogo;
import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import util.SwitchScenes;

public class Regras {

    @FXML
    void choseGameMode(ActionEvent event) throws IOException {
       SwitchScenes.switchScene(event, "/telas/ModoDeJogo.fxml");
    }

    @FXML
    void menu(ActionEvent event) throws IOException {
        SwitchScenes.switchScene(event, "/telas/Menu.fxml");
    }

}

