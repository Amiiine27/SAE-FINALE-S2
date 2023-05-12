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
                {3, 1, 0, 1, 1, 1, 0, 0, 0},
                {3, 1, 0, 1, 0, 1, 1, 1, 0},
                {3, 1, 1, 1, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 0, 0, 1, 1, 0},
                {0, 1, 1, 1, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 1, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 1, 1, 1, 1}
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
