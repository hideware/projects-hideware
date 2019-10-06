package br.com.fiap.bo;

import br.com.fiap.beans.Avaliacao;
import br.com.fiap.beans.Conteudo;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.dao.ConteudoDAO;
import br.com.fiap.dao.DisciplinaDAO;

public class AvaliacaoBO {

	public String novaAvaliacao(Avaliacao objetoAvaliacao) throws Exception {
		
		//Regra de Negócio: código < 1
		if(objetoAvaliacao.getCodigo() < 1) {
			return "Código inválido.";
		}
	
		//Padronização: tudo maiúsculo
		objetoAvaliacao.setTitulo(objetoAvaliacao.getTitulo().toUpperCase());
	
		//Requisito Funcional
		//Avaliacao deve existir na tabela Conteudo
		ConteudoDAO contDAO = new ConteudoDAO();
		Conteudo cont = contDAO.getConteudo(objetoAvaliacao.getCodigo());
		contDAO.close();
		if(cont.getCodigo() == 0) {
			return "Conteúdo não existe!";
		}
		
		//Avaliacao deve existir na tabela Disciplina
		DisciplinaDAO discDAO = new DisciplinaDAO();
		Disciplina disc = discDAO.getDisciplina(objetoAvaliacao.getCodigo());
		discDAO.close();
		if(disc.getCodigo() == 0) {
			return "Disciplina não existe!";
		}
		
		//Codigo da avaliacao deve ser único
		AvaliacaoDAO avaDAO = new AvaliacaoDAO();
		Avaliacao ava = avaDAO.getAvaliacao(objetoAvaliacao.getCodigo());
		if(ava.getCodigo() > 0) {
			return "Esse código de Avaliação já existe!";
		}
		
		avaDAO.addAvalicao(objetoAvaliacao);
		return "Avaliação Cadastrada.";
	}
}

