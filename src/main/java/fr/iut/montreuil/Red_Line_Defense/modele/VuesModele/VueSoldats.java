package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Rookie;
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
        nouvelleVague();
    }


    public void nouvelleVague() {

        if (vague == 1) {
            for (int i = 0; i < 7; i++) {
                int[] randomSelection = randomSelection();
                int startX = randomSelection[0] * 8;
                int startY = randomSelection[1] * 8;

                int destX = randomSelection[2] * 8;
                int destY = randomSelection[3] * 8;


                afficherRookie(startX, startY, destX, destY);
            }
        }

    }


    public void afficherRookie(double startX, double startY, double destX, double destY) {
        Rookie rookie = new Rookie((int) startX, (int) startY, (int) destX, (int) destY);
        terrain.ajouterSoldat(rookie);

        Circle cercleSoldat = new Circle(startX, startY, 4, Color.BLUE);

        terrain.getMapSoldatsCercles().put(rookie, cercleSoldat); // Associer le Rookie à son cercle correspondant dans la HashMap
        centerPane.getChildren().add(cercleSoldat);

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
                {88, 47},
                {89, 47},
                {90, 47}
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


    public void enleverSoldats() {
        centerPane.getChildren().removeIf(node -> node instanceof Circle && ((Circle) node).getFill() == Color.RED);
    }


}
