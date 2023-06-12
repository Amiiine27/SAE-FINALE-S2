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

        // Centrer l'image en ajustant x et y
        double halfWidth = (skin.getImage().getWidth() / 2.0) ;
        double halfHeight = (skin.getImage().getHeight() / 2.0);
        s.setX0(s.getX0Value() - halfWidth);
        s.setY0(s.getY0Value() - halfHeight);

        skin.xProperty().bind(s.getX0Property());
        skin.yProperty().bind(s.getY0Property());

        centerPane.getChildren().add(skin);
        System.out.println("  Skin ajouté au pane. Total des cercles  ");
    }

    public void mettreAJourSkin(int directionIndex, Soldat soldat) {
        ImageView skin = hashMapSoldatsSkin.get(soldat);
        switch (directionIndex) {
            case 0:
                skin.setImage(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/Personnage/versLeHaut.gif"));
                System.out.println("HAUT");
                break;
            case 1:
                skin.setImage(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/ComposantesMenuPrincipal/logo.png"));
                System.out.println("BAS");
                break;
            case 2:
                skin.setImage(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/ComposantesMenuPrincipal/luffy-shanks.jpg"));
                System.out.println("GAUCHE");
                break;
            case 3:
                skin.setImage(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/ToursPosables/sniperPosable.png"));
                System.out.println("DROITE");
                break;
        }
    }

    public ImageView creerImageSoldat() {
        Image image = loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/Personnage/versLeHaut.gif");
        ImageView img = new ImageView(image);
        img.setFitWidth(image.getWidth() / 2);
        img.setFitHeight(image.getHeight() / 2);
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
