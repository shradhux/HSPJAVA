package Classes;

public class Fournisseur {
    private static int id;

    private String nom;

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        Fournisseur.id = id;
    }
    public  String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {this.nom =nom;}
}
