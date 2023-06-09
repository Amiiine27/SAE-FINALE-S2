package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;


import fr.iut.montreuil.Red_Line_Defense.modele.Carte;

public class TourSniper extends ToursOffensives {
    public TourSniper(int x0, int y0, Carte terrain) {
        super(x0, y0, 3000, 30, 5, 600, terrain, 3); // 50 tirs par minutes
    }
    public void tirer(){
        Soldat s=ennemiÀPorter();
        if (s!=null){
            while(s.estVivant()) {
                Boulet p = new Boulet(getX0Value(), getY0Value(), s.getX0Value(), s.getY0Value(), 300);
                try {//Méthode permettant d'implémenter une cadence de tir
                    Thread.sleep(1000L *getCadence()); // Pause l'exécution du programme pendant une seconde
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
}
}
