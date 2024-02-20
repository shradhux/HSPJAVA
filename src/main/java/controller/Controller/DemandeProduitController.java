package controller.Controller;

import Classes.DemandeProduit;

import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DemandeProduitController {
    public static void modifDemandeProduit(DemandeProduit demandeProduit) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE DemandeProduit SET raison = ?, quantite = ?, statut = ?,ref_utilisateur=?,ref_produit = ?");
        req.setString(1,demandeProduit.getRaison());
        req.setInt(2,demandeProduit.getQuantite());
        req.setString(3,demandeProduit.getStatut());
        req.setInt(4,demandeProduit. getRef_utilisateur());
        req.setInt(5,demandeProduit.getRef_produit());
        req.executeUpdate();

    }
    public static void addDemandeProduit (DemandeProduit demandeProduit) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO DemandeProduit (raison,quantite,statut,ref_utilisateur,ref_produit) VALUES (?,?,?,?,? ) ");
        req.setString(1,demandeProduit.getRaison());
        req.setInt(2,demandeProduit.getQuantite());
        req.setString(3,demandeProduit.getStatut());
        req.setInt(4,demandeProduit. getRef_utilisateur());
        req.setInt(5,demandeProduit.getRef_produit());
        req.executeUpdate();

    }
    public static void deleteDemandeProduit(DemandeProduit demandeProduit) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM DemandeProduit Where id = ? ");
        req.executeUpdate();

    }
}
