package graphicController;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import application.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.bdd.Bdd;

public class CrudHospitalisationChambre {


    @FXML
    private TableColumn<?, ?> eid;

    @FXML
    private Button retour;

    @FXML
    private TextField ref_chambre;

    @FXML
    private TextField ref_hospitalisation;


    @FXML
    private TextField id;





    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> chambreCol = new TableColumn<>("ref_chambre");
        TableColumn<ObservableList<String>, String> hospitalisationCol = new TableColumn<>("ref_hospitalisation");



        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        chambreCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        hospitalisationCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));


        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, chambreCol, hospitalisationCol);
    }





    @FXML
    void deleteHospitalisationChambre(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM hospitalisationchambre WHERE id_hospitalisation_chambre = ?");
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
            req = new Bdd().getBdd().prepareStatement("INSERT INTO hospitalisationchambre (ref_chambre, ref_hospitalisation) VALUES (?,?)");
            req.setString(1, this.ref_chambre.getText());
            req.setString(2, this.ref_hospitalisation.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    @FXML
    void showAll(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM hospitalisationchambre");
            ResultSet rs = req.executeQuery();

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_produit"));
                row.add(rs.getString("ref_chambre"));
                row.add(rs.getString("ref_hospitalisation"));
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
            req = new Bdd().getBdd().prepareStatement("UPDATE hospitalisationchambre SET ref_chambre = ?, ref_hospitalisation = ? WHERE id_hospitalisation_chambre = ?");
            req.setString(1, this.ref_chambre.getText());
            req.setString(2, this.ref_hospitalisation.getText());
            req.setString(3, this.id.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void retour(ActionEvent event) {
        Main.change("Accueil");
    }

}
