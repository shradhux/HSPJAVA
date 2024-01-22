package Classes;

public class FichePatient {
    private static int id_fiche_patient;
    private String nom;
    private String prenom;
    private String email;
    private int num_securite_social;
    private String telephone;
    private String rue;
    private String code_postal;
    private String ville;
    private static int ref_utilisateur;

    public FichePatient(int id_fiche_patient, String nom, String prenom, String email,int num_securite_social,String telephone,String rue,String code_postal,String ville,int ref_utilisateur) {
        this.id_fiche_patient = id_fiche_patient;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.num_securite_social= num_securite_social;
        this.telephone=telephone;
        this.rue=rue;
        this.code_postal= code_postal;
        this.ville = ville;
        this.ref_utilisateur=ref_utilisateur;

    }
    public static int getId() {
        return id_fiche_patient;
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
    public int getNum_securite_social() {
        return num_securite_social;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getRue(){return rue;}
    public String getCode_postal(){return code_postal;}
    public String getVille(){return ville;}
    public static int getRef_utilisateur() {
        return ref_utilisateur;
    }
}
