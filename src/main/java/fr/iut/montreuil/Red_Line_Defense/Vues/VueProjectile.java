package fr.iut.montreuil.Red_Line_Defense.Vues;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Boulet;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import javafx.animation.AnimationTimer;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class VueProjectile {

    @FXML
    private Pane centerPane;

    public final static String BOULE_DE_FEU_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/Projectiles/bouleDeFeu.png";
    public final static String BOMBE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/Projectiles/bombe.png";
    public final static String BLAST_PATH = "/fr/iut/montreuil/Red_Line_Defense/Images/Projectiles/blast.png";


    public VueProjectile(Pane centerPane){
        this.centerPane=centerPane;
    }
    public void CreationSprite(Projectile p){
        /*Circle circle = new Circle(7);
        circle.setFill(Color.BLACK);
        circle.centerXProperty().bind(p.xProperty());
        circle.centerYProperty().bind(p.yProperty());
        */
        if(p instanceof Boulet) {
            ImageView bouleDeFeu = new ImageView(loadImage(BOULE_DE_FEU_PATH));
            bouleDeFeu.xProperty().bind(p.xProperty());
            bouleDeFeu.yProperty().bind(p.yProperty());
            bouleDeFeu.setId(p.getId());
            centerPane.getChildren().addAll(bouleDeFeu);
        }
        else {
        ImageView bombe = new ImageView(loadImage(BOMBE_PATH));
        bombe.xProperty().bind(p.xProperty());
        bombe.yProperty().bind(p.yProperty());
        bombe.setId(p.getId());
        centerPane.getChildren().addAll(bombe);
        }
        /*ImageView blast = new ImageView(loadImage(BLAST_PATH));
        blast.xProperty().bind(p.xProperty());
        blast.yProperty().bind(p.yProperty());*/

        System.out.println("ajout sprite projectile");// apres t'aura juste a mettre une virgule et les autres images si tu veux tout faire ici et ducoup tu dois faire verifier l'id de la tour pour savoir quel projectile utiliser sinon tu fais plusieurs fonctions
        AnimationTimer timer = new AnimationTimer() {

            private long lastUpdate = 0;

            @Override
            public void handle(long now) {
                if (lastUpdate > 0) {


                    double elapsedTime = (now - lastUpdate) / 1000000000.0;


                    p.deplacement(elapsedTime);
                    Soldat s=p.ennemiÀPorter();
                    if(s!=null){
                        System.out.println("Touche ! suppression confirmée");
                        p.getTerrain().supprimerProjectile(p);
                        s.setPointsDeVieValue(s.getPointsDeVieValue()-p.getDegats());
                        stop();

                    }
                    System.out.println("x"+p.getX());
                    System.out.println("y"+p.getY());

                    System.out.println(p.getId());
                    if(p.getX()>840 || (p.getX()<=0 ||(p.getY()>480||p.getY()<=0))){
                        System.out.println("suppression confirmée");
                        p.getTerrain().supprimerProjectile(p);
                        stop();
                    }


                }

                lastUpdate = now;
            }
        };

        timer.start();
        System.out.println("animation projectile");
    }

    public Pane getCenterPane() {
        return centerPane;
    }

    private Image loadImage(String path) {
        return new Image(getClass().getResourceAsStream(path));
    }
}
