package fr.iut.montreuil.Red_Line_Defense.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.Controleurs.Listeners.*;
import fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils.Audio;
import fr.iut.montreuil.Red_Line_Defense.Main;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.Environnement;
import fr.iut.montreuil.Red_Line_Defense.Modele.Jeu.GameLoop;
import fr.iut.montreuil.Red_Line_Defense.Controleurs.Outils.Inputs;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import fr.iut.montreuil.Red_Line_Defense.Vues.*;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.media.MediaPlayer;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class Controleur implements Initializable {
    private static final int TAILLE_IMAGE = 8;
    public static final String OST_JEU_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/ostJeu.mp3";
    public static final String DEFAITE = "/fr/iut/montreuil/Red_Line_Defense/Sons/gameOver.mp3";

    @FXML
    private Pane centerPane;

    @FXML
    private Label ennemisTues, pointVieBase;

    @FXML
    Label solde;

    @FXML
    ImageView wpp, berry, berryBot200b, berryBot400b, berryBot600b, berryBot800b;

    @FXML
    StackPane stackpane;

    @FXML
    HBox hboxMoneyCount, prix200b, prix800b, prix600b, prix400b;
    @FXML
    VBox vboxRight;

    @FXML
    private Button lancerButton, test;

    private Joueur joueur;
    private VueInterface vueInterface;

    private EcouteSoldats ecouteSoldats;
    private EcouteTours ecouteTours;

    private EcouteBasePrincipale ecouteBasePrincipale;

    private EcouteInterface ecouteInterface;

    private Inputs inputs;

    private EcouteProjectiles ecouteProjectiles;

    private Environnement terrain;
    private GameLoop gameLoop;
    private VueTours vueTours;
    private VueSoldats vueSoldats;

    private VueProjectile vueProjectile;

    private BasePrincipale basePrincipale;

    private EcouteVictoireEtDefaite ecouteVictoireEtDefaite;


    private VueBasePrincipale vueBasePrincipale;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        centerPane.getChildren().add(new ImageView(loadImage("/fr/iut/montreuil/Red_Line_Defense/Images/ElementsCarte/map.png")));
        initializeBasePrincipale();
        initializeJoueur();
        initializeEnvironnement();
        initializeVueTours();
        initializeVueSoldats();
        initializeGameLoop();
        initializeVueInterface();
        initializeVueBasePrincipale();
        initializeVueProjectile();
        initializeEcouteVictoireEtDefaite();

        initializeSons();



        terrain.setBasePrincipale(basePrincipale);

        //initializeInputs();
    }

    public Stage getStage() {
        Stage stage = (Stage) solde.getScene().getWindow();
        return stage;
    }

    private void initializeEcouteVictoireEtDefaite() {
        ecouteVictoireEtDefaite = new EcouteVictoireEtDefaite(terrain, vueInterface, this);
    }

    public void ajouterDefaite(){
        URL url = Main.class.getResource("Vues/VueDefaite.fxml");
        FXMLLoader loader = new FXMLLoader(url);
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Stage stage;
        ControleurDefaite controleur = loader.getController(); // Retrieve the controller instance
        stage = (Stage) ((javafx.scene.Node) centerPane).getScene().getWindow();
        Scene scene = new Scene(root, 940, 560);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);
        stage.show();
    }

    /*public void ajouterVictoire (){
        FXMLLoader loader = new FXMLLoader();

        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Controleur controleur = loader.getController(); // Retrieve the controller instance
        stage = (Stage) ((javafx.scene.Node) centerPane).getScene().getWindow();
        Scene scene = new Scene(root, 940, 560);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);
        stage.show();
    }*/

    public void ajouterEcouteurVagues(Environnement terrain) {
        terrain.getBasePrincipale().getPointsDeVieProperty().addListener(new ChangeListener<Number>() {
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                if(terrain.getBasePrincipale().getPointsDeVieValue()<=0){
                    ajouterDefaite();
                }
                else if (terrain.getVagueValue()==0){
                    //ajouterVictoire();
                }

    }});}

    private void initializeJoueur(){
        this.joueur = new Joueur("Ayoub");
    }
    private void initializeSons(){
        Media mediaJeu = new Media(getClass().getResource(OST_JEU_PATH).toString());
        Audio.chargerMedia(mediaJeu);
    }

    public void initializeInputs(){
        inputs = new Inputs(gameLoop, centerPane.getScene());
    }

    private void initializeVueInterface(){
        vueInterface = new VueInterface(terrain, lancerButton, test, solde, berry, ennemisTues, prix200b, prix800b, prix600b, prix400b,
                berryBot200b, berryBot400b, berryBot600b, berryBot800b, vboxRight, wpp, stackpane);
        initializeEcouteInterface();
    }

    private void initializeEcouteInterface(){
        ecouteInterface = new EcouteInterface(terrain, vueInterface);
    }

    private void initializeEcouteSoldats(){
        ecouteSoldats = new EcouteSoldats(terrain, vueSoldats);
    }


    private void initializeEcouteTours(){ ecouteTours = new EcouteTours(terrain,centerPane);}

    public void AfficherDefaite() {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueDefaite.fxml"));
                Parent root = fxmlLoader.load();
                Stage stage = new Stage();
                stage.setScene(new Scene(root));
                stage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }

    }



    private void initializeEnvironnement() {
        terrain = new Environnement(joueur);
    }

    @FXML
    private void lancerTours() {
        gameLoop.lancerTimeline();
    }

    private void initializeBasePrincipale() {
        basePrincipale = new BasePrincipale(700, 335);
    }
    private void initializeVueBasePrincipale(){
        vueBasePrincipale = new VueBasePrincipale(centerPane, basePrincipale);
        initializeEcouteBasePrincipale();
    }

    private void initializeEcouteBasePrincipale(){ ecouteBasePrincipale = new EcouteBasePrincipale(vueBasePrincipale, gameLoop);}

    private void initializeVueTours() {
        vueTours = new VueTours(terrain, centerPane);
        initializeEcouteTours();
    }

    private void initializeVueSoldats() {
        vueSoldats = new VueSoldats(centerPane);
        initializeEcouteSoldats();
    }
    private void initializeVueProjectile(){
        initializeEcouteProjectiles();
    }

    private void initializeEcouteProjectiles(){
        ecouteProjectiles =new EcouteProjectiles(terrain,centerPane);
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
        ajouterDefaite();
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
