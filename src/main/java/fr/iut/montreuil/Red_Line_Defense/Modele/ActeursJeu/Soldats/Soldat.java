package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats;



import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Acteurs;
import javafx.geometry.Point2D;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class Soldat extends Acteurs {
    private double destinationX, destinationY;

    public String couleur;

    private List<Point2D> chemin;
    private int pathPosition = 0;

    private Set<Point2D> zone;

    private int pointsDeVie;
    private boolean estPiégé;
    private int valeur; // valeur du soldat, permet de déterminer combien le joueur gagne en le tuant

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, double destinationX, double destinationY) {
        super(x0, y0, pointsDeVie, degats, defense);
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.zone = new HashSet<Point2D>();
        estPiégé=false;
        créerZone();
    }

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, int valeur, double destinationX, double destinationY) {
        super(x0, y0, pointsDeVie, degats, defense);
        this.valeur = valeur;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.zone = new HashSet<Point2D>();
        estPiégé=false;
        créerZone();
    }


    public boolean estVivant(){
        return (this.getPointsDeVieValue() > 0);
    }


    public int getValeurGagnee() {
        return this.valeur;
    }



    public void créerZone() {
        for (int xZone = 88; xZone <= 90; xZone++) {
            for (int yZone = 47; yZone <= 49; yZone++) {
                zone.add(new Point2D(xZone, yZone));
            }
        }
    }

    public String getCouleur() {
        return this.couleur;
    }

    public Set<Point2D> getZone(){
        return this.zone;
    }

    public double getDestinationX() {
        return this.destinationX;
    }

    public double getDestinationY() {
        return this.destinationY;
    }

    public boolean isEstPiégé(){
        return estPiégé;
    }
    public void estPiégés(){
        estPiégé=true;
    }
    public void libéré(){
        estPiégé=false;
    }

}
