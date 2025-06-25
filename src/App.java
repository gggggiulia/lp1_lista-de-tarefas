package src;

public class App{
  //Imprimir lista de tarefas e mostrar menu embaixo
  public static void main (String[] args){
    BuscaSQL buscaSQL = new BuscaSQL();

    System.out.println("Lista de tarefas");
    for(Tarefa tarefa : BuscaSQL.buscarTudo()){
      System.out.println(tarefa);
    }

    System.out.println("\nOpcões");
    System.out.println("1. Cadastrar uma nova tarefa");
    System.out.println("2. Editar uma tarefa");
    System.out.println("3. Alterar status de uma tarefa");
    System.out.println("4. Filtrar tarefas");
  }
}
