package fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicBoolean;

public class ControleurAide implements Initializable {
    private Stage stage;
    private Parent root;
    private Font jap;
    private boolean isWindowClosed=false;
    public static final String AUDIO_OPENING_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/opening-red-line-defense.mp3";
    public static final String AUDIO_WE_ARE_PATH = "/fr/iut/montreuil/Red_Line_Defense/Sons/opening.mp3";

    @FXML
    private Label labelTitre;




    @FXML
    private void onJouerButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueMenuPRincipal.fxml"));
        root = loader.load();
        ControleurMP controleur = loader.getController(); // Retrieve the controller instance
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 1000, 561);// Largeur 940px : 840px pour la carte, 100px pour le volet droit
        stage.setResizable(false);                     // Hauteur 560px : 480 pour la carte, 80px pour le volet bas
        stage.setTitle("Red Line Defense");
        stage.setScene(scene);
        stage.show();
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /*// Créez la police que vous voulez utiliser
        Font fontJap = Font.loadFont(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Polices/jap.ttf").toExternalForm(), 20); // 20 est la taille de la police, changez-la comme vous voulez

        // Appliquer la police à votre label
        labelTitre.setFont(fontJap);*/
    }
}
