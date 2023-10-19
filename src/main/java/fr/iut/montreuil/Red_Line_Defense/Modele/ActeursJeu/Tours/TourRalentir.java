package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Effets.Effet;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Effets.EffetRalenti;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.ArrayList;
import java.util.Iterator;

public class TourRalentir extends ToursDeffensives{


    private ArrayList<Soldat> soldatsPiégés;
    private Effet effet = new EffetRalenti();
    public TourRalentir(int x0, int y0,Environnement terrain) {
        super(x0, y0, terrain, 1500, 3, 100, 200, 100);
        soldatsPiégés = new ArrayList<>();
    }

    @Override
    public void agit(int n) {
        for (Soldat s: terrain.getSoldats()) {
            if (s != null) {
                effet.appliquerEffetSur(s);
                soldatsPiégés.add(s);
            }
        }
        if (!soldatsPiégés.isEmpty()) {
            Iterator<Soldat> iterator = soldatsPiégés.iterator();
            while (iterator.hasNext()) {
                Soldat sP = iterator.next();
                if (!vérificationEstÀPorter(sP.getX0Value(), sP.getY0Value())) {
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
