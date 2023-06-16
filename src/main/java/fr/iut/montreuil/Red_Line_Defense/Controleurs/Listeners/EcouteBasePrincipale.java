package fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners;

import fr.iut.montreuil.Red_Line_Defense.Vues.VueBasePrincipale;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.ProgressBar;

public class EcouteBasePrincipale {

    private int pointsDeVieBasePrincipale;
    private VueBasePrincipale vueBasePrincipale;
    private ProgressBar barreDeVieBasePrincipale;
    private DoubleProperty progression;

    public EcouteBasePrincipale(VueBasePrincipale vueBasePrincipale) {
        this.vueBasePrincipale = vueBasePrincipale;
        this.pointsDeVieBasePrincipale = vueBasePrincipale.getPointsDeVieBasePrincipale();
        this.barreDeVieBasePrincipale = vueBasePrincipale.getBarreDeVieBasePrincipale();
        this.progression = new SimpleDoubleProperty(1.0);
        barreDeVieBasePrincipale.progressProperty().bind(progression);
        ajouterEcouteurBarreDeVie();
        ajouterEcouteurPointsDeVie();
    }

    public void ajouterEcouteurBarreDeVie() {
        this.vueBasePrincipale.getBasePrincipale().getPointsDeVieProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                progression.set(newValue.doubleValue() / pointsDeVieBasePrincipale);
            }
        });
    }

    public void ajouterEcouteurPointsDeVie() {
        this.vueBasePrincipale.getBasePrincipale().getPointsDeVieProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if (newValue.doubleValue() < 0){

                }
            }
        });
    }



}
