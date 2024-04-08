package graphicController;

import application.Main;
import controller.Controller.UtilisateurController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CrudDemandeProduit {


    @FXML
    private TableColumn<?, ?> eid;

    @FXML
    private Button retour;

    @FXML
    private TextField raison;

    @FXML
    private TextField quantite;


    @FXML
    private TextField statut;


    @FXML
    private TextField ref_produit;

    @FXML
    private TextField ref_utilisateur;

    @FXML
    private TextField id;

    @FXML
    private TextField validatetext;




    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> raisonCol = new TableColumn<>("raison");
        TableColumn<ObservableList<String>, String> quantiteCol = new TableColumn<>("quantite");
        TableColumn<ObservableList<String>, String> statutCol = new TableColumn<>("statut");
        TableColumn<ObservableList<String>, String> ref_produitCol = new TableColumn<>("ref_produit");
        TableColumn<ObservableList<String>, String> ref_utilisateurCol = new TableColumn<>("ref_utilisateur");




        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        raisonCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        quantiteCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        statutCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        ref_produitCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        ref_utilisateurCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));



        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, raisonCol, quantiteCol, statutCol, ref_produitCol, ref_utilisateurCol);
    }





    @FXML
    void deleteDemandeProduit(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM demandeproduit WHERE id_demande_produit = ?");
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
            req = new Bdd().getBdd().prepareStatement("INSERT INTO demandeproduit (raison, quantite, statut, ref_produit, ref_utilisateur, approuve) VALUES (?,?,?,?,?,?)");
            req.setString(1, this.raison.getText());
            req.setString(2, this.quantite.getText());
            req.setString(3, this.statut.getText());
            req.setString(4, this.ref_produit.getText());
            req.setString(5, String.valueOf(UtilisateurController.getId_actual_user()));
            req.setString(6, "0");
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    @FXML
    void showAll(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM demandeproduit WHERE approuve = 0");
            ResultSet rs = req.executeQuery();

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_demande_produit"));
                row.add(rs.getString("raison"));
                row.add(rs.getString("quantite"));
                row.add(rs.getString("statut"));
                row.add(rs.getString("ref_produit"));
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
            req = new Bdd().getBdd().prepareStatement("UPDATE demandeproduit SET raison = ?, quantite = ?, statut = ?, ref_produit = ?, ref_utilisateur = ?, approuve = 0 WHERE id_demande_produit = ?");
            req.setString(1, this.raison.getText());
            req.setString(2, this.quantite.getText());
            req.setString(3, this.statut.getText());
            req.setString(4, this.ref_produit.getText());
            req.setString(5, String.valueOf(UtilisateurController.getId_actual_user()));
            req.setString(6, this.id.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }



    }


    @FXML
    void validate(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("UPDATE demandeproduit SET approuve = ? WHERE id_demande_produit = ?");
            req.setString(1, "1");
            req.setString(2, this.validatetext.getText());

            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    @FXML
    void retour(ActionEvent event) {
        Main.change("AccueilMedecin");
    }

    @FXML
    void listeProduit(ActionEvent event) {
        Main.fenetreAnnexe("listeProduit", new CrudProduit(), "liste produit");

    }

}
