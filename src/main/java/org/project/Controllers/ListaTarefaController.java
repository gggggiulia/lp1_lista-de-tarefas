//Alterações

package org.project.Controllers;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import org.project.Aplicacao.Tarefa;
import org.project.DAO.TarefaDAO;
import org.project.Database.DataBase;

import java.time.LocalDate;

public class ListaTarefasController {

    @FXML
    private TextField campoTexto;

    @FXML
    private ListView<Tarefa> listaTarefas;

    @FXML
    private DatePicker campoDataConclusao;

    @FXML
    private SplitMenuButton menuFiltro;

    @FXML
    private ChoiceBox<Tarefa> comboTarefas;

    private TarefaDAO dao;

    @FXML
    public void initialize() {
        dao = new TarefaDAO(DataBase.getInstance().getConnection());
        atualizarLista();
    }

    @FXML
    public void adicionarTarefa() {
        String texto = campoTexto.getText();
        if (texto != null && !texto.isBlank()) {
            Tarefa nova = new Tarefa(texto, false, null);
            dao.adicionarTarefa(nova);
            atualizarLista();
            campoTexto.clear();
        }else{
            mostrarAlerta("Preencha o campo para adicionar uma tarefa.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void alternarStatusTarefa() {
        Tarefa selecionada = comboTarefas.getValue();
        if (selecionada == null) {
            mostrarAlerta("Escolha uma tarefa listada para alterar o status.", Alert.AlertType.WARNING);
            return;
        }

        if (selecionada.isConcluida()) {
            dao.atualizarStatus(selecionada, false, null);
        } else {
            LocalDate data = campoDataConclusao.getValue();
            if (data == null) {
                mostrarAlerta("Informe a data de conclusão.", Alert.AlertType.WARNING);
                return;
            }
            dao.atualizarStatus(selecionada, true, data);
        }

        atualizarLista();
        campoDataConclusao.setValue(null);
        comboTarefas.setValue(null);
    }

    @FXML
    public void atualizarLista() {
        listaTarefas.getItems().setAll(dao.listarTodas());
        comboTarefas.getItems().setAll(dao.listarTodas());
        menuFiltro.setText("Todas as tarefas");
    }

    @FXML
    public void filtrarPendentes() {
        listaTarefas.getItems().setAll(dao.listarPendentes());
        comboTarefas.getItems().setAll(dao.listarPendentes());
        menuFiltro.setText("Tarefas pendentes");
    }

    @FXML
    public void filtrarConcluidas() {
        listaTarefas.getItems().setAll(dao.listarConcluidas());
        menuFiltro.setText("Tarefas concluídas");
    }

    private void mostrarAlerta(String mensagem, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle("Aviso");
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
