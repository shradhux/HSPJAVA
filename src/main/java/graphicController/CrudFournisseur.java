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

public class CrudFournisseur {

    @FXML
    private TableColumn<?, ?> eid;

    @FXML
    private TextField nom;

    @FXML
    private TextField id;



    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> nomCol = new TableColumn<>("nom");



        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0))); // Index 0 pour la première colonne (ID)
        nomCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1))); // Index 1 pour la deuxième colonne (Nom)



        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, nomCol);
    }





    @FXML
    void deleteFournisseur(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM fournisseur WHERE id_fournisseur = ?");
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
            req = new Bdd().getBdd().prepareStatement("INSERT INTO fournisseur (nom) VALUES (?)");
            req.setString(1, this.nom.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    @FXML
    void showAll(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM fournisseur");
            ResultSet rs = req.executeQuery();

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_fournisseur"));
                row.add(rs.getString("nom"));
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
            req = new Bdd().getBdd().prepareStatement("UPDATE fournisseur SET nom = ? WHERE id_fournisseur = ?");
            req.setString(1, this.nom.getText());
            req.setString(2, this.id.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
