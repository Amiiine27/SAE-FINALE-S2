package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;


import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import javafx.geometry.Point2D;

import java.util.List;

public abstract class Soldat extends Acteurs {

    private boolean ennemi;
    private int vieInitiale;

    private double destinationX, destinationY;

    private List<Point2D> chemin;
    private int pathPosition = 0;

    private int valeur; // valeur du soldat, permet de déterminer combien le joueur gagne en le tuant

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, double destinationX, double destinationY) {
        super(x0, y0, pointsDeVie, degats, defense);
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, boolean ennemi, int valeur, double destinationX, double destinationY) {
        super(x0, y0, pointsDeVie, degats, defense);
        this.ennemi = ennemi;
        this.valeur = valeur;
        this.vieInitiale = pointsDeVie;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }



    public int valeurGagnee() {

        return this.valeur;
    }

    public double getDestinationX() {
        return this.destinationX;
    }

    public double getDestinationY() {
        return this.destinationY;
    }



}
