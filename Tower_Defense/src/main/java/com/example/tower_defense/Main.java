package com.example.tower_defense;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import static javafx.application.Application.launch;

public class Main extends Application {
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("vue.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 180, 180);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false); // ne plus resizer la fenêtre
        stage.show();
    }
    public static void main(String[] args) {
        launch();
    }

}
