package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;


import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourSniper extends ToursOffensives {
    public TourSniper(int x0, int y0, Environnement terrain) {
        super(x0, y0, 3000, 50, 5, 600, terrain, 3,1000,600); // 50 tirs par minutes
    }

}
