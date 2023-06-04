module com.example.tower_defense {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.base;

    opens fr.iut.montreuil.Red_Line_Defense to javafx.fxml;
    exports fr.iut.montreuil.Red_Line_Defense;
    exports fr.iut.montreuil.Red_Line_Defense.modele.Controleurs;
    opens fr.iut.montreuil.Red_Line_Defense.modele.Controleurs to javafx.fxml;
}
