package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Rookie;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.Animation;
import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import fr.iut.montreuil.Red_Line_Defense.modele.Controleurs.EcouteSoldats;
import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueSoldats;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueTours;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;


public class VueSoldats {

    private Map<Soldat, Circle> mapRookiesCercles;
    private Pane centerPane;

    private Carte terrain;

    private int vague = 1;

    public VueSoldats(Carte terrain, Pane centerPane) {
        this.terrain = terrain;
        this.centerPane = centerPane;
        mapRookiesCercles = new HashMap<>();
        nouvelleVague();
    }


    public void nouvelleVague() {

        if (vague == 1) {
            for (int i = 0; i < 3; i++) {
                int[] randomSelection = randomSelection();
                int startX = randomSelection[0] * 8;
                int startY = 59 * 8;

                int destX = randomSelection[1] * 8;
                int destY = 47 * 8;


                afficherRookie(startX, startY, destX, destY);
                System.out.println("tour " + i);
            }
        }



        /*System.out.println("Tuile de départ : X = " + startX + ", Y = " + startY);
        int destX = possibleDestX[rand.nextInt(possibleDestX.length)];
        int destY = 47;  // Supposons que cette valeur est constante.

        Rookie rookie = new Rookie(15 * tailleImage, 59 * tailleImage, 89 * tailleImage, 47 * tailleImage);
        List<Point2D> chemin = gestionnaireDeDeplacement.deplacerRookie();
        Rookie rookie = new Rookie(startX * tailleImage, startY * tailleImage, destX * tailleImage, destY * tailleImage);
        List<Point2D> chemin = gestionnaireDeDeplacement.deplacerRookie(startX, startY, destX, destY);

        animation.creerAnimation(chemin);*/
    }


    public void afficherRookie(double startX, double startY, double destX, double destY) {
        Rookie rookie = new Rookie((int) startX, (int) startY, (int) destX, (int) destY);
        terrain.ajouterSoldat(rookie);

        Circle soldatRookie = new Circle(startX, startY, 2, Color.BLUE);
        centerPane.getChildren().add(soldatRookie);

        mapRookiesCercles.put(rookie, soldatRookie); // Associer le Rookie à son cercle correspondant dans la HashMap

        System.out.println("nouveau soldat");
    }






    public int[] randomSelection() {

            int[] resultat = new int[2];

            int[] possibleStartX = {14, 15, 16}; // startY = 59
            int[] possibleDestX = {88, 89, 90}; // destY = 47

            Random random = new Random();

            int randomStartX = possibleStartX[random.nextInt(possibleStartX.length)];
            int randomDestX = possibleDestX[random.nextInt(possibleDestX.length)];

            resultat[0] = randomStartX;
            resultat[1] = randomDestX;

            return resultat;

    }


    public void placerSoldat(double x, double y) {
        Circle soldat = new Circle(x, y, 5, Color.RED);
        centerPane.getChildren().add(soldat);
    }

    public void enleverSoldats() {
        centerPane.getChildren().removeIf(node -> node instanceof Circle && ((Circle) node).getFill() == Color.RED);
    }

    public Map<Soldat, Circle> getMapRookiesCercles(){return this.mapRookiesCercles;}




}
