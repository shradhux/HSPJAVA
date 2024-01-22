package Classes;

public class LesCommandesDeProduit {
    private static int id;
    private int quantite;
    private static int ref_commande_produit;
    private static int ref_produit;

    public LesCommandesDeProduit(int id, int quantite,int ref_commande_produit,int ref_produit) {
        this.id= id;
        this.quantite= quantite;
        this.ref_commande_produit = ref_commande_produit;
        this.ref_produit=ref_produit;

    }

    public static int getId() {
        return id;
    }

    public static int getRef_commande_produit() {
        return ref_commande_produit;
    }

    public static int getRef_produit() {
        return ref_produit;
    }
    public int getQuantite() {
        return quantite;
    }



}
