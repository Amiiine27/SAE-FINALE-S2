package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Rookie;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.SuperNova;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.scene.control.Skin;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;


public class VueSoldats {


    private Pane centerPane;

    private Map<Soldat, ImageView> hashMapSoldatsSkin = new HashMap<>();


    public VueSoldats(Pane centerPane) {
        this.centerPane = centerPane;
    }
    /*

    public void ajtCercleSoldats(Soldat s) {
        Circle cercleSoldat = new Circle(4, Color.DARKORCHID);
        System.out.println("Cercle créé pour le soldat : " + cercleSoldat);

        hashMapSoldatsCercles.put(s, cercleSoldat);

        cercleSoldat.centerXProperty().bind(s.getX0Property());
        cercleSoldat.centerYProperty().bind(s.getY0Property());

        centerPane.getChildren().add(cercleSoldat);
        System.out.println("Cercle ajouté au pane. Total des cercles : " + centerPane.getChildren().size());

    }

     */

    public void ajouterSkinSoldat(Soldat s) {
        ImageView skin  = creerImageSoldat();
        System.out.println("Skin créé pour le soldat : " + skin);

        hashMapSoldatsSkin.put(s, skin);
        //DoubleProperty x = new SimpleDoubleProperty(12);
        s.setX0(s.getX0Value()- 12);
        s.setY0(s.getY0Value()- 15);
        //DoubleProperty y = new SimpleDoubleProperty(15);

        skin.xProperty().bind(s.getX0Property());
        skin.yProperty().bind(s.getY0Property());

        centerPane.getChildren().add(skin);
        System.out.println("Skin ajouté au pane. Total des cercles : " + centerPane.getChildren().size());

    }
    public ImageView creerImageSoldat() {
        ImageView img = new ImageView(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/versLeHaut.gif"));
        return img;
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

    public void supprCercleSoldats(Soldat s) {

    }

    public Map<Soldat, ImageView> getHashMap(){
        return this.hashMapSoldatsSkin;
    }

    public ImageView getCircleForSoldat(Soldat soldat) {
        return this.hashMapSoldatsSkin.get(soldat);
    }
    public Soldat getSoldatForCircle(ImageView i) {
        for (Map.Entry<Soldat, ImageView> entry : this.hashMapSoldatsSkin.entrySet()) {
            if (Objects.equals(i, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}
