package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Projectile;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class VueProjectile {

    @FXML
    private Pane centerPane;

    public VueProjectile(Pane centerPane){
        this.centerPane=centerPane;
    }
    public void animationDeplacement(Projectile p){
        Circle circle = new Circle(7);
        circle.setFill(Color.BLACK);
        circle.centerXProperty().bind(p.xProperty());
        circle.centerYProperty().bind(p.yProperty());
        AnimationTimer timer = new AnimationTimer() {

            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (lastUpdate > 0) {


                    double elapsedTime = (now - lastUpdate) / 1000000000.0;


                    p.deplacement(elapsedTime);

                }

                lastUpdate = now;
            }
        };

        timer.start();
    }
}
