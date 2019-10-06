package br.com.fiap.bo;

import br.com.fiap.beans.Aluno;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.beans.Matricula;
import br.com.fiap.dao.AlunoDAO;
import br.com.fiap.dao.DisciplinaDAO;
import br.com.fiap.dao.MatriculaDAO;

public class MatriculaBO {

	public String novaMatricula(Matricula objetoMatricula) throws Exception {
		if(objetoMatricula.getRm() < 1) {
			return "Código inválido.";
		}
		
		objetoMatricula.setDataInicio(objetoMatricula.getDataInicio().toUpperCase());
		objetoMatricula.setDataTermino(objetoMatricula.getDataTermino().toUpperCase());
		
		DisciplinaDAO discDAO = new DisciplinaDAO();
		Disciplina disc = discDAO.getDisciplina(objetoMatricula.getRm());
		discDAO.close();
		if(disc.getCodigo() == 0) {
			return "Disciplina não existe!";
		}
		
		AlunoDAO aluDAO = new AlunoDAO();
		Aluno alu = aluDAO.getAluno(objetoMatricula.getRm());
		aluDAO.close();
		if(alu.getCodigo() == 0) {
			return "Aluno não existe!";
		}
		
		MatriculaDAO matriDAO = new MatriculaDAO();
		Matricula matri = matriDAO.getMatricula(objetoMatricula.getRm());
		if(matri.getRm() > 0) {
			return "Esse código de Matrícula já existe!";
		}
		
		matriDAO.addMatricula(objetoMatricula);
		return "Matricula cadastrada.";
	}
}
