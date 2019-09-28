package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Aluno;
import br.com.fiap.conexao.Conexao;

public class AlunoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//Recebendo conexão
	public AlunoDAO() throws Exception {
		con = Conexao.getConnection();
	}
	//Fechando conexão
	public void close() throws Exception {
		con.close();
	}
	
	//Funcionalidade: Mostrar aluno(s)
	public Aluno getAluno(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM TABELA_HIDEWARE WHERE CD_ALUNO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Aluno objeto = new Aluno();
			objeto.setCodigo(rs.getInt("CD_ALUNO"));
			objeto.setCpf(rs.getInt("NR_CPF"));
			objeto.setDataNascimento(rs.getString("DT_NASCIMENTO"));
			objeto.setEmail(rs.getString("DS_EMAIL"));
			objeto.setFaculdade(rs.getString("DS_FACULDADE"));
			objeto.setNome(rs.getString("NM_ALUNO"));
			objeto.setNumeroCelular(rs.getInt("NR_CELULAR"));
			objeto.setSenha(rs.getString("DS_SENHA"));
			objeto.setTelefone(rs.getInt("NR_TELEFONE"));
			return objeto;
		} else {
			return new Aluno();
		}
	}
	
	//Funcionalidade: Adicionar aluno(s)
	public int addAluno(Aluno objeto) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TABELA_HIDEWARE (CD_ALUNO, NR_CPF, DT_NASCIMENTO, DS_EMAIL, DS_FACULDADE, NM_ALUNO, NR_CELULAR, DS_SENHA, NR_TELEFONE) VALUES (?,?,?,?,?,?,?,?,?)"); 
		stmt.setInt(1, objeto.getCodigo());
		stmt.setInt(2, objeto.getCpf());
		stmt.setString(3, objeto.getDataNascimento());
		stmt.setString(4, objeto.getEmail());
		stmt.setString(5, objeto.getFaculdade());
		stmt.setString(6, objeto.getNome());
		stmt.setInt(7, objeto.getNumeroCelular());
		stmt.setString(8, objeto.getSenha());
		stmt.setInt(9, objeto.getTelefone());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Deletar aluno(s)
	public int deleteAluno(Aluno objeto) throws Exception {
		stmt = con.prepareStatement("DELETE FROM TABELA_HIDEWARE WHERE CD_ALUNO=?");
		stmt.setInt(1, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Atualizar aluno(s)
	public int updateAluno(Aluno objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE TABELA_HIDEWARE SET NR_CPF=?, DT_NASCIMENTO=?, DS_EMAIL=?, DS_FACULDADE=?, NM_ALUNO=?, NR_CELULAR=?, DS_SENHA=?, NR_TELEFONE=? WHERE CD_ALUNO=?");
		stmt.setInt(1, objeto.getCpf());
		stmt.setString(2, objeto.getDataNascimento());
		stmt.setString(3, objeto.getEmail());
		stmt.setString(4, objeto.getFaculdade());
		stmt.setString(5, objeto.getNome());
		stmt.setInt(6, objeto.getNumeroCelular());
		stmt.setString(7, objeto.getSenha());
		stmt.setInt(8, objeto.getTelefone());
		
		return stmt.executeUpdate();
	}
	
	
	
	
	
	
	
	
	
	
}
