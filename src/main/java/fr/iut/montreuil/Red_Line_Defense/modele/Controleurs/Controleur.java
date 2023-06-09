package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import fr.iut.montreuil.Red_Line_Defense.modele.GameLoop;
import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueSoldats;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueTours;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private static final int TAILLE_IMAGE = 8;

    @FXML
    private Button lancerButton;

    private Carte terrain;
    private GestionnaireDeDeplacement gestionnaireDeDeplacement;
    private GameLoop gameLoop;
    private VueTours vueTours;
    private VueSoldats vueSoldats;

    @FXML
    private Pane centerPane;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeCarte();
        initializeGestionnaireDeDeplacement();
        initializeVueTours();
    }

    private void initializeCarte() {
        terrain = new Carte();
        remplissage();
    }

    @FXML
    private void lancerTours() {
        initializeVueSoldats();
        initializeGameLoop();
    }

    private void initializeGestionnaireDeDeplacement() {
        gestionnaireDeDeplacement = new GestionnaireDeDeplacement(terrain, TAILLE_IMAGE, centerPane);
    }

    private void initializeVueTours() {
        vueTours = new VueTours(terrain, centerPane);
    }

    private void initializeVueSoldats() {
        vueSoldats = new VueSoldats(terrain, centerPane, gestionnaireDeDeplacement);
    }

    private void initializeGameLoop() {
        gameLoop = new GameLoop(centerPane, gestionnaireDeDeplacement, vueSoldats, terrain);
    }

    private void remplissage() {
        int xmax = terrain.getXmax();
        int ymax = terrain.getYmax();

        for (int i = 0; i < ymax; i++) {
            for (int j = 0; j < xmax; j++) {
                centerPane.getChildren().add(createTerrainImageView(i, j));
            }
        }
    }

    private ImageView createTerrainImageView(int i, int j) {
        int n = terrain.valeurDeLaCase(i, j);
        ImageView imageView = new ImageView(getTerrainImage(n));
        imageView.setTranslateX(j * TAILLE_IMAGE);
        imageView.setTranslateY(i * TAILLE_IMAGE);
        return imageView;
    }

    private Image getTerrainImage(int n) {
        switch (n) {
            case 1:
                return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/chemin.png");
            default:
                return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/herbeVierge.png");
        }
    }

    public void positionTour(MouseEvent event) {
        vueTours.positionTour(event);
    }

    public void selectionTour(MouseEvent event) {
        vueTours.selectionTour(event);
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }
}
