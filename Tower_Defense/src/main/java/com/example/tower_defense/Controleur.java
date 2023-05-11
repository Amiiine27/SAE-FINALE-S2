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
                URL herbe = getClass().getResource("green.png");
                Image imgHerbe = new Image(String.valueOf(herbe));
                URL chemin = getClass().getResource("sand.png");
                Image imgChemin = new Image(String.valueOf(chemin));
                if (n == 0){
                    myImageView.setImage(imgHerbe);
                }
                else {
                    myImageView.setImage(imgChemin);
                }
                tilepane.getChildren().add(myImageView);
            }
        }
    }


}
