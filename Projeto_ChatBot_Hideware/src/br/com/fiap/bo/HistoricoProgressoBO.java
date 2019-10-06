package br.com.fiap.bo;

import br.com.fiap.beans.Conteudo;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.beans.HistoricoProgresso;
import br.com.fiap.beans.Matricula;
import br.com.fiap.dao.ConteudoDAO;
import br.com.fiap.dao.DisciplinaDAO;
import br.com.fiap.dao.HistoricoProgressoDAO;
import br.com.fiap.dao.MatriculaDAO;

public class HistoricoProgressoBO {

	public String novoHistoricoProgresso(HistoricoProgresso objetoHistoricoProgresso) throws Exception {
		if(objetoHistoricoProgresso.getCodigo() < 1) {
			return "Código inválido.";
		}
		
		ConteudoDAO contDAO = new ConteudoDAO();
		Conteudo cont = contDAO.getConteudo(objetoHistoricoProgresso.getCodigo());
		contDAO.close();
		if(cont.getCodigo() == 0) {
			return "Conteúdo não existe!";
		}
		
		DisciplinaDAO discDAO = new DisciplinaDAO();
		Disciplina disc = discDAO.getDisciplina(objetoHistoricoProgresso.getCodigo());
		discDAO.close();
		if(disc.getCodigo() == 0) {
			return "Disciplina não existe!";
		}
		
		MatriculaDAO matriDAO = new MatriculaDAO();
		Matricula matri = matriDAO.getMatricula(objetoHistoricoProgresso.getCodigo());
		matriDAO.close();
		if(matri.getRm() == 0) {
			return "Matricula não existe!";
		}
		
		HistoricoProgressoDAO histDAO = new HistoricoProgressoDAO();
		HistoricoProgresso hist = histDAO.getHistoricoProgresso(objetoHistoricoProgresso.getCodigo());
		if(hist.getCodigo() > 0) {
			return "Esse código do Histórico do Progresso já existe!";
		}
		
		histDAO.addHistoricoProgresso(objetoHistoricoProgresso);
		return "Histórico Progresso cadastrado.";
	}
}
