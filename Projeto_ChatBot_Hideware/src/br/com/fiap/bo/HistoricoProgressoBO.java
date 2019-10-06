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
			return "C�digo inv�lido.";
		}
		
		ConteudoDAO contDAO = new ConteudoDAO();
		Conteudo cont = contDAO.getConteudo(objetoHistoricoProgresso.getCodigo());
		contDAO.close();
		if(cont.getCodigo() == 0) {
			return "Conte�do n�o existe!";
		}
		
		DisciplinaDAO discDAO = new DisciplinaDAO();
		Disciplina disc = discDAO.getDisciplina(objetoHistoricoProgresso.getCodigo());
		discDAO.close();
		if(disc.getCodigo() == 0) {
			return "Disciplina n�o existe!";
		}
		
		MatriculaDAO matriDAO = new MatriculaDAO();
		Matricula matri = matriDAO.getMatricula(objetoHistoricoProgresso.getCodigo());
		matriDAO.close();
		if(matri.getRm() == 0) {
			return "Matricula n�o existe!";
		}
		
		HistoricoProgressoDAO histDAO = new HistoricoProgressoDAO();
		HistoricoProgresso hist = histDAO.getHistoricoProgresso(objetoHistoricoProgresso.getCodigo());
		if(hist.getCodigo() > 0) {
			return "Esse c�digo do Hist�rico do Progresso j� existe!";
		}
		
		histDAO.addHistoricoProgresso(objetoHistoricoProgresso);
		return "Hist�rico Progresso cadastrado.";
	}
}
