package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Acteurs;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.projectile.Projectile;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class TourOffensif extends Tour {
    private DoubleProperty niveau;

    private int portée;

    public TourOffensif(double x, double y, int pointsDeVie, int coutFabrication, int defense) {
        super(x, y, pointsDeVie, defense, coutFabrication);
        this.niveau = new SimpleDoubleProperty(1);
        this.portée = 40;
    }

    public void estÀporter() {
        for (Soldat s : this.terrain.getSoldats()) {
            if (s.estVivant()) {
                if (((this.getY() - portée) <= s.getY() && s.getY() <= this.getY() + portée) && ((this.getX() - portée) <= s.getX() && s.getX() <= this.getX() + portée)) {

                }
            }
        }


    }
}

