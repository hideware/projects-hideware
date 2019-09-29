package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Aluno;
import br.com.fiap.beans.Avaliacao;
import br.com.fiap.beans.ExecucaoAvaliacaoAluno;
import br.com.fiap.beans.Matricula;
import br.com.fiap.conexao.Conexao;

public class ExecucaoAvaliacaoAlunoDAO {
	
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//Recebendo conexão
	public ExecucaoAvaliacaoAlunoDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	//Fechando conexão
	public void close() throws Exception {
		con.close();
	}
	
	//Funcionalidade: Mostrar resposta da avaliação
	public ExecucaoAvaliacaoAluno getExecucaoAvaliacaoAluno(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM TABELA_HIDEWARE WHERE CD_AVALIACAO_PELO_ALUNO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if(rs.next()) {
			ExecucaoAvaliacaoAluno objeto = new ExecucaoAvaliacaoAluno();
			objeto.setCodigo(rs.getInt("CD_AVALIACAO_PELO_ALUNO"));
			objeto.setResposta(rs.getString("DS_RESPOSTA"));
			
			AvaliacaoDAO avaDAO = new AvaliacaoDAO();
			Avaliacao ava = avaDAO.getAvaliacao(rs.getInt("CD_AVALIACAO"));
			avaDAO.close();
			objeto.setAvaliacao(ava);
			
			AlunoDAO aluDAO = new AlunoDAO();
			Aluno alu = aluDAO.getAluno(rs.getInt("CD_ALUNO"));
			aluDAO.close();
			objeto.setAluno(alu);
			
			MatriculaDAO matriDAO = new MatriculaDAO();
			Matricula matri = matriDAO.getMatricula(rs.getInt("NR_RM"));
			matriDAO.close();
			objeto.setMatricula(matri);
			
			return objeto;
		} else {
			return new ExecucaoAvaliacaoAluno();
		}
	}
	
	//Funcionalidade: Adicionar resposta à avaliação
	public int addExecucaoAvaliacaoAluno(ExecucaoAvaliacaoAluno objeto) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TABELA_HIDEWARE (CD_AVALIACAO_PELO_ALUNO, CD_AVALIACAO, CD_ALUNO, NR_RM, DS_RESPOSTA) VALUES (?,?,?,?,?)");
		stmt.setInt(1, objeto.getCodigo());
		stmt.setInt(2, objeto.getAvaliacao().getCodigo());
		stmt.setInt(3, objeto.getAluno().getCodigo());
		stmt.setInt(4, objeto.getMatricula().getRm());
		stmt.setString(5, objeto.getResposta());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Apagar resposta da avaliação 
	public int deleteExecucaoAvaliacaoAluno(ExecucaoAvaliacaoAluno objeto) throws Exception {
		stmt = con.prepareStatement("DELETE FROM TABELA_HIDEWARE WHERE CD_AVALIACAO_PELO_ALUNO=?");
		stmt.setInt(1, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Atualizar resposta da avaliação
	public int updateExecucaoAvaliacaoAluno(ExecucaoAvaliacaoAluno objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE TABELA_HIDEWARE SET DS_RESPOSTA=?");
		stmt.setString(1, objeto.getResposta());
		
		return stmt.executeUpdate();
	}
}
