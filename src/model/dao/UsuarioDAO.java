package model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import connection.ConnectionFactory;
import model.bin.filme;
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
		
		public List<usuario> read() {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			List<usuario> usuario = new ArrayList<>();

			try {
				stmt = con.prepareStatement("SELECT * FROM usuario;");
				rs = stmt.executeQuery();
				while (rs.next()) {
					usuario u = new usuario();
					u.setIdUsuario(rs.getInt("idUsuario"));
					u.setNome(rs.getString("nome"));
					u.setEmail(rs.getString("email"));
					u.setSenha(rs.getString("senha"));
					
					usuario.add(u);
				}
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Erro ao buscar as informações do BD: " + e);
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConnection(con, stmt, rs);
			}
			return usuario;
		}

		public usuario read(int idUsuario) {
			Connection con = ConnectionFactory.getConnection();
			PreparedStatement stmt = null;
			ResultSet rs = null;
			usuario u = new usuario();
			
			try {
				stmt = con.prepareStatement("SELECT * FROM usuario WHERE idUsuario=? LIMIT 1;");
				stmt.setInt(1, idUsuario);
				rs = stmt.executeQuery();
				if(rs != null && rs.next()) {
					u.setIdUsuario(rs.getInt("idUsuario"));
					u.setNome(rs.getString("nome"));
					u.setEmail(rs.getString("email"));
					u.setSenha(rs.getString("senha"));
					
				}		
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				ConnectionFactory.closeConnection(con, stmt, rs);
			}
			return u;
		}
		

	public  void  update ( usuario  u ) {
		Connection  con =  ConnectionFactory . getConnection ();
		PreparedStatement stmt =  null ;
		
		try {
			stmt = con . prepareStatement ( " UPDATE usuario SET nome = ?, email = ?, senha = ?"
					+ " WHERE idUsuario = ?; " );
			stmt.setString ( 1 , u.getNome ());
			stmt.setString ( 2 , u.getEmail ());
			stmt.setString ( 3 , u.getSenha ());
			stmt.setInt ( 4 , u.getIdUsuario());
			stmt.executeUpdate ();
			JOptionPane . showMessageDialog ( null , " Usuário atualizado com sucesso! " );
		} catch ( SQLException e) {
			JOptionPane . showMessageDialog ( null , " Erro ao atualizar: " + e);
		} finally {
			ConnectionFactory . closeConnection (con, stmt);
		}
	}
	
}
		

	