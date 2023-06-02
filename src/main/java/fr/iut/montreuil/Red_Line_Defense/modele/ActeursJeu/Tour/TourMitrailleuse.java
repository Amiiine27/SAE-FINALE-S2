package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour;

public class TourMitrailleuse extends ToursOffensives {

    public TourMitrailleuse(int x0, int y0, int x1, int y1) {
        super(x0, y0, 4000, 80, 5, 100, 120); // La cadence est la capacité de Tirs par minute
                                                                          // Par exemple ici 120 tirs à la minute ou 2 tirs par seconde
    }
}
