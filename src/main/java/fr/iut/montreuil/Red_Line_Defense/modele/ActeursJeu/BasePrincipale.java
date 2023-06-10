package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

public class BasePrincipale extends Tour {


    // C'est la base principale, celle qu'il faudra defendre des soldats ennemis et qui sera en bout de course


    public BasePrincipale(int x0, int y0, Environnement terrain) {
        super(x0, y0, 10000, 0, 0,0, terrain, 8*2); // 2 tiles de portéé
    }

    @Override
    public void agit() {

        setPointsDeVieValue(this.getPointsDeVieValue()-this.porteeBP().getDegatValue());
        System.out.println("---pv base : " + this.getPointsDeVieValue());
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
            System.out.println("entrer fonction");
            for (Soldat s : terrain.getSoldats()) {
                System.out.println("entrer boucle");
                if (s.estVivant()) {
                    System.out.println("vivant");
                    double distanceY = Math.abs(s.getY0Value() - getY0Value());
                    System.out.println(distanceY);
                    if (distanceY <= this.getPortée()) {
                        System.out.println("bonne portée");
                        return s;
                    }
                }
            }
            return null;

        // return Math.abs(this.getY0Value() - s.getY0Value()) <= this.getPortée();
    }


}
