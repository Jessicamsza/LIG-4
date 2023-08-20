package game;
import java.io.IOException;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import util.SwitchScenes;
import game.tabuleiro.*;
import game.user.*;
import exceptions.ColunaInvalida;


public class Jogo{

    @FXML
    private GridPane interfaceTabuleiro;
    @FXML
    private Button col1, col2, col3, col4, col5, col6, col7;
    @FXML
    private Label jog2Label, jog1Label, jogadorLabel, pontuacao, aviso,vitoriaLabel;
    @FXML
    private Pane buttonsPane;


    private Tabuleiro tabuleiro;
    private Jogador jogador1;
    private Jogador jogador2;
    private Jogador jogadorDaVez;

    public void initData(Tabuleiro modoDeJogo, Jogador jogador1, Jogador jogador2) {
        this.tabuleiro = modoDeJogo;
        this.jogador1 = jogador1;
        this.jogador2 = jogador2;
        this.jogadorDaVez = this.jogador1;

        jog1Label.setText(jogador1.getNome());
        jog2Label.setText(jogador2.getNome());
        jogadorLabel.setText(jogadorDaVez.getNome());
    }

    private void trocarJogadorDaVez(){
        if(jogadorDaVez == jogador1){
            this.jogadorDaVez = jogador2;
        }else{
            this.jogadorDaVez = jogador1;
        }

        jogadorLabel.setText(jogadorDaVez.getNome());
        
        if(jogadorDaVez == jogador1){
            jogadorLabel.setTextFill(Color.web("#df5c5c"));
        }
        else{
            jogadorLabel.setTextFill(Color.web("#ffcf00"));
        }
    }
    

    @FXML
    public void receberColuna (ActionEvent event) throws IOException {
        aviso.setText("");
        Button botaoPressionado = (Button) event.getSource();
        int col = Integer.parseInt(botaoPressionado.getId().substring(3)) - 1; // "colX" -> extrai "X" -1

        try{
            tabuleiro.isValidCol(col);
            fazerJogada(event, col);
        }
        catch(ColunaInvalida e){
            aviso.setText(e.getMessage());
            return;
        }
        
        if(jogador2 instanceof Maquina){
            jogadaMaquina(event);
        }
    }
    
    private void fazerJogada(ActionEvent event, int col){
        int peca = jogadorDaVez.getNum();
        tabuleiro.posicionarPeca(col, jogadorDaVez.getNum());
        
        if(tabuleiro.checkWin(peca)){
            vitoria();
            return;
        }else if(tabuleiro.checkTie()){
            aviso.setText("!EMPATE! O jogo foi resetado.");
            resetar(event);
        }
        trocarJogadorDaVez();
        updateInterface();
    }

    // Representar o Tabuleiro na interface gráfica
    private void updateInterface() {
        int[][] matrizTabuleiro = tabuleiro.getTabuleiro();
        
        for (int row = 0; row < 6; row++) {
            for (int col = 0; col < 7; col++) {
                if(matrizTabuleiro[row][col]==1){
                    Circle peca = new Circle(17, Color.web("#df5c5c"));//rosa
                    peca.setStroke(Color.WHITE);
                    interfaceTabuleiro.add(peca, col, row);
                }
                else if(matrizTabuleiro[row][col]==2){
                    Circle peca = new Circle(17, Color.web("#ffcf00"));//amarelo
                    peca.setStroke(Color.WHITE);
                    interfaceTabuleiro.add(peca, col, row); 
                }
                else if(matrizTabuleiro[row][col]==4) {
                    Circle peca = new Circle(17, Color.web("#00ff40"));//verde
                    peca.setStroke(Color.WHITE);
                    interfaceTabuleiro.add(peca, col, row);
                }
            }
        }
        interfaceTabuleiro.layout();
    }

    
    private void vitoria(){
        buttonsPane.setVisible(false);

        jogadorDaVez.addWin();
        pontuacao.setText(jogador1.getWins() + "  x  " + jogador2.getWins());
        vitoriaLabel.setText("Ponto para " + jogadorDaVez.getNome());
        updateInterface();

        PauseTransition pause = new PauseTransition(Duration.seconds(1.3));
        pause.setOnFinished(evt -> {
            resetar(evt);

            buttonsPane.setVisible(true);
            vitoriaLabel.setText("");

            if(jogadorDaVez instanceof Maquina){
                trocarJogadorDaVez();
            }

        });

        pause.play();
    }

    public void jogadaMaquina(ActionEvent event){

        buttonsPane.setVisible(false);

        PauseTransition pause = new PauseTransition(Duration.seconds(1));
        pause.setOnFinished(evt -> {

            int colMaquina = ((Maquina)jogador2).escolherColuna();

            while(true){
                try{
                    tabuleiro.isValidCol(colMaquina);
                    break;
                }catch (ColunaInvalida e){
                    colMaquina = ((Maquina)jogador2).escolherColuna();
                }
            }

            fazerJogada(event, colMaquina);

            buttonsPane.setVisible(true);
            updateInterface();
        });

        pause.play();
    }

    @FXML
    void resetar(ActionEvent event) {
        tabuleiro.reset();
        interfaceTabuleiro.getChildren().clear();
    }

    @FXML
    void modoDeJogo(ActionEvent event) throws IOException{
        SwitchScenes.switchScene(event, "/telas/ModoDeJogo.fxml");
    }
    @FXML
    void menu(ActionEvent event) throws IOException{
        SwitchScenes.switchScene(event, "/telas/Menu.fxml");
    }
}