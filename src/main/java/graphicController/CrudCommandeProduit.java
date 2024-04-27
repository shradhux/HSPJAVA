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
import javafx.scene.input.MouseButton;
import modele.bdd.Bdd;

public class CrudCommandeProduit {


    @FXML
    private TableColumn<?, ?> eid;

    @FXML
    private Button retour;

    @FXML
    private TextField raison;

    @FXML
    private TextField statut;

    @FXML
    private TextField ref_fournisseur;

    @FXML
    private TextField ref_utilisateur;


    @FXML
    private TextField id;





    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> raisonCol = new TableColumn<>("raison");
        TableColumn<ObservableList<String>, String> statutCol = new TableColumn<>("statut");
        TableColumn<ObservableList<String>, String> ref_fournisseurCol = new TableColumn<>("ref_fournisseur");
        TableColumn<ObservableList<String>, String> ref_utilisateurCol = new TableColumn<>("ref_utilisateur");


        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        raisonCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        statutCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        ref_fournisseurCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        ref_utilisateurCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));

        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, raisonCol, statutCol, ref_fournisseurCol,ref_utilisateurCol);





        // La methode on click pour récupérer l'id

        table.setOnMouseClicked(event -> {
            // Vérifier si un clic a été effectué avec le bouton gauche de la souris
            if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                // Récupérer la ligne sélectionnée dans la table
                ObservableList<String> rowData = table.getSelectionModel().getSelectedItem();
                if (rowData != null) {
                    // Récupérer l'ID de la ligne sélectionnée (supposons que l'ID est à l'index 0)
                    if(this.id != null) {
                        this.id.setText(rowData.get(0));
                    }

                }
            }
        });
    }




    @FXML
    void deleteCommandeProduit(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM commandeproduit WHERE id_commande_produit = ?");
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
            req = new Bdd().getBdd().prepareStatement("INSERT INTO commandeproduit (raison, statut, ref_utilisateur, ref_fournisseur) VALUES (?,?,?,?)");
            req.setString(1, this.raison.getText());
            req.setString(2, this.statut.getText());
            req.setString(3, this.ref_fournisseur.getText());
            req.setString(4, this.ref_utilisateur.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    @FXML
    void showAll(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM commandeproduit");
            ResultSet rs = req.executeQuery();

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_commande_produit"));
                row.add(rs.getString("raison"));
                row.add(rs.getString("statut"));
                row.add(rs.getString("ref_fournisseur"));
                row.add(rs.getString("ref_utilisateur"));
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
            req = new Bdd().getBdd().prepareStatement("UPDATE commandeproduit SET raison = ?, statut = ?, ref_fournisseur = ?, ref_utilisateur = ? WHERE id_commande_produit = ?");
            req.setString(1, this.raison.getText());
            req.setString(2, this.statut.getText());
            req.setString(3, this.ref_fournisseur.getText());
            req.setString(4, this.ref_utilisateur.getText());
            req.setString(5, this.id.getText());
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
