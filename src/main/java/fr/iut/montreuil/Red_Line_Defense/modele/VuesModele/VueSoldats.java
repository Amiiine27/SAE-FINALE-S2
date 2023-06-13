package fr.iut.montreuil.Red_Line_Defense.modele.VuesModele;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


public class VueSoldats {


    private Pane centerPane;

    private Map<Soldat, ImageView> hashMapSoldatsSkin = new HashMap<>();


    public VueSoldats(Pane centerPane) {
        this.centerPane = centerPane;
    }



    public void ajouterSkinSoldat(Soldat s) {
        ImageView skin  = creerImageSoldat();
        System.out.println("Skin créé pour le soldat : " + skin);

        hashMapSoldatsSkin.put(s, skin);

        s.setX0(s.getX0Value());
        s.setY0(s.getY0Value());

        skin.xProperty().bind(s.getX0Property());
        skin.yProperty().bind(s.getY0Property());

        centerPane.getChildren().add(skin);
        System.out.println("  Skin ajouté au pane. Total des cercles  ");
    }

    public void mettreAJourSkin(int directionIndex, Soldat soldat) {
        ImageView skin = hashMapSoldatsSkin.get(soldat);
        switch (directionIndex) {
            case 0:
                skin.setImage(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/Personnages/Violet/up.gif"));
                skin.setFitWidth(30);
                skin.setFitHeight(30);
                skin.setTranslateX(-15); // Ajout de cette ligne
                skin.setTranslateY(-15);
                break;
            case 1:
                skin.setImage(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/Personnages/Violet/down.gif"));
                skin.setFitWidth(30);
                skin.setFitHeight(30);
                skin.setTranslateX(-15); // Ajout de cette ligne
                skin.setTranslateY(-15);
                break;
            case 2:
                skin.setImage(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/Personnages/Violet/left.gif"));
                skin.setFitWidth(30);
                skin.setFitHeight(30);
                skin.setTranslateX(-15); // Ajout de cette ligne
                skin.setTranslateY(-15);
                break;
            case 3:
                skin.setImage(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/Personnages/Violet/right.gif"));
                skin.setFitWidth(30);
                skin.setFitHeight(30);
                skin.setTranslateX(-15); // Ajout de cette ligne
                skin.setTranslateY(-15);
                break;
        }
    }

    public ImageView creerImageSoldat() {
        Image image = loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/Personnages/Violet/up.gif");
        ImageView img = new ImageView(image);
        img.setFitWidth(30);
        img.setFitHeight(30);
        img.setTranslateX(-15); // Ajout de cette ligne
        img.setTranslateY(-15);
        img.setPreserveRatio(true);
        return img;
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }

    public void supprSkinSoldats(Soldat s) {
        centerPane.getChildren().remove(getSkinForSoldat(s));
    }

    public Map<Soldat, ImageView> getHashMap(){
        return this.hashMapSoldatsSkin;
    }

    public ImageView getSkinForSoldat(Soldat soldat) {
        return this.hashMapSoldatsSkin.get(soldat);
    }
    public Soldat getSoldatForSkin(ImageView i) {
        for (Map.Entry<Soldat, ImageView> entry : this.hashMapSoldatsSkin.entrySet()) {
            if (Objects.equals(i, entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

}
