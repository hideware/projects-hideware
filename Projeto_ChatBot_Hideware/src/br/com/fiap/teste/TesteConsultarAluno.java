package br.com.fiap.teste;

import javax.swing.JOptionPane;

import br.com.fiap.beans.Aluno;
import br.com.fiap.dao.AlunoDAO;

public class TesteConsultarAluno {

	public static void main(String[] args) {
		try {
			AlunoDAO dao = new AlunoDAO();
			int x = Integer.parseInt(JOptionPane.showInputDialog("Digite o Código: "));
			Aluno aluno = dao.getAluno(x);
			System.out.println("Nome: "+aluno.getNome());
			System.out.println("Senha: "+aluno.getSenha());
			System.out.println("Código: "+aluno.getCodigo());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
