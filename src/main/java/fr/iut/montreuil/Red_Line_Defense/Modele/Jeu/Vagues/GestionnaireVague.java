package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Vagues;

import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;

import java.util.ArrayList;
import java.util.Arrays;

public class GestionnaireVague {
    private ArrayList<Vagues> listeVague;
    private Environnement env;
    private int currentWave;
    private Vagues vagueActuelle;
    private int indiceVagueActuelle = 0;

    public GestionnaireVague(Environnement env){
        this.listeVague = new ArrayList<>(Arrays.asList(new PremiereVague(env),new DeuxièmeVague(env),new TroisiemeVague(env),new QuatrièmeVague(env),new CinquièmeVague(env)));
        this.env = env;
        this.vagueActuelle = this.listeVague.get(indiceVagueActuelle);
    }



    public Vagues getVagueActuelle(){
        return this.vagueActuelle;
    }
    public void unTour(){

        int envWave = env.getVagueValue();

        if (envWave != currentWave) {
            currentWave = envWave;
        }
                vagueActuelle = this.listeVague.get(envWave-1);
                vagueActuelle.spwanEnnemi();
    }
}
