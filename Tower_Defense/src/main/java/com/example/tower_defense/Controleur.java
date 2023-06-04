package com.example.tower_defense;

import com.example.tower_defense.modele.Map;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Map terrain;
    @FXML
    private TilePane tilepane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrain = new Map();
        remplissage();
    }

    public void remplissage() {
        for (int i = 0; i < terrain.getYmax(); i++) {
            for (int j = 0; j < terrain.getXmax(); j++) {
                int n = terrain.valeurDeLaCase(i, j);
                ImageView myImageView = new ImageView();
                URL herbeVierge = getClass().getResource("herbeVierge.png");
                URL herbeLimiteHaut = getClass().getResource("herbeLimiteHaut.png");
                URL herbeLimiteDroite = getClass().getResource("herbeLimiteDroite.png");
                URL herbeLimiteBas = getClass().getResource("herbeLimiteBas.png");
                URL herbeLimiteGauche = getClass().getResource("herbeLimiteGauche.png");
                URL herbeCoinHautDroite = getClass().getResource("herbeCoinHautDroite.png");
                URL herbeCoinHautGauche = getClass().getResource("herbeCoinHautGauche.png");
                URL herbeCoinBasDroite = getClass().getResource("herbeCoinBasDroite.png");
                URL herbeCoinBasGauche = getClass().getResource("herbeCoinBasGauche.png");
                URL herbeAngleHautDroite = getClass().getResource("herbeAngleHautDroite.png");
                URL herbeAngleHautGauche = getClass().getResource("herbeAngleHautGauche.png");
                URL herbeAngleBasDroite = getClass().getResource("herbeAngleBasDroite.png");
                URL herbeAngleBasGauche = getClass().getResource("herbeAngleBasGauche.png");
                URL chemin = getClass().getResource("chemin.png");
                Image imgHerbeVierge = new Image(String.valueOf(herbeVierge));
                Image imgChemin = new Image(String.valueOf(chemin));
                Image imgHerbeLimiteHaut = new Image(String.valueOf(herbeLimiteHaut));
                Image imgHerbeLimiteDroite = new Image(String.valueOf(herbeLimiteDroite));
                Image imgHerbeLimiteBas = new Image(String.valueOf(herbeLimiteBas));
                Image imgHerbeLimiteGauche = new Image(String.valueOf(herbeLimiteGauche));
                Image imgHerbeCoinHautDroite = new Image(String.valueOf(herbeCoinHautDroite));
                Image imgHerbeCoinHautGauche = new Image(String.valueOf(herbeCoinHautGauche));
                Image imgHerbeCoinBasDroite = new Image(String.valueOf(herbeCoinBasDroite));
                Image imgHerbeCoinBasGauche = new Image(String.valueOf(herbeCoinBasGauche));
                Image imgHerbeAngleBasGauche = new Image(String.valueOf(herbeAngleBasGauche));
                Image imgHerbeAngleHautDroite = new Image(String.valueOf(herbeAngleHautDroite));
                Image imgHerbeAngleHautGauche = new Image(String.valueOf(herbeAngleHautGauche));
                Image imgHerbeAngleBasDroite = new Image(String.valueOf(herbeAngleBasDroite));

                if (n == 0) {
                    myImageView.setImage(imgHerbeVierge);
                } else if (n == 1) {
                    myImageView.setImage(imgChemin);
                } else if (n == 2) {
                    myImageView.setImage(imgHerbeLimiteHaut);
                } else if (n == 3) {
                    myImageView.setImage(imgHerbeLimiteDroite);
                } else if (n == 4) {
                    myImageView.setImage(imgHerbeLimiteBas);
                } else if (n == 5) {
                    myImageView.setImage(imgHerbeLimiteGauche);
                } else if (n == 6) {
                    myImageView.setImage(imgHerbeCoinHautDroite);
                } else if (n == 7) {
                    myImageView.setImage(imgHerbeCoinHautGauche);
                } else if (n == 8) {
                    myImageView.setImage(imgHerbeCoinBasDroite);
                } else if (n == 9) {
                    myImageView.setImage(imgHerbeCoinBasGauche);
                } else if (n == 10) {
                    myImageView.setImage(imgHerbeAngleBasGauche);
                } else if (n == 11) {
                    myImageView.setImage(imgHerbeAngleHautDroite);
                } else if (n == 12) {
                    myImageView.setImage(imgHerbeAngleHautGauche);
                } else if (n == 13) {
                    myImageView.setImage(imgHerbeAngleBasDroite);
                }

                tilepane.getChildren().add(myImageView);
            }
        }
    }


}
