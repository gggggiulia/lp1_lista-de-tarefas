package org.project.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {
    private static DataBase instance;
    private Connection connection;

    private DataBase() {
        try {
            Class.forName("org.sqlite.JDBC");
            String url = "jdbc:sqlite:data/lista_de_tarefas.db";
            connection = DriverManager.getConnection(url);
            System.out.println("Conexão com o banco estabelecida com sucesso.");
            criarTabelaTarefaSeNaoExistir();
        } catch (SQLException | ClassNotFoundException e) {
            System.err.println("Erro ao conectar com o banco de dados: " + e.getMessage());
            connection = null;
        }
    }

    public static DataBase getInstance() {
        if (instance == null) {
            instance = new DataBase();
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }

    private void criarTabelaTarefaSeNaoExistir() {
        String sql = """
            CREATE TABLE IF NOT EXISTS tarefa (
                id INTEGER PRIMARY KEY AUTOINCREMENT,
                texto TEXT NOT NULL,
                concluida BOOLEAN,
                datadeConclusao DATE
            );
        """;

        try (Statement stmt = connection.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.err.println("Erro ao criar tabela: " + e.getMessage());
        }
    }
}