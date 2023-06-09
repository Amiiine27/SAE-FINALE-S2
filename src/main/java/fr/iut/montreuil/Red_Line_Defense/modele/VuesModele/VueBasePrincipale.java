package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.BasePrincipale;
import javafx.fxml.FXML;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class VueBasePrincipale {

    @FXML
    Pane centerpane;

    public VueBasePrincipale(Pane p) {
        this.centerpane = p;
    }

    public void afficherBasePrincipale(BasePrincipale bp) {
        Rectangle r = new Rectangle(bp.getX0Value(), bp.getY0Value(), 35, 25);
        r.setFill(Color.GREY);
        centerpane.getChildren().add(r);
    }
}
