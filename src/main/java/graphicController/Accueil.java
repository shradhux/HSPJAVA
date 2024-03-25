package graphicController;

import application.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Accueil {

    @FXML
    private Pane avatar;


    @FXML
    private ImageView fichepatient;

    @FXML
    private ImageView gestiondesutilisateurs;

    @FXML
    private Button gestionfichepatient;

    @FXML
    private Button gestionutilisateurs;


    @FXML
    void gestionfichepatient(ActionEvent event) {

    }

    @FXML
    void gestionstock(ActionEvent event) {
        Main.change("ProduitCrud", new CrudProduit(), "Crud produit");

    }

    @FXML
    void gestionutilisateurs(ActionEvent event) {
        Main.change("UserCrud", new UserCrud(), "Crud user");
    }

    }


