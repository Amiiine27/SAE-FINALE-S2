package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;

public class BasePrincipale extends Tour {


    // C'est la base principale, celle qu'il faudra defendre des soldats ennemis et qui sera en bout de course


    public BasePrincipale(int x0, int y0, Carte terrain) {
        super(x0, y0, 10000, 0, 5,terrain);
    }


}
