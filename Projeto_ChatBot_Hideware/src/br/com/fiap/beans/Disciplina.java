package br.com.fiap.beans;

public class Disciplina {
	private int codigo;
	private String titulo;
	private String dataInicio;
	private String dataTermino;
	
	public Disciplina(int codigo, String titulo, String dataInicio, String dataTermino) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
	}
	
	public Disciplina() {
		super();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}
	public String getDataFim() {
		return dataTermino;
	}
	public void setDataFim(String dataTermino) {
		this.dataTermino = dataTermino;
	}
}
