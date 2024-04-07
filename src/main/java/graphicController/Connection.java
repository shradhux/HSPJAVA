package graphicController;

import Classes.HospitalisationChambre;
import Classes.Utilisateur;
import application.Main;
import controller.Controller.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Objects;

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

            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT role FROM Utilisateur where email = ? AND mdp = ?");
            req.setString(1,login.getText());
            req.setString(2,mdp.getText());
            ResultSet rs = req.executeQuery();
            rs.next();
            String role = user.setRole(rs.getString(1));

            if (user == null){
                this.oubli.setVisible(true);
            }
            else if (Objects.equals(role, "secretaire")) {
                Main.change("AccueilSecretaire");
            }            else if (Objects.equals(role, "gestionnaire")) {
                Main.change("AccueilGestionnaire");
            }            else if (Objects.equals(role, "medecin")) {
                Main.change("Accueilmedecin");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }



    @FXML
    void oubli(ActionEvent event) {
        Main.change("Oubli", new Oubli(), "Réinitialiser votre mdp");
    }


}