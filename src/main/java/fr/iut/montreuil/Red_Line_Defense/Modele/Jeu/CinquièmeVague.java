package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

import java.util.Random;

public class CinquièmeVague extends Vagues {
    public CinquièmeVague(Environnement environnement) {
        super(environnement);
    }

    @Override
    public int ennemiFaireSpwan() {
        return 0;
    }

    @Override
    public int maxSoldType1() {
        return 11;
    }

    @Override
    public int maxSoldType2() {
        return 9;
    }

    @Override
    public int maxsoldType3() {
        return 5;
    }

    @Override
    public int nbtour() {
        return 9;
    }

    @Override
    public int randomTypeSoldier() {
        return 3;
    }

    @Override
    public int nbrspwan1() {
        return 16;
    }

    @Override
    public int nbrspwan2() {
        return 16;
    }

    @Override
    public int nbrspwan3() {
        return 9;
    }
}
