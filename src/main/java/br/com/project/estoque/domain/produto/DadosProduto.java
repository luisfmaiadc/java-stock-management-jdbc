package br.com.project.estoque.domain.produto;

import java.math.BigDecimal;

public record DadosProduto(String nome, BigDecimal preco, int quantidade) {}
