package br.com.fiap.bo;

import br.com.fiap.beans.Aluno;
import br.com.fiap.dao.AlunoDAO;

public class AlunoBO{
	AlunoDAO dao = null;
	
	//Validar cadastro do aluno
	public String cadastrarAluno(Aluno aluno) throws Exception {
		//Instanciando o DAO
		dao = new AlunoDAO();

		// Valida��es de chave prim�ria
		if (aluno.getCodigo() < 1) {
			return "C�digo inv�lido";
		}
		if (dao.getAluno(aluno.getCodigo()) != null) {
			return "C�digo j� existente";
		}

		
		// Valida��es de nome
		if (!aluno.getNome().contains(" ")) {
			return "Nome incompleto";
		}
		
		
		// Padroniza��o
		aluno.getNome().toUpperCase();

		
		// Valida��es de email
		if (!aluno.getEmail().contains("@") || !aluno.getEmail().contains(".com")) {
			return "Email inv�lido";
		}
		if (dao.getEmail(aluno.getEmail())) {
			return "Email j� cadastrado";
		}
		
		
		//Valida��o de sexo
		if(!aluno.getSexo().equals("M") && !aluno.getSexo().equals("F")) {
			return "Sexo digitado � inv�lido";
		}
		
		// Valida��es de cpf
		if (aluno.getCpf().length() != 11) {
			return "Cpf inv�lido";
		}
		if(dao.getCpf(aluno.getCpf())) {
			return "Cpf j� cadastrado";
		}


		dao.addAluno(aluno);
		dao.close();
		return "Cadastrado com sucesso!";
	}

	//Validar login do aluno
	public String logar(int codigo , String senha) throws Exception {
		//Instanciando o DAO
		dao = new AlunoDAO();
		
		if (dao.logarAluno(codigo, senha)) {
			return "Logado";
		}
		return "N�o logado";

	}
}
