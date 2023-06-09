package fr.iut.montreuil.Red_Line_Defense.modele.ActeursJeu;

import fr.iut.montreuil.Red_Line_Defense.modele.Carte;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;

public abstract class ToursOffensives extends Tour {

    private IntegerProperty cadence; // La cadence est la capacité de Tirs par minute
    private ObservableList<Projectile> projectiles; // Liste de tous les projectiles actuellement tirés par la tour


    public ToursOffensives(int x0, int y0, int pointsDeVie, int degats, int defense, int prix,Carte terrain,int cadence) {
        super(x0, y0, pointsDeVie, degats, defense,prix, terrain);

        this.cadence = new SimpleIntegerProperty(cadence);
        this.projectiles = FXCollections.observableArrayList();

        // Ajout des Listeners pour mettre à jour la direction si la position change


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
    public abstract void tirer();

    // Méthode pour mettre à jour la direction

    // Accesseur pour les projectiles
    public ObservableList<Projectile> getProjectiles() {
        return this.projectiles;
    }




    public int getCadence() {
        return cadence.getValue();
    }

    public IntegerProperty cadenceProperty() {
        return cadence;
    }
}
