package fr.iut.montreuil.Red_Line_Defense.modele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueSoldats;
import javafx.animation.KeyFrame;
import javafx.animation.ParallelTransition;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.List;

public class GameLoop {

    private List<Soldat> soldats;
    private Environnement terrain;
    private Pane centerPane;
    private int tailleImage = 8;
    private VueSoldats vueSoldats;


    public GameLoop(Pane centerPane, VueSoldats vueSoldats, Environnement terrain) {
        this.centerPane = centerPane;
        this.vueSoldats = vueSoldats;
        this.terrain = terrain;
        this.soldats = terrain.getSoldats();

       creerAnimation();
    }


    public void creerAnimation() {
        System.out.println("heha");
        KeyFrame keyFrame2 = new KeyFrame(Duration.seconds(0.5), event -> {  // Déplacer les soldats toutes les secondes
            System.out.println("hehe");
            terrain.unTourSoldat();
        }
        );
        KeyFrame keyFrame1 = new KeyFrame(Duration.seconds(0.5), event -> {  // Déplacer les soldats toutes les secondes
            System.out.println("hihi");
            terrain.unTourTours();
        }
        );


        Timeline timelineDeplacement = new Timeline();
        Timeline timelineTours = new Timeline(keyFrame1);
        timelineDeplacement.getKeyFrames().add(keyFrame2);
        timelineDeplacement.setCycleCount(Timeline.INDEFINITE);
        timelineTours.setCycleCount((Timeline.INDEFINITE));
        ParallelTransition animation = new ParallelTransition(timelineDeplacement,timelineTours);
        animation.play();
    }










}

