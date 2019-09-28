package br.com.fiap.beans;

public class ExecucaoAvaliacaoAluno {
	private int codigo;
	private String resposta;
	private Avaliacao avaliacao;
	private Aluno aluno;
	private Matricula matricula;
	
	public ExecucaoAvaliacaoAluno(int codigo, String resposta, Avaliacao avaliacao, Aluno aluno, Matricula matricula) {
		super();
		this.codigo = codigo;
		this.resposta = resposta;
		this.avaliacao = avaliacao;
		this.aluno = aluno;
		this.matricula = matricula;
	}
	
	public ExecucaoAvaliacaoAluno() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getResposta() {
		return resposta;
	}

	public void setResposta(String resposta) {
		this.resposta = resposta;
	}

	public Avaliacao getAvaliacao() {
		return avaliacao;
	}

	public void setAvaliacao(Avaliacao avaliacao) {
		this.avaliacao = avaliacao;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Matricula getMatricula() {
		return matricula;
	}

	public void setMatricula(Matricula matricula) {
		this.matricula = matricula;
	}
}
