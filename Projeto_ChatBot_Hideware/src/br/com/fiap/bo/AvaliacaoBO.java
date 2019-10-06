package br.com.fiap.bo;

import br.com.fiap.beans.Avaliacao;
import br.com.fiap.beans.Conteudo;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.dao.ConteudoDAO;
import br.com.fiap.dao.DisciplinaDAO;

public class AvaliacaoBO {

	public String novaAvaliacao(Avaliacao objetoAvaliacao) throws Exception {
		
		//Regra de Neg�cio: c�digo < 1
		if(objetoAvaliacao.getCodigo() < 1) {
			return "C�digo inv�lido.";
		}
	
		//Padroniza��o: tudo mai�sculo
		objetoAvaliacao.setTitulo(objetoAvaliacao.getTitulo().toUpperCase());
	
		//Requisito Funcional
		//Avaliacao deve existir na tabela Conteudo
		ConteudoDAO contDAO = new ConteudoDAO();
		Conteudo cont = contDAO.getConteudo(objetoAvaliacao.getCodigo());
		contDAO.close();
		if(cont.getCodigo() == 0) {
			return "Conte�do n�o existe!";
		}
		
		//Avaliacao deve existir na tabela Disciplina
		DisciplinaDAO discDAO = new DisciplinaDAO();
		Disciplina disc = discDAO.getDisciplina(objetoAvaliacao.getCodigo());
		discDAO.close();
		if(disc.getCodigo() == 0) {
			return "Disciplina n�o existe!";
		}
		
		//Codigo da avaliacao deve ser �nico
		AvaliacaoDAO avaDAO = new AvaliacaoDAO();
		Avaliacao ava = avaDAO.getAvaliacao(objetoAvaliacao.getCodigo());
		if(ava.getCodigo() > 0) {
			return "Esse c�digo de Avalia��o j� existe!";
		}
		
		avaDAO.addAvalicao(objetoAvaliacao);
		return "Avalia��o Cadastrada.";
	}
}

