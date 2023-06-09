package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;


import fr.iut.montreuil.Red_Line_Defense.modele.Carte;

public class TourSniper extends ToursOffensives {
    public TourSniper(int x0, int y0, Carte terrain) {
        super(x0, y0, 3000, 30, 5, 600, terrain, 3,500); // 50 tirs par minutes
    }

}
