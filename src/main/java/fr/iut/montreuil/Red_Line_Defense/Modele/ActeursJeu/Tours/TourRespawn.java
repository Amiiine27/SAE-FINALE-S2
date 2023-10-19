package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TourRespawn extends ToursDeffensives{

    public TourRespawn(int x0, int y0, Environnement terrain, int pv, int degats, int defense, int prix, int portee) {
        super(x0, y0, terrain, pv, degats, defense, prix, portee);
    }

    @Override
    public void agit(int n){
        for (Soldat s: terrain.getSoldats()) {
            if (s!= null) {

            }
        }
    }
}
