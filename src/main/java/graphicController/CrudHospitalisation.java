package graphicController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.bdd.Bdd;

public class CrudHospitalisation {

    @FXML
    private TableColumn<String, ?> datePriseEnChargeT;

    @FXML
    private TableColumn<?, ?> eid;

    @FXML
    private TextField refDossier;

    @FXML
    private TextField id;



    @FXML
    private TableColumn<String, ?> descriptionDeLaMaladieT;

    @FXML
    private TableColumn<String, ?> refDossierT;

    @FXML
    private TextField datePriseEnCharge;

    @FXML
    private TextField descriptionDeLaMaladie;



    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> datePriseEnChargeCol = new TableColumn<>("datePriseEnCharge");
        TableColumn<ObservableList<String>, String> descriptionDeLaMaladieCol = new TableColumn<>("descriptionDeLaMaladie");
        TableColumn<ObservableList<String>, String> refDossierCol = new TableColumn<>("refDossier");


        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0))); // Index 0 pour la première colonne (ID)
        datePriseEnChargeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1))); // Index 1 pour la deuxième colonne (Nom)
        descriptionDeLaMaladieCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2))); // Index 2 pour la troisième colonne (Prénom)
        refDossierCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3))); // Index 3 pour la quatrième colonne (Email)


        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, datePriseEnChargeCol, descriptionDeLaMaladieCol, refDossierCol);
    }





    @FXML
    void deletehospitalisation(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM hospitalisation WHERE idhospitalisation = ?");
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
            req = new Bdd().getBdd().prepareStatement("INSERT INTO hospitalisation (datePriseEnCharge, description, nivdanger, stock) VALUES (?,?,?,?)");
            req.setString(1, this.datePriseEnCharge.getText());
            req.setString(2, this.descriptionDeLaMaladie.getText());
            req.setString(3, this.refDossier.getText());
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
                row.add(rs.getString("idhospitalisation"));
                row.add(rs.getString("datePriseEnCharge"));
                row.add(rs.getString("descriptionDeLaMaladie"));
                row.add(rs.getString("refDossier"));
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
            req = new Bdd().getBdd().prepareStatement("UPDATE hospitalisation SET datePriseEnCharge = ?, descriptionDeLaMaladie = ?, nivdanger = ?, stock = ? WHERE idhospitalisation = ?");
            req.setString(1, this.datePriseEnCharge.getText());
            req.setString(2, this.descriptionDeLaMaladie.getText());
            req.setString(3, this.refDossier.getText());
            req.setString(4, this.id.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
