package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Acteurs {


    private DoubleProperty X0, Y0; // position de l'axe de rotation
    private IntegerProperty pointsDeVie;
    private IntegerProperty defense; // pourcentage de réduction des dégats

    protected Carte terrain;



    public Acteurs(double x0, double y0, int pointsDeVie, int defense) {

        // Coordonnées
        this.X0 = new SimpleDoubleProperty(x0);
        this.Y0 = new SimpleDoubleProperty(y0);


        // Statistiques
        this.pointsDeVie = new SimpleIntegerProperty(pointsDeVie);
        this.defense = new SimpleIntegerProperty(defense);

        //this.terrain=terrain;


    }

    public Acteurs(double x0, double y0) {

        // Coordonnées
        this.X0 = new SimpleDoubleProperty(x0);
        this.Y0 = new SimpleDoubleProperty(y0);
    }

    // ______________________ GETTERS ET SETTERS ________________________________________________________________________


    // Coordonnées

        // Getters
            // x0
            public double getX() { return this.X0.getValue(); }      // Valeur x0
            public DoubleProperty getX0Property() { return this.X0; }  // Property x0

            // y0
            public double getY() { return this.Y0.getValue(); }      // Valeur y0
            public DoubleProperty getY0Property() { return this.Y0; }  // Property y0




        // Setters
            // x0
            public void setX0(double val) { this.X0.setValue(val); }

            // y0
            public void setY0(double val) { this.Y0.setValue(val); }



    // _________________________________________________________________________________________________________________


    // Statistiques
        // Getters
            // Points De Vie
            public int getPointsDeVieValue() { return this.pointsDeVie.getValue(); }
            public IntegerProperty getPointsDeVieProperty() { return this.pointsDeVie; }

            // Degats


            // Defense
            public int getDefenseValue() { return this.defense.getValue();}
            public IntegerProperty getDefenseProperty() { return this.defense; }




        // Setters
            // Points De Vie
            public void setPointsDeVieValue(int val) { this.pointsDeVie.setValue(val); }

            // Degats


            // Defense
            public void setDefenseValue(int val) { this.defense.setValue(val); }





    // _________________________________________________________________________________________________________________


        public void soigner(int val) {
            // Ajouter les points de soin aux points de vie actuels de l'acteur
            int nouvelleVie = this.getPointsDeVieValue() + val;

            // Mettre à jour les points de vie de l'acteur
            this.setPointsDeVieValue(nouvelleVie);
        }













}
