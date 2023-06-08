package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;

public abstract class Tour extends Acteurs {


    private IntegerProperty X1, Y1; // donne avec l'axe de rotation la direction
    private IntegerProperty prix; // prix d'achat de l'acteur
    private IntegerProperty longueur; // la longueur entre xo;yo et x1;y1


    public Tour(int x0, int y0, int pointsDeVie, int degats, int defense, int prix, int x1, int y1) {
        super(x0, y0, pointsDeVie, degats, defense);

        this.X1 = new SimpleIntegerProperty(x1);
        this.Y1 = new SimpleIntegerProperty(y1);

        this.prix = new SimpleIntegerProperty(prix);


        // initialiserLongueur();
    }

    public Tour(int x0, int y0, int pointsDeVie, int degats, int defense, int x1, int y1) {
        super(x0, y0, pointsDeVie, degats, defense);

        this.X1 = new SimpleIntegerProperty(x1);
        this.Y1 = new SimpleIntegerProperty(y1);

        //initialiserLongueur();

    }

    public Tour(double x0, double y0, int pv){
        super(x0, y0, pv);
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
    public int getX1Value() {
        return this.X1.getValue();
    }

    // Setter X1
    public void setX1Value(int val) {
        this.X1.setValue(val);
    }

    public IntegerProperty getX1Property() {
        return this.X1;
    }

    // Getter Y1
    public int getY1Value() {
        return this.Y1.getValue();
    }

    // Setter Y1
    public void setY1Value(int val) {
        this.Y1.setValue(val);
    }

    public IntegerProperty getY1Property() {
        return this.Y1;
    }

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

    public boolean estEnVie(){
        return this.getPointsDeVieValue()>0;
    }

}
