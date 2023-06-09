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

    private int indexSoldat = 0;
    private List<Soldat> soldats;
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
        this.soldats = terrain.getSoldats();
        creerAnimationCreationSoldats();
        creerAnimationDeplacementSoldats();
    }

    public void creerAnimationCreationSoldats() {
        KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(5), event -> {  // Créer un nouveau soldat toutes les 5 secondes
            Soldat s = vueSoldats.nouvelleVague();
            soldats.add(s);
        });
        Timeline timelineCreation = new Timeline();
        timelineCreation.getKeyFrames().add(keyFrame1);
        timelineCreation.setCycleCount(Timeline.INDEFINITE);
        timelineCreation.play();
    }

    public void creerAnimationDeplacementSoldats() {
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(0.01), event -> {  // Déplacer les soldats toutes les secondes
            for (Soldat soldat: soldats){
                gestionnaireDeDeplacement.deplacerSoldat(soldat);
            }
        });
        Timeline timelineDeplacement = new Timeline();
        timelineDeplacement.getKeyFrames().add(keyFrame2);
        timelineDeplacement.setCycleCount(Timeline.INDEFINITE);
        timelineDeplacement.play();
    }
}