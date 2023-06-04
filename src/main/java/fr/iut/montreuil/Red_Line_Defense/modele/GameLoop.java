package fr.iut.montreuil.Red_Line_Defense.modele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueSoldats;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.List;

public class GameLoop {
    private Carte terrain;
    private Timeline timeline;
    private Pane centerPane;
    private int tailleImage = 8;

    private VueSoldats vueSoldats;

    private GestionnaireDeDeplacement gestionnaireDeDeplacement;

    public GameLoop(Pane centerPane, GestionnaireDeDeplacement gestionnaireDeDeplacement,
                    VueSoldats vueSoldats, Carte terrain) {
        this.centerPane = centerPane;
        this.gestionnaireDeDeplacement = gestionnaireDeDeplacement;
        this.vueSoldats = vueSoldats;
        this.terrain = terrain;
        this.timeline = new Timeline();
        creerAnimation();
        timeline.play();

        System.out.println("1");
    }

    public void creerAnimation() {
        ObservableList<Soldat> listeSoldats = terrain.getSoldats();

        System.out.println("2");

        for (Soldat soldat : listeSoldats) {
            List<Point2D> chemin = gestionnaireDeDeplacement.trouverChemin(soldat);

            System.out.println("3");

            double dureeTotale = 0.5 * chemin.size(); // Durée totale de l'animation en secondes

            for (int i = 0; i < chemin.size() - 1; i++) {
                System.out.println("4");
                Point2D point = chemin.get(i);
                Duration duree = Duration.seconds(dureeTotale * i / chemin.size());

                KeyValue keyValueX = new KeyValue(soldat.getX0Property(), point.getX() * tailleImage);
                KeyValue keyValueY = new KeyValue(soldat.getY0Property(), point.getY() * tailleImage);

                KeyFrame keyFrame = new KeyFrame(duree, keyValueX, keyValueY);
                timeline.getKeyFrames().add(keyFrame);
                System.out.println("5");
            }

            System.out.println("6");
        }
    }
}
