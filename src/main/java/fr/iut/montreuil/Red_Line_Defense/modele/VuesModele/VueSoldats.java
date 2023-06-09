package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Rookie;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.SuperNova;
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



    public VueSoldats(Carte terrain, Pane centerPane, GestionnaireDeDeplacement gestionnaireDeDeplacement) {
        this.terrain = terrain;
        this.centerPane = centerPane;
        this.gestionnaireDeDeplacement = gestionnaireDeDeplacement;
    }

    public Soldat afficherSoldat(double startX, double startY, int typeSoldat) {
        Soldat s = selectionSoldat(typeSoldat, startX, startY);

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

    public Soldat selectionSoldat(int typeSoldat, double startX, double startY) {

        Soldat s;

        switch(typeSoldat) {
            case 1:
                s = new Rookie((int) startX, (int) startY, 89, 47);
                break;
            case 2:
                s = new SuperNova((int) startX, (int) startY, 89, 47);
                break;
            case 3:
                s = new Shichibukais((int) startX, (int) startY, 89, 47);
                break;
            default:
                s = new Rookie((int) startX, (int) startY, 89, 47);
        }

        return s;
    }





    public Soldat nouveauSpawnSoldat(int typeSoldat) {

                int[] randomSelection = randomSelection();
                int startX = randomSelection[0] * 8;
                int startY = randomSelection[1] * 8;

                Soldat soldat = afficherSoldat(startX, startY,typeSoldat);

                return soldat;
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
