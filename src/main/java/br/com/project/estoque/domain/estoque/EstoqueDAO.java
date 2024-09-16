package br.com.project.estoque.domain.estoque;

import br.com.project.estoque.domain.produto.DadosProduto;
import br.com.project.estoque.domain.produto.Produto;

import java.math.BigDecimal;
import java.sql.*;
import java.util.HashSet;
import java.util.Set;

public class EstoqueDAO {

    private Connection connection;

    EstoqueDAO(Connection connection) {
        this.connection = connection;
    }

    public void cadastrarProduto(DadosProduto dadosProduto) {
        String sql = "INSERT INTO PRODUTO (nome, preco, quantidade) VALUES (?, ?, ?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dadosProduto.nome());
            preparedStatement.setBigDecimal(2, dadosProduto.preco());
            preparedStatement.setInt(3, dadosProduto.quantidade());
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            System.out.println("Produto cadastrado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public boolean verificarProduto(int productKey) {
        String sql = "SELECT 1 FROM PRODUTO WHERE id_produto = ?";
        boolean existe = false;

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productKey);
            ResultSet resultSet = preparedStatement.executeQuery();
             if (resultSet.next()) {
                 existe = true;
             }
             resultSet.close();
             preparedStatement.close();
             connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return existe;
    }

    public void atualizarProduto(int productKey, DadosProduto dadosProduto) {
        String sql = "UPDATE PRODUTO SET nome = ?, preco = ?, quantidade = ? WHERE id_produto = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, dadosProduto.nome());
            preparedStatement.setBigDecimal(2, dadosProduto.preco());
            preparedStatement.setInt(3, dadosProduto.quantidade());
            preparedStatement.setInt(4, productKey);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
            System.out.println("Produto atualizado com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<Produto> listarProdutos() {
        String sql = "SELECT * FROM PRODUTO";
        Set<Produto> produtos = new HashSet<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int productKey = resultSet.getInt("id_produto");
                String nome = resultSet.getString("nome");
                BigDecimal preco = resultSet.getBigDecimal("preco");
                int quantidade = resultSet.getInt("quantidade");

                DadosProduto dadosProduto = new DadosProduto(nome, preco, quantidade);
                Produto produto = new Produto(productKey, dadosProduto);
                produtos.add(produto);
            }
            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return produtos;
    }

    public void deletarProduto(int productKey) {
        String sql = "DELETE FROM PRODUTO WHERE id_produto = ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, productKey);
            preparedStatement.execute();
            preparedStatement.close();
            connection.close();
            System.out.println("Produto excluído com sucesso!");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
