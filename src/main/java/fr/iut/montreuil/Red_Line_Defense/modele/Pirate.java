package fr.iut.montreuil.Red_Line_Defense.modele;

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


}
