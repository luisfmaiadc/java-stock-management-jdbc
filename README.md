<h1 align="center">Projeto Java - CRUD com JDBC</h1>
<p align="center">
 <a href="#started">Começando</a> • 
  <a href="#cloning">Clonando</a> •
 <a href="#creating">Banco de Dados</a> •
 <a href="#environment">Variáveis de Ambiente</a> •
 <a href="#colab">Colaboradores</a>
</p>

<p align="center" style="margin-bottom: 20;">
    <img src="https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white" alt="Java" />
    <img src="https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white" alt="MySQL" />
    <img src="https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white" alt="Apache Maven" />
</p>

<p style="text-align: justify;">Este é um projeto de um sistema CRUD (Create, Read, Update, Delete) desenvolvido em Java, utilizando JDBC para a integração com o banco de dados MySQL. O sistema é responsável pelo gerenciamento de um estoque de produtos, permitindo o cadastro, consulta, atualização e exclusão de registros. Cada produto possui os seguintes atributos: código, nome, preço e quantidade.</p>

<h2 id="started">🚀 Começando</h2>

Antes de começar, verifique se você possui as seguintes ferramentas instaladas em sua máquina:

- [Java](https://www.oracle.com/java/technologies/downloads/#java22)
- [MySQL](https://dev.mysql.com/downloads/installer/)

<h2 id="cloning">👾 Clonando</h2>

Como clonar o projeto:
```bash
git clone git@github.com:luisfmaiadc/java-jdbcCrud.git
```

<h2 id="creating">💾 Criando Banco de Dados</h2>
Para que o projeto funcione corretamente, é necessário criar um banco de dados MySQL com o nome Estoque e uma tabela Produto. A tabela deve conter os seguintes campos:

- <b>id_produto:</b> chave primária, auto-incrementada pelo banco de dados
- <b>nome:</b> campo de texto (String)
- <b>preco:</b> campo decimal para o preço 
- <b>quantidade:</b> campo inteiro para a quantidade em estoque

```SQL
CREATE DATABASE Estoque;
USE Estoque;

CREATE TABLE Produto (
    id_produto INT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(255) NOT NULL,
    preco DECIMAL(5, 2) NOT NULL,
    quantidade INT NOT NULL,
    PRIMARY KEY (id_produto)
);
```

<h2 id="environment">💻 Configurando variáveis de ambiente</h2>

Antes de rodar o projeto, é necessário criar um arquivo .env na raiz do projeto para configurar as variáveis de ambiente responsáveis pelo acesso ao banco de dados MySQL. O arquivo deve conter as seguintes variáveis:

```env
DB_URL=jdbc:mysql://localhost:3306/nome_do_banco
DB_USER=seu_usuario
DB_PASSWORD=sua_senha
```

<h2 id="colab">🤝 Colaboradores</h2>
O projeto foi desenvolvido apenas por mim, contudo foi um trabalho desafiador e gratificante!
<table>
  <tr>
    <td align="center">
      <a href="#">
        <img src="https://avatars.githubusercontent.com/u/168129517?v=4&size=64" width="100px;" alt="Fernanda Kipper Profile Picture"/><br>
        <sub>
          <b>Luis Felipe Maia da Costa</b>
        </sub>
      </a>
    </td>
  </tr>
</table>



