package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

import java.util.ArrayDeque;
import java.util.Queue;

public class BFS {
    Environnement environnement;

    public BFS(Environnement environnement) {
        this.environnement = environnement;
    }

    public void calculerChemin(int destX, int destY) {  // Méthode modifiée pour calculer les distances à la destination

        boolean[][] visited = new boolean[this.environnement.getYmax()][this.environnement.getXmax()];

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

                if (this.environnement.isValidMove(nx, ny) && !visited[ny][nx]) {
                    queue.offer(nx);
                    queue.offer(ny);
                    visited[ny][nx] = true;
                    this.environnement.getDistances()[ny][nx] = this.environnement.getDistances()[y][x] + 1;
                }
            }
        }
    }
}