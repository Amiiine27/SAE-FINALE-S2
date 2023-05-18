package com.example.tower_defense.modele;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleIntegerProperty;
import org.controlsfx.control.action.Action;

public class Projectile extends Acteurs {

    private IntegerProperty X, Y; // Les coordonnées actuelles du projectile
    private DoubleProperty directionX, directionY; // Les directions de déplacement du projectile

    public Projectile(double x, double y, double directionX, double directionY) {
        super(x, y);

        // TODO : Définir les directions de déplacement en fonction de la cible ou de
        this.directionX = new SimpleDoubleProperty(directionX); // exemple
        this.directionY = new SimpleDoubleProperty(directionY); // exemple

    }

    // Met à jour la position du projectile
    public void actualiser() {
        this.setX0(this.getX0Value() + this.getDirectionXValue());
        this.setY0(this.getY0Value() + this.getDirectionYValue());
    }

    // Les accesseurs

    public DoubleProperty getDirectionXProperty() { return this.directionX;}
    public DoubleProperty getDirectionYProperty() { return this.directionY;}

    public double getDirectionXValue() { return this.directionX.getValue();}
    public double getDirectionYValue() { return this.directionY.getValue();}

    public void setDirectionX(double valeur) { this.directionX.setValue(valeur); }
    public void setDirectionY(double valeur) { this.directionY.setValue(valeur); }
}