
package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;



import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import javafx.beans.property.ListProperty;
import javafx.collections.ListChangeListener;

import java.util.List;

public class EcouteSoldats {

    private ListProperty<Soldat> listeSoldat;

    private Environnement terrain;

    public EcouteSoldats(Environnement terrain) {
        this.terrain = terrain;
        this.listeSoldat = this.terrain.getSoldatsProperty();
        ajouterEcouteurSurSoldat();
    }

    public void ajouterEcouteurSurSoldat() {
        this.listeSoldat.addListener(new ListChangeListener<Soldat>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Soldat> c) {
                while (c.next()) {
                    if (c.wasAdded()) {
                        List<? extends Soldat> addedSoldiers = c.getAddedSubList();
                        for (Soldat soldat : addedSoldiers) {
                            terrain.getVueSoldats().ajouterSkinSoldat(soldat);
                        }

                    }
                }
            }
        });
    }





}
