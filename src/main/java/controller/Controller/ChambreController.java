package controller.Controller;

import Classes.Chambre;
import Classes.Fournisseur;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ChambreController {
    public static void modifChambre (Chambre chambre) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE chambre SET est_libre = ? , numero = ?");
        req.setBoolean(1,chambre.getEst_libre());
        req.setString(2,chambre.getNumero());
        req.executeUpdate();

    }
    public static void addChambre (Chambre chambre) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO chambre (est_libre,numero) VALUES (?,? ) ");
        req.setBoolean(1,chambre.getEst_libre());
        req.setString(2,chambre.getNumero());
        req.executeUpdate();

    }
    public static void deleteChambre (Chambre chambre) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM chambre Where id = ? ");
        req.executeUpdate();

    }

}
