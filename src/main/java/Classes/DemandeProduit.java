package Classes;

public class DemandeProduit {
    private static int id;
    private  String raison;
    private int quantite;
    private  String statut;
    private static int ref_produit;
    private static int ref_utilisateur;


    public DemandeProduit(int id, String raison, int quantite,String statut,int ref_produit, int ref_utilisateur) {
        this.id = id;
        this.raison = raison;
        this.quantite = quantite;
        this.statut = statut;
        this.ref_produit = ref_produit;
        this.ref_utilisateur=ref_utilisateur;

    }
    public static int getId() {
        return id;
    }

    public String getRaison() {
        return raison;
    }
    public String getStatut() {
        return statut;
    }
    public int getQuantite() {
        return quantite;
    }

    public static int getRef_produit() {
        return ref_produit;
    }
    public static int getRef_utilisateur() {
        return ref_utilisateur;
    }
}
