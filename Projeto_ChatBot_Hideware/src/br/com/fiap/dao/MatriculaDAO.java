package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Aluno;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.beans.Matricula;
import br.com.fiap.conexao.Conexao;

public class MatriculaDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//Recebendo conexão
	public MatriculaDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	//Fechando conexão
	public void close() throws Exception {
		con.close();
	}
	
	//Funcionalidade: Mostrar matricula
	public Matricula getMatricula(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM TABELA_HIDEWARE WHERE NR_RM=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Matricula objeto = new Matricula();
			objeto.setRm(rs.getInt("NR_RM"));
			objeto.setDataInicio(rs.getString("DT_INICIO"));
			objeto.setDataTermino(rs.getString("DT_TERMINO"));
			
			AlunoDAO aluDAO = new AlunoDAO();
			Aluno alu = aluDAO.getAluno(rs.getInt("CD_ALUNO"));
			aluDAO.close();
			objeto.setAluno(alu);
			
			DisciplinaDAO discDAO = new DisciplinaDAO();
			Disciplina disc = discDAO.getDisciplina(rs.getInt("CD_DISCIPLINA"));
			discDAO.close();
			objeto.setDisciplina(disc);
			
			return objeto;
		} else {
			return new Matricula();
		}
	}
	
	//Funcionalidade: Adicionar matricula
	public int addMatricula(Matricula objeto) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TABELA_HIDEWARE (NR_RM, CD_ALUNO, CD_DISCIPLINA, DT_INICIO, DT_TERMINO) VALUES (?,?,?,?,?)");
		stmt.setInt(1, objeto.getRm());
		stmt.setInt(2, objeto.getAluno().getCodigo());
		stmt.setInt(3, objeto.getDisciplina().getCodigo());
		stmt.setString(4, objeto.getDataInicio());
		stmt.setString(5, objeto.getDataTermino());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Apagar matricula
	public int deleteMatricula(Matricula objeto) throws Exception {
		stmt = con.prepareStatement("DELETE FROM TABELA_HIDEWARE WHERE NR_RM=?");
		stmt.setInt(1, objeto.getRm());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Atualizar matricula
	public int updateMatricula(Matricula objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE TABELA_HIDEWARE SET DT_INICIO=?, DT_TERMINO=? WHERE NR_RM=?");
		stmt.setString(1, objeto.getDataInicio());
		stmt.setString(2, objeto.getDataTermino());
		stmt.setInt(3, objeto.getRm());
		
		return stmt.executeUpdate();
	}
}
