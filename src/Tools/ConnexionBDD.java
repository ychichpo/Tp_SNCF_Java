package Tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.TimeZone;

public class ConnexionBDD
{
    private static Connection cnx;

    public ConnexionBDD() throws ClassNotFoundException, SQLException {
        String pilote = "com.mysql.cj.jdbc.Driver";
        // chargement du pilote
        Class.forName(pilote);
        // DATABASE_URL="mysql://root@127.0.0.1:3306/helport?serverVersion=8.0.32&charset=utf8mb4"


        // L'objet connexion à la BDD avec le nom de la base, le user et le password
        cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/sncf",
                "root", "");
    }
    public static Connection getCnx() {
        return cnx;
    }
}
