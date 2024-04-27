package graphicController;

import Classes.Produit;
import application.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.input.MouseButton;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudProduitFournisseur {



    @FXML
    private TextField id;



    @FXML
    private TextField ref_produit;

    @FXML
    private TextField ref_fournisseur;

    @FXML
    private TextField prix;



    @FXML
    private TableView<ObservableList<String>> table;

    @FXML
    private Button retour;

    @FXML
    private Button deleteProduitFournisseur;




    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> prixCol = new TableColumn<>("prix");
        TableColumn<ObservableList<String>, String> ref_fournisseurCol = new TableColumn<>("ref_fournisseur");
        TableColumn<ObservableList<String>, String> ref_produitCol = new TableColumn<>("ref_produit");




        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        prixCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        ref_fournisseurCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        ref_produitCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));



        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, prixCol, ref_fournisseurCol, ref_produitCol);





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
    void deleteProduitFournisseur(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM produitfournisseur WHERE id_produit_fournisseur = ?");
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
            req = new Bdd().getBdd().prepareStatement("INSERT INTO produitfournisseur (prix, ref_fournisseur, ref_produit) VALUES (?,?,?)");
            req.setString(1, this.prix.getText());
            req.setString(2, this.ref_fournisseur.getText());
            req.setString(3,  this.ref_produit.getText());

            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    @FXML
    void showAll(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM produitfournisseur");
            ResultSet rs = req.executeQuery();


            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {


                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_produit_fournisseur"));
                row.add(rs.getString("prix"));
                row.add(rs.getString("ref_fournisseur"));
                row.add(rs.getString("ref_produit"));



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
            req = new Bdd().getBdd().prepareStatement("UPDATE produitfournisseur SET prix = ?, ref_fournisseur = ?, ref_produit = ? WHERE id_produit_fournisseur = ?");
            req.setString(1, this.prix.getText());
            req.setString(2, this.ref_fournisseur.getText());
            req.setString(3,  this.ref_produit.getText());
            req.setString(4, this.id.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void showAllProduitFournisseur(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM produitfournisseur WHERE ref_produit = ?");
            req.setString(1, CrudProduit.getIddetail());
            ResultSet rs = req.executeQuery();

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_produit_fournisseur"));
                row.add(rs.getString("prix"));
                row.add(rs.getString("ref_fournisseur"));
                row.add(rs.getString("ref_produit"));


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
    void retour(ActionEvent event) {
        Main.change("AccueilGestionnaire");
    }

    @FXML
    void listeProduit(ActionEvent event) {
        Main.fenetreAnnexe("listeProduit", new CrudProduit(),"Voir la liste des produits");
    }

    @FXML
    void listeFournisseur(ActionEvent event) {
        Main.fenetreAnnexe("listeFournisseur", new CrudFournisseur(), "Voir la liste des fournisseurs");
    }

}
