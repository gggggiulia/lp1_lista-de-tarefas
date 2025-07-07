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
    private ChoiceBox<Tarefa> comboPendentes;

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
            mostrarAlerta("Campo vazio!", "Preencha o campo 'Adicionar tarefa' para adicionar uma tarefa.", Alert.AlertType.WARNING);
        }
    }

    @FXML
    public void marcarComoFeita() {
        Tarefa selecionada = comboPendentes.getSelectionModel().getSelectedItem();
        LocalDate data = campoDataConclusao.getValue();

        if (selecionada == null) {
            mostrarAlerta("Nenhuma tarefa selecionada", "Escolha uma tarefa pendente na lista para concluir.", Alert.AlertType.WARNING);
            return;
        }

        if (data == null) {
            mostrarAlerta("Data não informada", "Escolha uma data de conclusão.", Alert.AlertType.WARNING);
            return;
        }

        dao.marcarComoConcluida(selecionada, data);
        atualizarLista();
        listaTarefas.refresh();
        campoDataConclusao.setValue(null);
        comboPendentes.getSelectionModel().clearSelection();
    }

    @FXML
    public void atualizarLista() {
        listaTarefas.getItems().setAll(dao.listarTodas());
        comboPendentes.getItems().setAll(dao.listarPendentes());
        menuFiltro.setText("Todas as tarefas");
    }

    @FXML
    public void filtrarPendentes() {
        listaTarefas.getItems().setAll(dao.listarPendentes());
        comboPendentes.getItems().setAll(dao.listarPendentes());
        menuFiltro.setText("Tarefas pendentes");
    }

    @FXML
    public void filtrarConcluidas() {
        listaTarefas.getItems().setAll(dao.listarConcluidas());
        menuFiltro.setText("Tarefas concluídas");
    }

    private void mostrarAlerta(String titulo, String mensagem, Alert.AlertType tipo) {
        Alert alerta = new Alert(tipo);
        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(mensagem);
        alerta.showAndWait();
    }
}
