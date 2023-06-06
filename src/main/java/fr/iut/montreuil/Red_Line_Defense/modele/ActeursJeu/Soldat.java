package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;



public abstract class Soldat extends Acteurs {

    private boolean ennemi;
    private int vieInitiale;

    private int degats;

    private double destinationX, destinationY;

    private int valeur; // valeur du soldat, permet de déterminer combien le joueur gagne en le tuant

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, double destinationX, double destinationY) {
        super(x0, y0, pointsDeVie, defense);
        this.degats=degats;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, boolean ennemi, int valeur, double destinationX, double destinationY) {
        super(x0, y0, pointsDeVie,defense);
        this.degats=degats;
        this.ennemi = ennemi;
        this.valeur = valeur;
        this.vieInitiale = pointsDeVie;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
    }

    public void deplacer(int deltaX, int deltaY) {

        // Calcul nouvelles coordonnées
        double newX = this.getX() + deltaX;
        double newY = this.getY() + deltaY;


        // Mettre à jour les coordonnées de l'acteur
        setX0(newX);
        setY0(newY);
    }

    public int valeurGagnee() {

       return this.valeur;
    }

    public double getDestinationX() {  return this.destinationX;
    }
    public double getDestinationY() {  return this.destinationY;
    }

}
