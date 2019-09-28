package br.com.fiap.beans;

public class Avaliacao {
	private int codigo;
	private String titulo;
	private Disciplina disciplina;
	private Conteudo conteudo;
	
	public Avaliacao(int codigo, String titulo, Disciplina disciplina, Conteudo conteudo) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.disciplina = disciplina;
		this.conteudo = conteudo;
	}
	
	public Avaliacao() {
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
	public Disciplina getDisciplina() {
		return disciplina;
	}
	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
	public Conteudo getConteudo() {
		return conteudo;
	}
	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
}
