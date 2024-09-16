package br.com.project.estoque.domain.estoque;

import br.com.project.estoque.domain.ConnectionFactory;
import br.com.project.estoque.domain.produto.DadosProduto;
import br.com.project.estoque.domain.produto.Produto;


import java.sql.Connection;
import java.util.Set;

public class EstoqueService {

    private ConnectionFactory connection;

    public EstoqueService() {
        this.connection = new ConnectionFactory();
    }

    public void cadastrarProduto(DadosProduto dadosProduto) {
        Connection conn = connection.retrieveConnection();
        new EstoqueDAO(conn).cadastrarProduto(dadosProduto);
    }

    public Set<Produto> listarProdutos() {
        Connection conn = connection.retrieveConnection();
        return new EstoqueDAO(conn).listarProdutos();
    }

    public boolean verificarProduto(int productKey) {
        Connection conn = connection.retrieveConnection();
        boolean produtoExiste = new EstoqueDAO(conn).verificarProduto(productKey);
        if (produtoExiste) {
            return true;
        } else {
            System.out.println("O produto com o código informado não existe.");
            return false;
        }
    }

    public void atualizarProduto(int productKey, DadosProduto dadosProduto) {
        Connection conn = connection.retrieveConnection();
        new EstoqueDAO(conn).atualizarProduto(productKey, dadosProduto);
    }

    public void deletarProduto(int productKey) {
        Connection conn = connection.retrieveConnection();
        new EstoqueDAO(conn).deletarProduto(productKey);
    }
}
