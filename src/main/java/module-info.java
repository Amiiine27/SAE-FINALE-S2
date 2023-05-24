module com.example.tower_defense {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;

    opens fr.iut.montreuil.Red_Line_Defense to javafx.fxml;
    exports fr.iut.montreuil.Red_Line_Defense;
}