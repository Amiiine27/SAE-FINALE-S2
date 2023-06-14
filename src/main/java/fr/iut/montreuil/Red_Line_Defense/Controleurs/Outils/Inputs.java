package fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.GameLoop;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.layout.StackPane;
import javafx.scene.Scene;

public class Inputs {
    private GameLoop gameLoop;
    private Scene scene;
    private Pane pausePane;

    public Inputs(GameLoop gameLoop, Scene scene) {
        this.gameLoop = gameLoop;
        this.scene = scene;


        preparePauseStage();
        ((Pane) scene.getRoot()).getChildren().add(pausePane);
        pausePane.resize(scene.getWidth(), scene.getHeight());
        pauseDuJeu();


    }

    private void pauseDuJeu(){
        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.P) {
                if (gameLoop.getTimeline().getStatus() == Animation.Status.RUNNING) {
                    gameLoop.pauseTimeline();
                    pausePane.setVisible(true);
                } else {
                    pausePane.setVisible(false);
                    gameLoop.lancerTimeline();
                }
            }
        });
    }


    private void preparePauseStage() {
        // Création d'un label avec le texte "PAUSE"
        Label pauseLabel = new Label("PAUSE");
        pauseLabel.setTextFill(Color.RED);
        pauseLabel.setStyle("-fx-font-size: 64px;");

        // Création d'un layout avec un fond semi-transparent
        pausePane = new StackPane(pauseLabel);
        pausePane.setStyle("-fx-background-color: rgba(0, 0, 0, 0.8);"); // Fond noir semi-transparent
        pausePane.setVisible(false); // Initially invisible

        pausePane.prefWidthProperty().bind(scene.widthProperty());
        pausePane.prefHeightProperty().bind(scene.heightProperty());
    }
}
