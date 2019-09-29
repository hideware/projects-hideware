package br.com.fiap.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import br.com.fiap.beans.Aluno;
import br.com.fiap.beans.Conteudo;
import br.com.fiap.beans.Disciplina;
import br.com.fiap.beans.HistoricoProgresso;
import br.com.fiap.beans.Matricula;
import br.com.fiap.conexao.Conexao;

public class HistoricoProgressoDAO {

	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	//Recebendo conexão
	public HistoricoProgressoDAO() throws Exception {
		con = Conexao.getConnection();
	}
	
	//Fechando conexão
	public void close() throws Exception {
		con.close();
	}
	
	//Funcionalidade: Mostrar histórico
	public HistoricoProgresso getHistoricoProgresso(int codigo) throws Exception {
		stmt = con.prepareStatement("SELECT * FROM TABELA_HIDEWARE WHERE CD_HISTORICO=?");
		stmt.setInt(1, codigo);
		rs = stmt.executeQuery();
		if(rs.next()) {
			HistoricoProgresso objeto = new HistoricoProgresso();
			objeto.setCodigo(rs.getInt("CD_HISTORICO"));
			objeto.setEstrelas(rs.getInt("NR_ESTRELAS"));
			objeto.setStatus(rs.getInt("NR_STATUS"));
			
			DisciplinaDAO discDAO = new DisciplinaDAO();
			Disciplina disc = discDAO.getDisciplina(rs.getInt("CD_DISCIPLINA"));
			discDAO.close();
			objeto.setDisciplina(disc);
			
			AlunoDAO aluDAO = new AlunoDAO();
			Aluno alu = aluDAO.getAluno(rs.getInt("CD_ALUNO"));
			aluDAO.close();
			objeto.setAluno(alu);
			
			MatriculaDAO matriDAO = new MatriculaDAO();
			Matricula matri = matriDAO.getMatricula(rs.getInt("NR_RM"));
			matriDAO.close();
			objeto.setMatricula(matri);
			
			ConteudoDAO contDAO = new ConteudoDAO();
			Conteudo cont = contDAO.getConteudo(rs.getInt("CD_CONTEUDO"));
			contDAO.close();
			objeto.setConteudo(cont);
			
			return objeto;
		} else {
			return new HistoricoProgresso();
		}
	}
	
	//Funcionalidade: Adicionar histórico
	public int addHistoricoProgresso(HistoricoProgresso objeto) throws Exception {
		stmt = con.prepareStatement("INSERT INTO TABELA_HIDEWARE (CD_HISTORICO, CD_DISCIPLINA, CD_ALUNO, NR_RM, CD_CONTEUDO, NR_ESTRELAS, NR_STATUS) VALUES (?,?,?,?,?,?,?)");
		stmt.setInt(1, objeto.getCodigo());
		stmt.setInt(2, objeto.getDisciplina().getCodigo());
		stmt.setInt(3, objeto.getAluno().getCodigo());
		stmt.setInt(4, objeto.getMatricula().getRm());
		stmt.setInt(5, objeto.getConteudo().getCodigo());
		stmt.setInt(6, objeto.getEstrelas());
		stmt.setInt(7, objeto.getStatus());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Apagar histórico
	public int deleteHistoricoProgresso(HistoricoProgresso objeto) throws Exception {
		stmt = con.prepareStatement("DELETE FROM TABELA_HIDEWARE WHERE CD_HISTORICO=?");
		stmt.setInt(1, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
	
	//Funcionalidade: Atualizar histórico
	public int updateHistoricoProgresso(HistoricoProgresso objeto) throws Exception {
		stmt = con.prepareStatement("UPDATE TABELA_HIDEWARE SET NR_ESTRELAS=?, NR_STATUS=? WHERE CD_HISTORICO=?");
		stmt.setInt(1, objeto.getEstrelas());
		stmt.setInt(2, objeto.getStatus());
		stmt.setInt(3, objeto.getCodigo());
		
		return stmt.executeUpdate();
	}
}
