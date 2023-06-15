package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourMitrailleuse extends ToursOffensives {

    public TourMitrailleuse(int x0, int y0,Environnement terrain) {
        super(x0, y0, 4000, 100, 5, 100, terrain, 1/15,800,100); // La cadence est la capacité de Tirs par minute
        // Par exemple ici 120 tirs à la minute ou 2 tirs par seconde
    }


}
