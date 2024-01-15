package application;

import modele.bdd.Bdd;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main extends Application {

    public static Stage stage;

    private static FXMLLoader fxmlLoader;


    @Override
    public void start(Stage mystage) throws IOException, SQLException {




        PreparedStatement extraireListes = new Bdd().getBdd().prepareStatement("SELECT * FROM liste");


        this.stage = mystage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("Connection.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void change(String fxml, Object controller, String title) {
        stage.close();
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
        fxmlLoader.setController(controller);
        Scene scene;
        try {
            scene = new Scene(fxmlLoader.load());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }


    public static void change(String fxml) {
        // Step 1
        stage.close();
        try {
            // Step 2
            fxmlLoader = new FXMLLoader(Main.class.getResource(fxml + ".fxml"));
            // Step 5
            Parent root = fxmlLoader.load();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            System.err.println(String.format("Error: %s", e.getMessage()));
        }
    }

}