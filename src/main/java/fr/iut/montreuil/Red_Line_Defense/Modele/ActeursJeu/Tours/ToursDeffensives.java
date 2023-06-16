package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Iterator;

public class ToursDeffensives extends Tour{
    private ArrayList<Soldat> soldatsPiégés;
    public ToursDeffensives(int x0, int y0,Environnement terrain) {
        super(x0, y0, 1500, 3, 600, 200, terrain, 100);
        soldatsPiégés = new ArrayList<>();
    }

    @Override
    public void agit(int n) {
        System.out.println("Agit td");
        for (Soldat s: terrain.getSoldats()) {
            if (s != null) {
                System.out.println("Ennemi à porter");
                s.estPiégés();
                soldatsPiégés.add(s);
            }
        }
        if (!soldatsPiégés.isEmpty()) {
            Iterator<Soldat> iterator = soldatsPiégés.iterator();
            while (iterator.hasNext()) {
                Soldat sP = iterator.next();
                if (!vérificationEstÀPorter(sP)) {
                    System.out.println("Plus à porter");
                    sP.libéré();
                    iterator.remove();
                }
            }
        }
    }

    public void suppSoldatPiégés(Soldat s){
        soldatsPiégés.remove(s);
    }
}
