package graphicController;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Main;
import controller.Controller.UtilisateurController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.bdd.Bdd;

public class CrudFichePatient {

    @FXML
    private TableColumn<String, ?> nomT;

    @FXML
    private Button retour;

    @FXML
    private TableColumn<String, ?> prenomT;

    @FXML
    private TableColumn<String, ?> num_securite_sociale_T;

    @FXML
    private TableColumn<String, ?> emailT;

    @FXML
    private TableColumn<String, ?> telephoneT;

    @FXML
    private TableColumn<String, ?> rueT;

    @FXML
    private TableColumn<String, ?> cpT;

    @FXML
    private TableColumn<String, ?> villeT;

    @FXML
    private TableColumn<String, ?> ref_utilisateurT;


    @FXML
    private TableColumn<?, ?> eid;


    @FXML
    private TextField id;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField num_securite_sociale;

    @FXML
    private TextField email;


    @FXML
    private TextField telephone;

    @FXML
    private TextField rue;


    @FXML
    private TextField cp;

    @FXML
    private TextField ville;

    @FXML
    private TextField ref_utilisateur;

    @FXML
    private Button gestiondossier;

    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> nomCol = new TableColumn<>("nom");
        TableColumn<ObservableList<String>, String> prenomCol = new TableColumn<>("prenom");
        TableColumn<ObservableList<String>, String> num_securite_socialeCol = new TableColumn<>("num_securite_sociale");
        TableColumn<ObservableList<String>, String> emailCol = new TableColumn<>("email");
        TableColumn<ObservableList<String>, String> telephoneCol = new TableColumn<>("telephone");
        TableColumn<ObservableList<String>, String> rueCol = new TableColumn<>("rue");
        TableColumn<ObservableList<String>, String> cpCol = new TableColumn<>("cp");
        TableColumn<ObservableList<String>, String> villeCol = new TableColumn<>("ville");


        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        nomCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        prenomCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        num_securite_socialeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        emailCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        telephoneCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
        rueCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(6)));
        cpCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(7)));
        villeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(8)));



        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, nomCol, prenomCol, num_securite_socialeCol,emailCol,telephoneCol,rueCol,cpCol,villeCol);
    }





    @FXML
    void deleteFichePatient(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM fichepatient WHERE id_fiche_patient = ?");
            req.setString(1, this.id.getText());

            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void register(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("INSERT INTO fichepatient (nom, prenom, num_securite_sociale,email,telephone,rue,cp,ville,ref_utilisateur) VALUES (?,?,?,?,?,?,?,?,?)");
            req.setString(1, this.nom.getText());
            req.setString(2, this.prenom.getText());
            req.setString(3, this.num_securite_sociale.getText());
            req.setString(4, this.email.getText());
            req.setString(5, this.telephone.getText());
            req.setString(6, this.rue.getText());
            req.setString(7, this.cp.getText());
            req.setString(8, this.ville.getText());
            req.setString(9, String.valueOf(UtilisateurController.getId_actual_user()));

            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    @FXML
    void showAll(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM fichepatient");
            ResultSet rs = req.executeQuery();

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_fiche_patient"));
                row.add(rs.getString("nom"));
                row.add(rs.getString("prenom"));
                row.add(rs.getString("num_securite_sociale"));
                row.add(rs.getString("email"));
                row.add(rs.getString("telephone"));
                row.add(rs.getString("rue"));
                row.add(rs.getString("cp"));
                row.add(rs.getString("ville"));
                data.add(row);
            }

            // Afficher les données dans la table
            table.setItems(data);

            rs.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    @FXML
    void update(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("UPDATE fichepatient SET nom = ?, prenom = ?, num_securite_sociale = ?,email = ?, telephone = ?, rue = ?,cp = ?, ville = ? WHERE id_fiche_patient = ?");
            req.setString(1, this.nom.getText());
            req.setString(2, this.prenom.getText());
            req.setString(3, this.num_securite_sociale.getText());
            req.setString(4, this.email.getText());
            req.setString(5, this.telephone.getText());
            req.setString(6, this.rue.getText());
            req.setString(7, this.cp.getText());
            req.setString(8, this.ville.getText());
            req.setString(9, this.id.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void retour(ActionEvent event) {
        Main.change("AccueilSecretaire");
    }

    @FXML
    void listeUtilisateur(ActionEvent event) {
        Main.fenetreAnnexe("ListeUtilisateur",new UserCrud(),"User");

    }



}
