package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.Environnement;
import fr.iut.montreuil.Red_Line_Defense.modele.GameLoop;
import fr.iut.montreuil.Red_Line_Defense.modele.Inputs.Inputs;
import fr.iut.montreuil.Red_Line_Defense.modele.Joueur;
import fr.iut.montreuil.Red_Line_Defense.modele.VuesModele.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private static final int TAILLE_IMAGE = 8;

    @FXML
    private Pane centerPane;

    @FXML
    private Label ennemisTues;

    @FXML
    Label solde;

    @FXML
    ImageView map, berry, berryBot200b, berryBot400b, berryBot600b, berryBot800b;

    @FXML
    HBox hboxMoneyCount, prix200b, prix800b, prix600b, prix400b;

    @FXML
    private Button lancerButton, test;

    private Joueur joueur;
    private VueInterface vueInterface;

    private EcouteSoldats ecouteSoldats;
    private EcouteTours ecouteTours;

    private EcouteInterface ecouteInterface;

    private Inputs inputs;

    private Environnement terrain;
    private GameLoop gameLoop;
    private VueTours vueTours;
    private VueSoldats vueSoldats;

    private VueProjectile vueProjectile;

    private VueBasePrincipale vueBasePrincipale;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        centerPane.getChildren().add(new ImageView(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/ElementsCarte/map.png")));
        initializeJoueur();
        initializeEnvironnement();
        initializeVueTours();
        initializeVueSoldats();
        initializeGameLoop();
        initializeVueInterface();
        initializeVueBasePrincipale();
        initializeVueProjectile();


        terrain.setVueSoldats(vueSoldats);
        terrain.setVueInterface(vueInterface);
        terrain.setVueProjectile((vueProjectile));

        //initializeInputs();
    }

    private void initializeJoueur(){
        this.joueur = new Joueur("Ayoub");
    }

    public void initializeInputs(){
        inputs = new Inputs(gameLoop, centerPane.getScene());
    }

    private void initializeVueInterface(){
        vueInterface = new VueInterface(terrain, hboxMoneyCount, lancerButton, test, solde, berry, ennemisTues, prix200b, prix800b, prix600b, prix400b,
                berryBot200b, berryBot400b, berryBot600b, berryBot800b);
        initializeEcouteInterface();
    }

    private void initializeEcouteInterface(){
        ecouteInterface = new EcouteInterface(terrain);
    }

    private void initializeEcouteSoldats(){
        ecouteSoldats = new EcouteSoldats(terrain);
    }


    private void initializeEcouteTours(){ ecouteTours = new EcouteTours(terrain);}



    private void initializeEnvironnement() {
        terrain = new Environnement(joueur);
        //remplissage();
    }

    @FXML
    private void lancerTours() {
        gameLoop.lancerTimeline();
    }


    private void initializeVueBasePrincipale(){
        vueBasePrincipale = new VueBasePrincipale(centerPane);
    }

    private void initializeVueTours() {
        vueTours = new VueTours(terrain, centerPane);
        initializeEcouteTours();
    }

    private void initializeVueSoldats() {
        vueSoldats = new VueSoldats(centerPane);
        initializeEcouteSoldats();
    }
    private void initializeVueProjectile(){
        vueProjectile = new VueProjectile(centerPane);
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
    @FXML
    public void testPv(ActionEvent event) {
        System.out.println("TEST");
        Random rand = new Random();
        for (Soldat s : this.terrain.getSoldats()) {
            // Generate a random number between 0 and 3 (inclusive)
            int chance = rand.nextInt(4);
            if (chance == 0) {
                s.setPointsDeVieValue(0);
                System.out.println("MORT");
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
                return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/ElementsCarte/chemin.png");
            default:
                return loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/ElementsCarte/herbeVierge.png");
        }
    }

    public GameLoop getGameLoop() {
        return gameLoop;
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
