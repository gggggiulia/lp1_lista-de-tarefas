package org.project.Aplicacao;

import java.time.LocalDate;

public class Tarefa {
    private int id;
    private String texto;
    private boolean concluida;
    private LocalDate datadeConclusao;

    public Tarefa(int id, String texto, boolean concluida, LocalDate datadeConclusao) {
        this.id = id;
        this.texto = texto;
        this.concluida = concluida;
        this.datadeConclusao = datadeConclusao;
    }

    public Tarefa(String texto, boolean concluida, LocalDate datadeConclusao) {
        this(-1, texto, concluida, datadeConclusao); // -1 para tarefa ainda não salva
    }

    public int getId() { return id; }
    public String getTexto() { return texto; }
    public boolean isConcluida() { return concluida; }
    public LocalDate getDataDeConclusao() { return datadeConclusao; }

    @Override
    public String toString() {
        String status = concluida ? "✓" : "";
        String dataTexto = (concluida && datadeConclusao != null)
                ? " – Concluída em: " + datadeConclusao
                : "";
        return status + " " + texto + dataTexto;
    }

}
