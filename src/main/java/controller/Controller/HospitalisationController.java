package controller.Controller;
import Classes.Hospitalisation;
import modele.bdd.Bdd;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class HospitalisationController {
    public static void modifHospitalisation (Hospitalisation hospitalisation) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE hospitalisation SET date_prise_en_charge = ?,description_de_la_maladie=?,ref_dossier=?");
        req.setString(1,hospitalisation.getDescription_de_la_maladie());
        req.setDate(2, (Date) hospitalisation.getDate_prise_en_charge());
        req.setInt(3,hospitalisation.getRef_dossier());
        req.executeUpdate();

    }
    public static void addHospitalisation (Hospitalisation hospitalisation) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO hospitalisation (date_prise_en_charge,description_de_la_maladie,ref_dossier) VALUES (?,?,? ) ");
        req.setString(1,hospitalisation.getDescription_de_la_maladie());
        req.setDate(2, (Date) hospitalisation.getDate_prise_en_charge());
        req.setInt(3,hospitalisation.getRef_dossier());
        req.executeUpdate();

    }
    public static void deleteHospitalisation(Hospitalisation hospitalisation) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM hospitalisation Where id = ? ");
        req.executeUpdate();

    }
}
