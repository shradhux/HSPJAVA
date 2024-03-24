package graphicController;

import Classes.Utilisateur;
import application.Main;
import controller.Controller.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.SQLException;

public class Connection {

    @FXML
    private Button connectbutton;



    @FXML
    private TextField login;

    @FXML
    private Button cruduser;

    @FXML
    private Button crudproduit;
    @FXML
    private TextField mdp;

    @FXML
    private Button oubli;

    @FXML
    private Label welcomeText;

    @FXML
    void connection(ActionEvent event) {
        try {
            Utilisateur user = new UtilisateurController().Connect(login.getText(), mdp.getText());
            if (user == null){
                this.oubli.setVisible(true);
            }
            else {
                Main.change("Accueil");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void cruduserbtn(ActionEvent event) {
        Main.change("UserCrud", new UserCrud(), "Crud user");
    }

    @FXML
    void crudproduitbtn(ActionEvent event) {
        Main.change("ProduitCrud", new CrudProduit(), "Crud produit");
    }

    @FXML
    void crudhospitalisationbtn(ActionEvent event) {
        Main.change("HospitalisationCrud", new CrudHospitalisation(), "Crud hospitalisation");
    }

    @FXML
    void oubli(ActionEvent event) {
        Main.change("Oubli", new Oubli(), "Réinitialiser votre mdp");
    }

}