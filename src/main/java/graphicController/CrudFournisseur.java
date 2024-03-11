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

public class CrudFournisseur {

    @FXML
    private TableColumn<String, ?> libelleT;

    @FXML
    private TableColumn<?, ?> eid;

    @FXML
    private TextField niv_danger;

    @FXML
    private TextField id;



    @FXML
    private TableColumn<String, ?> descriptionT;

    @FXML
    private TableColumn<String, ?> niv_dangerT;

    @FXML
    private TextField libelle;

    @FXML
    private TextField description;

    @FXML
    private TextField stock;

    @FXML
    private TableColumn<String, ?> stockT;

    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> libelleCol = new TableColumn<>("libelle");
        TableColumn<ObservableList<String>, String> descriptionCol = new TableColumn<>("description");
        TableColumn<ObservableList<String>, String> nivDangerCol = new TableColumn<>("niv_danger");
        TableColumn<ObservableList<String>, String> stockCol = new TableColumn<>("stock");

        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0))); // Index 0 pour la première colonne (ID)
        libelleCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1))); // Index 1 pour la deuxième colonne (Nom)
        descriptionCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2))); // Index 2 pour la troisième colonne (Prénom)
        nivDangerCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3))); // Index 3 pour la quatrième colonne (Email)
        stockCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4))); // Index 4 pour la cinquième colonne (Rôle)

        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, libelleCol, descriptionCol, nivDangerCol, stockCol);
    }





    @FXML
    void deleteProduit(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM produit WHERE id_produit = ?");
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
            req = new Bdd().getBdd().prepareStatement("INSERT INTO produit (libelle, description, niv_danger, stock) VALUES (?,?,?,?)");
            req.setString(1, this.libelle.getText());
            req.setString(2, this.description.getText());
            req.setString(3, this.niv_danger.getText());
            req.setString(4, this.stock.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    @FXML
    void showAll(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM Produit");
            ResultSet rs = req.executeQuery();

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_produit"));
                row.add(rs.getString("libelle"));
                row.add(rs.getString("description"));
                row.add(rs.getString("niv_danger"));
                row.add(rs.getString("stock"));
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
            req = new Bdd().getBdd().prepareStatement("UPDATE produit SET libelle = ?, description = ?, niv_danger = ?, stock = ? WHERE id_produit = ?");
            req.setString(1, this.libelle.getText());
            req.setString(2, this.description.getText());
            req.setString(3, this.niv_danger.getText());
            req.setString(4, this.stock.getText());
            req.setString(5, this.id.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
