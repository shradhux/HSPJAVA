package graphicController;

import Classes.Utilisateur;
import application.Main;
import controller.Controller.UtilisateurController;
import javafx.collections.SetChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextFormatter;

public class PasswordReset {

    @FXML
    private TextField confirmation;

    @FXML
    private TextField mdp;

    @FXML
    private Label message;

    private Utilisateur user;

    /**
     * Récupération des données de l'utilisateur
     * @param user l'utilisateur en question qui veut changer son mot de passe
     */

    public PasswordReset(Utilisateur user){
        this.user = user;
        System.out.println(this.user.getId());
        System.out.println(this.user.getEmail());
    }


    /**
     * Vérifie l'identité de l'utilisateur
     * @param event cet évènement vérifie d'abord la longueur du mot de passe puis les caractères
     */

    @FXML
    void valid(ActionEvent event) {
        System.out.println("valid");
        if (mdp.getText().length() > 5){
            if (mdp.getText().equals(confirmation.getText())){
                user.setMdp(mdp.getText());
                System.out.println("ok");
                UtilisateurController.SetMdp(user);
                Main.change("Connection");
            }
            else{
                message.setText("Les mots de passe e ");
            }
        }
        else{
            message.setText("votre mdp doit faire au moins 5 char");
        }
    }
}
