package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;


import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;

public class TourSniper extends ToursOffensives {
    public TourSniper(int x0, int y0, Environnement terrain) {
        super(x0, y0, 1000, 30, 5, 600, terrain, 3,2000,600); // 50 tirs par minutes
    }

}
