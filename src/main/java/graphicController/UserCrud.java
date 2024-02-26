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

public class UserCrud {

    @FXML
    private TableColumn<String, ?> nomT;

    @FXML
    private TableColumn<?, ?> eid;

    @FXML
    private TextField email;

    @FXML
    private TextField id;

    @FXML
    private Label label;

    @FXML
    private TableColumn<String, ?> prenomT;

    @FXML
    private TableColumn<String, ?> emailT;

    @FXML
    private TableColumn<String, ?> mdpT;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField role;
    @FXML
    private TextField mdp;

    @FXML
    private TableColumn<String, ?> roleT;

    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> nomCol = new TableColumn<>("Nom");
        TableColumn<ObservableList<String>, String> prenomCol = new TableColumn<>("Prénom");
        TableColumn<ObservableList<String>, String> emailCol = new TableColumn<>("Email");
        TableColumn<ObservableList<String>, String> roleCol = new TableColumn<>("Rôle");
        TableColumn<ObservableList<String>, String> mdpCol = new TableColumn<>("mdp");

        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0))); // Index 0 pour la première colonne (ID)
        nomCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1))); // Index 1 pour la deuxième colonne (Nom)
        prenomCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2))); // Index 2 pour la troisième colonne (Prénom)
        emailCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3))); // Index 3 pour la quatrième colonne (Email)
        roleCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4))); // Index 4 pour la cinquième colonne (Rôle)
        mdpCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));
        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, nomCol, prenomCol, emailCol, roleCol,mdpCol);
    }





    @FXML
    void deleteUser(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("DELETE FROM utilisateur WHERE id_utilisateur = ?");
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
            req = new Bdd().getBdd().prepareStatement("INSERT INTO utilisateur (nom, prenom, email, role,mdp) VALUES (?,?,?,?,?)");
            req.setString(1, this.nom.getText());
            req.setString(2, this.nom.getText());
            req.setString(3, this.nom.getText());
            req.setString(4, this.nom.getText());
            req.setString(5, this.mdp.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }








    @FXML
    void showAll(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("SELECT * FROM utilisateur");
            ResultSet rs = req.executeQuery();

            ObservableList<ObservableList<String>> data = FXCollections.observableArrayList();

            while (rs.next()) {
                ObservableList<String> row = FXCollections.observableArrayList();
                // Ajoutez les valeurs des colonnes à chaque ligne
                row.add(rs.getString("id_utilisateur"));
                row.add(rs.getString("nom"));
                row.add(rs.getString("prenom"));
                row.add(rs.getString("email"));
                row.add(rs.getString("role"));
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
            req = new Bdd().getBdd().prepareStatement("UPDATE utilisateur SET nom = ?, prenom = ?, email = ?, role = ?,mdp = ? WHERE id_utilisateur = ?");
            req.setString(1, this.nom.getText());
            req.setString(2, this.prenom.getText());
            req.setString(3, this.email.getText());
            req.setString(3, this.role.getText());
            req.setString(4, this.role.getText());
            req.setString(5, this.mdp.getText());
            req.setString(6, this.id.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
