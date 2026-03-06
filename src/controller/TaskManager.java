package controller;
import java.util.ArrayList;
import java.util.List;

import model.*;

public class TaskManager {
	
	private List<Tarefas> tarefas;

	public TaskManager() {
		this.tarefas = new ArrayList<>();
	}
	
	public void adicionarTarefa(Tarefas tarefa) {
		tarefas.add(tarefa);
	}
	
	public boolean removerTarefa(int id) {
		
		return tarefas.removeIf(t -> t.getId() == id);
		
	}
	
	public void listarTarefas() {
		
		if (tarefas.isEmpty()) {
	        System.out.println("Nenhuma tarefa cadastrada.");
	        return;
	    }
		
		for(Tarefas t : tarefas) {
			System.out.println("--------------");
			System.out.println(t);
			}
	}
	
	public boolean concluirTarefa(int id) {

	    for (Tarefas t : tarefas) {

	        if (t.getId() == id) {

	            if (!t.isConcluido()) {
	                t.setConcluido(true);
	            }

	            return true;
	        }
	    }

	    return false;
	}
	
}
