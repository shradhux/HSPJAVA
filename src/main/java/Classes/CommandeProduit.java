package Classes;

import java.sql.Date;
import java.sql.Time;

public class CommandeProduit {
    private static int id;
    private String raison;
    private String statut;

    public CommandeProduit(int id, String raison, String statut) {
        this.id= id;
        this.raison= raison;
        this.statut = statut;


    }
}
