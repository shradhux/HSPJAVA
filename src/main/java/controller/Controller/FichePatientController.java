package controller.Controller;


import Classes.FichePatient;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FichePatientController {
    public static void modifFichePatient (FichePatient fichePatient) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE fichePatient SET nom = ? , prenom = ?,email=?,num_securite_social=?,telephone=?, rue=?,code_postal=?,ville=?");
        req.setString(1,fichePatient.getNom());
        req.setString(2,fichePatient.getPrenom());
        req.setString(3,fichePatient.getEmail());
        req.setInt(4,fichePatient.getNum_securite_social());
        req.setString(5,fichePatient.getRue());
        req.setString(6,fichePatient.getCode_postal());
        req.setString(7,fichePatient.getVille());
        req.executeUpdate();

    }
    public static void addFichePatient (FichePatient fichePatient) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO fichePatient (nom,prenom,email,num_securite_social,rue,code_postal,ville) VALUES (?,?,?,?,?,?,? ) ");
        req.setString(1,fichePatient.getNom());
        req.setString(2,fichePatient.getPrenom());
        req.setString(3,fichePatient.getEmail());
        req.setInt(4,fichePatient.getNum_securite_social());
        req.setString(5,fichePatient.getRue());
        req.setString(6,fichePatient.getCode_postal());
        req.setString(7,fichePatient.getVille());
        req.executeUpdate();

    }
    public static void deleteFichePatient(FichePatient fichePatient) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM fichePatient Where id = ? ");
        req.executeUpdate();

    }
}
