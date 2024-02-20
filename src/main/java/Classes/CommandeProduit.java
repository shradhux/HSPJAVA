package Classes;



public class CommandeProduit {
    private static int id;
    private  String raison;
    private  String statut;
    private  int ref_utilisateur;
    private int ref_fournisseur;

    public CommandeProduit(int id, String raison, String statut,int ref_utilisateur,int ref_fournisseur) {
        this.id= id;
        this.raison= raison;
        this.statut = statut;
        this.ref_utilisateur=ref_utilisateur;
        this.ref_fournisseur = ref_fournisseur;

    }
    public static int getId() {
        return id;
    }
    public int getRef_fournisseur() {
        return ref_fournisseur;
    }

    public  int getRef_utilisateur() {
        return ref_utilisateur;
    }
    public  String getRaison() {
        return raison;
    }
    public String getStatut() {
        return statut;
    }



}
