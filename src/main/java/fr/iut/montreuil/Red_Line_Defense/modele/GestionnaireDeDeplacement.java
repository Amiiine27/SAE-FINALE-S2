package fr.iut.montreuil.Red_Line_Defense.modele;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;

import java.util.*;

public class GestionnaireDeDeplacement {
    private Carte terrain;

    public GestionnaireDeDeplacement(Carte terrain) {
        this.terrain = terrain;
    }

    public List<int[][]> trouverChemins(int[][] pointsDepart, int[] pointArrivee) {
        List<int[][]> chemins = new ArrayList<>();

        for (int[] pointDepart : pointsDepart) {
            int[][] chemin = trouverChemin(pointDepart, pointArrivee);
            if (chemin != null) {
                chemins.add(chemin);
            }
        }

        return chemins;
    }

    private int[][] trouverChemin(int[] pointDepart, int[] pointArrivee) {
        int[][] distances = new int[terrain.getYmax()][terrain.getXmax()];
        boolean[][] visite = new boolean[terrain.getYmax()][terrain.getXmax()];
        int[][] predecesseurs = new int[terrain.getYmax()][terrain.getXmax()];

        // Initialisation des distances avec une valeur infinie
        for (int i = 0; i < terrain.getYmax(); i++) {
            for (int j = 0; j < terrain.getXmax(); j++) {
                distances[i][j] = Integer.MAX_VALUE;
            }
        }

        // Le point de départ a une distance de 0
        distances[pointDepart[0]][pointDepart[1]] = 0;

        // Parcours des cases
        for (int i = 0; i < terrain.getYmax() * terrain.getXmax(); i++) {
            int[] caseCourante = obtenirCaseMinDistance(distances, visite);

            if (caseCourante == null) {
                // Aucune case accessible n'a été trouvée
                break;
            }

            visite[caseCourante[0]][caseCourante[1]] = true;

            // Vérifier si on a atteint le point d'arrivée
            if (caseCourante[0] == pointArrivee[0] && caseCourante[1] == pointArrivee[1]) {
                return reconstruireChemin(predecesseurs, pointDepart, pointArrivee);
            }

            // Récupérer les cases voisines de la case courante
            List<int[]> casesVoisines = obtenirCasesVoisines(caseCourante);

            for (int[] voisin : casesVoisines) {
                if (!visite[voisin[0]][voisin[1]] && terrain.estParcourable(voisin[0], voisin[1])) {
                    int distance = distances[caseCourante[0]][caseCourante[1]] + 1;
                    if (distance < distances[voisin[0]][voisin[1]]) {
                        distances[voisin[0]][voisin[1]] = distance;
                        predecesseurs[voisin[0]][voisin[1]] = caseCourante[0] * terrain.getXmax() + caseCourante[1];
                    }
                }
            }
        }

        return null; // Aucun chemin trouvé
    }

    private int[] obtenirCaseMinDistance(int[][] distances, boolean[][] visite) {
        int minDistance = Integer.MAX_VALUE;
        int[] caseMinDistance = null;

        for (int i = 0; i < terrain.getYmax(); i++) {
            for (int j = 0; j < terrain.getXmax(); j++) {
                if (!visite[i][j] && distances[i][j] < minDistance) {
                    minDistance = distances[i][j];
                    caseMinDistance = new int[]{i, j};
                }
            }
        }

        return caseMinDistance;
    }

    private List<int[]> obtenirCasesVoisines(int[] position) {
        List<int[]> voisins = new ArrayList<>();

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Haut, bas, gauche, droite

        for (int[] direction : directions) {
            int x = position[1] + direction[1];
            int y = position[0] + direction[0];

            if (x >= 0 && x < terrain.getXmax() && y >= 0 && y < terrain.getYmax()) {
                voisins.add(new int[]{y, x});
            }
        }

        return voisins;
    }

    private int[][] reconstruireChemin(int[][] predecesseurs, int[] pointDepart, int[] pointArrivee) {
        List<int[]> chemin = new ArrayList<>();
        int[] position = pointArrivee;

        while (position != null) {
            chemin.add(0, position);
            position = new int[]{predecesseurs[position[0]][position[1]] / terrain.getXmax(), predecesseurs[position[0]][position[1]] % terrain.getXmax()};
        }

        return chemin.toArray(new int[0][]);
    }
}
