package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;

public class TourLanceMissile extends ToursOffensives{
    public TourLanceMissile(int x0, int y0, Carte terrain) {
        super(x0, y0, 4000, 80, 5, 100, terrain, 6,10);

    }
}
