package game.ranking;
import java.io.IOException;
import java.util.List;

import game.user.Jogador;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.TextAlignment;
import util.SwitchScenes;

public class RankingController {
    private Ranking ranking = Ranking.getInstance();
    private List<Jogador> listaJogadores = ranking.getListaJogadores();

    @FXML
    private Pane rankingPane;
    @FXML
    private Label legendaLabel;

    public void initialize() {
        ranking.updateRanking();
        displayRanking();
    }

    private void displayRanking() {
        if(listaJogadores.size()==0){
            legendaLabel.setText("Ainda não há Jogadores no Ranking");
            return;
        }
        int maxPlayers = listaJogadores.size() >=10 ? 10: listaJogadores.size();
        for (int i = 0; i < maxPlayers; i++) {
            Jogador jogadorPosicao = listaJogadores.get(i);

            Label rankingLabel = new Label();
            rankingLabel.setText((i+1) + "°.    " + jogadorPosicao.getNome() + "  --   " + jogadorPosicao.getWins());
            rankingLabel.setTextFill(javafx.scene.paint.Color.WHITE);

            rankingLabel.setPrefWidth(300);
            rankingLabel.setLayoutX(0);
            rankingLabel.setLayoutY((i*50));

            Font font = Font.font("Arial Rounded MT Bold", FontWeight.BOLD, 24);
            rankingLabel.setFont(font);
            rankingLabel.setTextAlignment(TextAlignment.CENTER);

            rankingPane.getChildren().add(rankingLabel);
            
        }
    }

    @FXML
    public void voltar(ActionEvent event) throws IOException {
        SwitchScenes.switchScene(event, "/telas/Menu.fxml");
    }
}
