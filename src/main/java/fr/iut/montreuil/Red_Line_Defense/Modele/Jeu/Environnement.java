package fr.iut.montreuil.Red_Line_Defense.Modele.Jeu;

import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.BasePrincipale;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Projectiles.Projectile;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Soldats.Soldat;
import fr.iut.montreuil.Red_Line_Defense.Modele.ActeursJeu.Tours.Tour;
import fr.iut.montreuil.Red_Line_Defense.Modele.Joueur;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.ListProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Point2D;

import java.util.*;

public class Environnement {

    private int[][] quadrillage;

    private IntegerProperty numeroVague;
    private IntegerProperty ennemisTues;
    private int ennemisTuesCetteVague;
    private ListProperty<Projectile> listeProjectiles;
    private ListProperty<Tour> listeTours;
    private ListProperty<Soldat> listeSoldats;
    private int nbrTours = 0;
    private Joueur joueur;
    private int[][] distances;
    private BasePrincipale basePrincipale;
    private BFS bfs;
    private Terrain terrain;

    private GestionnaireVague gestionnaireVague;


    public Environnement(Joueur joueur) {
        this.joueur = joueur;

        this.numeroVague = new SimpleIntegerProperty(1);
        this.ennemisTues = new SimpleIntegerProperty(0);
        this.bfs = new BFS(this);

        this.ennemisTuesCetteVague = 0;
        this.terrain = new Terrain();
        this.quadrillage = terrain.initQuadrillage();

        ObservableList<Tour> observableListTour = FXCollections.observableArrayList();
        listeTours = new SimpleListProperty<>(observableListTour);

        ObservableList<Soldat> observableListSoldat = FXCollections.observableArrayList();
        listeSoldats = new SimpleListProperty<>(observableListSoldat);

        ObservableList<Projectile> projectileObservableList = FXCollections.observableArrayList();
        listeProjectiles = new SimpleListProperty<>(projectileObservableList);

        this.gestionnaireVague = new GestionnaireVague(this);


        this.distances = new int[getYmax()][getXmax()];  // Initialisation du tableau de distances
        bfs.calculerChemin(89, 47);
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- TOUR DE JEU ---------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public void unTour(){
        gestionnaireVague.unTour();
        verificationMorts();
        suppressionTour();
        checkNouvelleVagues();
        verificationDefaite();

        // Enlève les PV aux soldats
        basePrincipale.actionBasePrincipale();

        // Faire déplacer tout les soldats
        for (Soldat soldat : listeSoldats) {
            soldat.deplacementSoldat();
        }

        // Actionner les tours
        for (Tour tour : listeTours) {
            tour.actionTours(this.nbrTours);
        }

        nbrTours++;
    }

    public void checkNouvelleVagues() {
        if (ennemisTuesCetteVague == gestionnaireVague.getVagueActuelle().getTotalSoldats()) {
            numeroVague.setValue(numeroVague.getValue() + 1);
            // Reset
            ennemisTuesCetteVague = 0;
        }
    }

    public void actionBasePrincipale(){
        for (Soldat s: listeSoldats.getValue()) {
            Point2D positionSoldat = new Point2D(s.getX0Value()/8, s.getY0Value()/8);
            if (basePrincipale.getZone().contains(positionSoldat)) {
                    basePrincipale.infligerDegats(300);
                    s.setPointsDeVieValue(-1);
            }
        }
    }

    public void verificationDefaite(){
        if (basePrincipale.getPointsDeVieValue() < 1){
            this.numeroVague.setValue(-1);
        }
    }

    public void suppressionTour() {
        if (!listeTours.isEmpty()) {
            listeTours.removeIf(tour -> tour.getPointsDeVieValue() <= 0);
        }
    }

    public void verificationMorts() {
        Iterator<Soldat> iterator = listeSoldats.iterator();
        while (iterator.hasNext()) {
            Soldat soldat = iterator.next();
            if (soldat.getPointsDeVieValue() <= 0) {
                iterator.remove(); // Supprimer l'élément de la liste en utilisant l'itérateur
                joueur.crediterSolde(soldat.getValeurGagnee());
                ennemisTues.setValue(ennemisTues.getValue() + 1);
                ennemisTuesCetteVague++;
            }
        }
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- GETTER -----------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public void setNumeroVague(int i){ this.numeroVague.set(i);}
    public ListProperty<Soldat> getListSoldats() {
        return this.listeSoldats;
    }

    public int[][] getDistances() {
        return this.distances;
    }

    public ListProperty<Tour> getListeTours() {
        return this.listeTours;
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- INTERFACE --------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public IntegerProperty getVagueProperty() { return this.numeroVague; }

    public int getVagueValue() { return this.numeroVague.getValue(); }

    public void setEnnemisTues(int ennemisTues) {
        this.ennemisTues.set(ennemisTues);
    }

    public IntegerProperty getEnnemisTuesProperty() {
        return this.ennemisTues;
    }

    public int getEnnemisTuesValue() {
        return this.ennemisTues.getValue();
    }

    public int getNbrTours() {
        return this.nbrTours;
    }


    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- DEPLACEMENTS ET BFS ----------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------


    public boolean isValidMove(int x, int y) {
        return x >= 0 && x < distances[0].length && y >= 0 && y < distances.length && valeurDeLaCase(y, x) == 1;
    }


    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- LISTE PROJECTILES ------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public void ajouterProjectile(Projectile projectile) {
        this.listeProjectiles.add(projectile);
    }


    public void supprimerProjectile(Projectile projectile) {
        this.listeProjectiles.remove(projectile);
    }


    public ListProperty<Projectile> getProjectilesProperty() {
        return this.listeProjectiles;
    }


    public ObservableList<Projectile> getProjectiles() {
        return this.listeProjectiles.get();
    }


    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- MAP DE JEU -------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public int getYmax() {
        return this.quadrillage.length;
    }

    public int getXmax() {
        return this.quadrillage[0].length;
    }

    public int valeurDeLaCase(int i, int j) {
        return this.quadrillage[i][j];
    }


    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- LISTE TOURS ------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------


    public void ajouterTour(Tour tour) {
        this.listeTours.add(tour);
    }                    // Ajouter une tour

    public void supprimerTour(Tour tour) {
        this.listeTours.remove(tour);
    }               // Supprimer une tour

    public ListProperty<Tour> getToursProperty() {
        return this.listeTours;
    }             // Retourne la liste observable

    public ObservableList<Tour> getTours() {
        return this.listeTours.get();
    }             // Retourne la property qui contient la liste observable


    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- LISTE SOLDATS ----------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public void ajouterSoldat(Soldat soldat) {
        this.listeSoldats.add(soldat);
    }          // Ajouter un Soldat

    public void supprimerSoldat(Soldat soldat) {
        this.listeSoldats.remove(soldat);
    }     // Supprimer un Soldat

    public ListProperty<Soldat> getSoldatsProperty() {
        return this.listeSoldats;
    }       // Retourne la liste observable

    public ObservableList<Soldat> getSoldats() {
        return this.listeSoldats.get();
    }       // Retourne la property qui contient la liste observable


    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- JOUEUR --------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------


    public Joueur getJoueur() {
        return this.joueur;
    }

    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- BASE PRINCIPALE --------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------

    public void setBasePrincipale(BasePrincipale basePrincipale) {
        this.basePrincipale = basePrincipale;
    }

    public BasePrincipale getBasePrincipale() {
        return this.basePrincipale;
    }
    public Vagues getVagues(){
        return this.gestionnaireVague.getVagueActuelle();
    }


    public IntegerProperty getNumeroVague(){return this.numeroVague;}
    //--------------------------------------------------------------------------------------------------------------------------------
    //------------------------------------------------------- FIN --------------------------------------------------------------------
    //--------------------------------------------------------------------------------------------------------------------------------
}
