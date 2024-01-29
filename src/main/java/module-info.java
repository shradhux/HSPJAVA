module HSPJAVA {
    requires java.sql;
    requires jakarta.mail;
    requires javafx.base;
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    opens application to javafx.fxml;
    opens graphicController to javafx.fxml;
    exports application;
}