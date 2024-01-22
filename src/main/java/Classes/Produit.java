package Classes;

public class Produit {
    private static int id;
    private static String libelle;
    private static String description;
    private int nv_danger;
    public int stock;


    public Produit(int id,String libelle,String description, int nv_danger, int stock) {
        this.id = id;
        this.libelle = libelle;
        this.description = description;
        this.nv_danger = nv_danger;
        this.stock=stock;

    }
    public static int getId() {
        return id;
    }

    public static String getLibelle() {
        return libelle;
    }

    public static String getDescription() {
        return description;
    }
    public int getNv_danger() {
        return nv_danger;
    }
    public int getStock() {
        return stock;
    }
}

