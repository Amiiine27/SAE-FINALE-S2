package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tour extends Acteurs {
    private IntegerProperty prix; // prix d'achat de l'acteur
    private IntegerProperty longueur; // la longueur entre xo;yo et x1;y1

    private Environnement terrain;

    private double portée;

    public double getPortée() {
        return portée;
    }

    public Tour(int x0, int y0, int pointsDeVie, int degats, int defense, int prix, Environnement terrain) {
        super(x0, y0, pointsDeVie, degats, defense);

        this.prix = new SimpleIntegerProperty(prix);

        this.terrain = terrain;


        // initialiserLongueur();
    }

    public Tour(int x0, int y0, int pointsDeVie, int degats, int defense, Environnement terrain) {
        super(x0, y0, pointsDeVie, degats, defense);

        this.terrain = terrain;

        //initialiserLongueur();

    }

    /* public void initialiserLongueur() {

        // Calculer la distance entre (X0, Y0) et (X1, Y1)
        double deltaX = this.getX1Value() - this.getX0Value();
        double deltaY = this.getY1Value() - this.getY0Value();

        // Utiliser le théorème de Pythagore pour calculer la longueur
        int nouvelleLongueur = (int) Math.sqrt(deltaX * deltaX + deltaY * deltaY);

        // Mettre à jour la longueur
        this.setLongueur(nouvelleLongueur);

    } */


    // Getter X1


    // Getter Prix
    public int getPrixValue() {
        return this.prix.getValue();
    }

    // Setter Prix
    public void setPrixValue(int val) {
        this.prix.setValue(val);
    }

    public IntegerProperty getPrixProperty() {
        return this.prix;
    }

    // Getter Longueur
    public int getLongueurValue() {
        return this.longueur.getValue();
    }

    public IntegerProperty getLongueurProperty() {
        return this.longueur;
    }

    // Setter Longueur
    public void setLongueur(int val) {
        this.longueur.setValue(val);
    }

    public Environnement getTerrain() {
        return terrain;
    }

    public Soldat ennemiÀPorter() {
        for (Soldat s : this.terrain.getSoldats()) {
            if (s.estVivant()) {
                if (((this.getY0Value() - getPortée()) <= s.getY0Value() && s.getY0Value() <= this.getY0Value() + getPortée()) && ((this.getX0Value() - getPortée()) <= s.getX0Value() && s.getX0Value() <= this.getX0Value() + getPortée())) {
                    return s;
                }
            }
        }
        return null;
    }

}
