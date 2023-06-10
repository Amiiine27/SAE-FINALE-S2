package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;


import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.*;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.io.InputStream;

public class VueTours {

    public static final String TOWER_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/tour.png";
    public static final String HERBE_VIERGE_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/herbeVierge.png";
    public static final String CHEMIN_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/chemin.png";
    public static final String TOWER_MAP_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/tourMap.png";
    public static final String BAD_CLICK_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/badClic.png";
    public static final String HIGHLIGHTED_TOWER_IMAGE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/tour-surbrillance.png";


    private Environnement terrain;

    @FXML
    private Pane centerPane;


    private String idTourClicked = "0";

    public VueTours(Environnement terrain, Pane centerPane) {
        this.terrain = terrain;
        this.centerPane = centerPane;
    }

    @FXML
    public void positionTour(MouseEvent event) {
        double x = event.getX();
        double y = event.getY();

        System.out.println("x" + x + " y" + y);

        if (idTourClicked.equals("0")) {
            // Aucune tour sélectionnée, afficher un message d'erreur
            showErrorMessage(x, y);
        } else {
            if (tourPosable(x, y)) {
                switch (idTourClicked) {
                    case "tour200b":
                        ToursDeffensives td = new ToursDeffensives((int) x,(int) y, terrain);
                        terrain.ajouterTour(td);
                        td.afficherPortee(centerPane);
                        break;

                    case "tour400b":
                        TourMitrailleuse tm = new TourMitrailleuse((int) x, (int) y,terrain);
                        terrain.ajouterTour(tm);
                        tm.afficherPortee(centerPane);
                        break;

                    case "tour600b":
                        TourSniper ts = new TourSniper((int) x, (int) y,terrain);
                        terrain.ajouterTour(ts);
                        ts.afficherPortee(centerPane);
                        break;
                    case "tour800b":
                        TourLanceMissile tlm = new TourLanceMissile((int) x, (int) y,terrain);
                        terrain.ajouterTour(tlm);
                        tlm.afficherPortee(centerPane);
                        break;
                }
                centerPane.getChildren().add(createTourImageView(x, y));

                idTourClicked = "0"; // Réinitialiser la sélection de la tour
            } else {
                showErrorMessage(x, y);
            }
        }
    }


    private ImageView createTourImageView(double x, double y) {
        ImageView maTour = new ImageView(loadImage(TOWER_MAP_IMAGE_PATH));
        maTour.setX(x - 14);
        maTour.setY(y - 17.5);
        return maTour;
    }


    private boolean tourPosable(double x, double y) {
        int mapX = (int) x / 8;
        int mapY = (int) y / 8;

        // Vérifier si la case est valide et si elle est libre
        if (mapX >= 0 && mapX < terrain.getXmax() && mapY >= 0 && mapY < terrain.getYmax() && terrain.valeurDeLaCase(mapY, mapX) == 0) {
            // Vérifier si aucune tour n'est déjà positionnée sur cette case
            for (Tour tour : terrain.getTours()) {
                if (((int) (tour.getX0Value() / 8) == mapX) && ((int) (tour.getY0Value() / 8) == mapY)) {
                    System.out.println("Tour deja posée sur " + tour.getX0Value() + " (" + ((int) tour.getX0Value() / 8) + ") " + tour.getY0Value() + " (" + ((int) tour.getY0Value() / 8) + ") ");
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


        image.setImage(loadImage(HIGHLIGHTED_TOWER_IMAGE_PATH));
    }

    private Image loadImage(String path) {
        try {
            InputStream inputStream = getClass().getResourceAsStream(path);
            if (inputStream != null) {
                return new Image(inputStream);
            } else {
                System.err.println("Could not load image: " + path);
                return null;
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}