package graphicController;
import java.sql.*;

import Classes.HospitalisationChambre;
import application.Main;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import modele.bdd.Bdd;

public class CrudHospitalisation {

    @FXML
    private TableColumn<Date, ?> date_prise_en_chargeT;

    @FXML
    private TableColumn<?, ?> eid;

    @FXML
    private TextField ref_dossier;

    @FXML
    private TextField ref_chambre;

    @FXML
    private Button retour;


    @FXML
    private TextField id;



    @FXML
    private TableColumn<String, ?> description_de_la_maladieT;

    @FXML
    private TableColumn<String, ?> ref_dossierT;

    @FXML
    private DatePicker date_prise_en_charge;

    @FXML
    private TextField description_de_la_maladie;



    @FXML
    private TableView<ObservableList<String>> table;


    @FXML
    public void initialize() {
        // Configurez les cellules des colonnes pour afficher les valeurs correctes
        TableColumn<ObservableList<String>, String> idCol = new TableColumn<>("ID");
        TableColumn<ObservableList<String>, String> date_prise_en_chargeCol = new TableColumn<>("date_prise_en_charge");
        TableColumn<ObservableList<String>, String> description_de_la_maladieCol = new TableColumn<>("description_de_la_maladie");
        TableColumn<ObservableList<String>, String> ref_dossierCol = new TableColumn<>("ref_dossier");


        // Définir comment récupérer les valeurs pour chaque colonne
        idCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(0))); // Index 0 pour la première colonne (ID)
        date_prise_en_chargeCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(1))); // Index 1 pour la deuxième colonne (Nom)
        description_de_la_maladieCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(2))); // Index 2 pour la troisième colonne (Prénom)
        ref_dossierCol.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().get(3))); // Index 3 pour la quatrième colonne (Email)


        // Ajouter les colonnes à la TableView
        table.getColumns().addAll(idCol, date_prise_en_chargeCol, description_de_la_maladieCol, ref_dossierCol);
    }





    @FXML
    void deletehospitalisation(ActionEvent event) {
        PreparedStatement req = null;
        try {


            PreparedStatement req3 = null;
            req3 = new Bdd().getBdd().prepareStatement("UPDATE chambre set est_libre = ?  where id_chambre in (SELECT ref_chambre from hospitalisationchambre WHERE ref_hospitalisation = ?)");
            req3.setString(2, this.ref_chambre.getText());
            req3.setString(1, "1");
            req3.executeUpdate();


            req = new Bdd().getBdd().prepareStatement("DELETE FROM hospitalisation WHERE id_hospitalisation = ?");
            req.setString(1, this.id.getText());

            req.executeUpdate();

            PreparedStatement req2 = null;
            req2 = new Bdd().getBdd().prepareStatement("DELETE FROM hospitalisationchambre WHERE ref_hospitalisation = ?");
            req2.setString(1, this.id.getText());

            req2.executeUpdate();



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void register(ActionEvent event) {
        PreparedStatement req = null;

        try {
            req = new Bdd().getBdd().prepareStatement("INSERT INTO hospitalisation (date_prise_en_charge, description_de_la_maladie, ref_dossier) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            req.setString(1, String.valueOf(this.date_prise_en_charge.getValue()));
            req.setString(2, this.description_de_la_maladie.getText());
            req.setString(3, this.ref_dossier.getText());
            req.executeUpdate();


            int idchambre = 0;
            ResultSet generatedKeys = req.getGeneratedKeys();
            if (generatedKeys.next()) {
                 idchambre = generatedKeys.getInt(1);

            }
            PreparedStatement req2 = null;
            req2 = new Bdd().getBdd().prepareStatement("INSERT INTO hospitalisationchambre (ref_chambre, ref_hospitalisation) VALUES (?,?)");
            req2.setString(1, this.ref_chambre.getText());
            req2.setString(2, String.valueOf(idchambre));
            req2.executeUpdate();

            PreparedStatement req3 = null;
            req3 = new Bdd().getBdd().prepareStatement("UPDATE chambre set est_libre = ?  where id_chambre in (SELECT ref_chambre from hospitalisationchambre WHERE ref_hospitalisation = ?)");
            req3.setString(2, this.ref_chambre.getText());
            req3.setString(1, "0");
            req3.executeUpdate();

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
                row.add(rs.getString("id_hospitalisation"));
                row.add(rs.getString("date_prise_en_charge"));
                row.add(rs.getString("description_de_la_maladie"));
                row.add(rs.getString("ref_dossier"));
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
            req = new Bdd().getBdd().prepareStatement("UPDATE hospitalisation SET date_prise_en_charge = ?, description_de_la_maladie = ?, ref_dossier = ? WHERE id_hospitalisation = ?");
            req.setString(1, String.valueOf(this.date_prise_en_charge.getValue()));
            req.setString(2, this.description_de_la_maladie.getText());
            req.setString(3, this.ref_dossier.getText());
            req.setString(4, this.id.getText());
            req.executeUpdate();


            PreparedStatement req2 = null;
            req2 = new Bdd().getBdd().prepareStatement("UPDATE hospitalisationchambre SET ref_chambre = ? WHERE ref_hospitalisation = ?");
            req2.setString(1, this.ref_chambre.getText());
            req2.setString(2, this.id.getText());

            req2.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @FXML
    void listeDossier(ActionEvent event){
        Main.fenetreAnnexe("ListeDossier",new CrudDossier(),"Dossier");
    }

    @FXML
    void listeChambreDisponible(ActionEvent event){
        Main.fenetreAnnexe("listeChambreDisponible",new Chambre(),"Chambres disponibles");
    }

    @FXML
    void retour(ActionEvent event) {
        Main.change("AccueilMedecin");
    }

}
