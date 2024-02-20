package Classes;


import java.sql.Date;
import java.sql.Time;

public class Dossier {
    private static int id;
    private Date date;
    private Time heure;
    private static String symptome;
    private String gravite;
    private static int ref_utilisateur;
    private static int ref_fiche_patient;

    public Dossier(int id, Date date, Time heure, String symptome,String gravite,int ref_fiche_patient,int ref_utilisateur) {
        this.id= id;
        this.date= date;
        this.heure = heure;
        this.symptome = symptome;
        this.gravite = gravite;
        this.ref_utilisateur = ref_utilisateur;
        this.ref_fiche_patient = ref_fiche_patient;

    }
    public static int getId() {
        return id;
    }

    public Date getDate(){return date;}
    public Time getHeure(){return heure;}
    public  String getSymptome(){return symptome;}
    public  String getGravite(){return gravite;}
    public  int getRef_fiche_patient() {
        return ref_fiche_patient;
    }

    public  int getRef_utilisateur() {
        return ref_utilisateur;
    }


}
