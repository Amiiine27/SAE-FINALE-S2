package com.example.tower_defense;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application {
    public static void main(String[] args) {
        launch();
    }

    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("vueDeJeu.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 220, 260);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false); // ne plus resizer la fenêtre
        stage.show();
    }

}
