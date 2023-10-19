package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Vagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Rookie;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.SuperNova;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;

import java.util.Random;

public abstract class Vagues {

    private Environnement environnement;
    private int nbreSpawnsType1;
    private int nbreSpawnsType2;
    private int nbreSpawnsType3;

    private int totalSoldats;

    public Vagues(Environnement environnement) {
        this.environnement = environnement;
        this.nbreSpawnsType1 = 0;
        this.nbreSpawnsType2 = 0;
        this.nbreSpawnsType3 = 0;
    }


    public void majDefenseSoldats() {
        for (Soldat s : environnement.getSoldats()) {
            if (s.getPointsDeVieValue() > 5) {
                s.setPointsDeVieValue(s.getPointsDeVieValue() - 5);
            }
        }
    }

    public void resetTours() {
        for (Tour t : environnement.getTours()){
            t.setPointsDeVieValue(0);
        }
    }

    public abstract int maxSoldType1();
    public abstract int maxSoldType2();
    public abstract int maxsoldType3();
    public abstract int nbtour();
    public abstract int randomTypeSoldier();
    public abstract int nbrspwan1();
    public abstract int nbrspwan2();
    public abstract int nbrspwan3();


    public void spwanEnnemi(){
      //  ennemisAFaireSpawnType1 = this.ennemiFaireSpwan();

        int maxSoldiersType1 = this.maxSoldType1();
        int maxSoldiersType2 = this.maxSoldType2();
        int maxSoldiersType3 = this.maxsoldType3();

        totalSoldats = maxSoldiersType1 + maxSoldiersType2 + maxSoldiersType3;

        Random random = new Random();

        if ((environnement.getNbrTours() % this.nbtour()) == 0) { // Verifier si le tour dans environnement et dans notre classe est le même

            if ((nbreSpawnsType1 < maxSoldiersType1) || (nbreSpawnsType2 < maxSoldiersType2) || (nbreSpawnsType3 < maxSoldiersType3)) {
                int soldierTypeToSpawn = random.nextInt(this.randomTypeSoldier()) + 1; // Cela générera soit 1, soit 2 ou 3

                if ((soldierTypeToSpawn == 1) && (nbreSpawnsType1 < maxSoldiersType1)) {
                    System.out.println("Un nouveau Rookie apparait !");
                    nouveauSpawnSoldat(1, this.nbrspwan1());
                    nbreSpawnsType1++;
                } else if ((soldierTypeToSpawn == 2) && (nbreSpawnsType2 < maxSoldiersType2)) {
                    System.out.println("Un nouveau Super Nova apparait !");
                    nouveauSpawnSoldat(2, this.nbrspwan2());
                    nbreSpawnsType2++;
                } else if ((soldierTypeToSpawn == 3) && (nbreSpawnsType3 < maxSoldiersType3)) {
                    System.out.println("Un nouveau Shichibukai apparait !");
                    nouveauSpawnSoldat(3, this.nbrspwan3());
                    nbreSpawnsType3++;
                }
            }
        }
    }


    public void nouveauSpawnSoldat(int typeSoldat, int spawn) {

        int[] randomSelection = randomSelection(spawn);
        int startX = randomSelection[0] * 8;
        int startY = randomSelection[1] * 8;

        Soldat soldat = afficherSoldat(startX, startY,typeSoldat);
        soldat.setSpawnSoldat(new int[]{startX, startY});
    }



    public Soldat afficherSoldat(double startX, double startY, int typeSoldat) {
        Soldat s = selectionSoldat(typeSoldat, startX, startY);
        //listeSoldats.add(s);
        environnement.ajouterSoldat(s);

        return s;
    }



    public Soldat selectionSoldat(int typeSoldat, double startX, double startY) {

        Soldat s;

        switch(typeSoldat) {
            case 1:
                s = new Rookie((int) startX, (int) startY, 89, 49, environnement);
                break;
            case 2:
                s = new SuperNova((int) startX, (int) startY, 89, 49, environnement);
                break;
            case 3:
                s = new Shichibukais((int) startX, (int) startY, 89, 49, environnement);
                break;
            default:
                s = new Rookie((int) startX, (int) startY, 89, 49, environnement);
        }

        return s;
    }



    public int[] randomSelection(int i) {
        int[] resultat = new int[4];

        // 0-9 10-16

        int[][] possibleStartPositions = this.getEnvironnement().getTerrain().getSpawnPossible();

        int[][] possibleDestPositions = {
                {89, 49}
        };

        Random random = new Random();

        int[] randomStartPosition = possibleStartPositions[random.nextInt(i)];
        int[] randomDestPosition = possibleDestPositions[random.nextInt(possibleDestPositions.length)];

        resultat[0] = randomStartPosition[0];
        resultat[1] = randomStartPosition[1];
        resultat[2] = randomDestPosition[0];
        resultat[3] = randomDestPosition[1];

        return resultat;
    }

    public Environnement getEnvironnement() {
        return environnement;
    }
/*
    public int getListeSoldats() {
       // return listeSoldats.size();
        return environnement.getli
    }
 */
    public int getTotalSoldats(){
      return  this.totalSoldats;
    }

    public void setEnvironnement(Environnement environnement) {
        this.environnement = environnement;
    }

}