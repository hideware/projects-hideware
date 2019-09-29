package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Disciplina;
import br.com.fiap.conexao.Conexao;

public class DisciplinaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public DisciplinaDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	public void close() throws Exception {
		con.close();
	}
	
	//Funcionalidade: Mostrar disciplina
	public Disciplina getDisciplina(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM TABELA_HIDEWARE WHERE CD_DISCIPLINA=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Disciplina objeto = new Disciplina();
			objeto.setCodigo(rs.getInt("CD_DISCIPLINA"));
			objeto.setDataInicio(rs.getString("DT_INICIO"));
			objeto.setDataTermino(rs.getString("DT_TERMINO"));
			objeto.setTitulo(rs.getString("NM_TITULO"));
			
			return objeto;
		} else {
			return new Disciplina();
		}
	}
	
	//Funcionalidade: Adicionar disciplina
	public int addDisciplina(Disciplina objeto) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TABELA_HIDEWARE (CD_DISCIPLINA, DT_INICIO, DT_TERMINO, NM_TITULO) VALUES (?,?,?,?)");
		stmt.setInt(1, objeto.getCodigo());
		stmt.setString(2, objeto.getDataInicio());
		stmt.setString(3, objeto.getDataTermino());
		stmt.setString(4, objeto.getTitulo());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Remover disciplina
	public int deleteDisciplina(Disciplina objeto) throws Exception {
		stmt = con.prepareStatement("DELETE FROM TABELA_HIDEWARE WHERE CD_DISCIPLINA=?");
		stmt.setInt(1, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Atualizar disciplina
	public int updateDisciplina(Disciplina objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE FROM TABELA_HIDEWARE SET DT_INICIO=?, DT_TERMINO=?, NM_TITULO=? WHERE CD_DISCIPLINA=?");
		stmt.setString(1, objeto.getDataInicio());
		stmt.setString(2, objeto.getDataTermino());
		stmt.setString(3, objeto.getTitulo());
		stmt.setInt(4, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}	
}
