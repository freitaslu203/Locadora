package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bin.filme;
import model.bin.usuario;
import model.dao.FilmeDAO;
import model.dao.UsuarioDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jfListarusuarios extends JFrame {

	private JPanel contentPane;
	private JTable jttable;

	/**
	 * ok
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfListarusuarios frame = new jfListarusuarios();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public jfListarusuarios() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 594, 426);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblistarusuarios = new JLabel("Listar Usu\u00E1rios");
		lblistarusuarios.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblistarusuarios.setBounds(10, 11, 172, 14);
		contentPane.add(lblistarusuarios);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 36, 534, 287);
		contentPane.add(scrollPane);
		
		jttable = new JTable();
		jttable.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"IdUsu\u00E1rio", "Nome", "Email", "Senha"
			}
		));
		scrollPane.setViewportView(jttable);
		
		JButton btncadastrar = new JButton("Cadastrar Usu\u00E1rio");
		btncadastrar.setBounds(30, 337, 131, 23);
		contentPane.add(btncadastrar);
		
		JButton btneditar = new JButton("Editar Usu\u00E1rio");
		btneditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
							
				//verificar se há linha selecionada
				if(jttable.getSelectedRow()!= -1) {
					jfAtualizaUsuario au = new jfAtualizaUsuario(
							(int)jttable.getValueAt(jttable.getSelectedRow(), 0));
					au.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um usuário!");
				}
				readJTable();
			}
		});
		
		btneditar.setBounds(205, 337, 123, 23);
		contentPane.add(btneditar);
		
		JButton btnexcluir = new JButton("Excluir Usu\u00E1rio");
		btnexcluir.setBounds(384, 337, 123, 23);
		contentPane.add(btnexcluir);
		
		readJTable ();
	}
	
	public  void  readJTable () {
		DefaultTableModel modelo = ( DefaultTableModel ) jttable . getModel ();
		modelo . setNumRows ( 0 );
		UsuarioDAO udao =  new  UsuarioDAO ();
		for ( usuario u : udao . read ()) {
			modelo . addRow ( new  Object [] {
					u . getIdUsuario (),
					u . getNome (),
					u . getEmail (),
					u . getSenha ()
			});
		}
		
	}
	
	
}
