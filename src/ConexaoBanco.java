package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Statement;

public class CriarBanco {
    String URL = "jdbc:sqlite:tarefas.db"; //Criar um arquivo
    String caminhoSQL = "src/Tarefa.sql";

    public static Connection conectar() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    public static void main(String[] args) {
        try (Connection conexao = DriverManager.getConnection(url); //conexao com o banco
             Statement stmt = conexao.createStatement(); //"statement" para executar os comandos sql
             BufferedReader reader = new BufferedReader(new FileReader(caminhoSQL))) { //le o arquivo linha por linha

            String linha;
            StringBuilder comando = new StringBuilder(); //acumula comandos até um ";"

            while ((linha = reader.readLine()) != null) {
                linha = linha.trim();
                if (!linha.isEmpty() && !linha.startsWith("--")) { //ignora comentarios e linha vazia
                    comando.append(linha); //adiciona a linha em "comando"
                    if (linha.endsWith(";")) {
                        stmt.execute(comando.toString()); //executa o comando
                        comando.setLength(0);  // limpa o comando
                    }
                }
            }

            System.out.println("Banco criado com sucesso a partir do script!");

        } catch (Exception e) {
            e.printStackTrace(); //caso de erros
        }
    }
}
