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
        creerAnimation();

    }

    public void creerAnimation() {
        KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.01), event -> {  // 60 FPS
                Soldat s = vueSoldats.nouvelleVague();
            for (Soldat soldat: soldats){
                gestionnaireDeDeplacement.deplacerSoldat(soldat);
            }
        });
        this.timeline.getKeyFrames().add(keyFrame);
        this.timeline.setCycleCount(Timeline.INDEFINITE);
        this.timeline.play();
    }








}

