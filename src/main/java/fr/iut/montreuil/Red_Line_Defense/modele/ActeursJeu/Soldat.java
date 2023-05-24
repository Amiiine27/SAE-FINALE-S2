package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;



public abstract class Soldat extends Acteurs {

    private boolean ennemi;
    private int vieInitiale;

    private int valeur; // valeur du soldat, permet de déterminer combien le joueur gagne en le tuant

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense) {
        super(x0, y0, pointsDeVie, degats, defense);
    }

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, boolean ennemi, int valeur) {
        super(x0, y0, pointsDeVie, degats, defense);
        this.ennemi = ennemi;
        this.valeur = valeur;
        this.vieInitiale = pointsDeVie;
    }

    public void deplacer(int deltaX, int deltaY) {

        // Calcul nouvelles coordonnées
        double newX = this.getX0Value() + deltaX;
        double newY = this.getY0Value() + deltaY;


        // Mettre à jour les coordonnées de l'acteur
        setX0(newX);
        setY0(newY);
    }

    public int valeurGagnee() {

       return this.valeur;
    }
}
