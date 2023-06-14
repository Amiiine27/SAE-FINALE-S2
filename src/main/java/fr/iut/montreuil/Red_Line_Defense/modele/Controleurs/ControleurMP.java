package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;

import fr.iut.montreuil.Red_Line_Defense.modele.GameLoop;
import fr.iut.montreuil.Red_Line_Defense.modele.Inputs.Inputs;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.MediaPlayer;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import fr.iut.montreuil.Red_Line_Defense.Main;
public class ControleurMP implements Initializable {
    private Stage stage;
    private Parent root;
    private Font jap;

    @FXML
    private Label labelTitre;
    private MediaPlayer mediaPlayerJeu, mediaPlayerAide;
    private Media mediaJeu, mediaAide;
    public static final String AUDIO_OST_JEU_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/ostJeu.mp3";
    public static final String AUDIO_OST_AIDE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/ostAide.mp3";



    @FXML
    private void onJouerButtonClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueDeJeu.fxml"));
        root = loader.load();
        Controleur controleur = loader.getController(); // Retrieve the controller instance
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 940, 560);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);
        mediaJeu = new Media(getClass().getResource(AUDIO_OST_JEU_PATH).toString());
        mediaPlayerJeu = new MediaPlayer(mediaJeu);
        mediaPlayerJeu.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerJeu.play();

        controleur.initializeInputs();
    }
    @FXML
    private void onAideButtonClick(MouseEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueAide.fxml"));
        root = loader.load();
        ControleurAide controleur = loader.getController(); // Retrieve the controller instance
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 561);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);
        /*mediaAide = new Media(getClass().getResource(AUDIO_OST_AIDE_PATH).toString());
        mediaPlayerAide = new MediaPlayer(mediaAide);
        mediaPlayerAide.setCycleCount(MediaPlayer.INDEFINITE);
        mediaPlayerAide.play();*/
        stage.show();
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


    }
}
