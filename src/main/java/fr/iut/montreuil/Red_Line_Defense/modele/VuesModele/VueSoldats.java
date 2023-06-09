package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Rookie;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.SuperNova;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class VueSoldats {


    private Pane centerPane;

    private Map<Soldat, Circle> hashMapSoldatsCercles = new HashMap<>();


    public VueSoldats(Pane centerPane) {
        this.centerPane = centerPane;
    }

    public void ajtCercleSoldats(Soldat s) {
        Circle cercleSoldat = new Circle(4, Color.DARKORCHID);
        System.out.println("Cercle créé pour le soldat : " + cercleSoldat);

        hashMapSoldatsCercles.put(s, cercleSoldat);

        cercleSoldat.centerXProperty().bind(s.getX0Property());
        cercleSoldat.centerYProperty().bind(s.getY0Property());

        centerPane.getChildren().add(cercleSoldat);
        System.out.println("Cercle ajouté au pane. Total des cercles : " + centerPane.getChildren().size());

    }

    public Map<Soldat, Circle> getHashMap(){
        return this.hashMapSoldatsCercles;
    }

}
