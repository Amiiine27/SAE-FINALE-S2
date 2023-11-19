package fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Effets;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;

public class EffetBase extends Effet{
    @Override
    public void appliquerEffetSur(Soldat s) {
        s.setEffet(this);
    }
}
