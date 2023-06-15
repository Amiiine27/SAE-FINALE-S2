package fr.iut.montreuil.Red_Line_Defense;

import fr.iut.montreuil.Red_Line_Defense.Controleurs.ControleurMP;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class Main extends Application {
    public static final String AUDIO_OPENING_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/opening-red-line-defense.mp3";
    public static final String AUDIO_WE_ARE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/opening.mp3";

    public Media mediaOpening;
    public MediaPlayer mediaPlayerOpening;


    public static void main(String[] args) {
        launch(args);
    }



    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueMenuPrincipal.fxml"));
        Parent root = loader.load();
        primaryStage.setTitle("Red Line Defense");
        primaryStage.setScene(new Scene(root, 940, 560));
        mediaOpening = new Media(getClass().getResource(AUDIO_OPENING_PATH).toString());
        mediaPlayerOpening = new MediaPlayer(mediaOpening);
        mediaPlayerOpening.play();
        primaryStage.show();

        ControleurMP controleur = loader.getController();
        controleur.initialize(null, null); // Appeler la méthode initialize du contrôleur après l'affichage de la scène
    }
}
