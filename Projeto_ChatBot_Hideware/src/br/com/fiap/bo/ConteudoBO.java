package br.com.fiap.bo;

import br.com.fiap.beans.Avaliacao;
import br.com.fiap.beans.Conteudo;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.dao.AvaliacaoDAO;
import br.com.fiap.dao.ConteudoDAO;
import br.com.fiap.dao.DisciplinaDAO;

public class ConteudoBO {

	public String novoConteudo(Conteudo objetoConteudo) throws Exception {
		if(objetoConteudo.getCodigo() < 1) {
			return "C�digo inv�lido.";
		}
		
		objetoConteudo.setTitulo(objetoConteudo.getTitulo().toUpperCase());
		objetoConteudo.setAudio(objetoConteudo.getAudio().toUpperCase());
		
		DisciplinaDAO discDAO = new DisciplinaDAO();
		Disciplina disc = discDAO.getDisciplina(objetoConteudo.getCodigo());
		discDAO.close();
		if(disc.getCodigo() == 0) {
			return "Disciplina n�o existe!";
		}
		
		AvaliacaoDAO avaDAO = new AvaliacaoDAO();
		Avaliacao ava = avaDAO.getAvaliacao(objetoConteudo.getCodigo());
		avaDAO.close();
		if(ava.getCodigo() == 0) {
			return "Avalia��o n�o existe!";
		}
		
		ConteudoDAO contDAO = new ConteudoDAO();
		Conteudo cont = contDAO.getConteudo(objetoConteudo.getCodigo());
		if(cont.getCodigo() > 0) {
			return "Esse c�digo do Conte�do j� existe!";
		}
		
		contDAO.addConteudo(objetoConteudo);
		return "Conte�do cadastrado";
	}
}
