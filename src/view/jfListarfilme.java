package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import model.bin.filme;
import model.dao.FilmeDAO;

import javax.swing.JButton;

public class jfListarfilme extends JFrame {

	private JPanel contentPane;
	private JTable jtfilme;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfListarfilme frame = new jfListarfilme();
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
	public jfListarfilme() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 605, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblistarfilmes = new JLabel("Listar Filmes");
		lblistarfilmes.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblistarfilmes.setBounds(10, 11, 173, 14);
		contentPane.add(lblistarfilmes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 39, 559, 227);
		contentPane.add(scrollPane);
		
		jtfilme = new JTable();
		jtfilme.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"IdFilme", "T\u00EDtulo", "Categoria", "Tempo"
			}
		));
		scrollPane.setViewportView(jtfilme);
		
		JButton btncadastrar = new JButton("Cadastrar Filme");
		btncadastrar.setBounds(20, 296, 120, 23);
		contentPane.add(btncadastrar);
		
		JButton btnalterar = new JButton("Alterar Filme");
		btnalterar.setBounds(162, 296, 120, 23);
		contentPane.add(btnalterar);
		
		JButton btnexcluir = new JButton("Excluir Filme");
		btnexcluir.setBounds(311, 296, 114, 23);
		contentPane.add(btnexcluir);
		readJTable ();
	}
	public  void  readJTable () {
		DefaultTableModel modelo = ( DefaultTableModel ) jtfilme . getModel ();
		modelo . setNumRows ( 0 );
		FilmeDAO fdao =  new  FilmeDAO ();
		for ( filme f : fdao . read ()) {
			modelo . addRow ( new  Object [] {
					f . getIdFilme (),
					f . getTitulo (),
					f . getCategoria (),
					f . getTempo ()
			});
		}
		
	}
	
	
}