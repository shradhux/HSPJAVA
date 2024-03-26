package graphicController;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.bdd.Bdd;

public class CrudDossier {


    @FXML
    private TextField symptome;

    @FXML
    private TextField gravite;

    @FXML
    private TextField id;

    @FXML
    private DatePicker date;

    @FXML
    private TextField heure;

    @FXML
    private TextField ref_utilisateur;

    @FXML
    private TextField ref_fiche_patient;



    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> dateCol = new TableColumn<>("date");
        TableColumn<ObservableList<String>, String> symptomeCol = new TableColumn<>("symptome");
        TableColumn<ObservableList<String>, String> graviteCol = new TableColumn<>("gravite");        TableColumn<ObservableList<String>, String> date_prise_en_chargeCol = new TableColumn<>("date_prise_en_charge");
        TableColumn<ObservableList<String>, String> ref_utilisateurCol = new TableColumn<>("ref_utilisateur");
        TableColumn<ObservableList<String>, String> ref_fiche_patientCol = new TableColumn<>("ref_fiche_patient");


        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        dateCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        symptomeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        graviteCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        ref_utilisateurCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        ref_fiche_patientCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));


        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, dateCol, symptomeCol, graviteCol, ref_utilisateurCol,ref_fiche_patientCol);
    }





    @FXML
    void deletedossier(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM dossier WHERE id_dossier = ?");
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
            req = new Bdd().getBdd().prepareStatement("INSERT INTO dossier (date, heure, symptome, gravite, ref_utilisateur, ref_fiche_patient) VALUES (?,?,?,?,?,?)");
            req.setString(1, String.valueOf(this.date.getValue()));
            req.setString(2, this.heure.getText());
            req.setString(3, this.symptome.getText());
            req.setString(4,  this.gravite.getText());
            req.setString(5, this.ref_utilisateur.getText());
            req.setString(6, this.ref_fiche_patient.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    @FXML
    void showAll(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM hospitalisation");
            ResultSet rs = req.executeQuery();

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_dossier"));
                row.add(rs.getString("date"));
                row.add(rs.getString("heure"));
                row.add(rs.getString("symptome"));
                row.add(rs.getString("gravite"));
                row.add(rs.getString("ref_utilisateur"));
                row.add(rs.getString("ref_fiche_patient"));
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
            req = new Bdd().getBdd().prepareStatement("UPDATE hospitalisation SET date = ?, heure = ?, symptome = ?,  gravite = ?,  ref_utilisateur = ?, ref_fiche_patient = ? WHERE id_dossier = ?");
            req.setString(1, String.valueOf(this.date.getValue()));
            req.setString(2, this.heure.getText());
            req.setString(3, this.symptome.getText());
            req.setString(4,  this.gravite.getText());
            req.setString(5, this.ref_utilisateur.getText());
            req.setString(6, this.ref_fiche_patient.getText());
            req.setString(4, this.id.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
