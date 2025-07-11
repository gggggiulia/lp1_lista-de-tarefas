package org.project.DAO;

import org.project.Aplicacao.Tarefa;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class TarefaDAO {
    private Connection con;

    public TarefaDAO(Connection con) {
        this.con = con;
    }

    public void adicionarTarefa(Tarefa tarefa) {
        String sql = "INSERT INTO tarefa (texto, concluida, datadeConclusao) VALUES (?, ?, ?)";

        try (PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, tarefa.getTexto());
            stmt.setBoolean(2, tarefa.isConcluida());

            if (tarefa.getDataDeConclusao() != null) {
                stmt.setDate(3, Date.valueOf(tarefa.getDataDeConclusao()));
            } else {
                stmt.setNull(3, Types.DATE);
            }

            stmt.executeUpdate();

            try (ResultSet rs = stmt.getGeneratedKeys()) {
                if (rs.next()) {
                    int idGerado = rs.getInt(1);
                    tarefa.setId(idGerado);
                    System.out.println("Tarefa salva com sucesso. ID: " + idGerado);
                }
            }

        } catch (SQLException e) {
            System.err.println("Erro ao salvar tarefa: " + e.getMessage());
        }
    }

    public void atualizarStatus(Tarefa tarefa, boolean concluida, LocalDate dataConclusao) {
        String sql = "UPDATE tarefa SET concluida = ?, datadeConclusao = ? WHERE id = ?";

        try (PreparedStatement stmt = con.prepareStatement(sql)) {
            stmt.setBoolean(1, concluida);

            if (concluida && dataConclusao != null) {
                stmt.setDate(2, Date.valueOf(dataConclusao));
            } else {
                stmt.setNull(2, Types.DATE);
            }

            stmt.setInt(3, tarefa.getId());
            stmt.executeUpdate();

            System.out.println("Status da tarefa atualizado: " + (concluida ? "Concluída" : "Pendente"));
        } catch (SQLException e) {
            System.err.println("Erro ao atualizar status da tarefa: " + e.getMessage());
        }
    }

    public List<Tarefa> listarTodas() {
        return listarPorQuery("SELECT * FROM tarefa");
    }

    public List<Tarefa> listarPendentes() {
        return listarPorQuery("SELECT * FROM tarefa WHERE concluida = 0");
    }

    public List<Tarefa> listarConcluidas() {
        return listarPorQuery("SELECT * FROM tarefa WHERE concluida = 1");
    }

    private List<Tarefa> listarPorQuery(String sql) {
        List<Tarefa> tarefas = new ArrayList<>();

        try (PreparedStatement stmt = con.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            while (rs.next()) {
                int id = rs.getInt("id");
                String texto = rs.getString("texto");
                boolean concluida = rs.getBoolean("concluida");
                Date data = rs.getDate("datadeConclusao");
                LocalDate dataConclusao = data != null ? data.toLocalDate() : null;

                Tarefa t = new Tarefa(id, texto, concluida, dataConclusao);
                tarefas.add(t);
            }
        } catch (SQLException e) {
            System.err.println("Erro ao listar tarefas: " + e.getMessage());
        }

        return tarefas;
    }
}
