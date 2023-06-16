package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Rookie;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.SuperNova;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;

import java.util.Random;

public class Vagues {

    private ListProperty<Soldat> listeSoldats;

    private IntegerProperty nbrTours;
    private Environnement environnement;

    private int currentWave;

    private int numeroDeVague;

    private int ennemisAFaireSpawnType1;

    private int ennemisAFaireSpawnType2;

    private int ennemisAFaireSpawnType3;

    private int nbreSpawnsType1;
    private int nbreSpawnsType2;

    private int nbreSpawnsType3;


    public Vagues(Environnement environnement) {
        this.environnement = environnement;
        this.listeSoldats = environnement.getSoldatsProperty();
        this.numeroDeVague = environnement.getVagueValue();
        this.nbreSpawnsType1 = 0;
        this.nbreSpawnsType2 = 0;
        this.nbreSpawnsType3 = 0;
    }

    public void unTour(){

        int envWave = environnement.getVagueValue();

        if (envWave != currentWave) {
            resetNbreSpawns();
            currentWave = envWave;
        }

        switch (envWave) {
            case 1:
                premiereVague();
                System.out.println("Première Vague");
                break;
            case 2:
                deuxiemeVague();
                System.out.println("Deuxieme Vague");
                break;
            case 3:
                troisiemeVague();
                System.out.println("Troisième Vague");
                break;
            case 4:
                quatriemeVague();
                System.out.println("Quatrieme Vague");
                break;
            case 5:
                cinquiemeVague();
                System.out.println("Cinquieme et dernière Vague");
                break;
            default:
                vagueParDefault();
        }
    }

    public void resetNbreSpawns() {
        nbreSpawnsType1 = 0;
        nbreSpawnsType2 = 0;
        nbreSpawnsType3 = 0;
    }



    public void premiereVague(){
        ennemisAFaireSpawnType1 = 10;

        if (((environnement.getNbrTours() % 20) == 0) && (ennemisAFaireSpawnType1 > nbreSpawnsType1)) {
            System.out.println("Un nouveau Soldat Apparait !");
            nouveauSpawnSoldat(1,9);
            nbreSpawnsType1++;
        }
    }

    public void deuxiemeVague(){

        resetNbreSpawns();

        int maxSoldiersType1 = 15;
        int maxSoldiersType2 = 7;

        Random random = new Random();

        if ((environnement.getNbrTours() % 15) == 0){

            if ((nbreSpawnsType1 < maxSoldiersType1) || (nbreSpawnsType2 < maxSoldiersType2)) {
                int soldierTypeToSpawn = random.nextInt(2) + 1; // Cela générere soit 1 soit 2

                if ((soldierTypeToSpawn == 1) && (nbreSpawnsType1 < maxSoldiersType1)) {
                    System.out.println("Un nouveau Rookie apparait !");
                    nouveauSpawnSoldat(1, 9);
                    nbreSpawnsType1++;
                } else if ((soldierTypeToSpawn == 2) && (nbreSpawnsType2 < maxSoldiersType2)) {
                    System.out.println("Un nouveau Super Nova apparait !");
                    nouveauSpawnSoldat(2, 9);
                    nbreSpawnsType2++;
                }
            }
        }
    }


    public void troisiemeVague(){
        int maxSoldiersType1 = 20;
        int maxSoldiersType2 = 12;

        Random random = new Random();

        if ((environnement.getNbrTours() % 12) == 0) {

            if ((nbreSpawnsType1 < maxSoldiersType1) || (nbreSpawnsType2 < maxSoldiersType2)) {
                int soldierTypeToSpawn = random.nextInt(2) + 1; // Cela générere soit 1 soit 2

                if ((soldierTypeToSpawn == 1) && (nbreSpawnsType1 < maxSoldiersType1)) {
                    System.out.println("Un nouveau Rookie apparait !");
                    nouveauSpawnSoldat(1, 12);
                    nbreSpawnsType1++;
                } else if ((soldierTypeToSpawn == 2) && (nbreSpawnsType2 < maxSoldiersType2)) {
                    System.out.println("Un nouveau Super Nova apparait !");
                    nouveauSpawnSoldat(2, 12);
                    nbreSpawnsType2++;
                }
            }
        }
    }

    public void quatriemeVague(){
        int maxSoldiersType1 = 17;
        int maxSoldiersType2 = 10;
        int maxSoldiersType3 = 6;

        Random random = new Random();

        if ((environnement.getNbrTours() % 10) == 0) {

            if ((nbreSpawnsType1 < maxSoldiersType1) || (nbreSpawnsType2 < maxSoldiersType2) || (nbreSpawnsType3 < maxSoldiersType3)) {
                int soldierTypeToSpawn = random.nextInt(3) + 1; // Cela générera soit 1, soit 2 ou 3

                if ((soldierTypeToSpawn == 1) && (nbreSpawnsType1 < maxSoldiersType1)) {
                    System.out.println("Un nouveau Rookie apparait !");
                    nouveauSpawnSoldat(1, 9);
                    nbreSpawnsType1++;
                } else if ((soldierTypeToSpawn == 2) && (nbreSpawnsType2 < maxSoldiersType2)) {
                    System.out.println("Un nouveau Super Nova apparait !");
                    nouveauSpawnSoldat(2, 9);
                    nbreSpawnsType2++;
                } else if ((soldierTypeToSpawn == 3) && (nbreSpawnsType3 < maxSoldiersType3)) {
                    System.out.println("Un nouveau Shichibukai apparait !");
                    nouveauSpawnSoldat(3, 9);
                    nbreSpawnsType3++;
                }
            }
        }
    }


    public void cinquiemeVague(){
        int maxSoldiersType1 = 18;
        int maxSoldiersType2 = 10;
        int maxSoldiersType3 = 8;

        Random random = new Random();

        if ((environnement.getNbrTours() % 9) == 0) {

            if ((nbreSpawnsType1 < maxSoldiersType1) || (nbreSpawnsType2 < maxSoldiersType2) || (nbreSpawnsType3 < maxSoldiersType3)) {
                int soldierTypeToSpawn = random.nextInt(3) + 1; // Cela générera soit 1, soit 2 ou 3

                if ((soldierTypeToSpawn == 1) && (nbreSpawnsType1 < maxSoldiersType1)) {
                    System.out.println("Un nouveau Rookie apparait !");
                    nouveauSpawnSoldat(1, 9);
                    nbreSpawnsType1++;
                } else if ((soldierTypeToSpawn == 2) && (nbreSpawnsType2 < maxSoldiersType2)) {
                    System.out.println("Un nouveau Super Nova apparait !");
                    nouveauSpawnSoldat(2, 9);
                    nbreSpawnsType2++;
                } else if ((soldierTypeToSpawn == 3) && (nbreSpawnsType3 < maxSoldiersType3)) {
                    System.out.println("Un nouveau Shichibukai apparait !");
                    nouveauSpawnSoldat(3, 9);
                    nbreSpawnsType3++;
                }
            }
        }
    }




    public void vagueParDefault(){
        System.out.println("Default");
    }

    public Soldat nouveauSpawnSoldat(int typeSoldat, int spawn) {

        int[] randomSelection = randomSelection(spawn);
        int startX = randomSelection[0] * 8;
        int startY = randomSelection[1] * 8;

        Soldat soldat = afficherSoldat(startX, startY,typeSoldat);
        return soldat;
    }



    public Soldat afficherSoldat(double startX, double startY, int typeSoldat) {
        Soldat s = selectionSoldat(typeSoldat, startX, startY);
        listeSoldats.add(s);
        System.out.println("Soldat créé et ajouté au terrain");

        return s;
    }



    public Soldat selectionSoldat(int typeSoldat, double startX, double startY) {

        Soldat s;

        switch(typeSoldat) {
            case 1:
                s = new Rookie((int) startX, (int) startY, 89, 49);
                break;
            case 2:
                s = new SuperNova((int) startX, (int) startY, 89, 49);
                break;
            case 3:
                s = new Shichibukais((int) startX, (int) startY, 89, 49);
                break;
            default:
                s = new Rookie((int) startX, (int) startY, 89, 49);
        }

        return s;
    }



    public int[] randomSelection(int i) {
        int[] resultat = new int[4];

        // 0-9 10-16

        int[][] possibleStartPositions = {
                {14, 57},
                {15, 57},
                {16, 57},
                {0, 42},
                {0, 41},
                {0, 43},
                {0, 19},
                {0, 18},
                {9, 1},
                {8, 1},
                {44, 59},
                {45, 58},
                {44, 57},
                {82, 0},
                {83, 0},
                {81, 1},
                {82, 2}
        };

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

}
