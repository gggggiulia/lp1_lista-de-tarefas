package src;
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

    public void setTexto(String novoTexto) {
        this.texto = novoTexto;
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

    public void cadastrarTarefa() {
        System.out.print("Qual tarefa você deseja adicionar hoje? ");
        this.texto = scanner.nextLine();

    }
    
    @Override
    public String toString() {
        return "[" + (check ? "X" : " ") + "] " + texto + (dataConclusao != null ? " (Concluído em: " + dataConclusao + ")" : "");
    }
}
