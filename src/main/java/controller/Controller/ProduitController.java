package controller.Controller;
import Classes.Produit;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ProduitController {

    public static void modifProduit (Produit produit) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE produit SET libelle = ?,description =?,nv_danger=?,stock=?");
        req.setString(1, Produit.getLibelle());
        req.setString(2, Produit.getDescription());
        req.setInt(3,produit.getNv_danger());
        req.setInt(4,produit.getStock());
        req.executeUpdate();

    }
    public static void addProduit (Produit produit) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO produit (libelle,description,nv_danger,stock) VALUES (?,?,?,? ) ");
        req.setString(1, Produit.getLibelle());
        req.setString(2, Produit.getDescription());
        req.setInt(3,produit.getNv_danger());
        req.setInt(4,produit.getStock());
        req.executeUpdate();

    }
    public static void deleteProduit (Produit produit) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM produit Where id = ? ");
        req.executeUpdate();

    }

}
