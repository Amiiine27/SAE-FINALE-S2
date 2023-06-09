package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import javafx.beans.property.*;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;

public abstract class Acteurs {


    private DoubleProperty X0, Y0; // position de l'axe de rotation
    private IntegerProperty pointsDeVie, degats; // les noms parlent d'eux meme
    private IntegerProperty defense; // pourcentage de réduction des dégats
    private int rayon;


    public Acteurs(double x0, double y0, int pointsDeVie, int degats, int defense) {

        // Coordonnées
        this.X0 = new SimpleDoubleProperty(x0);
        this.Y0 = new SimpleDoubleProperty(y0);


        // Statistiques
        this.pointsDeVie = new SimpleIntegerProperty(pointsDeVie);
        this.degats = new SimpleIntegerProperty(degats);
        this.defense = new SimpleIntegerProperty(defense);


    }

    public Acteurs(double x0, double y0) {

        // Coordonnées
        this.X0 = new SimpleDoubleProperty(x0);
        this.Y0 = new SimpleDoubleProperty(y0);
    }

    public Acteurs(double x0, double y0, int pv, int rayon){
        this.X0 = new SimpleDoubleProperty(x0);
        this.Y0 = new SimpleDoubleProperty(y0);
        this.pointsDeVie = new SimpleIntegerProperty(pv);
        this.rayon = rayon;

    }

    // ______________________ GETTERS ET SETTERS ________________________________________________________________________


    // Coordonnées

    // Getters
    // x0
    public double getX0Value() {
        return this.X0.getValue();
    }      // Valeur x0

    public DoubleProperty getX0Property() {
        return this.X0;
    }  // Property x0

    // y0
    public double getY0Value() {
        return this.Y0.getValue();
    }      // Valeur y0

    public DoubleProperty getY0Property() {
        return this.Y0;
    }  // Property y0

    public int getRayon() {
        return rayon;
    }

    // Setters
    // x0
    public void setX0(double val) {
        this.X0.setValue(val);
    }

    // y0
    public void setY0(double val) {
        this.Y0.setValue(val);
    }

    public void setPosition(double posX, double posY) {
        this.X0.setValue(posX);
        this.Y0.setValue(posY);
    }


    // _________________________________________________________________________________________________________________


    // Statistiques
    // Getters
    // Points De Vie
    public int getPointsDeVieValue() {
        return this.pointsDeVie.getValue();
    }

    // Setters
    // Points De Vie
    public void setPointsDeVieValue(int val) {
        this.pointsDeVie.setValue(val);
    }

    public IntegerProperty getPointsDeVieProperty() {
        return this.pointsDeVie;
    }

    // Degats
    public int getDegatValue() {
        return this.degats.getValue();
    }

    public IntegerProperty getDegatsProperty() {
        return this.degats;
    }

    // Defense
    public int getDefenseValue() {
        return this.defense.getValue();
    }

    // Defense
    public void setDefenseValue(int val) {
        this.defense.setValue(val);
    }

    public IntegerProperty getDefenseProperty() {
        return this.defense;
    }

    // Degats
    public void setDegatsValue(int val) {
        this.degats.setValue(val);
    }


    // _________________________________________________________________________________________________________________

    public void soigner(int val) {
        // Ajouter les points de soin aux points de vie actuels de l'acteur
        int nouvelleVie = this.getPointsDeVieValue() + val;

        // Mettre à jour les points de vie de l'acteur
        this.setPointsDeVieValue(nouvelleVie);
    }

    // _________________________________________________________________________________________________________________
    // Calculs range
    /*public Soldat estDansMaRange(ObservableList<Soldat> soldats){
        //double distance = Math.sqrt(Math.pow(a.getX0Value()-this.getX0Value(), 2) +  Math.pow(a.getY0Value()-this.getY0Value(), 2));
        //return distance <= this.rayon;
        for (Soldat s : soldats){
            if (Math.abs(this.getX0Value()-s.getX0Value()) + (Math.abs(this.getY0Value()-s.getY0Value())) <= this.getRayon()){
                return s;
            }
        }
        return null;

    } */

        public boolean estSoldatDansPortee(Soldat soldat, double x, double y) {
            Point2D coordSoldat = new Point2D(soldat.getX0Value(), soldat.getY0Value());
            Point2D coordPortee = new Point2D(x, y);

            double distance = coordSoldat.distance(coordPortee);

            return distance <= this.getRayon();
        }
}
