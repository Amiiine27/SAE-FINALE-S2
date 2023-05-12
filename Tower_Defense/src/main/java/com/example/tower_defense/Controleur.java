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
    public void remplissage(){
        for (int i=0; i<terrain.getYmax(); i++){
            for (int j=0; j<terrain.getXmax();j++) {
                int n = terrain.valeurDeLaCase(i, j);
                ImageView myImageView = new ImageView();
                URL herbeVierge = getClass().getResource("herbeVierge.png");
                URL herbeLimiteHaut = getClass().getResource("herbeLimiteHaut.png");
                URL herbeLimiteDroite = getClass().getResource("herbeLimiteDroite.png");
                URL herbeLimiteBas = getClass().getResource("herbeLimiteBas.png");
                URL herbeLimiteGauche = getClass().getResource("herbeLimiteGauche.png");
                URL chemin = getClass().getResource("chemin.png");
                Image imgHerbeVierge = new Image(String.valueOf(herbeVierge));
                Image imgChemin = new Image(String.valueOf(chemin));
                Image imgherbeLimiteHaut = new Image(String.valueOf(herbeLimiteHaut));
                Image imgherbeLimiteDroite = new Image(String.valueOf(herbeLimiteDroite));
                Image imgherbeLimiteBas = new Image(String.valueOf(herbeLimiteBas));
                Image imgherbeLimiteGauche = new Image(String.valueOf(herbeLimiteGauche));
                if (n == 0){
                    myImageView.setImage(imgHerbeVierge);
                }
                else if (n == 1){
                    myImageView.setImage(imgChemin);
                }
                else if (n == 2){
                    myImageView.setImage(imgherbeLimiteHaut);
                }
                else if (n == 3){
                    myImageView.setImage(imgherbeLimiteDroite);
                }
                else if (n == 4){
                    myImageView.setImage(imgherbeLimiteBas);
                }
                else if (n == 5){
                    myImageView.setImage(imgherbeLimiteGauche);
                }
                tilepane.getChildren().add(myImageView);
            }
        }
    }


}
