package br.edu.ifsp.spo.java.todolist;

public class Tarefa {
    private String texto;
    private boolean concluido;
    private LocalDateTime dataConclusao;
    
    //Construtor
    public Tarefa(String descricao) {
        this.descricao = descricao;
        this.concluido = false;
        this.dataConclusao = null;
    }

    public String getTexto() {
        return texto;
    }

    public boolean isConcluido() {
        return check;
    }

    public LocalDateTime getDataConclusao() {
        return dataConclusao;
    }

    public void check() {
        check = true;
    }

    public void uncheck() {
        check = false;
        dataConclusao = null;
    }
}
