/*

package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;



import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import javafx.beans.property.ListProperty;
import javafx.beans.value.ChangeListener;
import javafx.collections.ListChangeListener;
import javafx.scene.shape.Circle;

import java.util.List;
import java.util.Map;

public class EcouteSoldats {


    private ListProperty<Soldat> listeSoldat;

    private Carte terrain;

    public EcouteSoldats(Carte terrain, ListProperty<Soldat> listeSoldat) {
        this.terrain = terrain;
        this.listeSoldat = listeSoldat;
        ajouterEcouteurSurSoldat();
    }

    public void ajouterEcouteurSurSoldat() {
        listeSoldat.addListener(new ListChangeListener<Soldat>() {
            @Override
            public void onChanged(Change<? extends Soldat> change) {
                while (change.next()) {

                    if (change.wasAdded()) {
                        List<? extends Soldat> nouveauxSoldats = change.getAddedSubList();

                        for (Soldat soldat : nouveauxSoldats) {
                            soldat.getX0Property().addListener((observable, oldValue, newValue) -> {
                                miseAJourSpriteSoldat(soldat, newValue.intValue(), (int) soldat.getY0Value());
                            });
                            soldat.getY0Property().addListener((observable, oldValue, newValue) -> {
                                miseAJourSpriteSoldat(soldat, (int) soldat.getX0Value(), newValue.intValue());
                            });

                        }

                    } else if (change.wasRemoved()) {


                        List<? extends Soldat> soldatsSupprimes = change.getRemoved();

                        for (Soldat soldat : soldatsSupprimes) {
                            soldat.getX0Property().removeListener((ChangeListener<? super Number>) null);
                            soldat.getY0Property().removeListener((ChangeListener<? super Number>) null);
                        }
                    }
                }
            }

        });

    }

    private void miseAJourSpriteSoldat(Soldat soldat, int x, int y) {
        Map<Soldat, Circle> mapSoldatsCercles = terrain.getMapSoldatsCercles();
        Circle cercleSoldat = mapSoldatsCercles.get(soldat);

        if (cercleSoldat != null) {
            cercleSoldat.setCenterX(x);
            cercleSoldat.setCenterY(y);
        }
    }


}
*/