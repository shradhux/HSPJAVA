package graphicController;


import application.Main;
import controller.Controller.UtilisateurController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import modele.bdd.Bdd;
import service.emailUtil.Email;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Random;

import static java.lang.Integer.parseInt;

public class Oubli {

    @FXML
    private Label email_envoie;

    @FXML
    private TextField input;

    @FXML
    private Label title;

    @FXML
    private Button verrif;

    private int nb;
    private String email;

    @FXML
    void verrifi_email(ActionEvent event) {
        try {
            PreparedStatement req = new Bdd().getBdd().prepareStatement("select count(id_utilisateur) from utilisateur where email = ? ;");
            req.setString(1, input.getText());
            ResultSet res = req.executeQuery();
            res.next();

            email_envoie.setVisible(true);
            this.email = input.getText();
            input.setText("");
            title.setText("entrez le code de validation reçu par e-mail !!");
            verrif.setOnAction(actionEvent -> {
                try {
                    verrif();
                } catch (SQLException e) {
                    throw new RuntimeException(e);
                }
            });
            if (res.getInt(1) != 0){
                this.nb = new Random().nextInt() % 99999999;
                //xrilmahriuhyrevn
                Email.send(this.email, "Code de validation CrudFX", "le code de validation est : "+nb);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void verrif() throws SQLException {
        if (parseInt(input.getText()) == this.nb){
            System.out.println(parseInt(input.getText()));
            Main.change("PasswordReset", new PasswordReset(UtilisateurController.getByEmail(this.email)), "Réinitiliser le mot de passe !");
        }
        else {
            Main.change("Oubli", new Oubli(), "Dommage");
        }
    }

}
