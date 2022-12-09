package trabalho1;

import exercicio1.Produto;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciamento extends Moto {

    public static Moto inserirDadosMotos() {
        Scanner sc = new Scanner(System.in);
        Moto moto = new Moto();

        System.out.println("Marca: ");
        moto.setMarca(sc.nextLine());

        System.out.println("Modelo: ");
        moto.setModelo(sc.nextLine());

        System.out.println("Cor: ");
        moto.setCor(sc.nextLine());

        System.out.println("Ano: ");
        moto.setAno(sc.nextInt());

        return moto;

    }

    public static void cadastrarMoto() {

        Moto moto = inserirDadosMotos();

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

    public static List<Moto> listarMotos() {
        String sql = "SELECT * FROM moto";
        List<Moto> motos = null;

        Connection connection = ConnectionFactory.getConnection();

        try {

            PreparedStatement myStmt = connection.prepareStatement(sql);

            ResultSet result = myStmt.executeQuery();

            motos = new ArrayList<>();

            while (result.next()) {

                Moto moto = new Moto();
                moto.setId(result.getInt("id"));
                moto.setMarca(result.getString("marca"));
                moto.setModelo(result.getString("modelo"));
                moto.setCor(result.getString("cor"));
                moto.setAno(result.getInt("ano"));

                motos.add(moto);

            }

            myStmt.close();
            connection.close();
            result.close();
        } catch (SQLException e) {
            System.out.println("Erro ao listar motos: " + e);
        }
        return motos;
    }

    public static void consultarMoto() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Informe o ID da moto a ser consultada: ");
        int id = sc.nextInt();

        String sql = "SELECT * FROM moto WHERE id = ?";

        Connection connection = ConnectionFactory.getConnection();

        try {
            PreparedStatement myStmt = connection.prepareStatement(sql);

            myStmt.setInt(1, id);

            ResultSet result = myStmt.executeQuery();

            while (result.next()) {
                System.out.println("\nMoto = {\n\tid: " + result.getInt("id")
                        + "\n\tmarca: " + result.getString("marca")
                        + "\n\tmodelo: " + result.getString("modelo")
                        + "\n\tcor: " + result.getString("cor")
                        + "\n\tano: " + result.getInt("ano") + "\n}");
            }

            myStmt.close();
            connection.close();
            result.close();
        } catch (SQLException e) {
            System.out.println("Erro ao consultar moto: " + e);
        }

    }

    public static void atualizarMoto() {

        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o ID da moto a ser atualizada: ");
        int id = sc.nextInt();

        Moto moto = inserirDadosMotos();
        moto.setId(id);

        String sql = "UPDATE moto SET marca = ?, modelo = ?, cor = ?, ano = ? WHERE id = ?";

        Connection connection = ConnectionFactory.getConnection();

        try {

            PreparedStatement myStmt = connection.prepareStatement(sql);

            myStmt.setString(1, moto.getMarca());
            myStmt.setString(2, moto.getModelo());
            myStmt.setString(3, moto.getCor());
            myStmt.setInt(4, moto.getAno());
            myStmt.setInt(5, moto.getId());

            int result = myStmt.executeUpdate();

            if (result != 0) {
                System.out.println("\nInformações atualizadas com sucesso!\nNovos dados: ");
                System.out.println("\nMoto = \n\tmarca: " + moto.getMarca()
                        + "\n\tmodelo: " + moto.getModelo()
                        + "\n\tcor: " + moto.getCor()
                        + "\n\tano: " + moto.getAno() + "\n}");

            }
            connection.close();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e);
        }
    }

    public static void exluirMoto() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Informe o ID da moto a ser excluida: ");
        int id = sc.nextInt();

        String sql = "DELETE FROM moto WHERE id = ?";

        Connection connection = ConnectionFactory.getConnection();

        try {

            PreparedStatement myStmt = connection.prepareStatement(sql);

            myStmt.setInt(1, id);

            int result = myStmt.executeUpdate();
            if (result != 0) {
                System.out.println("Cadastro excluido com sucesso!");
            }

            myStmt.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Erro ao exluir: " + e);
        }
    }
}
