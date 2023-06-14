package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;


import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueProjectile;

public class Missile extends Projectile {
    private Soldat s;
    public Missile(double x, double y, double v, int degats, Soldat s, Environnement terrain) {
        super(x, y, s.getX0Value(), s.getY0Value(), v, degats,terrain);
        this.s=s;
    }

    public void deplacement(double elapsedTime) {
        double deltaX = getxDirection() * getV()* elapsedTime;
        double deltaY = getyDirection() * getV()* elapsedTime;

        if (!(getX()==s.getX0Value()) || (getY()==s.getY0Value())) {
            setX(getX() + deltaX);
            setY(getY() + deltaY);
        }
        double distance = Math.sqrt(Math.pow(s.getX0Value() - getX(), 2) + Math.pow(s.getY0Value() - getY(), 2));
        setxDirection((s.getX0Value()- getX())/ distance);
        setyDirection((s.getY0Value()- getY()) / distance);
    }
}

