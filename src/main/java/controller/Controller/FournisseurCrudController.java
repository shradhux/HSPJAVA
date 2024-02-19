package controller.Controller;

import Classes.Fournisseur;
import Classes.Utilisateur;
import modele.bdd.Bdd;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FournisseurCrudController {
    public static void modifFournisseur (Fournisseur fournisseur) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("UPDATE fournisseur SET nom = ?");
        req.setString(1,fournisseur.getNom());
        req.executeUpdate();

    }
    public static void addFournisseur (Fournisseur fournisseur) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("INSERT INTO fournisseur (nom) VALUES (? ) ");
        req.setString(1, fournisseur.getNom());
        req.executeUpdate();

    }
    public static void deleteFournisseur (Fournisseur fournisseur) throws SQLException {
        PreparedStatement req = new Bdd().getBdd().prepareStatement("DELETE FROM fournisseur Where id = ? ");
        req.executeUpdate();

    }




}
