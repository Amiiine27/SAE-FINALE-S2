package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;


import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueProjectile;

public class Boulet extends Projectile {
    public Boulet(double x, double y, double xCible, double yCible, double v, int degats) {
        super(x, y, xCible, yCible, v,degats);
    }

    public void deplacement(double elapsedTime) {
        double deltaX = super.getxDirection() * super.getV() * elapsedTime;
        double deltaY = super.getyDirection() * super.getV() * elapsedTime;

        if (!(super.getX()==super.getxCible()) || (super.getY()==super.getyCible())) {
            setX(getX() + deltaX);
            setY(getY() + deltaY);
        }
    }
}