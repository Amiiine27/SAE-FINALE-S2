package fr.iut.montreuil.Red_Line_Defense.modele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueSoldats;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameLoop {
    private  Carte terrain;
    private Timeline timeline;
    private Pane centerPane;
    private int tailleImage = 8;

    private VueSoldats vueSoldats;

    private GestionnaireDeDeplacement gestionnaireDeDeplacement;


    public GameLoop(Pane centerPane, GestionnaireDeDeplacement gestionnaireDeDeplacement, VueSoldats vueSoldats, Carte terrain) {
        this.centerPane = centerPane;
        this.gestionnaireDeDeplacement = gestionnaireDeDeplacement;
        this.vueSoldats = vueSoldats;
        this.terrain = terrain;
        this.timeline = new Timeline();
        creerAnimation();
    }

    public void creerAnimation() {
        deplacerSoldats(terrain);
        timeline.play();
    }

    public void deplacerSoldats(Carte terrain) {

        ObservableList<Soldat> listeSoldats = terrain.getSoldats();


        for (Soldat soldat : listeSoldats) {
            List<Point2D> chemin = gestionnaireDeDeplacement.trouverChemin(soldat);

            for (int i = 0; i < chemin.size(); i++) {
                Point2D point = chemin.get(i);

                KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5 * i),
                        event -> {
                            soldat.setPosition(point.getX() * tailleImage, point.getY() * tailleImage);
                        });

                timeline.getKeyFrames().add(keyFrame);
            }
        }

    }
}
