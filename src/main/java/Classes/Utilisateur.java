package Classes;

public class Utilisateur {

    private static int id;
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private String mdp;
    private boolean est_admin;

    public Utilisateur(int id, String nom, String prenom, String email, String mdp,boolean est_admin) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.est_admin=est_admin;
    }
    public static int getId() {
        return id;
    }
    public boolean getEst_admin() {
        return est_admin;
    }



    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getEmail() {
        return email;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }


}
