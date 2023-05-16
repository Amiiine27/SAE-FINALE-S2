package com.example.tower_defense.modele;

public class Pirate {
    /*
    - Un pirate à des Points de vie, des Dégats, une poistion x et y.
    - Il peut avancer à droite, avancer à gauche, avancer vers le haut, avancer vers le bas, attaquer et mourir
     */
    /*
     * ATTRIBUTS
     */
    private int pv, degats, x, y;


    /*
     * CONSTRUCTORS
     */
    public Pirate() {
        pv = 10;
        degats = 5;

    }


    /*
     * METHODES
     */
    public void avancerHaut() {
        this.y -= 2;
    }

    public boolean estArrive(){
        return this.x > 60 && this.x < 80 && this.y > 240 && this.y < 260;
    }

}
