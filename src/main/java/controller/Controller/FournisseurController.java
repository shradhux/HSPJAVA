package controller.Controller;


import Classes.Fournisseur;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class FournisseurController {

    @FXML
    private TextField idField;

    @FXML
    private void ajouterFournisseur() {
        String id = idField.getText().trim();
        if (!id.isEmpty()) {
            Fournisseur fournisseur = new Fournisseur();
            // Ajoutez la logique pour ajouter le fournisseur à la liste ou à la base de données
            clearFields();
        }
    }

    @FXML
    private void mettreAJourFournisseur() {
        String id = idField.getText().trim();
        if (!id.isEmpty()) {
            Fournisseur selectedFournisseur = getSelectedFournisseur();
            if (selectedFournisseur != null) {
                selectedFournisseur.setId(Integer.parseInt(id));
                // Ajoutez la logique pour mettre à jour le fournisseur dans la liste ou à la base de données
                clearFields();
            }
        }
    }

    @FXML
    private void supprimerFournisseur() {
        Fournisseur selectedFournisseur = getSelectedFournisseur();
        if (selectedFournisseur != null) {
            // Ajoutez la logique pour supprimer le fournisseur de la liste ou de la base de données
            clearFields();
        }
    }

    private Fournisseur getSelectedFournisseur() {
        String id = idField.getText().trim();
        // Implémentez la logique pour récupérer le fournisseur en fonction de l'ID
        return null;
    }

    private void clearFields() {
        idField.clear();
    }
}
