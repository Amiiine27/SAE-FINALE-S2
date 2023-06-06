package fr.iut.montreuil.Red_Line_Defense;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour.Tour;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour.TourOffensif;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.ennemi.Rookie;
import fr.iut.montreuil.Red_Line_Defense.modele.Animation;
import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import javafx.animation.AnimationTimer;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;


import java.net.URL;
import java.util.*;

public class Controleur implements Initializable {
    private Carte terrain;
    private final int tailleImage = 8; // Remplacez cette valeur par la taille réelle de vos images

    private GestionnaireDeDeplacement gestionnaireDeDeplacement;

    private Animation animation;
    @FXML
    private Pane centerPane;

    @FXML
    private TilePane tilepane;
    @FXML
    private VBox vboxKillCount, vboxMoneyCount, vboxVague;

    @FXML
    private ImageView tour200b, tour400b, tour600b, tour800b;

    private String idTourClicked="0";


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        terrain = new Carte();
        remplissage();
        gestionnaireDeDeplacement = new GestionnaireDeDeplacement(terrain, tailleImage, centerPane);
        animation = new Animation(centerPane);
    }


    public void remplissage(){
        for (int i=0; i<terrain.getYmax(); i++){
            for (int j=0; j<terrain.getXmax();j++) {
                int n = terrain.valeurDeLaCase(i, j);
                ImageView myImageView = new ImageView();
                URL herbeVierge = getClass().getResource("Images/herbeVierge.png");
                URL chemin = getClass().getResource("Images/chemin.png");
                Image imgHerbeVierge = new Image(String.valueOf(herbeVierge));
                Image imgChemin = new Image(String.valueOf(chemin));


                myImageView.setTranslateX(j * tailleImage);
                myImageView.setTranslateY(i * tailleImage);



                if (n == 0) {
                    myImageView.setImage(imgHerbeVierge);
                }
                else if (n == 1) {
                    myImageView.setImage(imgChemin);
                }


                centerPane.getChildren().add(myImageView);
            }
        }

        terrain.afficherSoldat(centerPane);


    }




    @FXML
    public void positionTour(MouseEvent event) {
        Random rand = new Random();
        double x=event.getX(), y=event.getY();
        URL t = getClass().getResource("Images/tour.png");
        Image simple = new Image(String.valueOf(t));
         if (this.idTourClicked.equals("tour200b")){
            ImageView maTour = new ImageView();
            URL tour = getClass().getResource("Images/tourMap.png");
            Image imgTour = new Image(String.valueOf(tour));
            maTour.setImage(imgTour);
            maTour.setX(x);
            maTour.setY(y);
            Tour tourM = new TourOffensif(x,y,200,25,100);
            terrain.ajouterTour(tourM);
            centerPane.getChildren().add(maTour);
            tour200b.setImage(simple);
        }
        else if (this.idTourClicked.equals("tour400b")){
            ImageView maTour = new ImageView();
            URL tour = getClass().getResource("Images/tourMap.png");
            Image imgTour = new Image(String.valueOf(tour));
            maTour.setImage(imgTour);
            maTour.setX(x);
            maTour.setY(y);
            centerPane.getChildren().add(maTour);
            tour400b.setImage(simple);
        }
        else if (this.idTourClicked.equals("tour600b")){
            ImageView maTour = new ImageView();
            URL tour = getClass().getResource("Images/tourMap.png");
            Image imgTour = new Image(String.valueOf(tour));
            maTour.setImage(imgTour);
            maTour.setX(x);
            maTour.setY(y);
            centerPane.getChildren().add(maTour);
            tour600b.setImage(simple);
        }
        else if (this.idTourClicked.equals("tour800b")){
            ImageView maTour = new ImageView();
            URL tour = getClass().getResource("Images/tourMap.png");
            Image imgTour = new Image(String.valueOf(tour));
            maTour.setImage(imgTour);
            maTour.setX(x);
            maTour.setY(y);
            centerPane.getChildren().add(maTour);
            tour800b.setImage(simple);
        }
        else {
             ImageView err = new ImageView();
             URL s = getClass().getResource("Images/badClic.png");
             Image bs = new Image(String.valueOf(s));
             err.setImage(bs);
             err.setX(x);
             err.setY(y);
             centerPane.getChildren().add(err);
             Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(3), e -> {
                 // Fonction à exécuter après 5 secondes
                 centerPane.getChildren().remove(err);
             }));
             timeline.play();
         }


             /*
             ScheduledExecutorService scheduler = Executors.newSingleThreadScheduledExecutor();
             scheduler.schedule(() -> {
                 // La fonction à exécuter après le délai spécifié
                 System.out.println("yo");
                 centerPane.getChildren().remove(err);
                 System.out.println("fini");
             }, 3, TimeUnit.SECONDS);

             // Arrêt du scheduler après l'exécution de la fonction
             scheduler.shutdown();
         }

              */
             /*Timer timer = new Timer();
             TimerTask task = new TimerTask() {
                 @Override
                 public void run() {
                     // La fonction à exécuter après le délai spécifié
                     centerPane.getChildren().remove(err);
                 }
             };

             timer.schedule(task, 3000);

              */


        this.idTourClicked="0";
        /* System.out.println(x);
        System.out.println(y);
        ArrayList<Double> coordonnees = new ArrayList<Double>();
        coordonnees.add(x);
        coordonnees.add(y);
        return coordonnees; */
        /* double[] coordinates = new double[] {x, y};



        int[] possibleStartX = {14, 15, 16};
        int[] possibleDestX = {88, 89, 90};

        int startX = possibleStartX[rand.nextInt(possibleStartX.length)];
        int startY = 59;  // cette valeur est constante.

        int destX = possibleDestX[rand.nextInt(possibleDestX.length)];
        int destY = 47;  // cette valeur est constante.

        Rookie rookie = new Rookie(startX * tailleImage, startY * tailleImage, destX * tailleImage, destY * tailleImage);
        List<Point2D> chemin = gestionnaireDeDeplacement.deplacerRookie(startX, startY, destX, destY);

        animation.creerAnimation(chemin); */


    }


    public void selectionTour(MouseEvent event) {
        /* tour200b.setOnMouseClicked(e -> System.out.println("tour défensive cliquée"));
        tour400b.setOnMouseClicked(e -> System.out.println("tour mitrailleuse cliquée"));
        tour600b.setOnMouseClicked(e -> System.out.println("tour sniper cliquée"));
        tour800b.setOnMouseClicked(e -> System.out.println("tour tête chercheuse cliquée")); *


        System.out.println(event.getSource());
        ImageView imageClique = (ImageView) event.getSource();
        System.out.println("clic");
        if (imageClique.getId().equals("tour600b")){
           terrain.ajouterTour(new TourSniper(positionTour().get(0)));
        }*/

        ImageView image = (ImageView) event.getSource();
        String id = image.getId();
        System.out.println(id);
        this.idTourClicked=id;
        URL ts = getClass().getResource("Images/tour-Surbrillance.png");
        Image surb = new Image(String.valueOf(ts));
        URL t = getClass().getResource("Images/tour.png");
        Image simple = new Image(String.valueOf(t));
        if (id.equals("tour200b")){
            tour200b.setImage(surb);
            tour400b.setImage(simple);
            tour600b.setImage(simple);
            tour800b.setImage(simple);
        }
        else if (id.equals("tour400b")){
            tour200b.setImage(simple);
            tour400b.setImage(surb);
            tour600b.setImage(simple);
            tour800b.setImage(simple);
        }
        else if (id.equals("tour600b")){
            tour200b.setImage(simple);
            tour400b.setImage(simple);
            tour600b.setImage(surb);
            tour800b.setImage(simple);
        }
        else if (id.equals("tour800b")){
            tour200b.setImage(simple);
            tour400b.setImage(simple);
            tour600b.setImage(simple);
            tour800b.setImage(surb);
        }
    }


    public void animationTest(){

        Circle cercle = new Circle(10);
        Soldat ennemiTest = new Rookie(200,200,800,0);
        cercle.centerXProperty().bind(ennemiTest.getX0Property());
        cercle.centerYProperty().bind(ennemiTest.getY0Property());
        centerPane.getChildren().add(cercle);
        terrain.ajouterSoldat(ennemiTest);
        AnimationTimer timer = new AnimationTimer() {
            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                ennemiTest.deplacer(800,0);
            }
        };
        timer.start();
    }

    }
