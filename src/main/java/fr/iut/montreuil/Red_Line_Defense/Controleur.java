package fr.iut.montreuil.Red_Line_Defense;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Rookie;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.TourSniper;
import fr.iut.montreuil.Red_Line_Defense.modele.Animation;
import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;


import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.ResourceBundle;

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

    private String idTourClicked=null;


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
        if (this.idTourClicked.equals("tour600b")){
            ImageView maTour = new ImageView();
            URL tour = getClass().getResource("Images/tour.png");
            Image imgTour = new Image(String.valueOf(tour));
            maTour.setImage(imgTour);
            maTour.setX(x);
            maTour.setY(y);
            centerPane.getChildren().add(maTour);
        }
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
    }


















}
