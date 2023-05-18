package com.example.tower_defense.modele;

import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Carte {

    private int[][] quadrillage;
    private ListProperty<Tour> tours;
    private ListProperty<Soldat> soldats;



    public Carte() {
        quadrillage = new int[][]{
                {0, 3, 1, 5, 8, 4, 4, 4, 4, 4, 9},
                {0, 3, 1, 5, 3, 1, 1, 1, 1, 1, 5},
                {0, 3, 1, 10, 13, 1, 12, 2, 11, 1, 5},
                {0, 3, 1, 1, 1, 1, 5, 0, 3, 1, 5},
                {0, 6, 2, 2, 2, 2, 7, 0, 3, 1, 5},
                {0, 0, 0, 0, 0, 0, 8, 4, 13, 1, 5},
                {8, 4, 4, 4, 4, 9, 3, 1, 1, 1, 5},
                {3, 1, 1, 1, 1, 10, 13, 1, 12, 2, 7},
                {3, 1, 12, 11, 1, 1, 1, 1, 5, 0, 0},
                {3, 1, 5, 6, 2, 2, 2, 2, 7, 0, 0},
                {3, 1, 10, 4, 4, 9, 0, 0, 0, 0, 0},
                {3, 1, 1, 1, 1, 10, 4, 4, 4, 4, 9},
                {6, 2, 2, 11, 1, 1, 1, 1, 1, 1, 5}
            };

        ObservableList<Tour> observableListTour = FXCollections.observableArrayList();
        tours = new SimpleListProperty<>(observableListTour);

        ObservableList<Soldat> observableListSoldat = FXCollections.observableArrayList();
        soldats = new SimpleListProperty<>(observableListSoldat);
    }


    // ----------------------------------------------------------------

    // Getters Map
    public int getYmax(){ return this.quadrillage.length; }
    public int getXmax(){ return this.quadrillage[0].length; }
    public int valeurDeLaCase(int i, int j){ return this.quadrillage[i][j]; }


    // Methodes Tours
    public void ajouterTour(Tour tour) { this.tours.add(tour); }                    // Ajouter une tour
    public void supprimerTour(Tour tour) { this.tours.remove(tour); }               // Supprimer une tour
    public ListProperty<Tour> getToursProperty() { return this.tours; }             // Retourne la liste observable
    public ObservableList<Tour> getTours() { return this.tours.get(); }             // Retourne la property qui contient la liste observable

    // Methodes Soldats
    public void ajouterSoldat(Soldat soldat) { this.soldats.add(soldat); }          // Ajouter un Soldat
    public void supprimerSoldat(Soldat soldat) { this.soldats.remove(soldat); }     // Supprimer un Soldat
    public ListProperty<Soldat> getSoldatsProperty() { return this.soldats; }       // Retourne la liste observable
    public ObservableList<Soldat> getSoldats() { return this.soldats.get(); }       // Retourne la property qui contient la liste observable







}
