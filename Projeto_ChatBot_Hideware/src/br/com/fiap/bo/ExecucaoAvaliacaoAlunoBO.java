package br.com.fiap.bo;

import br.com.fiap.beans.Avaliacao;
import br.com.fiap.beans.ExecucaoAvaliacaoAluno;
import br.com.fiap.beans.Matricula;
import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.dao.ExecucaoAvaliacaoAlunoDAO;
import br.com.fiap.dao.MatriculaDAO;

public class ExecucaoAvaliacaoAlunoBO {

	public String novaExecucaoAvaliacaoAluno(ExecucaoAvaliacaoAluno objetoExeAvaAluno) throws Exception {
		if(objetoExeAvaAluno.getCodigo() < 1) {
			return "Código inválido.";
		}
		
		objetoExeAvaAluno.setResposta(objetoExeAvaAluno.getResposta().toUpperCase());
		
		AvaliacaoDAO avaDAO = new AvaliacaoDAO();
		Avaliacao ava = avaDAO.getAvaliacao(objetoExeAvaAluno.getCodigo());
		avaDAO.close();
		if(ava.getCodigo() == 0) {
			return "Avaliação não existe!";
		}
		
		MatriculaDAO matriDAO = new MatriculaDAO();
		Matricula matri = matriDAO.getMatricula(objetoExeAvaAluno.getCodigo());
		matriDAO.close();
		if(matri.getRm() == 0) {
			return "Matricula não existe!";
		}
		
		ExecucaoAvaliacaoAlunoDAO exeDAO = new ExecucaoAvaliacaoAlunoDAO();
		ExecucaoAvaliacaoAluno exe = exeDAO.getExecucaoAvaliacaoAluno(objetoExeAvaAluno.getCodigo());
		if(exe.getCodigo() > 0) {
			return "Esse código da Execução da Avaliação já existe!";
		}
		
		exeDAO.addExecucaoAvaliacaoAluno(objetoExeAvaAluno);
		return "Execução da Avaliação do aluno cadastrada.";
	}
}
