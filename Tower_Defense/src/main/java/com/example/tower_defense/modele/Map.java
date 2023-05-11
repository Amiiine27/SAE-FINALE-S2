package com.example.tower_defense.modele;

public class Map {
    private int[][] quadrillage;
    private int nbPiratesArrive;

    public Map() {
        quadrillage = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0}
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
