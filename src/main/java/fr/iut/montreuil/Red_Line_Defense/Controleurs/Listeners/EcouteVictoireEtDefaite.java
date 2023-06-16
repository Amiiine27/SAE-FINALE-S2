package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Controleurs.Controleur;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Vagues;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import fr.iut.montreuil.Red_Line_Defense.Vues.VueInterface;
import javafx.beans.property.IntegerProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class EcouteVictoireEtDefaite {

    private Joueur joueur;
    private Environnement terrain;

    private VueInterface vueInterface;

    private Vagues vagues;

    private Controleur c;

    private IntegerProperty vague;

    public EcouteVictoireEtDefaite(Environnement terrain, VueInterface vueInterface, Controleur c) {
        this.terrain = terrain;
        this.joueur = terrain.getJoueur();
        this.vague = terrain.getVagueProperty();
        this.vagues = terrain.getVagues();
        this.vueInterface = vueInterface;
        this.c = c;
        ajouterEcouteurVictoire();
    }



    private void ajouterEcouteurVictoire() {

        this.vague.addListener((observable, oldValue, newValue) -> {
            if (newValue.intValue() > 5) {
                try {
                    System.out.println("HA");
                    FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/chemin/vers/votre/vueDefaite.fxml"));
                    Parent root = fxmlLoader.load();

                    Stage currentStage = c.getStage();
                    currentStage.setScene(new Scene(root));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
    }




}
