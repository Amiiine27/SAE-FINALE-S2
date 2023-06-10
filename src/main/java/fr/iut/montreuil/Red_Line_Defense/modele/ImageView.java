package fr.iut.montreuil.Red_Line_Defense.modele;

import javafx.beans.property.IntegerProperty;

public class ImageView {

    IntegerProperty x, y;

    public int getX() {
        return x.get();
    }

    public IntegerProperty xProperty() {
        return x;
    }

    public int getY() {
        return y.get();
    }

    public IntegerProperty yProperty() {
        return y;
    }
}
