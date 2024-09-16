package br.com.project.estoque.domain.produto;

import java.math.BigDecimal;

public class Produto {

    private int codigo;
    private String nome;
    private BigDecimal preco;
    private int quantidade;

    public Produto(int productKey,DadosProduto dados) {
        this.codigo = productKey;
        this.nome = dados.nome();
        this.preco = dados.preco();
        this.quantidade = dados.quantidade();
    }

    @Override
    public String toString() {
        return "Produto {" +
                "Código = " + codigo +
                ", Nome = " + nome +
                ", Preco = " + preco +
                ", Quantidade = " + quantidade +
                '}';
    }
}
