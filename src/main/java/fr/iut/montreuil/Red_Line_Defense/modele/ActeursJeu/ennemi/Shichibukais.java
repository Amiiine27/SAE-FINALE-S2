package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.ennemi;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;

public class Shichibukais extends Soldat {

    public Shichibukais(double x0, double y0, double x1, double y1 ) {
        super(x0, y0, 10000, 300, 20, true, 250, x1, y1);              // Ennemi True car ce sera un Soldat exclusivement Ennemi
    }
}
