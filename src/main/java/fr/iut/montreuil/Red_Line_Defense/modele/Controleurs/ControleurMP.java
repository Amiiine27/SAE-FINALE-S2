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

public class ControleurMP implements Initializable {
    private Stage stage;
    private Parent root;
    private Font jap;

    @FXML
    private Label labelTitre;

    @FXML
    private void onJouerButtonClick(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fr/iut/montreuil/Red_Line_Defense/Vues/vueDeJeu.fxml"));
        root = loader.load();
        stage = (Stage) ((javafx.scene.Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root, 940, 560); // Largeur 940px : 840px pour la carte, 100px pour le volet droit
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