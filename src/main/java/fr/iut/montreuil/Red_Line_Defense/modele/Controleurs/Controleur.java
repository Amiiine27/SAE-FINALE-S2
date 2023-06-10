package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import fr.iut.montreuil.Red_Line_Defense.modele.GameLoop;
import fr.iut.montreuil.Red_Line_Defense.modele.Joueur;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueBasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueSoldats;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.VueTours;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private static final int TAILLE_IMAGE = 8;


    @FXML
    private Button lancerButton;

    private EcouteSoldats ecouteSoldats;

    private EcouteTours ecouteTours;

    private Environnement terrain;

    private GameLoop gameLoop;
    private VueTours vueTours;
    private VueSoldats vueSoldats;

    @FXML
    private Pane centerPane;
    @FXML
    Label solde;

    @FXML
    ImageView berry;

    @FXML
    HBox hboxMoneyCount;

    private BasePrincipale bp;

    private VueBasePrincipale VBP;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initializeEnvironnement();;
        initializeVueTours();
        initializeVueSoldats();
        initializeImageBerry();
        initializeBasePrincipale();
        initializeVueBasePrincipale();
        VBP.afficherBase(bp);
        terrain.setVueSoldats(vueSoldats);
        solde.textProperty().bind(terrain.getJoueur().getSoldeJoueurProperty().asString());
    }

    private void initializeEcouteSoldats(){
        ecouteSoldats = new EcouteSoldats(terrain);
    }

    private void initializeImageBerry(){
        berry = new ImageView(getBerryImage());
        System.out.println("imageView ajt");
        hboxMoneyCount.getChildren().add(berry);
    }

    private void initializeEcouteTours(){ ecouteTours = new EcouteTours(terrain);}

    private void initializeEnvironnement() {
        terrain = new Environnement();
        remplissage();
    }

    @FXML
    private void lancerTours() {
        initializeGameLoop();
    }

    private void initializeBasePrincipale(){
        bp = new BasePrincipale(700, 335, terrain);
    }

    private void initializeVueBasePrincipale(){
        VBP = new VueBasePrincipale(centerPane);
    }

    private void initializeVueTours() {
        vueTours = new VueTours(terrain, centerPane);
        initializeEcouteTours();
    }

    private void initializeVueSoldats() {
        vueSoldats = new VueSoldats(centerPane);
        initializeEcouteSoldats();
    }

    private void initializeGameLoop() {
        gameLoop = new GameLoop(centerPane, vueSoldats, terrain);
    }

    private void remplissage() {
        int xmax = terrain.getXmax();
        int ymax = terrain.getYmax();

        for (int i = 0; i < ymax; i++) {
            for (int j = 0; j < xmax; j++) {
                centerPane.getChildren().add(createTerrainImageView(i, j));
            }
        }
    }

    private ImageView createTerrainImageView(int i, int j) {
        int n = terrain.valeurDeLaCase(i, j);
        ImageView imageView = new ImageView(getTerrainImage(n));
        imageView.setTranslateX(j * TAILLE_IMAGE);
        imageView.setTranslateY(i * TAILLE_IMAGE);
        return imageView;
    }

    private Image getTerrainImage(int n) {
        switch (n) {
            case 1:
                return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/chemin.png");
            default:
                return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/herbeVierge.png");
        }
    }
    private Image getBerryImage() {
                return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/berry.png");
    }

    public void positionTour(MouseEvent event) {
        vueTours.positionTour(event);
    }

    public void selectionTour(MouseEvent event) {
        vueTours.selectionTour(event);
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }
}
