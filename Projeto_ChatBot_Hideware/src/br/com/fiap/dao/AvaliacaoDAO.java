package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Avaliacao;
import br.com.fiap.beans.Conteudo;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.conexao.Conexao;

public class AvaliacaoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//Recebendo conexão
	public AvaliacaoDAO() throws Exception {
		con = Conexao.getConnection();
	}
	//Fechando conexão
	public void close() throws Exception {
		con.close();
	}
	
	//Funcionalidade: Mostrar avaliação
	public Avaliacao getAvaliacao(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM TABELA_HIDEWARE WHERE CD_AVALIACAO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Avaliacao objeto = new Avaliacao();
			objeto.setCodigo(rs.getInt("CD_AVALIACAO"));
			objeto.setTitulo(rs.getString("NM_TITULO"));
			
			DisciplinaDAO discDAO = new DisciplinaDAO();
			Disciplina disc = discDAO.getDisciplina(rs.getInt("CD_DISCIPLINA"));
			discDAO.close();
			objeto.setDisciplina(disc);
			
			ConteudoDAO contDAO = new ConteudoDAO();
			Conteudo cont = contDAO.getConteudo(rs.getInt("CD_CONTEUDO"));
			contDAO.close();
			objeto.setConteudo(cont);
			
			return objeto;
		} else {
			return new Avaliacao();
		}
	}
	
	//Funcionalidade: Adicionar avaliação
	public int addAvalicao(Avaliacao objeto) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TABELA_HIDEWARE (CD_AVALIACAO, CD_DISCIPLINA, CD_CONTEUDO, NM_TITULO) VALUES (?,?,?,?)");
		stmt.setInt(1, objeto.getCodigo());
		stmt.setInt(2, objeto.getDisciplina().getCodigo());
		stmt.setInt(3, objeto.getConteudo().getCodigo());
		stmt.setString(4, objeto.getTitulo());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Apagar avaliação
	public int deleteAvaliacao(Avaliacao objeto) throws Exception {
		stmt = con.prepareStatement("DELETE FROM TABELA_HIDEWARE WHERE CD_AVALIACAO=?");
		stmt.setInt(1, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Atualizar avaliação
	public int updateAvaliacao(Avaliacao objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE TABELA_HIDEWARE SET NM_TITULO=? WHERE CD_AVALIACAO=?");
		stmt.setString(1, objeto.getTitulo());
		stmt.setInt(2, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}	
}
