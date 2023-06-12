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


    ImageView berry, berryBot200b, berryBot400b, berryBot600b, berryBot800b;


    HBox hboxMoneyCount, prix200b, prix800b, prix600b, prix400b;

    Label ennemisTues;

    private Button lancerButton, test;





    public VueInterface(Environnement terrain, HBox hboxMoneyCount, Button lancerButton, Button test, Label solde, ImageView berry, Label ennemisTues,
                        HBox prix200b, HBox prix400b, HBox prix600b, HBox prix800b, ImageView berryBot200b, ImageView berryBot600b, ImageView berryBot400b, ImageView berryBot800b) {
        solde.setText(String.valueOf(terrain.getJoueur().getSoldeJoueurValue()));
        this.hboxMoneyCount = hboxMoneyCount;
        this.lancerButton = lancerButton;
        this.test = test;
        this.solde = solde;
        this.berry = berry;
        this.ennemisTues = ennemisTues;
        this.prix200b = prix200b;
        this.prix400b = prix400b;
        this.prix600b = prix600b;
        this.prix800b = prix800b;
        this.berryBot200b = berryBot200b;
        this.berryBot400b = berryBot400b;
        this.berryBot600b = berryBot600b;
        this.berryBot800b = berryBot800b;
        initializeImageBerry();
    }

    private void initializeImageBerry() {
        berry = new ImageView(getBerryImage());
        hboxMoneyCount.getChildren().add(berry);
        berryBot200b = new ImageView(getBerryPrixImage());
        prix200b.getChildren().add(berryBot200b);
        berryBot400b = new ImageView(getBerryPrixImage());
        prix400b.getChildren().add(berryBot400b);

        berryBot600b = new ImageView(getBerryPrixImage());
        prix600b.getChildren().add(berryBot600b);

        berryBot800b = new ImageView(getBerryPrixImage());
        prix800b.getChildren().add(berryBot800b);

    }

    private Image getBerryImage() {
        return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/berry.png");
    }
    private Image getBerryPrixImage() {
        return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/berryPrix.png");
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
