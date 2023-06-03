package fr.iut.montreuil.Red_Line_Defense;

import fr.iut.montreuil.Red_Line_Defense.modele.Animation;
import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import fr.iut.montreuil.Red_Line_Defense.modele.Controleurs.EcouteSoldats;
import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueSoldats;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueTours;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.*;

public class Controleur implements Initializable {

    private static final String HERBE_VIERGE_IMAGE_PATH = "Images/herbeVierge.png";
    private static final String CHEMIN_IMAGE_PATH = "Images/chemin.png";




    private Carte terrain;
    private final int tailleImage = 8;

    private GestionnaireDeDeplacement gestionnaireDeDeplacement;
    private Animation animation;

    private VueTours vueTours;

    private VueSoldats vueSoldats;
    @FXML
    private Pane centerPane;




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrain = new Carte();
        remplissage();
        gestionnaireDeDeplacement = new GestionnaireDeDeplacement(terrain, tailleImage, centerPane);
        vueTours = new VueTours(terrain, centerPane);
        animation = new Animation(centerPane);
        vueSoldats = new VueSoldats(terrain, centerPane); // Déplacer cette ligne après l'initialisation de vueTours et animation
        new EcouteSoldats(vueSoldats, terrain.getSoldatsProperty());
    }


    private void remplissage() {
        for (int i = 0; i < terrain.getYmax(); i++) {
            for (int j = 0; j < terrain.getXmax(); j++) {
                centerPane.getChildren().add(createTerrainImageView(i, j));
            }
        }
        terrain.afficherSoldat(centerPane);
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
                return loadImage(CHEMIN_IMAGE_PATH);
            default:
                return loadImage(HERBE_VIERGE_IMAGE_PATH);
        }
    }

    public void positionTour(MouseEvent event){
        vueTours.positionTour(event);
    }

    public void selectionTour(MouseEvent event){
        vueTours.selectionTour(event);
    }



    private Image loadImage(String path) {
        return new Image(String.valueOf(getClass().getResource(path)));
    }
}
