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
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseButton;
import javafx.stage.Stage;
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

    private Scene homeScene;

    @FXML
    private Button retour;

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

        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> nomCol = new TableColumn<>("Nom");
        TableColumn<ObservableList<String>, String> prenomCol = new TableColumn<>("Prénom");
        TableColumn<ObservableList<String>, String> emailCol = new TableColumn<>("Email");
        TableColumn<ObservableList<String>, String> roleCol = new TableColumn<>("Rôle");
        TableColumn<ObservableList<String>, String> mdpCol = new TableColumn<>("mdp");


        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0)));
        nomCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1)));
        prenomCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2)));
        emailCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3)));
        roleCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(4)));
        mdpCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(5)));

        table.getColumns().addAll(idCol, nomCol, prenomCol, emailCol, roleCol,mdpCol);




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

                row.add(rs.getString("id_utilisateur"));
                row.add(rs.getString("nom"));
                row.add(rs.getString("prenom"));
                row.add(rs.getString("email"));
                row.add(rs.getString("role"));
                row.add(rs.getString("mdp"));
                data.add(row);
            }


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


    @FXML
    void retour(ActionEvent event) {
        Main.change("AccueilAdmin");
    }




}

