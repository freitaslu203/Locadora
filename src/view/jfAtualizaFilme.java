package view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import model.bin.filme;
import model.dao.FilmeDAO;

public class jfAtualizaFilme extends JFrame {

	private JPanel contentPane;
	private JTextField txtTitulo;
	private JTextField txtCategoria;
	
	private static int id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					jfAtualizaFilme frame = new jfAtualizaFilme(id);
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
	public jfAtualizaFilme(int id) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 607, 407);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbcadastrar_filme = new JLabel("Alterar Filme");
		lbcadastrar_filme.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbcadastrar_filme.setBounds(0, 0, 136, 25);
		contentPane.add(lbcadastrar_filme);
		
		JLabel lblNewLabel = new JLabel("Id Filme");
		lblNewLabel.setBounds(142, 8, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblid = new JLabel("New label");
		lblid.setBounds(207, 8, 46, 14);
		contentPane.add(lblid);
		
		FilmeDAO fdao = new FilmeDAO();
		filme f = fdao.read(id);
		
		JLabel lbtitulo = new JLabel("T\u00EDtulo");
		lbtitulo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbtitulo.setBounds(10, 36, 46, 14);
		contentPane.add(lbtitulo);
		
		JTextField titulo = new JTextField();
		titulo.setBounds(20, 55, 554, 20);
		contentPane.add(titulo);
		titulo.setColumns(10);
		
		JLabel lbsinopse = new JLabel("Sinopse");
		lbsinopse.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbsinopse.setBounds(10, 86, 46, 14);
		contentPane.add(lbsinopse);
		
		JTextField sinopse = new JTextField();
		sinopse.setBounds(10, 111, 571, 109);
		contentPane.add(sinopse);
		sinopse.setColumns(10);
		
		JLabel lbcategoria = new JLabel("Categoria");
		lbcategoria.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbcategoria.setBounds(10, 233, 91, 14);
		contentPane.add(lbcategoria);
		
		JTextField categoria = new JTextField();
		categoria.setBounds(13, 258, 561, 20);
		contentPane.add(categoria);
		categoria.setColumns(10);
		
		JLabel lbtempo = new JLabel("Tempo");
		lbtempo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lbtempo.setBounds(10, 287, 46, 14);
		contentPane.add(lbtempo);
		
		JSpinner tempo = new JSpinner();
		tempo.setBounds(10, 302, 78, 20);
		contentPane.add(tempo);
		
		
		JRadioButton rdbtn2d = new JRadioButton("2D");
		rdbtn2d.setBounds(111, 301, 60, 23);
		contentPane.add(rdbtn2d);
		
		
		JRadioButton rdbtn3d = new JRadioButton("3D");
		rdbtn3d.setBounds(175, 301, 65, 23);
		contentPane.add(rdbtn3d);
		
		ButtonGroup imagem = new ButtonGroup();
		imagem.add(rdbtn2d);
		imagem.add(rdbtn3d);
		
		JRadioButton dublado = new JRadioButton("Dublado");
		dublado.setBounds(281, 301, 136, 23);
		contentPane.add(dublado);
		
		JRadioButton legendado = new JRadioButton("Legendado");
		legendado.setBounds(429, 301, 156, 23);
		contentPane.add(legendado);
		
		ButtonGroup audio = new ButtonGroup();
		audio.add(dublado);
		audio.add(legendado);
		
		
		lblid.setText(String.valueOf(f.getIdFilme()));
		titulo . setText (f . getTitulo ());
		sinopse . setText (f . getSinopse ());
		categoria . setText (f . getCategoria ());
		tempo . setValue (f . getTempo ());
		if (f . isImagem3d () ==  true ) {
			rdbtn3d . setSelected ( true );
		} else  if (f . isImagem3d () ==  false ) {
			rdbtn2d . setSelected ( true );
		}
		if (f . isDublado () ==  true ) {
		dublado . setSelected ( true );
		} else  if (f . isDublado () ==  false ) {
		legendado . setSelected ( true );
		}
		
		
		
		
		
	
			
		
		JButton btnalterar = new JButton("Alterar");
		btnalterar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				filme f = new filme();
				FilmeDAO dao = new FilmeDAO();
				
				
				f.setIdFilme(Integer.parseInt(lblid.getText()));
				
				
				
				
				f.setTitulo(titulo.getText());
				f.setSinopse(sinopse.getText());
				f.setCategoria(categoria.getText());
				f.setTempo(Integer.parseInt(tempo.getValue().toString()));
				if(rdbtn2d.isSelected()) {
					f.setImagem3d(false);
				}else if (rdbtn3d.isSelected()) {
					f.setImagem3d(true);
				}
				if(dublado.isSelected()) {
					f.setDublado(true);
				}
				dao.update(f);
			}

	});
		btnalterar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnalterar.setBounds(12, 334, 89, 23);
		contentPane.add(btnalterar);
		

		JButton btnlimpar = new JButton("Limpar");
		btnlimpar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnlimpar.setBounds(121, 334, 89, 23);
		contentPane.add(btnlimpar);
		
		JButton btncancelar = new JButton("Cancelar");
		btncancelar.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btncancelar.setBounds(225, 334, 89, 23);
		contentPane.add(btncancelar);
		
		
		
	}
}