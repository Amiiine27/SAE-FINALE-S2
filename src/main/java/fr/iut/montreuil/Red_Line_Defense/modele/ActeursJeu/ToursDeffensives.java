package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;

public class ToursDeffensives extends Tour{
    public ToursDeffensives(int x0, int y0,Carte terrain) {
        super(x0, y0, 200, 3, 600, 200, terrain);
    }
}