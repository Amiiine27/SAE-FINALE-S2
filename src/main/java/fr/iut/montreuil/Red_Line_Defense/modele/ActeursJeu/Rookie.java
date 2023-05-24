package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

public class Rookie extends Soldat {

    public Rookie(double x0, double y0) {
        super(x0, y0, 2000, 80, 7, true, 100);              // Ennemi True car ce sera un Soldat exclusivement Ennemi
    }
}
