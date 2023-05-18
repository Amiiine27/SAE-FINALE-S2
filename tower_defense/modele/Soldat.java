package com.example.tower_defense.modele;



public abstract class Soldat extends Acteurs {

    private boolean ennemi;

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense) {
        super(x0, y0, pointsDeVie, degats, defense);
    }

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, boolean ennemi) {
        super(x0, y0, pointsDeVie, degats, defense);
        this.ennemi = ennemi;
    }

    public void deplacer(int deltaX, int deltaY) {

        // Calcul nouvelles coordonnées
        double newX = this.getX0Value() + deltaX;
        double newY = this.getY0Value() + deltaY;


        // Mettre à jour les coordonnées de l'acteur
        setX0(newX);
        setY0(newY);
    }
}
