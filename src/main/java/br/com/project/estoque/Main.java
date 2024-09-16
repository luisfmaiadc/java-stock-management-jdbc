package br.com.project.estoque;

import br.com.project.estoque.domain.estoque.EstoqueService;
import br.com.project.estoque.domain.produto.DadosProduto;

import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    private static EstoqueService service = new EstoqueService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        System.out.println("Bem vindo(a) ao projeto CRUD - Estoque com JDBC.");
        int option = menu();
        while (option != 5) {
            try {
                switch (option) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        atualizarProduto();
                        break;
                    case 3:
                        listarProdutos();
                        break;
                    case 4:
                        deletarProduto();
                        break;
                    default:
                        System.out.println("Digite uma opção válida.");
                }
            } catch (RuntimeException e) {
                throw new RuntimeException(e);
            }
            option = menu();
        }
        System.out.println("Finalizando aplicação CRUD - Estoque com JDBC.");
    }

    private static int menu() {
        System.out.println();
        System.out.println("""
                PROJETO CRUD ESTOQUE - ESCOLHA UMA OPÇÃO:
                1 - Cadastrar novo produto
                2 - Atualizar informações sobre um produto
                3 - Listar produtos cadastrados
                4 - Excluir um produto
                5 - Sair
                """);
        return scanner.nextInt();
    }

    private static void cadastrarProduto() {
        System.out.println("Digite o nome do produto.");
        String nome = scanner.next();
        System.out.println("Digite o preço do produto.");
        BigDecimal preco = scanner.nextBigDecimal();
        System.out.println("Digite a quantidade de produtos.");
        int quantidade = scanner.nextInt();
        service.cadastrarProduto(new DadosProduto(nome, preco, quantidade));
    }

    private static void atualizarProduto() {
        System.out.println("Digite o código do produto que deseja atualizar.");
        int productKey = scanner.nextInt();
        boolean produtoVerificado = service.verificarProduto(productKey);
        if (produtoVerificado) {
            System.out.println("Digite o nome do produto.");
            String nome = scanner.next();
            System.out.println("Digite o preço do produto.");
            BigDecimal preco = scanner.nextBigDecimal();
            System.out.println("Digite a quantidade de produtos.");
            int quantidade = scanner.nextInt();
            DadosProduto dadosProduto = new DadosProduto(nome, preco, quantidade);
            service.atualizarProduto(productKey, dadosProduto);
        }
    }

    private static void listarProdutos() {
        System.out.println("Relação de produtos cadastrados em Estoque.");
        var produtos = service.listarProdutos();
        produtos.stream().forEach(System.out::println);
    }

    private static void deletarProduto() {
        System.out.println("Digite o código do produto que deseja excluir.");
        int productKey = scanner.nextInt();
        boolean produtoVerificado = service.verificarProduto(productKey);
        if (produtoVerificado) {
            service.deletarProduto(productKey);
        }
    }
}
