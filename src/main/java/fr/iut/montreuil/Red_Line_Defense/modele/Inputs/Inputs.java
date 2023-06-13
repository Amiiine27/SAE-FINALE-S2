package fr.iut.montreuil.Red_Line_Defense.modele.Inputs;

import fr.iut.montreuil.Red_Line_Defense.modele.GameLoop;
import javafx.animation.Animation;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;

public class Inputs {
    private GameLoop gameLoop;
    private Scene scene;

    public Inputs(GameLoop gameLoop, Scene scene) {
        this.gameLoop = gameLoop;
        this.scene = scene;

        scene.setOnKeyPressed(event -> {
            if (event.getCode() == KeyCode.P) {
                if (gameLoop.getTimeline().getStatus() == Animation.Status.RUNNING) {
                    gameLoop.pauseTimeline();
                } else {
                    gameLoop.lancerTimeline();
                }
            }
        });
    }
}
