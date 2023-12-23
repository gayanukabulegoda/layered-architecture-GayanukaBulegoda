module com.example.layeredarchitecture {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.jfoenix;
    requires java.sql;

    opens lk.grb.layeredarchitecture to javafx.fxml;
    opens lk.grb.layeredarchitecture.controller to javafx.fxml;
    opens lk.grb.layeredarchitecture.view.tdm to javafx.base;

    exports lk.grb.layeredarchitecture;
    exports lk.grb.layeredarchitecture.controller;
}
