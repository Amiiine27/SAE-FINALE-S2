module com.example.tower_defense {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens com.example.tower_defense to javafx.fxml;
    exports com.example.tower_defense;
}