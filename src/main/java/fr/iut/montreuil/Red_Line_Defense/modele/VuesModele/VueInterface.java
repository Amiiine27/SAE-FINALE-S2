package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

public class VueInterface {



    Label solde;

    StackPane stackpane;


    ImageView berry, berryBot200b, berryBot400b, berryBot600b, berryBot800b, wpp;


    HBox hboxMoneyCount, prix200b, prix800b, prix600b, prix400b;

    VBox vboxRight;

    Label ennemisTues;

    private Button lancerButton, test;





    public VueInterface(Environnement terrain, HBox hboxMoneyCount, Button lancerButton, Button test, Label solde, ImageView berry, Label ennemisTues,
                        HBox prix200b, HBox prix400b, HBox prix600b, HBox prix800b, ImageView berryBot200b, ImageView berryBot600b, ImageView berryBot400b, ImageView berryBot800b, VBox vboxRight,
                        ImageView wpp, StackPane stackpane) {

        solde.setText(String.valueOf(terrain.getJoueur().getSoldeJoueurValue()));
        //this.hboxMoneyCount = hboxMoneyCount;
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
        this.vboxRight = vboxRight;
        this.wpp = wpp;
        this.stackpane = stackpane;
        initializeRightPane();
        initializeImageBerry();

    }

    private void initializeImageBerry() {
        berry = new ImageView(getBerryImage());
        //hboxMoneyCount.getChildren().add(berry);
        berryBot200b = new ImageView(getBerryPrixImage());
        prix200b.getChildren().add(berryBot200b);
        berryBot400b = new ImageView(getBerryPrixImage());
        prix400b.getChildren().add(berryBot400b);

        berryBot600b = new ImageView(getBerryPrixImage());
        prix600b.getChildren().add(berryBot600b);

        berryBot800b = new ImageView(getBerryPrixImage());
        prix800b.getChildren().add(berryBot800b);

    }

    public void initializeRightPane(){
        wpp = new ImageView(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/AccessoiresInterface/rightPane.gif"));

        stackpane.getChildren().add(0, wpp);

        //StackPane.setMargin(ennemisTues, new Insets(0, 12, 44, 0));
        //stackpane.getChildren().add(solde);
        //stackpane.getChildren().add(lancerButton);
        //hboxMoneyCount.setTranslateX(59);
        //hboxMoneyCount.setTranslateY(259);
        /*solde.setTranslateX(59);
        solde.setTranslateY(259);
        stackpane.getChildren().add(1, solde);
        ennemisTues.setTranslateX(59);
        ennemisTues.setTranslateY(194);
        stackpane.getChildren().add(2,ennemisTues);
         */

    }

    private Image getBerryImage() {
        return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/AccessoiresInterface/berry.png");
    }
    private Image getBerryPrixImage() {
        return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/AccessoiresInterface/berryPrix.png");
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
