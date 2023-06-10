package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.BasePrincipale;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VueBasePrincipale {

    @FXML
    Pane p;

    public VueBasePrincipale(Pane p) {
        this.p = p;
    }

    public void afficherBase(BasePrincipale bp){
        ImageView img = creerImageBP();
        img.setLayoutX(bp.getX0Value()-40);
        img.setLayoutY(bp.getY0Value()-50);
        p.getChildren().add(img);
    }

    public ImageView creerImageBP() {
        ImageView img = new ImageView(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/bp.png"));
        return img;
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

}
