package br.com.fiap.teste;

import javax.swing.JOptionPane;
import br.com.fiap.beans.Aluno;
import br.com.fiap.bo.AlunoBO;

public class TestandoCadastro {

	public static void main(String[] args) throws Exception{
		AlunoBO bo = null;
		Aluno aluno = null;
		try {
			bo = new AlunoBO();
			aluno = new Aluno();
			
			
			aluno.setCodigo(8);
			aluno.setNome("Leandro Farias");
			aluno.setEmail("leandro.farias04@hotmail.com");
			aluno.setEndereco("Lins");
			aluno.setCpf("48457713820");
			aluno.setDataNascimento("05/02/02");
			aluno.setSenha("050201");
			aluno.setNumeroCelular(983732412);
//			aluno.setSexo("m");
			aluno.setSexo(JOptionPane.showInputDialog("Digite o sexo do aluno: (M , F)").toUpperCase());
			aluno.setFaculdade("fiap");
			aluno.setTelefone(23118972);
			
			
//			aluno.setCodigo(Integer.parseInt(JOptionPane.showInputDialog("Digite seu código:")));
//			aluno.setNome(JOptionPane.showInputDialog("Digite seu nome:"));
//			aluno.setEmail(JOptionPane.showInputDialog("Digite seu email:"));
//			aluno.setEndereco(JOptionPane.showInputDialog("Digite o endereco do aluno:"));
//			aluno.setCpf(JOptionPane.showInputDialog("Digite o CPF do aluno:"));
//			aluno.setDataNascimento(JOptionPane.showInputDialog("Digite a data de nascimento do aluno:"));
//			aluno.setSenha(JOptionPane.showInputDialog("Digite a senha do aluno:"));
//			aluno.setNumeroCelular(Long.parseLong(JOptionPane.showInputDialog("Digite o celular do aluno:")));
//			aluno.setFaculdade(JOptionPane.showInputDialog("Digite a faculdade do aluno:"));
//			aluno.setTelefone(Long.parseLong(JOptionPane.showInputDialog("Digite o telefone do aluno:")));

			JOptionPane.showMessageDialog(null,bo.cadastrarAluno(aluno));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}