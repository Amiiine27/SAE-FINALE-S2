package com.example.tower_defense.modele;

public class Map {

    /*
     * -Lorsque la valeur de map est égale à :
     *      - 0 : le sol n'est pas traversable donc c'est de L'HERBE
     *      - 1 : le sol est traversable donc c'est du CHEMIN
     *      - 0 : le sol n'est pas traversable et permet de poser une tour donc c'est de LA ROCHE
     */

    /*
     * ATTRIBUTS
     */
    private int[][] quadrillage;
    private int nbPiratesArrive;


    /*
     * CONSTRUCTORS
     */

    public Map() {
        quadrillage = new int[][]{
                {0, 3, 1, 5, 8, 4, 4, 4, 4, 4, 9},
                {0, 3, 1, 5, 3, 1, 1, 1, 1, 1, 5},
                {0, 3, 1, 10, 13, 1, 12, 2, 11, 1, 5},
                {0, 3, 1, 1, 1, 1, 5, 0, 3, 1, 5},
                {0, 6, 2, 2, 2, 2, 7, 0, 3, 1, 5},
                {0, 0, 0, 0, 0, 0, 8, 4, 13, 1, 5},
                {8, 4, 4, 4, 4, 9, 3, 1, 1, 1, 5},
                {3, 1, 1, 1, 1, 10, 13, 1, 12, 2, 7},
                {3, 1, 12, 11, 1, 1, 1, 1, 5, 0, 0},
                {3, 1, 5, 6, 2, 2, 2, 2, 7, 0, 0},
                {3, 1, 10, 4, 4, 9, 0, 0, 0, 0, 0},
                {3, 1, 1, 1, 1, 10, 4, 4, 4, 4, 9},
                {6, 2, 2, 11, 1, 1, 1, 1, 1, 1, 5}
            };
        nbPiratesArrive = 0;
    }

    public int getYmax(){
        return this.quadrillage.length;
    }

    public int getXmax(){
        return this.quadrillage[0].length;
    }

    public int valeurDeLaCase(int i, int j){
        return this.quadrillage[i][j];
    }
}
