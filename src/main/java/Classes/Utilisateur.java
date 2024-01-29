package Classes;

public class Utilisateur {

    private static int id;
    private String nom;
    private String prenom;
    private String email;
    private String role;
    private String mdp;


    public Utilisateur(int id, String nom, String role, String prenom, String email, String mdp) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.role=role;

    }
    public static int getId() {
        return id;
    }




    public String getNom() {
        return nom;
    }
    public String getRole() {
        return role;
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
