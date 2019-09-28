package br.com.fiap.beans;

public class Conteudo {
	private int codigo;
	private String titulo;
	private String audio;
	private Disciplina disciplina;
	private Avaliacao avaliacao;
	
	public Conteudo(int codigo, String titulo, String audio, Disciplina disciplina, Avaliacao avaliacao) {
		super();
		this.codigo = codigo;
		this.titulo = titulo;
		this.audio = audio;
		this.disciplina = disciplina;
		this.avaliacao = avaliacao;
	}
	
	public Conteudo() {
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

	public String getAudio() {
		return audio;
	}

	public void setAudio(String audio) {
		this.audio = audio;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}
}
