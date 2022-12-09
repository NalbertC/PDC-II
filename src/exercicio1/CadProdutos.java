package exercicio1;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CadProdutos {

    public static void main(String[] args) {

//        Produto p = new Produto();
////        p.setId(1);
//        p.setNome("Fita de Led");
//        p.setDescricao("RGB Multicolorido 5M");
//        p.setFornecedor("Shein");
//        p.setPreco((float) 13.75);
////        CRUD
//        inserirProduto(p);
        System.out.println(consultarProdutos());

    }

    public static void inserirProduto(Produto p) {
        String sql = "INSERT INTO produto (nome, descricao, fornecedor, preco) "
                + "VALUES ('" + p.getNome() + "', '" + p.getDescricao() + "', "
                + "'" + p.getFornecedor() + "', '" + p.getPreco() + "')";

        Connection connection = ConnectionFactory.getConnection();

        try {
            try ( Statement statement = connection.createStatement()) {
                int result = statement.executeUpdate(sql);

                if (result != 0) {
                    System.out.println("Produto cadastrado com sucesso!");
                }
            }
            connection.close();

        } catch (SQLException e) {
            System.out.println("Erro ao cadastrar produto: " + e);
        }
    }

    public static void atualizarProduto(Produto p) {
        String sql = "UPDATE produto SET nome = '" + p.getNome() + "', descricao = '" + p.getDescricao() + "', fornecedor = '" + p.getFornecedor() + "', preco = '" + p.getPreco() + "' WHERE id = " + p.getId();

        Connection connection = ConnectionFactory.getConnection();

        try {

            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);

            if (result != 0) {
                System.out.println("Produto atualizado com sucesso!");
            }

            connection.close();

        } catch (SQLException e) {
            System.out.println("Erro ao atualizar produto: " + e);
        }
    }

    public static void exluirProduto(Produto p) {
        String sql = "DELETE FROM produto WHERE id = " + p.getId();

        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement statement = connection.createStatement();
            int result = statement.executeUpdate(sql);

            if (result != 0) {
                System.out.println("Produto exluÃ­do com sucesso!");
            }

            statement.close();
            connection.close();

        } catch (SQLException e) {
            System.out.println("Erro ao exluir produto: " + e);
        }
    }

    public static List<Produto> consultarProdutos() {
        String sql = "SELECT * FROM produto";
        List<Produto> produtos = null;

        Connection connection = ConnectionFactory.getConnection();

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(sql);
            produtos = new ArrayList<>();
            while (rs.next()) {
                Produto produto = new Produto();
                produto.setId(rs.getInt("id"));
                produto.setNome(rs.getString("nome"));
                produto.setDescricao(rs.getString("descricao"));
                produto.setFornecedor(rs.getString("fornecedor"));
                produto.setPreco(rs.getInt("preco"));

                produtos.add(produto);
            }

            statement.close();
            connection.close();
            rs.close();
        } catch (SQLException e) {
            System.out.println("Erro: " + e);
        }
        return produtos;
    }
}
