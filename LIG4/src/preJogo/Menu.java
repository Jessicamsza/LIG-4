package preJogo;
import java.io.IOException;
import game.Jogo;
import game.tabuleiro.Tabuleiro;
import game.user.Jogador;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import util.SwitchScenes;

public class Menu {

    @FXML
    void modoDeJogo(ActionEvent event) throws IOException {
        SwitchScenes.switchScene(event, "/telas/ModoDeJogo.fxml");
    }

    
    @FXML
    void regras(ActionEvent event) throws IOException {
        SwitchScenes.switchScene(event, "/telas/Regras.fxml");
    }

    @FXML
    void ranking(ActionEvent event) throws IOException {
        SwitchScenes.switchScene(event, "/telas/Ranking.fxml");
    }
    
    @FXML
    void sair(ActionEvent event) {
        Platform.exit();
    }
    
    @FXML
    public void comecoRapido(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchScenes.class.getResource("/telas/Jogo.fxml"));
            Parent root = loader.load();

            Jogo jogo = loader.getController();
            jogo.initData(new Tabuleiro(), new Jogador(1,"Jogador 1"), new Jogador(2,"Jogador 2"));

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

