package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bin.usuario;

public class UsuarioDAO {
	
		public void create(usuario u) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			
			try {
				stmt = con.prepareStatement("INSERT INTO usuario (nome, email, senha) VALUES"
						+ "(?,?,?)");
				stmt.setString(1, u.getNome());
				stmt.setString(2, u.getEmail());
				stmt.setString(3, u.getSenha());
				
				stmt.executeUpdate();
				JOptionPane.showMessageDialog(null, "Usuário cadastrado com sucesso!");
			} catch(SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao cadastrar: "+ e);
			}finally{
				ConnectionFactory.closeConnection(con, stmt);
			}
		}
		

	
}
