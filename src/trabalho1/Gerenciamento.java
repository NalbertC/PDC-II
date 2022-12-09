package trabalho1;

import exercicio1.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciamento extends Moto {

    public static void cadastrarMoto() {
        Scanner sc = new Scanner(System.in);
        Moto moto = new Moto();

        System.out.println("Marca: ");
        String marca = sc.nextLine();
        moto.setMarca(marca);

        System.out.println("Modelo: ");
        String modelo = sc.nextLine();
        moto.setModelo(modelo);

        System.out.println("Cor: ");
        String cor = sc.nextLine();
        moto.setCor(cor);

        System.out.println("Ano: ");
        int ano = sc.nextInt();
        moto.setAno(ano);

        String url = "INSERT INTO moto (marca,modelo,cor,ano) VALUES (?,?,?,?)";

        Connection connection = ConnectionFactory.getConnection();

        try {

            PreparedStatement myStmt = connection.prepareStatement(url);

            myStmt.setString(1, moto.getMarca());
            myStmt.setString(2, moto.getModelo());
            myStmt.setString(3, moto.getCor());
            myStmt.setInt(4, moto.getAno());

            int result = myStmt.executeUpdate();

            if (result != 0) {
                System.out.println("\nMoto cadastrada com sucesso!");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("\nErro a cadastrar moto: " + e);
        }
    }

    public static List<Moto> consultarMoto() {
        String sql = "SELECT * FROM moto";
        List<Moto> motos = null;

        Connection connection = ConnectionFactory.getConnection();

        try {

            Statement statement = connection.createStatement();

            ResultSet rs = statement.executeQuery(sql);

            motos = new ArrayList<>();

            while (rs.next()) {

                Moto moto = new Moto();
                moto.setId(rs.getInt("id"));
                moto.setMarca(rs.getString("marca"));
                moto.setModelo(rs.getString("modelo"));
                moto.setCor(rs.getString("cor"));
                moto.setAno(rs.getInt("ano"));

                motos.add(moto);

            }

            statement.close();
            connection.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return motos;
    }
}
