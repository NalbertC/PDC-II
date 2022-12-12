package trabalho1;

import java.sql.*;


/*
CREATE SCHEMA bd_gestao_motos;

USE bd_gestao_motos;

CREATE TABLE moto(
	id INT NOT NULL AUTO_INCREMENT,
	marca VARCHAR(20) NOT NULL,
	modelo VARCHAR(50)NOT NULL,
	cor VARCHAR(20) NOT NULL,
	ano INT(4) NOT NULL,
	PRIMARY KEY(id));
 */

public class ConnectionFactory {

    public static Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/bd_gestao_motos?useTimezone=true&serverTimezone=America/Sao_Paulo";
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
