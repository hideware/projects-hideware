package br.com.fiap.beans;

public class HistoricoProgresso {
	private int codigo;
	private int estrelas;
	private int status;
	private Disciplina disciplina;
	private Aluno aluno;
	private Matricula matricula;
	private Conteudo conteudo;
	
	public HistoricoProgresso(int codigo, int estrelas, int status, Disciplina disciplina, 
			Aluno aluno, Matricula matricula, Conteudo conteudo) {
		super();
		this.codigo = codigo;
		this.estrelas = estrelas;
		this.status = status;
		this.disciplina = disciplina;
		this.aluno = aluno;
		this.matricula = matricula;
		this.conteudo = conteudo;
	}
	
	public HistoricoProgresso() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public int getEstrelas() {
		return estrelas;
	}

	public void setEstrelas(int estrelas) {
		this.estrelas = estrelas;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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

	public Conteudo getConteudo() {
		return conteudo;
	}

	public void setConteudo(Conteudo conteudo) {
		this.conteudo = conteudo;
	}
}
