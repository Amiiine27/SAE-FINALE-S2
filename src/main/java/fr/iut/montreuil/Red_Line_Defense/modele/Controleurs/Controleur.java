package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import fr.iut.montreuil.Red_Line_Defense.modele.GameLoop;
import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueSoldats;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueTours;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private final int tailleImage = 8;
    private Carte terrain;
    private GestionnaireDeDeplacement gestionnaireDeDeplacement;
    private GameLoop gameLoop;
    private List<Point2D> chemin;

    private VueTours vueTours;

    private VueSoldats vueSoldats;
    @FXML
    private Pane centerPane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        System.out.println("Lancement ...");

        System.out.println("Création de la carte ...");
        terrain = new Carte();

        System.out.println("Remplissage de la carte ...");
        remplissage();

        System.out.println("Initialisation du Gestionnaire De Deplacements ...");
        gestionnaireDeDeplacement = new GestionnaireDeDeplacement(terrain, tailleImage, centerPane);

        System.out.println("Ajouts des Listeners Soldats ...");
        new EcouteSoldats(terrain, (terrain.getSoldatsProperty()));

        System.out.println("Affichage des Soldats ...");
        vueSoldats = new VueSoldats(terrain, centerPane, gestionnaireDeDeplacement);

        System.out.println("Initialisation de la GameLoop ...");
        gameLoop = new GameLoop(centerPane, gestionnaireDeDeplacement, vueSoldats, terrain);

        System.out.println("Intialisation des tours ...");
        vueTours = new VueTours(terrain, centerPane);

        System.out.println("Fin !");
    }


    private void remplissage() {
        for (int i = 0; i < terrain.getYmax(); i++) {
            for (int j = 0; j < terrain.getXmax(); j++) {
                centerPane.getChildren().add(createTerrainImageView(i, j));
            }
        }
    }

    private ImageView createTerrainImageView(int i, int j) {
        int n = terrain.valeurDeLaCase(i, j);
        ImageView imageView = new ImageView(getTerrainImage(n));
        imageView.setTranslateX(j * tailleImage);
        imageView.setTranslateY(i * tailleImage);
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
