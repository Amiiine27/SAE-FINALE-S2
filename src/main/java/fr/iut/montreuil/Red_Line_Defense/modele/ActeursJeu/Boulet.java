package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

public class Boulet extends Projectile {
    public Boulet(double x, double y, double xCible, double yCible, double v) {
        super(x, y, xCible, yCible, v);
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


