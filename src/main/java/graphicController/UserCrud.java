package graphicController;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import modele.bdd.Bdd;

public class UserCrud {

    @FXML
    private TableColumn<?, ?> department;

    @FXML
    private TableColumn<?, ?> eid;

    @FXML
    private TextField email;

    @FXML
    private TextField id;

    @FXML
    private Label label;

    @FXML
    private TableColumn<?, ?> mobile;

    @FXML
    private TableColumn<?, ?> name;

    @FXML
    private TextField nom;

    @FXML
    private TextField prenom;

    @FXML
    private TextField role;

    @FXML
    private TableColumn<?, ?> salary1;

    @FXML
    private TableView<?> table;

    @FXML
    public void initialize() {




    }




    @FXML
    void deleteUser(ActionEvent event) {

    }

    @FXML
    void register(ActionEvent event) {
        PreparedStatement req = null;
        try {
            req = new Bdd().getBdd().prepareStatement("INSERT INTO utilisateur (nom, prenom, email, role) VALUES (?,?,?,?) ");
            req.setString(1, this.nom.getText());
            req.setString(2, this.nom.getText());
            req.setString(3, this.nom.getText());
            req.setString(4, this.nom.getText());
            req.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @FXML
    void showAll(ActionEvent event) {




    }

    @FXML
    void update(ActionEvent event) {

    }

}
