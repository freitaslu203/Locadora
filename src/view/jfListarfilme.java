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
import model.dao.FilmeDAO;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class jfListarfilme extends JFrame {

	private JPanel contentPane;
	private JTable jtfilme;
	private static int id;

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
		
		JButton btnalterar = new JButton("Alterar");
		btnalterar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
					// verificar se há linha selecionada
				if(jfListarfilme.getSelectedRow()!= -1) {
					jfAtualizaFilme af = new jfAtualizaFilme(
							(int)jtfilme.getValueAt(jtfilme.getSelectedRow(), 0));
					af.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			}
		});
		
		btnalterar.setBounds(162, 296, 120, 23);
		contentPane.add(btnalterar);
		
		JButton btnexcluir = new JButton("Excluir Filme");
		btnexcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
				if(jtfilme.getSelectedRow()!= -1) {
					int opcao = JOptionPane.showConfirmDialog(null, "Deseja excluir o filme selecionado?"
							,"Exclusão",JOptionPane.YES_NO_OPTION);
					if (opcao == 0) {
						FilmeDAO dao = new FilmeDAO();
						filme f = new filme();
						f.setIdFilme((int) jtfilme.getValueAt(jtfilme.getSelectedRow(), 0));
						dao.delete(f);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Selecione um filme!");
				}
				readJTable();
			}
		});
		btnexcluir.setBounds(311, 296, 114, 23);
		contentPane.add(btnexcluir);
		readJTable ();
	}
	protected static int getSelectedRow() {
		// TODO Auto-generated method stub
		return 0;
	}

	public  void  readJTable () {
		DefaultTableModel modelo = ( DefaultTableModel ) jtfilme.getModel ();
		modelo.setNumRows ( 0 );
		FilmeDAO fdao =  new  FilmeDAO ();
		for ( filme f : fdao.read ()) {
			modelo . addRow ( new  Object [] {
					f.getIdFilme (),
					f.getTitulo (),
					f.getCategoria (),
					f.getTempo ()
			});
		}	
	}
}