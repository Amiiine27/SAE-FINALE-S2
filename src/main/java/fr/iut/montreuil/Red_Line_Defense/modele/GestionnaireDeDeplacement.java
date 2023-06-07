package fr.iut.montreuil.Red_Line_Defense.modele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.util.*;

public class GestionnaireDeDeplacement {
    private Carte carte;
    private int tailleImage;
    private Pane centerPane;


    private int[][] distances;  // Ajout d'un tableau de distances

    public GestionnaireDeDeplacement(Carte carte, int tailleImage, Pane centerPane) {
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

        // Créez une animation pour déplacer le soldat
        Timeline timeline = new Timeline();
        timeline.getKeyFrames().addAll(
                new KeyFrame(Duration.ZERO,
                        new KeyValue(soldat.getX0Property(), soldat.getX0Value()),
                        new KeyValue(soldat.getY0Property(), soldat.getY0Value())
                ),
                new KeyFrame(Duration.seconds(0.3),
                        new KeyValue(soldat.getX0Property(), nextX * tailleImage),
                        new KeyValue(soldat.getY0Property(), nextY * tailleImage)
                )
        );
        timeline.play();
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < distances[0].length && y >= 0 && y < distances.length && carte.valeurDeLaCase(y, x) == 1;
    }
}

