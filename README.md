# SDK: Oracle OpenJDK 24.0.1

# Configuração da IDE:
File > Project Structure > Libraries
Adicione a pasta "lib” do JavaFX SDK.
Run > Edit configurations 
Na VM options:
--module-path /caminho/para/javafx-sdk-”versão”/lib --add-modules javafx.controls,javafx.fxml --enable-native-access=javafx.graphics

A pasta “resources” precisa ser marcada como “Resources Root”.

File > Project Structure > Libraries
Adicionar .jar do SQLite (na pasta lib deste respositório: sqlite-jdbc-3.36.0.3.jar);


# Recursos

Adicionar tarefas à lista;
Alternar status das tarefas (concluída ou pendente): quando a tarefa for marcada como concluída, o usuário precisa, obrigatoriamente, marcar a data de conclusão. Se a tarefa for alterada para o status "pendente" novamente, a data de conclusão será removida;
Filtrar as tarefas por: Todas as Tarefas, Tarefas Pendentes e Tarefas Concluídas.


1) Adicionar tarefas à lista
<img width="979" height="695" alt="Image" src="https://github.com/user-attachments/assets/cf12b473-538c-4efe-8374-13c6ae298763" />
<img width="999" height="712" alt="Image" src="https://github.com/user-attachments/assets/6138abee-d4d8-4d32-9fc1-3834897808f4" />
Caso o usuário clique no botão “Adicionar” com o campo vazio.

<img width="1002" height="716" alt="Image" src="https://github.com/user-attachments/assets/1a080b07-04ac-4af1-97cd-57c1eca30d09" />

2) Alternar status de tarefas existentes

    a) De concluída para pendente
<div align="center">
<img src="https://github.com/user-attachments/assets/39ca6af5-60a7-49e8-b7f9-6c3b2a80c4ee" width=704px" />
</div>

<img width="946" height="672" alt="Image" src="https://github.com/user-attachments/assets/88547c5f-00a7-4dde-8daf-fdbad6687d49" />

OBS: caso o usuário selecione uma tarefa concluída (isto é, uma tarefa que ele deseja tornar pendente) e adicione um valor no campo “Data de conclusão”, esse valor será ignorado pelo sistema.

<img width="966" height="688" alt="Image" src="https://github.com/user-attachments/assets/a8cee122-e955-4bb1-9d80-91dd3a0bcf07" />


  b) De pendente para concluída
<div align="center">
<img src="https://github.com/user-attachments/assets/a1da2381-8198-42a4-8531-0d1201fd0c3d" width=726px" />
</div>
<div align="center">
<img src="https://github.com/user-attachments/assets/e77b7155-1623-49c7-b632-862f372eb047" width=718px" />
</div>
<img width="959" height="682" alt="image" src="https://github.com/user-attachments/assets/233a9be2-0bc8-446a-9a97-5b74d7b83238" />
<img width="977" height="696" alt="image" src="https://github.com/user-attachments/assets/1d463750-7a0c-4de8-ac2a-1135e3b87f15" />

Caso o usuário clique no botão “OK” sem preencher os campos da função “Alternar status”.

<img width="976" height="699" alt="image" src="https://github.com/user-attachments/assets/b0a23215-b275-463c-be36-656a516c6eea" />


Caso o usuário não preencha apenas o campo “Data de conclusão” no momento de alternar status:

a) Tornando uma tarefa pendente em concluída:

<img width="902" height="647" alt="image" src="https://github.com/user-attachments/assets/28a3674d-a097-4082-845d-0eac8d6d55f4" />


b) Tornando uma tarefa concluída em pendente: a funcionalidade não é afetada.

3) Filtrar tarefas

a) Pendentes

<img width="732" height="526" alt="image" src="https://github.com/user-attachments/assets/af03ee1e-b62d-45c4-8407-8513a6422861" />



b) Concluídas

<img width="730" height="522" alt="image" src="https://github.com/user-attachments/assets/0aedd848-18b1-451c-a677-29103f32554a" />


