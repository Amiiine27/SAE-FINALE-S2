package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class ToursDeffensives extends Tour{
    private ArrayList<Soldat> soldatsPiégés;
    public ToursDeffensives(int x0, int y0, Environnement terrain, int pv, int degats, int defense, int prix, int portee) {
        super(x0, y0, pv, degats, defense, prix, terrain, portee);
    }

    @Override
    public void agit(int n) {}
}
