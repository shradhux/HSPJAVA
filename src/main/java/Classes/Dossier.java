package Classes;

import sun.util.calendar.LocalGregorianCalendar;

import java.sql.Date;
import java.sql.Time;

public class Dossier {
    private static int id;
    private Date date;
    private Time heure;
    private String symptome;
    private String gravite;

    public Dossier(int id, Date date, Time heure, String symptome,String gravite) {
        this.id= id;
        this.date= date;
        this.heure = heure;
        this.symptome = symptome;
        this.gravite = gravite;

    }
    public static int getId() {
        return id;
    }

    public Date getDate(){return date;}
    public Time getHeure(){return heure;}
    public String getSymptome(){return symptome;}
    public String getGravite(){return gravite;}


}
