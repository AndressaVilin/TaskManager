package model;
import exceptions.*;

public class TarefaPrioritaria extends Tarefas {
	
	private Prioridade prioridade;

	public TarefaPrioritaria(String titulo, String descricao, Prioridade prioridade) {
		super(titulo, descricao);
		setPrioridade(prioridade);
	}

	public Prioridade getPrioridade() {
		return prioridade;
	}

	public void setPrioridade(Prioridade prioridade) {
		if(prioridade == null) {
			throw new PrioridadeInvalidaException("A prioridade informada é inválida.");
		}
		this.prioridade = prioridade;	
	}
	
	@Override
	public String toString() {
		return super.toString() + 
				"\nPrioridade: " + prioridade;
	}

}
