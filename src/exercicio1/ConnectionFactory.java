package exercicio1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/bd_produtos?useTimezone=true&serverTimezone=America/Sao_Paulo";
        String user = "root";
        String pass = "root";

        try {
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Erro de SQLException: " + e);

        }

        return null;
    }
}
