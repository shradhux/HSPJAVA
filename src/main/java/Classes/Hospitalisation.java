package Classes;

import java.util.Date;

public class Hospitalisation {
    private static int id;
    private static Date date_prise_en_charge;
    private String desciption_de_la_maladie;
    private static int ref_dossier;

    public Hospitalisation(int id, Date date_prise_en_charge, String desciption_de_la_maladie, int ref_dossier) {
        this.id = id;
        this.date_prise_en_charge = date_prise_en_charge;
        this.desciption_de_la_maladie = desciption_de_la_maladie;
        this.ref_dossier = ref_dossier;

    }
    public static int getId() {
        return id;
    }

    public Date getDate_prise_en_charge() {
        return date_prise_en_charge;
    }

    public String getDescription_de_la_maladie() {
        return desciption_de_la_maladie;
    }
    public static int getRef_dossier() {
        return ref_dossier;
    }


}
