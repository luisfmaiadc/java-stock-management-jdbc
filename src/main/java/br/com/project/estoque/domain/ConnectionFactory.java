package br.com.project.estoque.domain;

import java.sql.Connection;
import java.sql.SQLException;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import io.github.cdimascio.dotenv.Dotenv;

public class ConnectionFactory {

    private final Dotenv dotenv = Dotenv.load(); //Carregando credenciais do BD com variáveis de ambiente

    public Connection retrieveConnection() {
        try {
            return createDataSource().getConnection();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    private HikariDataSource createDataSource() {
        HikariConfig config = new HikariConfig();
        config.setJdbcUrl(dotenv.get("DB_URL"));
        config.setUsername(dotenv.get("DB_USER"));
        config.setPassword(dotenv.get("DB_PASSWORD"));
        config.setMaximumPoolSize(Integer.parseInt(dotenv.get("DB_POOLSIZE")));
        return new HikariDataSource(config);
    }
}
