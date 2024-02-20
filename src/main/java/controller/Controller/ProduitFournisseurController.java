package controller.Controller;
import Classes.ProduitFournisseur;
import modele.bdd.Bdd;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProduitFournisseurController {
    public static void modifFournisseurChambre (ProduitFournisseur produitFournisseur) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE fournisseur SET prix = ? , ref_produit = ?, ref_fournisseur=?");
        req.setInt(1,produitFournisseur.getPrix());
        req.setInt(2,produitFournisseur.getRef_produit());
        req.setInt(3,produitFournisseur.getRef_fournisseur());
        req.executeUpdate();

    }
    public static void addChambre (ProduitFournisseur produitFournisseur) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO fournisseur (prix,ref_produit,ref_fournisseur) VALUES (?,?,? ) ");
        req.setInt(1,produitFournisseur.getPrix());
        req.setInt(2,produitFournisseur.getRef_produit());
        req.setInt(3,produitFournisseur.getRef_fournisseur());
        req.executeUpdate();

    }
    public static void deleteChambre (ProduitFournisseur produitFournisseur) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM fournisseur Where id = ? ");
        req.executeUpdate();

    }
}
