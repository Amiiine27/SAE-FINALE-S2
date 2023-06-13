package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;


import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueProjectile;

public class Boulet extends Projectile {
    public Boulet(double x, double y, double xCible, double yCible, double v, int degats, Environnement terrain) {
        super(x, y, xCible, yCible, v,degats,terrain);
    }

    public void deplacement() {
        double deltaX = super.getxDirection() * super.getV();
        double deltaY = super.getyDirection() * super.getV();

        if (!(super.getX()==super.getxCible()) || (super.getY()==super.getyCible())) {
            setX(getX() + deltaX);
            setY(getY() + deltaY);
        }
    }
}