package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourLanceMissile extends ToursOffensives{
    public TourLanceMissile(int x0, int y0, Environnement terrain) {
        super(x0, y0, 4000, 8, 5, 100, terrain, 6,100,300);
    }
}
