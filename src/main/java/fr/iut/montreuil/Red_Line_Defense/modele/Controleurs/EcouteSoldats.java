
package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;



import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import javafx.beans.property.ListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.scene.shape.Circle;

import java.util.List;
import java.util.Map;

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
                            terrain.getVueSoldats().ajtCercleSoldats(soldat);
                        }

                    }
                }
            }
        });
    }





}
