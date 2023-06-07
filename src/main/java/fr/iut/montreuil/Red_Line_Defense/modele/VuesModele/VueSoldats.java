package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Rookie;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.Random;


public class VueSoldats {


    private Pane centerPane;

    private GestionnaireDeDeplacement gestionnaireDeDeplacement;
    private Carte terrain;

    private int vague = 1;

    public VueSoldats(Carte terrain, Pane centerPane, GestionnaireDeDeplacement gestionnaireDeDeplacement) {
        this.terrain = terrain;
        this.centerPane = centerPane;
        this.gestionnaireDeDeplacement = gestionnaireDeDeplacement;
    }

    public Soldat afficherSoldat(double startX, double startY) {
        Soldat s = new Rookie((int) startX, (int) startY, 89, 47);
        terrain.ajouterSoldat(s);
        System.out.println("Soldat créé et ajouté au terrain : " + s);

        Circle cercleSoldat = new Circle(4, Color.DARKORCHID);
        System.out.println("Cercle créé pour le soldat : " + cercleSoldat);

        cercleSoldat.centerXProperty().bind(s.getX0Property());
        cercleSoldat.centerYProperty().bind(s.getY0Property());

        centerPane.getChildren().add(cercleSoldat);
        System.out.println("Cercle ajouté au pane. Total des cercles : " + centerPane.getChildren().size());

        return s;
    }





    public Soldat nouvelleVague() {

                int[] randomSelection = randomSelection();
                int startX = randomSelection[0] * 8;
                int startY = randomSelection[1] * 8;

                Soldat soldat = afficherSoldat(startX, startY);

                return soldat;


            // Après avoir créé tous les soldats, calculez le chemin pour eux.
            // Assume que destX et destY sont les coordonnées de la destination.


        }





    public int[] randomSelection() {
        int[] resultat = new int[4];

        int[][] possibleStartPositions = {
                {14, 59},
                {15, 59},
                {16, 59},
                {2, 27},
                {2, 28},
                {2, 29}
        };

        int[][] possibleDestPositions = {
                {89, 47}
        };

        Random random = new Random();

        int[] randomStartPosition = possibleStartPositions[random.nextInt(possibleStartPositions.length)];
        int[] randomDestPosition = possibleDestPositions[random.nextInt(possibleDestPositions.length)];

        resultat[0] = randomStartPosition[0];
        resultat[1] = randomStartPosition[1];
        resultat[2] = randomDestPosition[0];
        resultat[3] = randomDestPosition[1];

        return resultat;
    }




}
