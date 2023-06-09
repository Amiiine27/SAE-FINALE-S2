package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;

public class TourMitrailleuse extends ToursOffensives {

    public TourMitrailleuse(int x0, int y0,Environnement terrain) {
        super(x0, y0, 4000, 80, 5, 100, terrain, 1/15,200); // La cadence est la capacité de Tirs par minute
        // Par exemple ici 120 tirs à la minute ou 2 tirs par seconde
    }


}
