package fr.iut.montreuil.Red_Line_Defense.modele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.*;

public class GestionnaireDeDeplacement {
    private Environnement carte;
    private int tailleImage;
    private Pane centerPane;


    private int[][] distances;  // Ajout d'un tableau de distances

    public GestionnaireDeDeplacement(Environnement carte, int tailleImage, Pane centerPane) {
        this.carte = carte;
        this.tailleImage = tailleImage;
        this.centerPane = centerPane;
        this.distances = new int[carte.getYmax()][carte.getXmax()];  // Initialisation du tableau de distances
        calculerChemin(89, 47);
    }


    public void calculerChemin(int destX, int destY) {  // Méthode modifiée pour calculer les distances à la destination

        System.out.println("Calcul du chemin ");

        boolean[][] visited = new boolean[carte.getYmax()][carte.getXmax()];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(destX);
        queue.offer(destY);
        visited[destY][destX] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                if (isValidMove(nx, ny) && !visited[ny][nx]) {
                    queue.offer(nx);
                    queue.offer(ny);
                    visited[ny][nx] = true;
                    distances[ny][nx] = distances[y][x] + 1;
                }
            }
        }

        System.out.println("Calcul du chemin OK ");
    }

    public void deplacerSoldat(Soldat soldat) {
        int startX = (int) (soldat.getX0Value() / tailleImage);
        int startY = (int) (soldat.getY0Value() / tailleImage);

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        int nextX = startX;
        int nextY = startY;
        int minDistance = Integer.MAX_VALUE;


        for (int i = 0; i < 4; i++) {
            int nx = startX + dx[i];
            int ny = startY + dy[i];


            if (isValidMove(nx, ny) && distances[ny][nx] < minDistance) {
                nextX = nx;
                nextY = ny;
                minDistance = distances[ny][nx];
            }
        }


        soldat.setX0(nextX * tailleImage);
        soldat.setY0(nextY * tailleImage);
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < distances[0].length && y >= 0 && y < distances.length && carte.valeurDeLaCase(y, x) == 1;
    }
}

