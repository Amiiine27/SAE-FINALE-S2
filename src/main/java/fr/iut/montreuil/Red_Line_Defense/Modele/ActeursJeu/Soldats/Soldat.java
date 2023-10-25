package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats;



import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Acteurs;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.geometry.Point2D;

import java.util.HashSet;
import java.util.Set;

public abstract class Soldat extends Acteurs {
    private double destinationX;
    private double destinationY;

    public String couleur;
    private Environnement env;

    private int pathPosition = 0;

    private Set<Point2D> zone;

    private boolean estPiégé;
    private int valeur; // valeur du soldat, permet de déterminer combien le joueur gagne en le tuant

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, double destinationX, double destinationY, Environnement env) {
        super(x0, y0, pointsDeVie, degats, defense);
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.env = env;
        this.zone = new HashSet<Point2D>();
        estPiégé=false;
        créerZone();
    }

    public Soldat(double x0, double y0, int pointsDeVie, int degats, int defense, int valeur, double destinationX, double destinationY, Environnement env) {
        super(x0, y0, pointsDeVie, degats, defense);
        this.valeur = valeur;
        this.destinationX = destinationX;
        this.destinationY = destinationY;
        this.env = env;
        this.zone = new HashSet<Point2D>();
        estPiégé=false;
        créerZone();
    }

    public void deplacementSoldat(){
        if (!this.env.getListSoldats().isEmpty()) {
            if(!this.isEstPiégé() || this.env.getNbrTours() % 2 == 0) {
                int startX = (int) (this.getX0Value() / 8);
                int startY = (int) (this.getY0Value() / 8);

                int[] dx = {0, 0, -1, 1};
                int[] dy = {-1, 1, 0, 0};

                int nextX = startX;
                int nextY = startY;
                int minDistance = Integer.MAX_VALUE;

                for (int i = 0; i < 4; i++) {
                    int nx = startX + dx[i];
                    int ny = startY + dy[i];

                    if (this.env.getBfs().isValidMove(nx, ny) && this.env.getBfs().getDistances()[ny][nx] < minDistance) {
                        nextX = nx;
                        nextY = ny;
                        minDistance = this.env.getBfs().getDistances()[ny][nx];
                    }
                }

                this.setX0(nextX * 8);
                this.setY0(nextY * 8);
            }
        }
    }

    public boolean estVivant(){
        return (this.getPointsDeVieValue() > 0);
    }

    public int getValeurGagnee() {
        return this.valeur;
    }

    public void créerZone() {
        for (int xZone = 88; xZone <= 90; xZone++) {
            for (int yZone = 47; yZone <= 49; yZone++) {
                zone.add(new Point2D(xZone, yZone));
            }
        }
    }

    public String getCouleur() {
        return this.couleur;
    }

    public boolean isEstPiégé(){
        return estPiégé;
    }
    public void estPiégés(){
        estPiégé=true;
    }
    public void libéré(){
        estPiégé=false;
    }

}
