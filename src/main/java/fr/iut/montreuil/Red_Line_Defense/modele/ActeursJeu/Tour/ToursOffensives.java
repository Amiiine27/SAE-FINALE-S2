package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour;

import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.Tour.Tour;
import fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu.projectile.Projectile;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public abstract class ToursOffensives extends Tour {

    private IntegerProperty cadence; // La cadence est la capacité de Tirs par minute
    private ObservableList<Projectile> projectiles; // Liste de tous les projectiles actuellement tirés par la tour

    public ToursOffensives(int x0, int y0, int pointsDeVie, int degats, int defense,int prix/*, int x1, int y1,*/, int cadence) {
        super(x0, y0, pointsDeVie, degats, defense, prix);

        this.cadence = new SimpleIntegerProperty(cadence);
        this.projectiles = FXCollections.observableArrayList();

        // Ajout des Listeners pour mettre à jour la direction si la position change
       // this.getX0Property().addListener((obs, oldVal, newVal) -> updateDirection());
        //this.getY0Property().addListener((obs, oldVal, newVal) -> updateDirection());
        //this.getX1Property().addListener((obs, oldVal, newVal) -> updateDirection());
        //this.getY1Property().addListener((obs, oldVal, newVal) -> updateDirection());

        // Listener pour la liste de projectiles
        this.projectiles.addListener((ListChangeListener.Change<? extends Projectile> c) -> {
            while (c.next()) {
                if (c.wasAdded()) {
                    for (Projectile p : c.getAddedSubList()) {
                        System.out.println("Projectile ajouté : " + p);
                        // Ici, vous pouvez ajouter le code pour ajouter le projectile à la vue
                    }
                } else if (c.wasRemoved()) {
                    for (Projectile p : c.getRemoved()) {
                        System.out.println("Projectile supprimé : " + p);
                        // Ici, vous pouvez ajouter le code pour supprimer le projectile de la vue
                    }
                }
            }
        });
    }


    // Tire un projectile et l'ajoute à la liste
  /*  public void tirer() {

        // Calculer la différence en x et y
       double dx = this.getX1Value() - this.getX0Value();
        double dy = this.getY1Value() - this.getY0Value();

        // Calculer la distance entre les deux points
        double distance = Math.sqrt(dx*dx + dy*dy);

        // Calcul du vecteur unitaire
        double directionX = dx / distance;
        double directionY = dy / distance;


        // Crée un nouveau projectile à la position de la tour
        Projectile nouveauProjectile = new Projectile(this.getX0Value(), this.getY0Value(), dx, dy);

        // Ajoute le nouveau projectile à la liste
        this.projectiles.add(nouveauProjectile);
    }

    // Méthode pour mettre à jour la direction
    private void updateDirection() {
        // Calculer la différence en x et y
        double dx = this.getX1Value() - this.getX0Value();
        double dy = this.getY1Value() - this.getY0Value();

        // Calculer la distance entre les deux points
        double distance = Math.sqrt(dx*dx + dy*dy);

        // Normaliser la différence pour obtenir un vecteur unitaire
        double directionX = dx / distance;
        double directionY = dy / distance;

        // Mettre à jour la direction dans tous les projectiles
        for (Projectile projectile : this.projectiles) {
            projectile.setDirectionX(directionX);
            projectile.setDirectionY(directionY);
        }
    }*/

    // Accesseur pour les projectiles
    public ObservableList<Projectile> getProjectiles() {
        return this.projectiles;
    }

}
