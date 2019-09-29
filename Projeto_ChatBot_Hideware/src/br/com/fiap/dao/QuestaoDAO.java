package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Avaliacao;
import br.com.fiap.beans.Questao;
import br.com.fiap.conexao.Conexao;

public class QuestaoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//Recebendo conexão
	public QuestaoDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	//Fechando conexão
	public void close() throws Exception {
		con.close();
	}
	
	//Funcionalidade: Mostrar questão
	public Questao getQuestao(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM TABELA_HIDEWARE WHERE CD_QUESTAO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Questao objeto = new Questao();
			objeto.setAlternativaA(rs.getString("DS_ALTERNATIVA_A"));
			objeto.setAlternativaB(rs.getString("DS_ALTERNATIVA_B"));
			objeto.setAlternativaC(rs.getString("DS_ALTERNATIVA_C"));
			objeto.setAlternativaD(rs.getString("DS_ALTERNATIVA_D"));
			objeto.setAlternativaCorreta(rs.getString("DS_ALTERNATIVA_CORRETA"));
			objeto.setCodigo(rs.getInt("CD_QUESTAO"));
			objeto.setDificuldade(rs.getInt("NR_DIFICULDADE"));
			objeto.setQuestao(rs.getString("DS_QUESTAO"));
			
			AvaliacaoDAO avaDAO = new AvaliacaoDAO();
			Avaliacao ava = avaDAO.getAvaliacao(rs.getInt("CD_AVALIACAO"));
			avaDAO.close();
			objeto.setAvaliacao(ava);
			
			return objeto;
		} else {
			return new Questao();
		}
	}
	
	//Funcionaliadade: Adicionar questão
	public int addQuestao(Questao objeto) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TABELA_HIDEWARE (CD_QUESTAO, CD_AVALIACAO, NR_DIFICULDADE, DS_QUESTAO, DS_ALTERNATIVA_A, DS_ALTERNATIVA_B, DS_ALTERNATIVA_C, DS_ALTERNATIVA_D, DS_ALTERNATIVA_CORRETA) VALUES (?,?,?,?,?,?,?,?,?)");
		stmt.setInt(1, objeto.getCodigo());
		stmt.setInt(2, objeto.getAvaliacao().getCodigo());
		stmt.setInt(3, objeto.getDificuldade());
		stmt.setString(4, objeto.getQuestao());
		stmt.setString(5, objeto.getAlternativaA());
		stmt.setString(6, objeto.getAlternativaB());
		stmt.setString(7, objeto.getAlternativaC());
		stmt.setString(8, objeto.getAlternativaD());
		stmt.setString(9, objeto.getAlternativaCorreta());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Remover questão
	public int deleteQuestao(Questao objeto) throws Exception {
		stmt = con.prepareStatement("DELETE FROM TABELA_HIDEWARE WHERE CD_QUESTAO=?");
		stmt.setInt(1, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Atualizar questão
	public int updateQuestao(Questao objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE TABELA_HIDEWARE SET NR_DIFICULDADE=?, DS_QUESTAO=?, DS_ALTERNATIVA_A=?, DS_ALTERNATIVA_B=?, DS_ALTERNATIVA_C=?, DS_ALTERNATIVA_D=?, DS_ALTERNATIVA_CORRETA=?");
		stmt.setInt(1, objeto.getDificuldade());
		stmt.setString(2, objeto.getQuestao());
		stmt.setString(3, objeto.getAlternativaA());
		stmt.setString(4, objeto.getAlternativaB());
		stmt.setString(5, objeto.getAlternativaC());
		stmt.setString(6, objeto.getAlternativaD());
		stmt.setString(7, objeto.getAlternativaCorreta());
		
		return stmt.executeUpdate();
	}
}
