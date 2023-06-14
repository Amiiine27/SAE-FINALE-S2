package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class ToursDeffensives extends Tour{
    public ToursDeffensives(int x0, int y0,Environnement terrain) {
        super(x0, y0, 1500, 3, 600, 200, terrain, 30);
    }

    @Override
    public void agit() {
        setPointsDeVieValue(getPointsDeVieValue()-1);
    }
}
