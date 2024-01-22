package Classes;



public class CommandeProduit {
    private static int id;
    private String raison;
    private String statut;
    private static int ref_utilisateur;
    private static int ref_fournisseur;

    public CommandeProduit(int id, String raison, String statut,int ref_utilisateurr,int ref_fournisseur) {
        this.id= id;
        this.raison= raison;
        this.statut = statut;
        this.ref_utilisateur=ref_utilisateurr;
        this.ref_fournisseur = ref_fournisseur;

    }
    public static int getRef_fournisseur() {
        return ref_fournisseur;
    }

    public static int getRef_utilisateur() {
        return ref_utilisateur;
    }


}
