package fr.iut.montreuil.Red_Line_Defense.modele;

import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import java.util.List;
import java.util.Random;

public class Animation {
    private Timeline timeline;
    private Pane centerPane;
    private int tailleImage = 8;
    private Random rand;

    public Animation(Pane centerPane) {
        this.centerPane = centerPane;
        this.rand = new Random();
    }

    public void creerAnimation(List<Point2D> chemin) {
        if (chemin.isEmpty()) {
            throw new IllegalArgumentException("Empty path for animation.");
        }

        Circle cercle = new Circle(tailleImage / 2, Color.RED);
        centerPane.getChildren().add(cercle);
        timeline = new Timeline();

        for (int i = 0; i < chemin.size(); i++) {
            Point2D point = chemin.get(i);
            double randomFactorX = (rand.nextDouble() - 1) * tailleImage / 4;
            double randomFactorY = (rand.nextDouble() - 1) * tailleImage / 4;
            double centerX = point.getX() * tailleImage + tailleImage / 2 + randomFactorX;
            double centerY = point.getY() * tailleImage + tailleImage / 2 + randomFactorY;

            KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5 * i),
                    new KeyValue(cercle.centerXProperty(), centerX),
                    new KeyValue(cercle.centerYProperty(), centerY));
            timeline.getKeyFrames().add(keyFrame);
        }
        timeline.play();
    }

    public void start() {
        if (timeline != null) {
            timeline.play();
        }
    }

    public void stop() {
        if (timeline != null) {
            timeline.stop();
        }
    }
}
