package app;

import java.util.Scanner;
import model.*;
import controller.TaskManager;

public class Main {

	public static void main(String[] args) {
		int opcao = 0;
		
		Scanner sc = new Scanner(System.in);
		TaskManager manager = new TaskManager();
		
		do {
			System.out.println("\n-----------------------------");
			System.out.println("===== GERENCIADOR DE TAREFAS =====");
			System.out.println("1. Criar nova tarefa");
			System.out.println("2. Criar Tarefa Prioritária");
			System.out.println("3. Marcar tarefa como concluída");
			System.out.println("4. Remover tarefa");
			System.out.println("5. Listar Tarefas");
			System.out.println("6. Sair");
			System.out.println("Escolha uma opção:");
			
			
			try {
				opcao = sc.nextInt();
				sc.nextLine();
				
				switch (opcao) {
				
				case 1: 
					System.out.print("Título: ");
					String titulo = sc.nextLine();
					
					System.out.print("Descrição: ");
					String descricao = sc.nextLine();
					
					Tarefas tarefa = new Tarefas(titulo, descricao);
					manager.adicionarTarefa(tarefa);
					
					System.out.println("Tarefa criada com sucesso!");
                    break;
                    
				case 2: 
					 System.out.print("Título: ");
                     titulo = sc.nextLine();

                     System.out.print("Descrição: ");
                     descricao = sc.nextLine();

                     try {

                    	    System.out.println("Digite a prioridade (MEDIA ou ALTA): ");
                    	    String entrada = sc.nextLine();

                    	    Prioridade prioridade = Prioridade.valueOf(entrada.toUpperCase());

                    	    TarefaPrioritaria tarefaP =
                    	            new TarefaPrioritaria(titulo, descricao, prioridade);
                    	    
                    	    manager.adicionarTarefa(tarefaP);

                    	    System.out.println("Tarefa prioritária criada com sucesso!");

                    	} catch (IllegalArgumentException e) {

                    	    System.out.println("Prioridade inválida! Use MEDIA ou ALTA.");

                    	}
					break;
					
				case 3: 
					System.out.print("Digite o ID da tarefa: ");
                    int idConclusao = sc.nextInt();
                    sc.nextLine();
                    
                    if(manager.concluirTarefa(idConclusao)) {
                    	System.out.println("Tarefa concluída com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;
                    
				case 4: 
					System.out.print("Digite o ID da tarefa: ");
                    int idRemover = sc.nextInt();
                    sc.nextLine();
                    
                    if(manager.removerTarefa(idRemover)) {
                    	System.out.println("Tarefa removida com sucesso!");
                    } else {
                        System.out.println("Tarefa não encontrada.");
                    }
                    break;
                    
				case 5: 
					manager.listarTarefas();
					break;
                
				case 6: 
					System.out.println("Encerrando sistema...");
				    break;   
				    
				default:
				    System.out.println("Opção inválida.");
				}
				
			} catch(Exception e) {
				System.out.println("Entrada inválida.");
			    sc.nextLine();
			}
			
		} while (opcao != 6);
		sc.close();
	}

}
