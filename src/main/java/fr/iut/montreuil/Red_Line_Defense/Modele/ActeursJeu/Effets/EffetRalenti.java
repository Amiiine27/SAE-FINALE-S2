package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Effets;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;

public class EffetRalenti extends Effet{

    @Override
    public void appliquerEffet(Soldat soldat) {
        soldat.estPiégés();
    }
}
