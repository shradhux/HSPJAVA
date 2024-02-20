package controller.Controller;

import Classes.Dossier;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DossierController {
    public static void modifDossier (Dossier dossier) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE dossier SET date = ? , heure = ?,symptome=?,gravite=?,ref_utilisateur=?, ref_fiche_patient=?");
        req.setDate(1,dossier.getDate());
        req.setTime(2,dossier.getHeure());
        req.setString(3, dossier.getSymptome());
        req.setInt(4, dossier.getRef_utilisateur());
        req.setInt(5, dossier.getRef_fiche_patient());
        req.executeUpdate();

    }
    public static void addDossier (Dossier dossier) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO dossier (date,heure,symptome,gravite,ref_utilisateur,ref_fiche_patient) VALUES (?,?,?,?,?,? ) ");
        req.setDate(1,dossier.getDate());
        req.setTime(2,dossier.getHeure());
        req.setString(3, dossier.getSymptome());
        req.setInt(4, dossier.getRef_utilisateur());
        req.setInt(5, dossier.getRef_fiche_patient());
        req.executeUpdate();


    }
    public static void deleteDossier(Dossier dossier) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM dossier Where id = ? ");
        req.executeUpdate();

    }
}
