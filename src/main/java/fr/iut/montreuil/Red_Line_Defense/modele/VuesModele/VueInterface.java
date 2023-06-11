package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import fr.iut.montreuil.Red_Line_Defense.modele.Joueur;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;

public class VueInterface {



    Label solde;


    ImageView berry;


    HBox hboxMoneyCount;

    Label ennemisTues;

    private Button lancerButton, test;





    public VueInterface(Environnement terrain, HBox hboxMoneyCount, Button lancerButton, Button test, Label solde, ImageView berry, Label ennemisTues) {
        solde.setText(String.valueOf(terrain.getJoueur().getSoldeJoueurValue()));
        this.hboxMoneyCount = hboxMoneyCount;
        this.lancerButton = lancerButton;
        this.test = test;
        this.solde = solde;
        this.berry = berry;
        this.ennemisTues = ennemisTues;
        initializeImageBerry();
    }

    private void initializeImageBerry() {
        berry = new ImageView(getBerryImage());
        hboxMoneyCount.getChildren().add(berry);
    }

    private Image getBerryImage() {
        return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/berry.png");
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

    // Getters and Setters for FXML elements
    public Button getLancerButton() {
        return lancerButton;
    }

    public void setLancerButton(Button lancerButton) {
        this.lancerButton = lancerButton;
    }

    public Button getTestButton() {
        return test;
    }

    public void setTestButton(Button test) {
        this.test = test;
    }

    public Label getSolde() {
        return solde;
    }

    public Label getEnnemisTues(){
        return ennemisTues;
    }

    public void setEnnemisTues(Label ennemisTues) {
        this.ennemisTues = ennemisTues;
    }

    public void setSolde(Label solde) {
        this.solde = solde;
    }

    public ImageView getBerry() {
        return berry;
    }

    public void setBerry(ImageView berry) {
        this.berry = berry;
    }

    public HBox getHboxMoneyCount() {
        return hboxMoneyCount;
    }

    public void setHboxMoneyCount(HBox hboxMoneyCount) {
        this.hboxMoneyCount = hboxMoneyCount;
    }
}
