package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueProjectile;
import javafx.beans.property.DoubleProperty;

import javafx.beans.property.SimpleDoubleProperty;

public abstract class Projectile {
    private double xDépart;
    private double yDépart;
    private DoubleProperty x;
    private DoubleProperty y;
    private DoubleProperty xCible;
    private DoubleProperty yCible;
    private double xDirection;
    private double yDirection;
    private double v;//Vitesse de l'obus

    private Environnement terrain;

    private int degats;

    private VueProjectile vue;

    private boolean touche;

    public Projectile(double x, double y, double xCible, double yCible, double v, int degats,Environnement terrain) {

        this.x = new SimpleDoubleProperty(x);

        this.y = new SimpleDoubleProperty(y);

        xDépart=x;

        yDépart=y;

        this.xCible = new SimpleDoubleProperty(xCible);

        this.yCible = new SimpleDoubleProperty(yCible);

        this.v = v;

        this.degats = degats;
        touche = false;
        this.terrain=terrain;
        double distance = Math.sqrt(Math.pow(xCible - x, 2) + Math.pow(yCible - y, 2));
        this.xDirection = (xCible - x) / distance;
        this.yDirection = (yCible - y) / distance;
    }

    public abstract void deplacement(double elapsedTime);

    public boolean isTouche() {
        return touche;
    }

    public void Agit(VueProjectile v){
        v.animationDeplacement(this);
        if (ennemiÀPorter()){
            touche = true;
        }
    }

    public boolean ennemiÀPorter() {
        for (Soldat s : terrain.getSoldats()) {
            System.out.println("entrer boucle");
            if (s.estVivant()) {
                System.out.println("vivant");
                double distanceX = Math.abs(s.getX0Value() - getX());
                double distanceY = Math.abs(s.getY0Value() - getY());
                double distanceTotale = distanceX + distanceY;
                System.out.println(distanceTotale);
                if (distanceTotale <= 20) {
                    System.out.println("bonne portée");
                    return true;
                }
            }
        }
        return false;
    }

    	/*double deltaX = xDirection * v * elapsedTime;
    	double deltaY = yDirection * v * elapsedTime;

    	if (!(x.getValue().equals(xCible.getValue())) || !(y.getValue().equals(yCible.getValue()))) {
        	x.setValue(getX() + deltaX);
        	y.setValue(getY() + deltaY);
    	}*/

    public double getxCible() {
        return xCible.get();
    }

    public DoubleProperty xCibleProperty() {
        return xCible;
    }

    public double getyCible() {
        return yCible.get();
    }

    public DoubleProperty yCibleProperty() {
        return yCible;
    }

    public double getxDirection() {
        return xDirection;
    }

    public double getyDirection() {
        return yDirection;
    }

    public double getV() {
        return v;
    }

    public DoubleProperty xProperty() {
        return x;
    }

    public DoubleProperty yProperty() {
        return y;
    }

    public double getX() {
        return x.getValue();
    }

    public double getY() {
        return y.getValue();
    }

    public void setX(double x) {
        this.x.set(x);
    }

    public void setY(double y) {
        this.y.set(y);
    }

    public void setxCible(double xCible) {
        this.xCible.set(xCible);
    }

    public void setyCible(double yCible) {
        this.yCible.set(yCible);
    }

    public void setxDirection(double xDirection) {
        this.xDirection = xDirection;
    }

    public void setyDirection(double yDirection) {
        this.yDirection = yDirection;
    }

    public void setV(double v) {
        this.v = v;
    }

    public void setTerrain(Environnement e){
        this.terrain=e;
    }
}