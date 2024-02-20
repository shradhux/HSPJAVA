package controller.Controller;
import Classes.CommandeProduit;
import modele.bdd.Bdd;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CommandeProduitController {
    public static void modifCommandeProduit (CommandeProduit commandeProduit) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE CommandeProduit SET raison = ? ,statut = ?,ref_utilisauteur=?,ref_fournisseur=?");
        req.setString(1,commandeProduit.getRaison());
        req.setString(2,commandeProduit .getStatut());
        req.setInt(3,commandeProduit.getRef_utilisateur());
        req.setInt(4,commandeProduit.getRef_fournisseur());
        req.executeUpdate();

    }
    public static void addCommandeProduit(CommandeProduit commandeProduit) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO CommandeProduit  (raison,statut,ref_utilisauteur=?,ref_fournisseur=?) VALUES (?,?,?,? ) ");
        req.setString(1,commandeProduit.getRaison());
        req.setString(2,commandeProduit.getStatut());
        req.setInt(3,commandeProduit.getRef_utilisateur());
        req.setInt(4,commandeProduit.getRef_fournisseur());

        req.executeUpdate();

    }
    public static void deleteCommandeProduit ( CommandeProduit commandeProduit) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM CommandeProduit  Where id = ? ");
        req.executeUpdate();

    }
}
