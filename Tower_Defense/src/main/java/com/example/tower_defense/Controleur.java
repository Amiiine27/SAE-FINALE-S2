package com.example.tower_defense;

import com.example.tower_defense.modele.Map;
import javafx.fxml.Initializable;
import javafx.scene.layout.TilePane;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private Map terrain;
    private TilePane tilepane;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrain = new Map();
    }

    public void remplissage(){
    }
}
