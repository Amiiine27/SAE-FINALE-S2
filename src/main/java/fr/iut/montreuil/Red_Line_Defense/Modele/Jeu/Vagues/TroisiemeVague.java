package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Vagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

public class TroisiemeVague extends Vagues {

    public TroisiemeVague(Environnement environnement) {
        super(environnement);
    }

    @Override
    public int maxSoldType1() {
        return 10;
    }

    @Override
    public int maxSoldType2() {
        return 8;
    }

    @Override
    public int maxsoldType3() {
        return 0;
    }

    @Override
    public int nbtour() {
        return 12;
    }

    @Override
    public int randomTypeSoldier() {
        return 2;
    }

    @Override
    public int nbrspwan1() {
        return 12;
    }

    @Override
    public int nbrspwan2() {
        return 12;
    }

    @Override
    public int nbrspwan3() {
        return 0;
    }
}
