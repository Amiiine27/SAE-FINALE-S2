package fr.iut.montreuil.Red_Line_Defense.Vues;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.fxml.FXML;
import javafx.geometry.Point2D;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VueBasePrincipale {

    @FXML
    Pane p;

    private BasePrincipale basePrincipale;

    private ProgressBar barreDeVieBasePrincipale;

    public VueBasePrincipale(Pane p) {
        this.p = p;
        basePrincipale = new BasePrincipale(700, 335);
        afficherBase();
    }


    public void afficherBase(){
        ImageView img = creerImageBP();
        img.setLayoutX(basePrincipale.getX0Value()-40);
        img.setLayoutY(basePrincipale.getY0Value()-50);

        DoubleProperty progression = new SimpleDoubleProperty(1.0);;
        barreDeVieBasePrincipale = creerBarreDeVie(progression, basePrincipale.getX0Value(), basePrincipale.getY0Value());


        p.getChildren().addAll(img, barreDeVieBasePrincipale);
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

    public ProgressBar getBarreDeVieBasePrincipale(){
        return barreDeVieBasePrincipale;
    }

    public void actionBasePrincipale(ListProperty<Soldat> listeSoldats){
        for (Soldat s: listeSoldats.getValue()) {
            Point2D positionSoldat = new Point2D(s.getX0Value()/8, s.getY0Value()/8);
            if (basePrincipale.getZone().contains(positionSoldat)) {
                System.out.println("Soldat Arrivé devant le chateau");
                basePrincipale.infligerDegats(300);
                s.setPointsDeVieValue(-1);
            }
        }
    }

    public ImageView creerImageBP() {
        ImageView img = new ImageView(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/BasePrincipale.png"));
        return img;
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

    public BasePrincipale getBasePrincipale() {
        return basePrincipale;
    }

    public int getPointsDeVieBasePrincipale(){
        return basePrincipale.getPointsDeVieValue();
    }

}
