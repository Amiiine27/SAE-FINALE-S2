package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;

public class TourLanceMissile extends ToursOffensives{
    public TourLanceMissile(int x0, int y0, Environnement terrain) {
        super(x0, y0, 800, 80, 5, 100, terrain, 6,10,300);
    }
}
