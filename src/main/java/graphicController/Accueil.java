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
    private Button gestionproduitfournisseur;

    @FXML
    private Button gestionutilisateurs;

    @FXML
    private Button deconnexion;

    @FXML
    void gestionfichepatient(ActionEvent event) {
        Main.change("FichePatientCrud", new CrudFichePatient(), "Crud fiche Patient");

    }

    @FXML
    void gestionstock(ActionEvent event) {
        Main.change("ProduitCrud", new CrudProduit(), "Crud produit");

    }

    @FXML
    void gestionutilisateurs(ActionEvent event) {
        Main.change("UserCrud", new UserCrud(), "Crud user");
    }





    @FXML
    void gestionhospitalisation(ActionEvent event) {
        Main.change("HospitalisationCrud", new CrudHospitalisation(), "Crud Hospitalisation");

    }

    @FXML
    void gestiondossier(ActionEvent event) {
        Main.change("DossierCrud", new CrudDossier(), "Crud dossier");

    }


    @FXML
    void gestionproduit(ActionEvent event) {
        Main.change("ProduitCrud", new CrudProduit(), "Crud produit");

    }

    @FXML
    void deconnexion(ActionEvent event) {Main.change("Connection");

    }

}


