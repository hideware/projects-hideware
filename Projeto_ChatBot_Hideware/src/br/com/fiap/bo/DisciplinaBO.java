package br.com.fiap.bo;

import br.com.fiap.beans.Disciplina;
import br.com.fiap.dao.DisciplinaDAO;

public class DisciplinaBO {

	public String novaDisciplina(Disciplina objetoDisciplina) throws Exception {
		if(objetoDisciplina.getCodigo() < 1) {
			return "Código inválido";
		}
		
		objetoDisciplina.setTitulo(objetoDisciplina.getTitulo().toUpperCase());
		
		DisciplinaDAO discDAO = new DisciplinaDAO();
		Disciplina disc = discDAO.getDisciplina(objetoDisciplina.getCodigo());
		if(disc.getCodigo() > 0) {
			return "Esse código da Disciplina já existe!";
		}
		
		discDAO.addDisciplina(objetoDisciplina);
		return "Disciplina cadastrada.";
	}
}
