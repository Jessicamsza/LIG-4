package preJogo;
import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import util.SwitchScenes;
import exceptions.NomeException;
import game.Jogo;
import game.ranking.Ranking;
import game.tabuleiro.*;
import game.user.*;

public class ModoDeJogo {

    private Jogador jogador1;
    private Jogador jogador2;
    private Tabuleiro tabuleiro = new Tabuleiro();
    private Ranking ranking = Ranking.getInstance();
    
    @FXML
    private ToggleGroup opcoesModoDeJogo;
    @FXML
    private RadioButton modoClassicoRatio,modoTurboRatio,modoMalucoRatio;

    @FXML
    private Pane paneNivelMaluco;
    @FXML
    private ToggleGroup opcoesNivelMaluco;
    @FXML
    private RadioButton nivelBaixoRatio,nivelMedioRatio,nivelAltoRatio;

    @FXML
    private ToggleGroup opcoesJogadores;
    @FXML
    private RadioButton jogarComDoisJogadores;

    @FXML
    private Label avisoNome1;
    @FXML
    private TextField inputNome1;
    
    @FXML
    private Pane paneJogador2;
    @FXML
    private Label avisoNome2;
    @FXML
    private TextField inputNome2;

    /*
     * opçoes do nivel de maluquisse aperecem somente se "lig4 turbo maluco" estuver selecionado.
     * cria tipo do tabuleiro de acordo com o modo de jogo selecionado
     * o modo turbo maluco precisa de uma função auxiliar pois responde a 2 ratio groups diferentes
     * a opção de escolher o nome do 2° jogador não aperecer se selecionarem jogar contra a máquina
     */
    public void initialize() {
        paneNivelMaluco.visibleProperty().bind(modoMalucoRatio.selectedProperty());

        opcoesModoDeJogo.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if(modoClassicoRatio.isSelected()){
                    this.tabuleiro = new Tabuleiro();
                }
                else if(modoTurboRatio.isSelected()){
                    this.tabuleiro = new TabuleiroTurbo();
                }
                else if (modoMalucoRatio.isSelected()) {
                    atualizarTabuleiroTurboMaluco();
                }
            });

            opcoesNivelMaluco.selectedToggleProperty().addListener((observable, oldValue, newValue) -> {
                if (modoMalucoRatio.isSelected()) {
                    atualizarTabuleiroTurboMaluco();
                }
            });

        paneJogador2.visibleProperty().bind(jogarComDoisJogadores.selectedProperty());
    }

    private void atualizarTabuleiroTurboMaluco() {
        if (nivelBaixoRatio.isSelected()) {
            this.tabuleiro = new TabuleiroTurboMaluco(0.1);
        } else if (nivelMedioRatio.isSelected()) {
            this.tabuleiro = new TabuleiroTurboMaluco(0.3);
        } else if (nivelAltoRatio.isSelected()) {
            this.tabuleiro = new TabuleiroTurboMaluco(0.6);
        }
    }
    
    
    //Confere se os nomes fornecidos são validos antes de iniciar o jogo
    @FXML
    public void receberNomes(ActionEvent event) throws IOException {

        if (inputNome1.getText().isEmpty()) {
            this.jogador1 = new Jogador(1, "Jogador 1");
        }else{
            try {
                String nomeJ1 = validarNome(inputNome1.getText());
                this.jogador1 = new Jogador(1, nomeJ1);
                avisoNome1.setText("");
            } catch (NomeException e) {
                avisoNome1.setText(e.getMessage());
                return;
            }
        }
        if(paneJogador2.isVisible()){
            if (inputNome2.getText().isEmpty()) {
                this.jogador2 = new Jogador(2, "Jogador 2");
            }else{
                try {
                    String nomeJ2 = validarNome(inputNome2.getText());
                    this.jogador2 = new Jogador(2, nomeJ2);
                    avisoNome2.setText("");
                } catch (NomeException e) {
                    avisoNome2.setText(e.getMessage());
                    return;
                }
            }
        }else{
            this.jogador2= (Maquina)new Maquina();
        }

        adicionarJogadoresRanking();
        jogar(event);
    }

    // Iniciar a tela do Jogo com os dados obtidos.
    private void jogar(ActionEvent event) throws IOException {
        try {
            FXMLLoader loader = new FXMLLoader(SwitchScenes.class.getResource("/telas/Jogo.fxml"));
            Parent root = loader.load();

            Jogo jogo = loader.getController();
            jogo.initData(this.tabuleiro, this.jogador1, this.jogador2);

            Scene scene = new Scene(root);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setResizable(false);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // adiciona jogadores ao ranking se tiverem um nome diferente dos nomes padrões
    private void adicionarJogadoresRanking(){
        if (! jogador1.getNome().equals("Jogador 1")){
            ranking.addJogador(jogador1);
        }
        if(!(jogador2.getNome().equals("Jogador 2") || jogador2.getNome().equals("Máquina"))){
            ranking.addJogador(jogador2);
        }
    }
    
    private String validarNome(String nome) throws NomeException {
        if (nome.length() < 3) {
            throw new NomeException("Seu nome deve ter no Mínimo 3 caracteres");
        } else if (nome.length() > 9) {
            throw new NomeException("Seu nome deve ter no Máximo 9 caracteres");
        }
        for (char c : nome.toCharArray()) {
            if (Character.isLetter(c)) {
                return nome.trim();
            }
        }
        throw new NomeException("Seu nome deve ter Pelo Menos 1 Letra");
    }

    @FXML
    public void voltar(ActionEvent event) throws IOException {
        SwitchScenes.switchScene(event, "/telas/Menu.fxml");
    }
}
