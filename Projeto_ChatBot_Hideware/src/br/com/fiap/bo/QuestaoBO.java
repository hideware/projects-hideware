package br.com.fiap.bo;

import br.com.fiap.beans.Avaliacao;
import br.com.fiap.beans.Questao;
import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.dao.QuestaoDAO;

public class QuestaoBO {

	public String novaQuestao(Questao objetoQuestao) throws Exception {
		if(objetoQuestao.getCodigo() < 1) {
			return "Código inválido.";
		}
		
		objetoQuestao.setQuestao(objetoQuestao.getQuestao().toUpperCase());
		objetoQuestao.setAlternativaA(objetoQuestao.getAlternativaA().toUpperCase());
		objetoQuestao.setAlternativaB(objetoQuestao.getAlternativaB().toUpperCase());
		objetoQuestao.setAlternativaC(objetoQuestao.getAlternativaC().toUpperCase());
		objetoQuestao.setAlternativaD(objetoQuestao.getAlternativaD().toUpperCase());
		objetoQuestao.setAlternativaCorreta(objetoQuestao.getAlternativaCorreta().toUpperCase());
		
		AvaliacaoDAO avaDAO = new AvaliacaoDAO();
		Avaliacao ava = avaDAO.getAvaliacao(objetoQuestao.getCodigo());
		avaDAO.close();
		if(ava.getCodigo() == 0) {
			return "Avaliação não existe!";
		}
		
		QuestaoDAO quesDAO = new QuestaoDAO();
		Questao ques = quesDAO.getQuestao(objetoQuestao.getCodigo());
		if(ques.getCodigo() > 0) {
			return "Esse código da Questão já existe!";
		}
		
		quesDAO.addQuestao(objetoQuestao);
		return "Questão cadastrada.";
	}
}
