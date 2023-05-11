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
        //remplissage();
    }



}
