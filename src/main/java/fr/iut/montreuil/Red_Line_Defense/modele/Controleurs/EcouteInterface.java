package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import fr.iut.montreuil.Red_Line_Defense.modele.Joueur;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueInterface;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.collections.ListChangeListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;

import java.util.List;

public class EcouteInterface {

    private Joueur joueur;
    private Environnement terrain;

    // Assuming vague is a property in Joueur
    private IntegerProperty vague;

    public EcouteInterface(Environnement terrain) {
        this.terrain = terrain;
        this.joueur = terrain.getJoueur();
        this.vague = terrain.getVagueProperty();
        ajouterEcouteurSolde();
        ajouterEcouteurEnnemisTues();
        ajouterListenerVague();
    }

    public void ajouterEcouteurSolde() {

        this.joueur.getSoldeJoueurProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                terrain.getVueInterface().getSolde().setText(String.valueOf(newValue));
            }
        });
    }

    public void ajouterEcouteurEnnemisTues() {

        this.terrain.getEnnemisTuesProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                terrain.getVueInterface().getEnnemisTues().setText(String.valueOf(newValue));
            }
        });
    }

    private void ajouterListenerVague() {
        this.vague.addListener((observable, oldValue, newValue) -> {
            System.out.println("Vague numéro " + newValue.intValue());
            joueur.crediterSolde(50); // Chaque Vague le Joueur Gagne 50 Berrys
        });
    }


}
