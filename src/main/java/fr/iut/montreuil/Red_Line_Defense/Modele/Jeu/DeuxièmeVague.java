package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

import java.util.Random;

public class DeuxièmeVague extends Vagues{

    public DeuxièmeVague(Environnement environnement) {
        super(environnement);
    }

    @Override
    public int ennemiFaireSpwan() {
        return 0;
    }

    @Override
    public int maxSoldType1() {
        return 8;
    }

    @Override
    public int maxSoldType2() {
        return 6;
    }

    @Override
    public int maxsoldType3() {
        return 0;
    }

    @Override
    public int nbtour() {
        return 15;
    }

    @Override
    public int randomTypeSoldier() {
        return 2;
    }

    @Override
    public int nbrspwan1() {
        return 9;
    }

    @Override
    public int nbrspwan2() {
        return 9;
    }

    @Override
    public int nbrspwan3() {
        return 0;
    }
}
