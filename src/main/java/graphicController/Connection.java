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

import java.sql.SQLException;

public class Connection {

    private static int id_actual_user;

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
                Main.change("AccueilMedecin");
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
    void crudfichepatientbtn(ActionEvent event) {
        Main.change("FichePatientCrud", new CrudFichePatient(), "Crud fiche patient");
    }

    @FXML
    void oubli(ActionEvent event) {
        Main.change("Oubli", new Oubli(), "Réinitialiser votre mdp");
    }

    @FXML
    void cruddossierbtn(ActionEvent event) {
        Main.change("DossierCrud", new CrudDossier(), "Crud dossier");
    }


    @FXML
    void crudfournisseurbtn(ActionEvent event) {
        Main.change("FournisseurCrud", new CrudFournisseur(), "Crud fournisseur");
    }

    @FXML
    void crudproduitfournisseurbtn(ActionEvent event) {
        Main.change("ProduitFournisseurCrud", new CrudProduitFournisseur(), "Crud produit fournisseur");
    }

    @FXML
    void crudlescommandesdeproduitbtn(ActionEvent event) {
        Main.change("LesCommandesDeProduitCrud", new CrudLesCommandesDeProduit(), "Crud les commandes de produits");
    }

    @FXML
    void crudcommandeproduitbtn(ActionEvent event) {
        Main.change("CommandeProduitCrud", new CrudCommandeProduit(), "Crud commande produit");
    }

    @FXML
    void crudhospitalisationchambrebtn(ActionEvent event) {
        Main.change("HospitalisationChambreCrud", new CrudHospitalisationChambre(), "Crud hospitalisation chambre");
    }
}