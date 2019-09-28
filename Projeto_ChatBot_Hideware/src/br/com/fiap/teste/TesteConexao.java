package br.com.fiap.teste;

import java.sql.Connection;

import br.com.fiap.conexao.Conexao;

public class TesteConexao {

	public static void main(String[] args) {
		try {
			Connection con = Conexao.getConnection();
			System.out.println("Conectado.");
			con.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
