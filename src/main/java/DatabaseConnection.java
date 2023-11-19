import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {
    public static Connection getConnection() {
        Connection connection = null;
        try {
            String jdbcUrl = "jdbc:postgresql://localhost:5432/nom_de_la_base_de_donnees";
            String utilisateur = "votre_utilisateur";
            String motDePasse = "votre_mot_de_passe";

            connection = DriverManager.getConnection(jdbcUrl, utilisateur, motDePasse);
            System.out.println("Connexion à la base de données PostgreSQL établie avec succès.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
