package model;
import exceptions.*;

public class Tarefas {
	
	protected String titulo;
	protected String descricao;
	protected boolean concluido;
	protected int id;
	private static int contador = 1;
	
	public Tarefas(String titulo, String descricao) {
		this.id = contador++;
		setTitulo(titulo);
		setDescricao(descricao);
		this.concluido = false;
	}

	public String getTitulo() {
		 return titulo;
	}

	public void setTitulo(String titulo) {
		if (titulo != null && !titulo.isEmpty()) {
            this.titulo = titulo;
        } else {
            throw new TituloInvalidoException("Titulo inválido");
        }
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		if (descricao != null && !descricao.isEmpty()) {
            this.descricao = descricao;
        } else {
            throw new DescricaoInvalidaException("Descrição inválida");
        }
	}
	

	public int getId() {
		return id;
	}

	public boolean isConcluido() {
		return concluido;
	}
	
	public void setConcluido(boolean concluido) {
		this.concluido = concluido;
	}

	public String toString() {
	        return "ID: " + id + 
	        	   "\nTítulo: " + titulo +
		           "\nDescrição: " + descricao +
		           "\nConcluído: " + (concluido ? "Sim" : "Não");
	}
	
}
