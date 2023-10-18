package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

public class PremiereVague extends Vagues {
    public PremiereVague(Environnement environnement) {
        super(environnement);
    }


    @Override
    public int maxSoldType1() {
        return 12;
    }

    @Override
    public int maxSoldType2() {
        return 0;
    }

    @Override
    public int maxsoldType3() {
        return 0;
    }

    @Override
    public int nbtour() {
        return 20;
    }

    @Override
    public int randomTypeSoldier() {
        return 1;
    }

    @Override
    public int nbrspwan1() {
        return 9;
    }

    @Override
    public int nbrspwan2() {
        return 0;
    }

    @Override
    public int nbrspwan3() {
        return 0;
    }
}
