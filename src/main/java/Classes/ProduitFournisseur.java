package Classes;

public class ProduitFournisseur {
    private static int id;
    private int prix;
    private int ref_produit;
    private int ref_fournisseur;


    public ProduitFournisseur(int id, int prix, int ref_fournisseur, int ref_produit) {
        this.id = id;
        this.prix = prix;
        this.ref_produit = ref_produit;
        this.ref_fournisseur = ref_fournisseur;

    }
    public static int getId() {
        return id;
    }

    public  int getRef_fournisseur() {
        return ref_fournisseur;
    }

    public  int getRef_produit() {
        return ref_produit;
    }
    public int getPrix() {
        return prix;
    }
}