package fr.iut.montreuil.Red_Line_Defense.modele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;

import java.util.*;

public class GestionnaireDeDeplacement {
    private Carte carte;
    private int tailleImage;
    private Pane centerPane;

    public GestionnaireDeDeplacement(Carte carte, int tailleImage, Pane centerPane) {
        this.carte = carte;
        this.tailleImage = tailleImage;
        this.centerPane = centerPane;
    }


    public List<Point2D> trouverChemin(Soldat soldat) {
        int startX = (int) (soldat.getX0Value() / 8);
        int startY = (int) (soldat.getY0Value() / 8);
        int destX = (int) (soldat.getDestinationX() / 8);
        int destY = (int) (soldat.getDestinationY() / 8);


        List<Point2D> chemin = new ArrayList<>();
        int[][] distances = new int[carte.getYmax()][carte.getXmax()];
        boolean[][] visited = new boolean[carte.getYmax()][carte.getXmax()];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startX);
        queue.offer(startY);
        visited[startY][startX] = true;

        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};
        Point2D point = new Point2D(0, 0);

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            if (x == destX && y == destY) {
                point = new Point2D(x, y);
                chemin.add(point);
                break;  // Destination reached
            }

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

        int currentX = destX;
        int currentY = destY;

        while (currentX != startX || currentY != startY) {
            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (isValidMove(nx, ny) && distances[ny][nx] == distances[currentY][currentX] - 1) {
                    point = new Point2D(nx, ny);
                    chemin.add(point);
                    currentX = nx;
                    currentY = ny;
                    break;
                }
            }
        }

        Collections.reverse(chemin);
        return chemin;
    }

    private boolean isValidMove(int x, int y) {
        return x >= 0 && x < carte.getXmax() && y >= 0 && y < carte.getYmax() && carte.valeurDeLaCase(y, x) == 1;
    }
}
