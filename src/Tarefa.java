package br.edu.ifsp.spo.java.todolist;
import java.time.LocalDateTime;

public class Tarefa {
    private String texto;
    private boolean check;
    private LocalDateTime dataConclusao;
    
    //Construtor
    public Tarefa(String texto) {
        this.texto = texto;
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
        dataConclusao = LocalDateTime.now();
    }

    public void uncheck() {
        check = false;
        dataConclusao = null;
    }
    
    @Override
    public String toString() {
        return "[" + (check ? "X" : " ") + "] " + texto + (dataConclusao != null ? " (Atualizado em: " + dataConclusao + ")" : "");
    }
}
