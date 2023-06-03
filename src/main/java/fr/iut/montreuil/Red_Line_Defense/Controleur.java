package fr.iut.montreuil.Red_Line_Defense;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Rookie;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.TourMitrailleuse;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.TourSniper;
import fr.iut.montreuil.Red_Line_Defense.modele.Animation;
import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.util.Duration;
import java.net.URL;
import java.util.*;

public class Controleur implements Initializable {
    private static final String TOWER_IMAGE_PATH = "Images/tour.png";
    private static final String HERBE_VIERGE_IMAGE_PATH = "Images/herbeVierge.png";
    private static final String CHEMIN_IMAGE_PATH = "Images/chemin.png";
    private static final String TOWER_MAP_IMAGE_PATH = "Images/tourMap.png";
    private static final String BAD_CLICK_IMAGE_PATH = "Images/badClic.png";
    private static final String HIGHLIGHTED_TOWER_IMAGE_PATH = "Images/tour-Surbrillance.png";

    private Carte terrain;
    private final int tailleImage = 8;

    private GestionnaireDeDeplacement gestionnaireDeDeplacement;
    private Animation animation;
    @FXML
    private Pane centerPane;
    @FXML
    private ImageView tour200b, tour400b, tour600b, tour800b;

    private String idTourClicked = "0";

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrain = new Carte();
        remplissage();
        gestionnaireDeDeplacement = new GestionnaireDeDeplacement(terrain, tailleImage, centerPane);
        animation = new Animation(centerPane);
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

    @FXML
    public void positionTour(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        if (tourPosable(x, y)) {
            terrain.ajouterTour(new TourMitrailleuse((int) x,(int) y, 0, 0));
            centerPane.getChildren().add(createTourImageView(x, y));
            resetAllToursToDefault();
        } else {
            showErrorMessage(x, y);
        }
    }

    private ImageView createTourImageView(double x, double y) {
        ImageView maTour = new ImageView(loadImage(TOWER_MAP_IMAGE_PATH));
        maTour.setX(x - 14);
        maTour.setY(y - 17.5);
        return maTour;
    }

    private void resetAllToursToDefault() {
        tour200b.setImage(loadImage(TOWER_IMAGE_PATH));
        tour400b.setImage(loadImage(TOWER_IMAGE_PATH));
        tour600b.setImage(loadImage(TOWER_IMAGE_PATH));
        tour800b.setImage(loadImage(TOWER_IMAGE_PATH));
    }

    private boolean tourPosable(double x, double y) {
        int mapX = (int) x / 8;
        int mapY = (int) y / 8;

        // Vérifier si la case est valide et si elle est libre
        if (mapX >= 0 && mapX < terrain.getXmax() && mapY >= 0 && mapY < terrain.getYmax() && terrain.valeurDeLaCase(mapY, mapX) == 0) {
            // Vérifier si aucune tour n'est déjà positionnée sur cette case
            for (Tour tour : terrain.getTours()) {
                if (((int)(tour.getX0Value() / 8) == mapX) && ((int)(tour.getY0Value() / 8) == mapY)) {
                    System.out.println("Tour deja posée sur " + tour.getX0Value() + " ("+ ((int)tour.getX0Value()/8 ) +") " + tour.getY0Value() + " ("+ ((int)tour.getY0Value()/8) + ") ");
                    return false; // Une tour est déjà positionnée sur cette case
                }
            }
            return true; // La case est libre et aucune tour n'est positionnée dessus
        }
        return false; // La case est invalide ou déjà occupée par une tour
    }


    private void showErrorMessage(double x, double y) {
        ImageView errorImageView = createErrorImageView(x, y);
        centerPane.getChildren().add(errorImageView);
        new Timeline(new KeyFrame(Duration.seconds(0.3), e -> centerPane.getChildren().remove(errorImageView))).play();
        this.idTourClicked = "0";
    }

    private ImageView createErrorImageView(double x, double y) {
        ImageView err = new ImageView(loadImage(BAD_CLICK_IMAGE_PATH));
        err.setX(x - 75);
        err.setY(y - 37.5);
        return err;
    }

    @FXML
    public void selectionTour(MouseEvent event) {
        ImageView image = (ImageView) event.getSource();
        this.idTourClicked = image.getId();

        resetAllToursToDefault();
        image.setImage(loadImage(HIGHLIGHTED_TOWER_IMAGE_PATH));
    }

    private Image loadImage(String path) {
        return new Image(String.valueOf(getClass().getResource(path)));
    }
}
