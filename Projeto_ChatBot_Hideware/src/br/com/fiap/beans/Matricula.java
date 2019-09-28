package br.com.fiap.beans;

public class Matricula {
	private int rm;
	private String dataInicio;
	private String dataTermino;
	private Aluno aluno;
	private Disciplina disciplina;
	
	public Matricula(int rm, String dataInicio, String dataTermino, Aluno aluno, Disciplina disciplina) {
		super();
		this.rm = rm;
		this.dataInicio = dataInicio;
		this.dataTermino = dataTermino;
		this.aluno = aluno;
		this.disciplina = disciplina;
	}
	
	public Matricula() {
		super();
	}

	public int getRm() {
		return rm;
	}

	public void setRm(int rm) {
		this.rm = rm;
	}

	public String getDataInicio() {
		return dataInicio;
	}

	public void setDataInicio(String dataInicio) {
		this.dataInicio = dataInicio;
	}

	public String getDataTermino() {
		return dataTermino;
	}

	public void setDataTermino(String dataTermino) {
		this.dataTermino = dataTermino;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
	}
}
