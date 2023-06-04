package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Acteurs;

public class Tour extends Acteurs {

    private int prix;

    public Tour(double x0, double y0, int pointsDeVie, int defense,int prix) {
        super(x0, y0, pointsDeVie, defense);
        this.prix=prix;
    }

    public Tour(double x0, double y0) {
        super(x0, y0);
    }

    public int getPrix() {
        return prix;
    }
}
