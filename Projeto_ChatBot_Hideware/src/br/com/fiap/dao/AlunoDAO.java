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
	
	//Funcionalidade: Mostrar aluno
	public Aluno getAluno(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM EMMADOC_T_ALUNO WHERE CD_ALUNO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if(rs.next()) {
			Aluno objeto = new Aluno();
			objeto.setCodigo(rs.getInt("CD_ALUNO"));
			objeto.setNome(rs.getString("NM_ALUNO"));
			objeto.setEmail(rs.getString("DS_EMAIL"));
			objeto.setEndereco(rs.getString("DS_ENDERECO"));
			objeto.setCpf(rs.getString("NR_CPF"));
			objeto.setDataNascimento(rs.getString("DT_NASCIMENTO"));
			objeto.setSenha(rs.getString("DS_SENHA"));
			objeto.setNumeroCelular(rs.getLong("NR_TELEFONE"));
			objeto.setSexo(rs.getString("DS_SEXO"));
			objeto.setFaculdade(rs.getString("DS_FACULDADE"));
			objeto.setTelefone(rs.getLong("NR_TELEFONE"));
			return objeto;
		} else {
			return null;
		}
	}
	
	//Funcionalidade: Adicionar aluno
	public int addAluno(Aluno aluno) throws Exception{
		stmt = con.prepareStatement("INSERT INTO EMMADOC_T_ALUNO (CD_ALUNO , NM_ALUNO , DS_EMAIL"
				+ ", DS_ENDERECO , NR_CPF , DT_NASCIMENTO , DS_SENHA , NR_CELULAR , DS_SEXO , DS_FACULDADE"
				+ ", NR_TELEFONE) VALUES (?,?,?,?,?,?,?,?,?,?,?)");
		stmt.setInt(1, aluno.getCodigo());
		stmt.setString(2,aluno.getNome());
		stmt.setString(3, aluno.getEmail());
		stmt.setString(4, aluno.getEndereco());
		stmt.setString(5, aluno.getCpf());
		stmt.setString(6, aluno.getDataNascimento());
		stmt.setString(7, aluno.getSenha());
		stmt.setLong(8, aluno.getNumeroCelular());
		stmt.setString(9, aluno.getSexo());
		stmt.setString(10, aluno.getFaculdade());
		stmt.setLong(11, aluno.getTelefone());
		
		return stmt.executeUpdate();
	}

	
	//Funcionalidade: Deletar aluno
	public int deleteAluno(Aluno objeto) throws Exception {
		stmt = con.prepareStatement("DELETE FROM TABELA_HIDEWARE WHERE CD_ALUNO=?");
		stmt.setInt(1, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
	
	
	//Funcionalidade: Logar
	public boolean logarAluno(int codigo , String senha) throws Exception{
		stmt = con.prepareStatement("SELECT CD_ALUNO , DS_SENHA FROM EMMADOC_T_ALUNO WHERE CD_ALUNO = ? AND DS_SENHA = ?");
		stmt.setInt(1, codigo);
		stmt.setString(2, senha);
		rs = stmt.executeQuery();
		if(rs.next()) {
			return true;
		}
		return false;
	}
	
	
	//Consultar email
	public boolean getEmail(String email) throws Exception{
		stmt = con.prepareStatement("SELECT DS_EMAIL FROM EMMADOC_T_ALUNO WHERE DS_EMAIL = ?");
		stmt.setString(1, email);
		rs = stmt.executeQuery();
		if(rs.next()){
			return true;
		} return false;
	}
	//Consultar CPF
	public boolean getCpf(String cpf) throws Exception{
		stmt = con.prepareStatement("SELECT NR_CPF FROM EMMADOC_T_ALUNO WHERE NR_CPF = ?");
		stmt.setString(1, cpf);
		rs = stmt.executeQuery();
		if(rs.next()) {
			return true;
		} return false;
	}
	
	
//	//Funcionalidade: Atualizar aluno
//	public int updateAluno(Aluno objeto) throws Exception {
//		stmt = con.prepareStatement("UPDATE TABELA_HIDEWARE SET NR_CPF=?, DT_NASCIMENTO=?, DS_EMAIL=?, DS_FACULDADE=?, NM_ALUNO=?, NR_CELULAR=?, DS_SENHA=?, NR_TELEFONE=? WHERE CD_ALUNO=?");
//		stmt.setInt(1, objeto.getCpf());
//		stmt.setString(2, objeto.getDataNascimento());
//		stmt.setString(3, objeto.getEmail());
//		stmt.setString(4, objeto.getFaculdade());
//		stmt.setString(5, objeto.getNome());
//		stmt.setInt(6, objeto.getNumeroCelular());
//		stmt.setString(7, objeto.getSenha());
//		stmt.setInt(8, objeto.getTelefone());
//		
//		return stmt.executeUpdate();
//	}
	
	
	
	
	
	
	
	
	
	
}
