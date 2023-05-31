package fr.iut.montreuil.Red_Line_Defense;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Rookie;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Shichibukais;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Soldat;
import fr.iut.montreuil.Red_Line_Defense.modele.Animation;
import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import fr.iut.montreuil.Red_Line_Defense.modele.GestionnaireDeDeplacement;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Point2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.layout.BorderPane;
import javafx.util.Duration;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;





import java.net.URL;
import java.util.List;
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
                /* URL herbeLimiteHaut = getClass().getResource("herbeLimiteHaut.png");
                URL herbeLimiteDroite = getClass().getResource("herbeLimiteDroite.png");
                URL herbeLimiteBas = getClass().getResource("herbeLimiteBas.png");
                URL herbeLimiteGauche = getClass().getResource("herbeLimiteGauche.png");
                URL herbeCoinHautDroite = getClass().getResource("herbeCoinHautDroite.png");
                URL herbeCoinHautGauche = getClass().getResource("herbeCoinHautGauche.png");
                URL herbeCoinBasDroite = getClass().getResource("herbeCoinBasDroite.png");
                URL herbeCoinBasGauche = getClass().getResource("herbeCoinBasGauche.png");
                URL herbeAngleHautDroite = getClass().getResource("herbeAngleHautDroite.png");
                URL herbeAngleHautGauche = getClass().getResource("herbeAngleHautGauche.png");
                URL herbeAngleBasDroite = getClass().getResource("herbeAngleBasDroite.png");
                URL herbeAngleBasGauche = getClass().getResource("herbeAngleBasGauche.png"); */
                URL chemin = getClass().getResource("Images/chemin.png");
                Image imgHerbeVierge = new Image(String.valueOf(herbeVierge));
                Image imgChemin = new Image(String.valueOf(chemin));
                /* Image imgHerbeLimiteHaut = new Image(String.valueOf(herbeLimiteHaut));
                Image imgHerbeLimiteDroite = new Image(String.valueOf(herbeLimiteDroite));
                Image imgHerbeLimiteBas = new Image(String.valueOf(herbeLimiteBas));
                Image imgHerbeLimiteGauche = new Image(String.valueOf(herbeLimiteGauche));
                Image imgHerbeCoinHautDroite = new Image(String.valueOf(herbeCoinHautDroite));
                Image imgHerbeCoinHautGauche = new Image(String.valueOf(herbeCoinHautGauche));
                Image imgHerbeCoinBasDroite = new Image(String.valueOf(herbeCoinBasDroite));
                Image imgHerbeCoinBasGauche = new Image(String.valueOf(herbeCoinBasGauche));
                Image imgHerbeAngleBasGauche = new Image(String.valueOf(herbeAngleBasGauche));
                Image imgHerbeAngleHautDroite = new Image(String.valueOf(herbeAngleHautDroite));
                Image imgHerbeAngleHautGauche = new Image(String.valueOf(herbeAngleHautGauche));
                Image imgHerbeAngleBasDroite = new Image(String.valueOf(herbeAngleBasDroite));*/

                myImageView.setTranslateX(j * tailleImage);
                myImageView.setTranslateY(i * tailleImage);



                if (n == 0) {
                    myImageView.setImage(imgHerbeVierge);
                }
                else if (n == 1) {
                    myImageView.setImage(imgChemin);
                }
                /* else if (n == 2) {
                    myImageView.setImage(imgHerbeLimiteHaut);
                }
                else if (n == 3) {
                    myImageView.setImage(imgHerbeLimiteDroite);
                }
                else if (n == 4) {
                    myImageView.setImage(imgHerbeLimiteBas);
                }
                else if (n == 5) {
                    myImageView.setImage(imgHerbeLimiteGauche);
                }
                else if (n == 6) {
                    myImageView.setImage(imgHerbeCoinHautDroite);
                }
                else if (n == 7) {
                    myImageView.setImage(imgHerbeCoinHautGauche);
                }
                else if (n == 8) {
                    myImageView.setImage(imgHerbeCoinBasDroite);
                }
                else if (n == 9) {
                    myImageView.setImage(imgHerbeCoinBasGauche);
                }
                else if (n == 10) {
                    myImageView.setImage(imgHerbeAngleBasGauche);
                }
                else if (n == 11) {
                    myImageView.setImage(imgHerbeAngleHautDroite);
                }
                else if (n == 12) {
                    myImageView.setImage(imgHerbeAngleHautGauche);
                }
                else if (n == 13) {
                    myImageView.setImage(imgHerbeAngleBasDroite);
                } */

                centerPane.getChildren().add(myImageView);
            }
        }

        terrain.afficherSoldat(centerPane);


    }




    @FXML
    public void handleMouseClick(MouseEvent event) {
        double clickX = event.getX();
        double clickY = event.getY();
        System.out.println("Coordonnées du clic : X = " + event.getX() + ", Y = " + event.getY());

        int startX = (int) (clickX / tailleImage);
        int startY = (int) (clickY / tailleImage);

        System.out.println("Tuile de départ : X = " + startX + ", Y = " + startY);

        Rookie rookie = new Rookie(15 * tailleImage, 59 * tailleImage, 89 * tailleImage, 47 * tailleImage);
        List<Point2D> chemin = gestionnaireDeDeplacement.deplacerRookie();

        animation.creerAnimation(chemin);
    }


















}
