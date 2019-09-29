package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Avaliacao;
import br.com.fiap.beans.Conteudo;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.conexao.Conexao;

public class ConteudoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//Recebendo conexão
	public ConteudoDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	//Fechando conexão
	public void close() throws Exception {
		con.close();
	}
	
	//Funcionalidade: Mostrar conteúdo
	public Conteudo getConteudo(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM TABELA_HIDEWARE WHERE CD_CONTEUDO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Conteudo objeto = new Conteudo();
			objeto.setAudio(rs.getString("DS_AUDIO"));
			objeto.setTitulo(rs.getString("NM_TITULO"));
			
			AvaliacaoDAO avaDAO = new AvaliacaoDAO();
			Avaliacao ava = avaDAO.getAvaliacao(rs.getInt("CD_AVALIACAO"));
			avaDAO.close();
			objeto.setAvaliacao(ava);
			
			DisciplinaDAO discDAO = new DisciplinaDAO();
			Disciplina disc = discDAO.getDisciplina(rs.getInt("CD_DISCIPLINA"));
			discDAO.close();
			objeto.setDisciplina(disc);
			
			return objeto;
		} else {
			return new Conteudo();
		}
	}
	
	//Funcionalidade: Adicionar conteúdo
	public int addConteudo(Conteudo objeto) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TABELA_HIDEWARE (CD_CONTEUDO, CD_DISCIPLINA, CD_AVALIACAO, NM_TITULO, DS_AUDIO) VALUES (?,?,?,?,?)");
		stmt.setInt(1, objeto.getCodigo());
		stmt.setInt(2, objeto.getDisciplina().getCodigo());
		stmt.setInt(3, objeto.getAvaliacao().getCodigo());
		stmt.setString(4, objeto.getTitulo());
		stmt.setString(5, objeto.getAudio());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Apagar conteúdo
	public int deleteConteudo (Conteudo objeto) throws Exception {
		stmt = con.prepareStatement("DELETE FROM TABELA_HIDEWARE WHERE CD_CONTEUDO=?");
		stmt.setInt(1, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Atualizar conteúdo
	public int updateConteudo (Conteudo objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE TABELA_HIDEWARE SET NM_TITULO=?, DS_AUDIO=? WHERE CD_CONTEUDO=?");
		stmt.setString(1, objeto.getTitulo());
		stmt.setString(2, objeto.getAudio());
		stmt.setInt(3, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
}
