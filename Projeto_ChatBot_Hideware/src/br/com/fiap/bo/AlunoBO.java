package br.com.fiap.bo;

import br.com.fiap.beans.Aluno;
import br.com.fiap.dao.AlunoDAO;

public class AlunoBO{
	AlunoDAO dao = null;
	
	//Validar cadastro do aluno
	public String cadastrarAluno(Aluno aluno) throws Exception {
		//Instanciando o DAO
		dao = new AlunoDAO();

		// Validações de chave primária
		if (aluno.getCodigo() < 1) {
			return "Código inválido";
		}
		if (dao.getAluno(aluno.getCodigo()) != null) {
			return "Código já existente";
		}

		
		// Validações de nome
		if (!aluno.getNome().contains(" ")) {
			return "Nome incompleto";
		}
		
		
		// Padronização
		aluno.getNome().toUpperCase();

		
		// Validações de email
		if (!aluno.getEmail().contains("@") || !aluno.getEmail().contains(".com")) {
			return "Email inválido";
		}
		if (dao.getEmail(aluno.getEmail())) {
			return "Email já cadastrado";
		}
		
		
		//Validação de sexo
		if(!aluno.getSexo().equals("M") && !aluno.getSexo().equals("F")) {
			return "Sexo digitado é inválido";
		}
		
		// Validações de cpf
		if (aluno.getCpf().length() != 11) {
			return "Cpf inválido";
		}
		if(dao.getCpf(aluno.getCpf())) {
			return "Cpf já cadastrado";
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
		return "Não logado";

	}
}
