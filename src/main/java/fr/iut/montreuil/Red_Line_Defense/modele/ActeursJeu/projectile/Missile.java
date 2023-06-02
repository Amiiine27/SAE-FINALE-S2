package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.projectile;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.projectile.Projectile;

public class Missile extends Projectile {
    public Missile(double x, double y, double xCible, double yCible, double v) {
        super(x, y, xCible, yCible, v);
    }

    public void deplacement(double elapsedTime) {
        double deltaX = getxDirection() * getV() * elapsedTime;
        double deltaY = getyDirection() * getV() * elapsedTime;

        if (!(getX()==getxCible()) || (getY()==getyCible())) {
            setX(getX() + deltaX);
            setY(getY() + deltaY);
        }
        double distance = Math.sqrt(Math.pow(getxCible() - getX(), 2) + Math.pow(getyCible() - getY(), 2));
        setxDirection((getxCible()- getX())/ distance);
        setyDirection((getyCible()- getY()) / distance);
    }
}

