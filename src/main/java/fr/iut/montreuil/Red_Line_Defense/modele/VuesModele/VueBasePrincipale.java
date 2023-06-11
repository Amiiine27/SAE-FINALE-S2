package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.BasePrincipale;
import javafx.beans.binding.Bindings;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VueBasePrincipale {

    @FXML
    Pane p;

    public VueBasePrincipale(Pane p) {
        this.p = p;
    }

    public void afficherBase(BasePrincipale bp){
        ImageView img = creerImageBP();
        img.setLayoutX(bp.getX0Value()-40);
        img.setLayoutY(bp.getY0Value()-50);

        DoubleProperty progression = new SimpleDoubleProperty(1.0);;
        ProgressBar hpb = creerBarreDeVie(progression, bp.getX0Value(), bp.getY0Value());
        DoubleProperty hp = new SimpleDoubleProperty(bp.getPointsDeVieValue());
        progression.bind(Bindings.divide(bp.getPointsDeVieProperty(), (double) bp.getPointsDeVieValue()));

        p.getChildren().addAll(img, hpb);
    }

    public ProgressBar creerBarreDeVie(DoubleProperty d, double x, double y){
        ProgressBar hpBarre = new ProgressBar();
        hpBarre.progressProperty().bind(d);
        //hpBarre.setPadding(new Insets(2));
        hpBarre.setLayoutX(x-25); // moitié de l'image
        hpBarre.setLayoutY(y-10-17.5); //10 pixels au dessus + la moitié de l'image
        hpBarre.setPrefHeight(10);
        hpBarre.setPrefWidth(100);
        return hpBarre;
    }

    public ImageView creerImageBP() {
        ImageView img = new ImageView(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/bp.png"));
        return img;
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

}
