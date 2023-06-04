package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.projectile.Projectile;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;

public class TourOffensif extends Tour {
    private DoubleProperty niveau;

    public TourOffensif(int pointsDeVie, int coutFabrication,int defense, double x, double y, double niveau) {
    super(x,y,pointsDeVie,defense,coutFabrication);
        this.niveau = new SimpleDoubleProperty(niveau);
    }




}

