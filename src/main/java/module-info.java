module com.example.hspjava {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens com.example.hspjava to javafx.fxml;
    exports com.example.hspjava;
}