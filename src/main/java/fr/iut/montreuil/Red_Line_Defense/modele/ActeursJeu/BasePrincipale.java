package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;

public class BasePrincipale extends Tour {

    private Carte terrain;


    // C'est la base principale, celle qu'il faudra defendre des soldats ennemis et qui sera en bout de course
    // elle a une position x, une position y et une nombre de point de vie


    public BasePrincipale(){
        super(102, 467, 10000, 24);
    }



    public void perdPointsDeVie(){
        for(Soldat s : terrain.getSoldats()) {
            if (this.estSoldatDansPortee(s, this.getX0Value(), this.getY0Value())) {
                System.out.println("Pv de la base :" + this.getPointsDeVieValue());
            }
        }
    }

}
