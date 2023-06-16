package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import javafx.geometry.Point2D;

import java.util.HashSet;
import java.util.Set;

public class BasePrincipale extends Tour {


    // C'est la base principale, celle qu'il faudra defendre des soldats ennemis et qui sera en bout de course

    Set<Point2D> zone;

    public BasePrincipale(int x0, int y0) {
        super(x0, y0, 10000,0,0,0,null,100); // 2 tiles de portéé
         zone = new HashSet<>();
         initializeZone();
    }

    public void agit(int n) {

        setPointsDeVieValue(this.getPointsDeVieValue()-this.porteeBP().getDegatValue());
    }

    private void initializeZone(){
        for (int x = 88; x <= 90; x++) {
            for (int y = 47; y <= 49; y++) {
                zone.add(new Point2D(x, y));
            }
        }
    }

    public Set<Point2D> getZone(){
        return zone;
    }

    public void testPv() {
        this.setPointsDeVieValue(this.getPointsDeVieValue()-1000);
    }

    /*public void afficherPorteeB(Pane p){
        double rayon = this.getPortée()+30;
        Circle c = new Circle(this.getX0Value(), this.getY0Value(), rayon);
        c.setStroke(Color.GREY);
        c.setFill(Color.TRANSPARENT);
        p.getChildren().add(c);
        System.out.println("portée affichée");
    }*/

    public Soldat porteeBP() {
            for (Soldat s : terrain.getSoldats()) {
                if (s.estVivant()) {
                    double distanceY = Math.abs(s.getY0Value() - getY0Value());
                    System.out.println(distanceY);
                    if (distanceY <= this.getPortée()) {
                        return s;
                    }
                }
            }
            return null;

        // return Math.abs(this.getY0Value() - s.getY0Value()) <= this.getPortée();
    }


}
