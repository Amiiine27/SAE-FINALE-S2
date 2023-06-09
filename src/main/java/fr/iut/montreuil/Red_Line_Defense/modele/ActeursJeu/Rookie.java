package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

public class Rookie extends Soldat {

    public Rookie(int x0, int y0, int x1, int y1) {
        super(x0, y0, 10000, 300, 20, 250, x1, y1);       // Ennemi True car ce sera un Soldat exclusivement Ennemi
    }
}
