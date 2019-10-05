package br.com.fiap.beans;

public class Aluno {
	private int codigo;
	private String nome;
	private String email;
	private String cpf;
	private String dataNascimento;
	private String senha;
	private long numeroCelular;
	private String faculdade;
	private long telefone;
	private String sexo;
	private String endereco;
	
	public Aluno(int codigo, String nome, String email, String cpf, String dataNascimento, String senha, 
			long numeroCelular, String faculdade, long telefone, String sexo, String endereco) {
		super();
		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.senha = senha;
		this.numeroCelular = numeroCelular;
		this.faculdade = faculdade;
		this.telefone = telefone;
		this.endereco = endereco;
		this.sexo = sexo;
	}
	
	public Aluno() {
		super();
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public long getNumeroCelular() {
		return numeroCelular;
	}

	public void setNumeroCelular(long numeroCelular) {
		this.numeroCelular = numeroCelular;
	}

	public String getFaculdade() {
		return faculdade;
	}

	public void setFaculdade(String faculdade) {
		this.faculdade = faculdade;
	}

	public long getTelefone() {
		return telefone;
	}

	public void setTelefone(long telefone) {
		this.telefone = telefone;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}
	
}
