package fr.iut.montreuil.Red_Line_Defense.modele;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;

import java.util.*;

public class GestionnaireDeDeplacement {

    private Carte carte;
    private Circle cercle;
    private int tailleImage;
    private Pane centerPane;

    public GestionnaireDeDeplacement(Carte carte, int tailleImage, Pane centerPane) {
        this.carte = carte;
        this.tailleImage = tailleImage;
        this.centerPane = centerPane;

        cercle = new Circle(tailleImage / 2, Color.RED);
        centerPane.getChildren().add(cercle);
    }

    public void deplacerRookie() {
        int startX = 15;
        int startY = 59;

        int destX = 89;
        int destY = 47;

        List<Point2D> chemin = trouverChemin(startX, startY, destX, destY);

        Timeline timeline = new Timeline();
        for (int i = 0; i < chemin.size(); i++) {
            Point2D point = chemin.get(i);
            double centerX = point.getX() * tailleImage + tailleImage / 2;
            double centerY = point.getY() * tailleImage + tailleImage / 2;
            KeyFrame keyFrame = new KeyFrame(Duration.seconds(0.5 * i), new KeyValue(cercle.centerXProperty(), centerX),
                    new KeyValue(cercle.centerYProperty(), centerY));
            timeline.getKeyFrames().add(keyFrame);
        }

        timeline.play();
    }

    private List<Point2D> trouverChemin(int startX, int startY, int destX, int destY) {
        List<Point2D> chemin = new ArrayList<>();
        int[][] distances = new int[carte.getYmax()][carte.getXmax()];
        boolean[][] visited = new boolean[carte.getYmax()][carte.getXmax()];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(startX);
        queue.offer(startY);
        visited[startY][startX] = true;

        while (!queue.isEmpty()) {
            int x = queue.poll();
            int y = queue.poll();

            if (x == destX && y == destY) {
                chemin.add(new Point2D(x, y));
                break;  // Destination reached
            }

            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};

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
            int[] dx = {0, 0, -1, 1};
            int[] dy = {-1, 1, 0, 0};
            for (int i = 0; i < 4; i++) {
                int nx = currentX + dx[i];
                int ny = currentY + dy[i];

                if (isValidMove(nx, ny) && distances[ny][nx] == distances[currentY][currentX] - 1) {
                    chemin.add(new Point2D(nx, ny));
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
