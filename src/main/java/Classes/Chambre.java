package Classes;

public class Chambre {

    private static int id;

    private String numero;
    private boolean est_libre;

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setEst_libre(boolean est_libre) {
        this.est_libre = est_libre;
    }

    public static int getId() {
        return id;
    }
    public boolean getEst_libre() {
        return est_libre;
    }

}
