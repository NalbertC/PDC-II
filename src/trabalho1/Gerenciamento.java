package trabalho1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Gerenciamento {

    public static void cadastrarMoto() {

        Scanner sc = new Scanner(System.in);
        System.out.println("Digite a marca da moto: ");
        String marca = sc.nextLine();
        System.out.println("Digite o modelo da moto: ");
        String modelo = sc.nextLine();
        System.out.println("Digite a cor da moto: ");
        String cor = sc.nextLine();
        System.out.println("Digite o ano da moto: ");
        int ano = sc.nextInt();
        sc.nextLine();

        Moto moto = new Moto.MotoBuilder()
                .marca(marca)
                .modelo(modelo)
                .cor(cor)
                .ano(ano)
                .build();

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

                Moto moto = new Moto.MotoBuilder()
                        .id(result.getInt("id"))
                        .marca(result.getString("marca"))
                        .modelo(result.getString("modelo"))
                        .cor(result.getString("cor"))
                        .ano(result.getInt("ano"))
                        .build();

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
        sc.nextLine();
        System.out.println("Digite a marca da moto: ");
        String marca = sc.nextLine();
        System.out.println("Digite o modelo da moto: ");
        String modelo = sc.nextLine();
        System.out.println("Digite a cor da moto: ");
        String cor = sc.nextLine();
        System.out.println("Digite o ano da moto: ");
        int ano = sc.nextInt();
        sc.nextLine();

        String sql = "UPDATE moto SET marca = ?, modelo = ?, cor = ?, ano = ? WHERE id = ?";

        Connection connection = ConnectionFactory.getConnection();

        try {

            PreparedStatement myStmt = connection.prepareStatement(sql);

            myStmt.setString(1, marca);
            myStmt.setString(2, modelo);
            myStmt.setString(3, cor);
            myStmt.setInt(4, ano);
            myStmt.setInt(5, id);

            int result = myStmt.executeUpdate();

            if (result != 0) {
                System.out.println("\nInformações atualizadas com sucesso!\nNovos dados: ");
                System.out.println("\nMoto = \n\tmarca: " + marca
                        + "\n\tmodelo: " + modelo
                        + "\n\tcor: " + cor
                        + "\n\tano: " + ano + "\n}");
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
