package com.example.tower_defense.modele;

public class Map {
    private int[][] map;
    private int nbPiratesArrive;

    public Map() {
        map = new int[][]{
                {0, 1, 0, 0, 0},
                {0, 1, 0, 0, 0},
                {0, 1, 1, 1, 1},
                {0, 0, 0, 0, 0},
            };
        nbPiratesArrive = 0;
    }
}
