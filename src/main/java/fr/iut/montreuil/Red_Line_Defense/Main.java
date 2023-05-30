package fr.iut.montreuil.Red_Line_Defense;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {


    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueMenuPrincipal.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Tower Defense");
        primaryStage.setScene(new Scene(root, 600, 400));
        primaryStage.show();

        ControleurMP controleur = loader.getController();
        controleur.initialize(null, null); // Appeler la méthode initialize du contrôleur après l'affichage de la scène

    }


    public static void main(String[] args) {
        launch(args);
    }
}
