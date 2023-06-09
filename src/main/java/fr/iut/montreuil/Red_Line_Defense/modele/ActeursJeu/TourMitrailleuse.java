package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;

public class TourMitrailleuse extends ToursOffensives {

    public TourMitrailleuse(int x0, int y0,Carte terrain) {
        super(x0, y0, 4000, 80, 5, 100, terrain, 15); // La cadence est la capacité de Tirs par minute
        // Par exemple ici 120 tirs à la minute ou 2 tirs par seconde
    }
    public void tirer(){
        Soldat s=ennemiÀPorter();
        if (s!=null){
            while(s.estVivant()) {
                Boulet p = new Boulet(getX0Value(), getY0Value(), s.getX0Value(), s.getY0Value(), 300);
                try {//Méthode permettant d'implémenter une cadence de tir
                    Thread.sleep(1000L/getCadence()); // Pause l'exécution du programme pendant une seconde
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
