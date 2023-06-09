package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import fr.iut.montreuil.Red_Line_Defense.modele.Joueur;
import javafx.beans.property.ListProperty;
import javafx.collections.ListChangeListener;

import java.util.List;

public class EcouteTours {

    private ListProperty<Tour> listeTours;

    private Joueur joueur;
    private Environnement terrain;

    public EcouteTours(Environnement terrain) {
        this.terrain = terrain;
        this.joueur = terrain.getJoueur();
        this.listeTours = this.terrain.getToursProperty();
        ajouterEcouteurSurTours();
    }

    public void ajouterEcouteurSurTours() {

        this.listeTours.addListener(new ListChangeListener<Tour>() {
            @Override
            public void onChanged(ListChangeListener.Change<? extends Tour> t) {
                while (t.next()) {
                    if (t.wasAdded()) {
                        List<? extends Tour> addedTowers = t.getAddedSubList();
                        for (Tour tour : addedTowers) {
                            joueur.debiterSolde(tour.getPrixValue());
                        }
                        if (joueur.getSoldeJoueurValue() < 0) {

                        }

                    }
                }
            }
        });
    }
}
