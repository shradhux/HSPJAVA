package modele.bdd;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Bdd {

    private Connection connection;

    public Connection getBdd(){
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javafx_hsp","root", "");
            return connection;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}